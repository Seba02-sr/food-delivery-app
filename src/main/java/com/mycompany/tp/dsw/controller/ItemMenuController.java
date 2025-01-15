package com.mycompany.tp.dsw.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dao.ItemMenuDao;
import com.mycompany.tp.dsw.dto.BebidaDto;
import com.mycompany.tp.dsw.dto.CoordenadaDto;
import com.mycompany.tp.dsw.dto.ItemMenuDto;
import com.mycompany.tp.dsw.dto.PlatoDto;
import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.CategoriaNoEncontradaException;
import com.mycompany.tp.dsw.exception.NoValidarException;
import com.mycompany.tp.dsw.service.BebidaService;
import com.mycompany.tp.dsw.service.CategoriaService;
import com.mycompany.tp.dsw.service.PlatoService;
import com.mycompany.tp.dsw.service.VendedorService;
import com.mycompany.tp.dsw.model.Bebida;
import com.mycompany.tp.dsw.model.Categoria;
import com.mycompany.tp.dsw.model.Plato;
import com.mycompany.tp.dsw.model.Vendedor;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.service.ServiceManager;

public class ItemMenuController {

    private final ServiceManager serviceManager;
    private final CategoriaService categoriaService;
    private final PlatoService platoService;
    private final BebidaService bebidaService;
    private final VendedorService vendedorService;

    private final ItemMenuDao itemMenuDao;

    public ItemMenuController() {
        itemMenuDao = new ItemMenuDao();
        serviceManager = ServiceManager.getInstance();
        categoriaService = serviceManager.getCategoriaService();

        platoService = serviceManager.getPlatoService();
        bebidaService = serviceManager.getBebidaService();
        vendedorService = serviceManager.getVendedorService();
    }

    /**
     * Persiste un nuevo item en el menú, ya sea un plato o una bebida.
     *
     * @param item          El item a guardar en el menú.
     * @param tipoCategoria El tipo de categoría (Plato o Bebida) del item.
     */
    public void guardarItemMenu(ItemMenuDto item, String tipoCategoria) {
        switch (tipoCategoria) {
            case "Plato":
                PlatoDto platoDto = (PlatoDto) item;
                platoService.registrarPlato(platoDto);
                break;
            case "Bebida":
                BebidaDto bebidaDto = (BebidaDto) item;
                bebidaService.registrarBebida(bebidaDto);
                break;
            default:
                break;
        }
    }

    /**
     * Elimina logicamente un item del menú basado en su ID y tipo de categoría.
     *
     * @param idText        El ID del item a eliminar.
     * @param tipoCategoria El tipo de categoría del item (Plato o Bebida).
     * @throws NoValidarException Si el ID no es válido.
     */
    public void eliminarItemMenu(String idText, String tipoCategoria) throws NoValidarException {
        Integer id = null;
        if (idText != null) {
            id = idValido(idText);
        }
        switch (tipoCategoria) {
            case "Plato":
                platoService.eliminarItemMenu(id);
                break;
            case "Bebida":
                bebidaService.eliminarItemMenu(id);
                break;
        }
    }

    /**
     * Modifica un item existente en el menú, ya sea un plato o una bebida.
     *
     * @param item          El item a modificar.
     * @param tipoCategoria El tipo de categoría (Plato o Bebida) del item.
     */
    public void modificarItemMenu(ItemMenuDto item, String tipoCategoria) {
        switch (tipoCategoria) {
            case "Plato":
                PlatoDto platoDto = (PlatoDto) item;
                platoService.modificarPlato(platoDto);
                break;
            case "Bebida":
                BebidaDto bebidaDto = (BebidaDto) item;
                bebidaService.modificarBebida(bebidaDto);
                break;
            default:
                break;
        }
    }

    /**
     * Obtiene un vendedor por su ID.
     *
     * @param idText El ID del vendedor.
     * @return Un DTO de Vendedor con los detalles del vendedor.
     * @throws NoValidarException Si el ID no es válido.
     */
    public VendedorDto obtenerVendedor(String idText) throws NoValidarException {
        Integer id = null;
        if (idText != null) {
            id = idValido(idText);
        }
        Vendedor vendedor = vendedorService.buscarVendedorPorId(id);
        return mapToDto(vendedor);
    }

    /**
     * Obtiene los valores del tipo de categoria.
     *
     * @param tipoCategoria El tipo de categoría (Plato o Bebida).
     * @return Una lista de nombres de categorías.
     * @throws CategoriaNoEncontradaException Si no se encuentra ninguna categoría
     *                                        para el tipo proporcionado.
     */
    public List<String> getValoresComboBoxCategoria(String tipoCategoria) throws CategoriaNoEncontradaException {
        if (tipoCategoria.equals("Plato")) {
            tipoCategoria = "Comida";
        }
        List<Categoria> categorias = new ArrayList<>();
        try {
            categorias = categoriaService.buscarPorTipoCategoria(tipoCategoria);
            List<String> categoriasString = new ArrayList<>();
            for (Categoria cat : categorias) {
                String nombre = cat.getNombre();
                categoriasString.add(nombre);
            }
            return categoriasString;
        } catch (CategoriaNoEncontradaException e) {
            throw e;
        }

    }

    /**
     * Obtiene los platos disponibles de un vendedor basado en su ID.
     *
     * @param vendedorDto El DTO del vendedor con el ID.
     * @return Una lista de DTOs de platos del vendedor.
     */
    public List<PlatoDto> obtenerPlatoPorIdVendedor(VendedorDto vendedorDto) {
        List<Plato> platos = platoService.obtenerPlatoPorIdVendedor(vendedorDto.getId());
        return platos.stream().map(this::mapToDto).toList();
    }

    /**
     * Obtiene las bebidas disponibles de un vendedor basado en su ID.
     *
     * @param vendedorDto El DTO del vendedor con el ID.
     * @return Una lista de DTOs de bebidas del vendedor.
     */
    public List<BebidaDto> obtenerBebidaPorIdVendedor(VendedorDto vendedorDto) {
        List<Bebida> bebidas = bebidaService.obtenerBebidaPorIdVendedor(vendedorDto.getId());
        return bebidas.stream().map(this::mapToDto).toList();
    }

    /**
     * Obtiene todos los items del menú (platos y bebidas) para un vendedor
     * específico.
     *
     * @param id El ID del vendedor.
     * @return Una lista de DTOs de items del menú (platos y bebidas).
     */
    public List<ItemMenuDto> obtenerItemMenuPorIdVendedor(Integer id) {
        List<ItemMenu> retItems = new ArrayList<>();
        retItems.addAll(platoService.obtenerPlatoPorIdVendedor(id));
        retItems.addAll(bebidaService.obtenerBebidaPorIdVendedor(id));

        return retItems.stream().map(this::mapToDto).toList();
    }

    /**
     * Obtiene un plato específico de un vendedor por su ID de plato.
     *
     * @param idPlatoText El ID del plato.
     * @param vendedorDto El DTO del vendedor.
     * @return Un DTO de Plato.
     * @throws NoValidarException Si el ID del plato no es válido.
     */
    public ItemMenuDto obtenerPlatoVendedorPorId(String idPlatoText, VendedorDto vendedorDto)
            throws NoValidarException {
        Integer idPlato = null;
        if (idPlatoText != null) {
            idPlato = idValido(idPlatoText);
        }

        Plato plato = platoService.buscarPlatoPorId(idPlato, vendedorDto.getId());

        return mapToDto(plato);
    }

    /**
     * Obtiene una bebida específica de un vendedor por su ID de bebida.
     *
     * @param idText      El ID de la bebida.
     * @param vendedorDto El DTO del vendedor.
     * @return Un DTO de Bebida.
     * @throws NoValidarException Si el ID de la bebida no es válido.
     */
    public BebidaDto obtenerBebidaVendedorPorId(String idText, VendedorDto vendedorDto) throws NoValidarException {

        Integer idBebida = null;
        if (idText != null) {
            idBebida = idValido(idText);
        }
        Bebida bebida = bebidaService.buscarBebidaPorId(idBebida, vendedorDto.getId());
        return mapToDto(bebida);
    }

    /**
     * Obtiene un item del menú por su ID.
     *
     * @param idText El ID del item.
     * @return Un DTO de ItemMenu.
     * @throws NoValidarException Si el ID no es válido.
     */
    public ItemMenuDto obtenerItemPorId(String idText) throws NoValidarException {
        Integer id = null;
        if (idText != null) {
            id = idValido(idText);
        }
        ItemMenu itemMenu = platoService.buscarPorId(id);
        return mapToDto(itemMenu);
    }

    /**
     * Busca un plato por su nombre y el ID de vendedor.
     *
     * @param nombre El nombre del plato.
     * @param id     El ID del vendedor.
     * @return Una lista de DTOs de platos que coinciden con el nombre y el
     *         vendedor.
     */
    public List<PlatoDto> buscarPlatoPorNombreYVendedor(String nombre, Integer id) {
        List<Plato> platos = platoService.buscarPlatoPorNombreYVendedor(nombre, id);
        return platos.stream().map(this::mapToDto).toList();
    }

    /**
     * Busca una bebida por su nombre y el ID de vendedor.
     *
     * @param nombre El nombre de la bebida.
     * @param id     El ID del vendedor.
     * @return Una lista de DTOs de bebidas que coinciden con el nombre y el
     *         vendedor.
     */
    public List<BebidaDto> buscarBebidaPorNombreYVendedor(String nombre, Integer id) {
        List<Bebida> bebidas = bebidaService.buscarBebidaPorNombreYVendedor(nombre, id);
        return bebidas.stream().map(this::mapToDto).toList();
    }

    /**
     * Busca un item del menú por su nombre.
     *
     * @param nombre El nombre del item.
     * @return Una lista de DTOs de items del menú que coinciden con el nombre.
     */
    public List<ItemMenuDto> buscarPorNombre(String nombre) {
        List<ItemMenu> itemMenus = itemMenuDao.findActiveByNombre(nombre);
        return itemMenus.stream().map(this::mapToDto).toList();
    }

    /**
     * Mapea un objeto ItemMenu a su correspondiente DTO basado en la categoría.
     *
     * @param itemMenu El objeto ItemMenu a mapear.
     * @return Un DTO correspondiente al itemMenu.
     */
    public ItemMenuDto mapToDto(ItemMenu itemMenu) {
        switch (itemMenu.getCategoria().getTipo().toString().toLowerCase()) {
            case "comida":
                Plato plato = (Plato) itemMenu;
                return mapToDto(plato);
            case "bebida":
                Bebida bebida = (Bebida) itemMenu;
                return mapToDto(bebida);
            default:
                return null;
        }

    }

    /**
     * Mapea un objeto Plato a su correspondiente DTO.
     * 
     * @param plato El objeto Plato a mapear.
     * @return Un DTO correspondiente al Plato.
     */
    private PlatoDto mapToDto(Plato plato) {
        return PlatoDto.builder()
                .id(plato.getId())
                .calorias(plato.getCalorias())
                .aptoCeliaco(plato.getAptoCeliaco())
                .aptoVegetariano(plato.getAptoVegetariano())
                .aptoVegano(plato.aptoVegano())
                .peso(plato.getPeso())
                .nombre(plato.getNombre())
                .descripcion(plato.getDescripcion())
                .precio(plato.getPrecio())
                .categoria(plato.getCategoria().getNombre())
                .idVendedor(plato.getVendedor().getId())
                .build();
    }

    /**
     * Mapea un objeto Bebida a su correspondiente DTO.
     * 
     * @param plato El objeto Bebida a mapear.
     * @return Un DTO correspondiente al Bebida.
     */
    private BebidaDto mapToDto(Bebida bebida) {
        return BebidaDto.builder()
                .graduacionAlcoholica(bebida.getGraduacionAlcoholica())
                .tamano(bebida.getTamano())
                .volumen(bebida.getVolumen())
                .id(bebida.getId())
                .nombre(bebida.getNombre())
                .descripcion(bebida.getDescripcion())
                .precio(bebida.getPrecio())
                .categoria(bebida.getCategoria().getNombre())
                .idVendedor(bebida.getVendedor().getId())
                .build();
    }

    /**
     * Mapea un objeto Vendedor a su correspondiente DTO.
     * 
     * @param plato El objeto Vendedor a mapear.
     * @return Un DTO correspondiente al Vendedor.
     */
    private VendedorDto mapToDto(Vendedor vendedor) {
        CoordenadaDto coordenadaDto = CoordenadaDto.builder()
                .Id(vendedor.getCoordenada().getId())
                .latitud(vendedor.getCoordenada().getLatitud())
                .longitud(vendedor.getCoordenada().getLongitud())
                .build();
        return VendedorDto.builder()
                .id(vendedor.getId())
                .nombre(vendedor.getNombre())
                .direccion(vendedor.getDireccion())
                .coordenadaDto(coordenadaDto)
                .build();
    }

    /**
     * Crea un DTO de Plato a partir de los parámetros proporcionados.
     *
     * @return Un DTO de Plato con los datos validados y mapeados.
     * @throws NoValidarException Si alguno de los datos no es válido.
     */
    public PlatoDto crearPlatoDto(String idText, String nombre, String descripcion, String precioText, String categoria,
            Integer idVendedor, String caloriasText, Boolean aptoCeliaco, boolean aptoVegetariano, boolean aptoVegano,
            String pesoText) throws NoValidarException {
        Integer id = null;
        BigDecimal precio = null;
        Double calorias = null;
        Double peso = null;
        if (idText != null) {
            id = idValido(idText);
        }

        if (nombre != null) {
            nombreValido(nombre);
        }

        if (precioText != null) {
            precio = precioValido(precioText);
        }

        if (descripcion != null) {
            descripcionValido(descripcion);
        }

        if (caloriasText != null) {
            calorias = caloriasValido(caloriasText);
        }

        if (pesoText != null) {
            peso = pesoValido(pesoText);
        }

        return PlatoDto.builder()
                .id(id)
                .calorias(calorias)
                .aptoCeliaco(aptoCeliaco)
                .aptoVegetariano(aptoVegetariano)
                .aptoVegano(aptoVegano)
                .peso(peso)
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .categoria(categoria)
                .idVendedor(idVendedor)
                .build();

    }

    // Validaciones de los atributos para realizar la creacion de un Plato.
    public Double pesoValido(String peso) throws NoValidarException {

        try {
            if (isEmpty(peso)) {
                throw new NoValidarException("El peso no puede estar vacío");
            }
            return Double.parseDouble(peso);
        } catch (NumberFormatException e) {
            throw new NoValidarException("El peso solo puede contener numeros decimales");
        }
    }

    private Double caloriasValido(String calorias) throws NoValidarException {

        try {
            if (isEmpty(calorias)) {
                throw new NoValidarException("Error: El compo calorias no puede estar vacío");
            }
            return Double.parseDouble(calorias);
        } catch (NumberFormatException e) {
            throw new NoValidarException("Las calorias solo puede contener numeros decimales");
        }

    }

    private BigDecimal precioValido(String precio) throws NoValidarException {
        try {
            if (isEmpty(precio)) {
                throw new NoValidarException("Error: El campo precio no puede estar vacío");
            }
            return new BigDecimal(precio);
        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: El campo precio solo puede contener numeros decimales");
        }
    }

    private void descripcionValido(String descripcion) throws NoValidarException {
        if (isEmpty(descripcion)) {
            throw new NoValidarException("La descripcion no puede estar vacía");
        }
        if (!letrasNumeros(descripcion)) {
            throw new NoValidarException("La descripcion solo puede contener letras y/o numeros");
        }
    }

    private void nombreValido(String nombre) throws NoValidarException {
        if (isEmpty(nombre)) {
            throw new NoValidarException("Error: El nombre no puede estar vacío");
        }
        if (!soloLetras(nombre)) {
            throw new NoValidarException("Error: El nombre solo puede contener letras");
        }
    }

    private Integer idValido(String idText) throws NoValidarException {
        try {
            if (isEmpty(idText)) {
                throw new NoValidarException("Error: El id no puede estar vacío");
            }
            return Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: El id solo puede contener números");
        }
    }

    private Boolean letrasNumeros(String palabra) {
        return palabra.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s.,]+$");
    }

    private Boolean soloLetras(String palabra) {
        return palabra.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    public Boolean isEmpty(String palabra) {
        return (palabra.trim().isEmpty());
    }

    /**
     * Crea un DTO de Bebida a partir de los parámetros proporcionados.
     *
     * @return Un DTO de Bebida con los datos validados y mapeados.
     * @throws NoValidarException Si alguno de los datos no es válido.
     */
    public BebidaDto crearBebidaDto(String idText, String nombre, String descripcion, String precioText,
            String categoria,
            Integer idVendedor, String graduacionAlcoholicaText, String tamanoText, String volumenText)
            throws NoValidarException {

        Integer id = null;
        BigDecimal precio = null;
        Double graduacionAlcoholica = null;
        Double tamano = null;
        Double volumen = null;
        if (idText != null) {
            id = idValido(idText);
        }

        if (nombre != null) {
            nombreValido(nombre);
        }

        if (precioText != null) {
            precio = precioValido(precioText);
        }

        if (descripcion != null) {
            descripcionValido(descripcion);
        }

        if (graduacionAlcoholicaText != null) {
            graduacionAlcoholica = graduacionAlcoholicaValida(graduacionAlcoholicaText);
        }

        if (tamanoText != null) {
            tamano = tamanoValido(tamanoText);
        }

        if (volumenText != null) {
            volumen = volumenValido(volumenText);
        }

        return BebidaDto.builder()
                .id(id)
                .graduacionAlcoholica(graduacionAlcoholica)
                .tamano(tamano)
                .volumen(volumen)
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .categoria(categoria)
                .idVendedor(idVendedor)
                .build();
    }

    // Validaciones de los atributos para realizar la creacion de una Bebida.
    public Double graduacionAlcoholicaValida(String graduacionAlcoholicaText) throws NoValidarException {

        try {
            if (isEmpty(graduacionAlcoholicaText)) {
                throw new NoValidarException("El campo de graduacion alcoholica no puede estar vacio");
            }

            Double graduacionAlcoholica = Double.parseDouble(graduacionAlcoholicaText);

            if (graduacionAlcoholica < 0 || graduacionAlcoholica > 100) {
                throw new NoValidarException("La graduacion alcoholica debe ser un numero entre 0 y 100");
            }
            return graduacionAlcoholica;
        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: El campo graduacion alcoholica debe ser un numero valido");
        }
    }

    public Double tamanoValido(String tamano) throws NoValidarException {

        try {
            if (isEmpty(tamano)) {
                throw new NoValidarException("El campo de tamano no puede estar vacio");
            }
            return Double.parseDouble(tamano);
        } catch (NumberFormatException e) {
            throw new NoValidarException("El campo tamano debe ser un numero con decimales");
        }

    }

    public Double volumenValido(String volumen) throws NoValidarException {

        try {
            if (isEmpty(volumen)) {
                throw new NoValidarException("El campo de volumen no puede estar vacio");
            }
            return Double.parseDouble(volumen);
        } catch (NumberFormatException e) {
            throw new NoValidarException("El campo volumen debe ser un numero con decimales");
        }

    }

}
