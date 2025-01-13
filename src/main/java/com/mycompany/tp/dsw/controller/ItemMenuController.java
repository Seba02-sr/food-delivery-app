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

    public void eliminarItemMenu(String idText, String tipoCategoria) {
        Integer id = Integer.parseInt(idText);
        switch (tipoCategoria) {
            case "Plato":
                platoService.eliminarItemMenu(id);
                break;
            case "Bebida":
                bebidaService.eliminarItemMenu(id);
                break;
        }
    }

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

    public VendedorDto obtenerVendedor(String idText) {
        Integer id = Integer.parseInt(idText);
        Vendedor vendedor = vendedorService.buscarVendedorPorId(id);
        return mapToDto(vendedor);
    }

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

    public List<PlatoDto> obtenerPlatoPorIdVendedor(VendedorDto vendedorDto) {
        List<Plato> platos = platoService.obtenerPlatoPorIdVendedor(vendedorDto.getId());
        return platos.stream().map(this::mapToDto).toList();
    }

    public List<BebidaDto> obtenerBebidaPorIdVendedor(VendedorDto vendedorDto) {
        List<Bebida> bebidas = bebidaService.obtenerBebidaPorIdVendedor(vendedorDto.getId());
        return bebidas.stream().map(this::mapToDto).toList();
    }

    public List<ItemMenuDto> obtenerItemMenuPorIdVendedor(Integer id) {
        List<ItemMenu> retItems = new ArrayList<>();
        retItems.addAll(platoService.obtenerPlatoPorIdVendedor(id));
        retItems.addAll(bebidaService.obtenerBebidaPorIdVendedor(id));

        return retItems.stream().map(this::mapToDto).toList();
    }

    public ItemMenuDto obtenerPlatoVendedorPorId(String idPlatoText, VendedorDto vendedorDto) {
        Integer idPlato = Integer.parseInt(idPlatoText);

        Plato plato = platoService.buscarPlatoPorId(idPlato, vendedorDto.getId());

        return mapToDto(plato);
    }

    public BebidaDto obtenerBebidaVendedorPorId(String idText, VendedorDto vendedorDto) {

        Integer idBebida = Integer.parseInt(idText);
        Bebida bebida = bebidaService.buscarBebidaPorId(idBebida, vendedorDto.getId());
        return mapToDto(bebida);
    }

    public ItemMenuDto obtenerItemPorId(String idText) {
        Integer id = Integer.parseInt(idText);
        ItemMenu itemMenu = platoService.buscarPorId(id);
        return mapToDto(itemMenu);
    }

    public List<PlatoDto> buscarPlatoPorNombreYVendedor(String nombre, Integer id) {
        List<Plato> platos = platoService.buscarPlatoPorNombreYVendedor(nombre, id);
        return platos.stream().map(this::mapToDto).toList();
    }

    public List<BebidaDto> buscarBebidaPorNombreYVendedor(String nombre, Integer id) {
        List<Bebida> bebidas = bebidaService.buscarBebidaPorNombreYVendedor(nombre, id);
        return bebidas.stream().map(this::mapToDto).toList();
    }

    public List<ItemMenuDto> buscarPorNombre(String nombre) {
        List<ItemMenu> itemMenus = itemMenuDao.findActiveByNombre(nombre);
        return itemMenus.stream().map(this::mapToDto).toList();
    }

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

    public PlatoDto crearPlatoDto(String idText, String nombre, String descripcion, String precioText, String categoria,
            Integer idVendedor, String caloriasText, Boolean aptoCeliaco, boolean aptoVegetariano, boolean aptoVegano,
            String pesoText) throws NoValidarException {
        Integer id = idValido(idText);
        nombreValido(nombre);
        BigDecimal precio = precioValido(precioText);
        descripcionValido(descripcion);
        Double calorias = caloriasValido(caloriasText);
        Double peso = pesoValido(pesoText);

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

    public Double pesoValido(String peso) throws NoValidarException {

        try {
            if (esNullOrEmpty(peso)) {
                throw new NoValidarException("El peso no puede estar vacío");
            }
            return Double.parseDouble(peso);
        } catch (NumberFormatException e) {
            throw new NoValidarException("El peso solo puede contener numeros decimales");
        }
    }

    private Double caloriasValido(String calorias) throws NoValidarException {

        try {
            if (esNullOrEmpty(calorias)) {
                throw new NoValidarException("Error: El compo calorias no puede estar vacío");
            }
            return Double.parseDouble(calorias);
        } catch (NumberFormatException e) {
            throw new NoValidarException("Las calorias solo puede contener numeros decimales");
        }

    }

    private BigDecimal precioValido(String precio) throws NoValidarException {
        try {
            if (esNullOrEmpty(precio)) {
                throw new NoValidarException("Error: El campo precio no puede estar vacío");
            }
            return new BigDecimal(precio);
        } catch (NumberFormatException e) {
            throw new NoValidarException("Error: El campo precio solo puede contener numeros decimales");
        }
    }

    private void descripcionValido(String descripcion) throws NoValidarException {
        if (esNullOrEmpty(descripcion)) {
            throw new NoValidarException("La descripcion no puede estar vacía");
        }
        if (!letrasNumeros(descripcion)) {
            throw new NoValidarException("La descripcion solo puede contener letras y/o numeros");
        }
    }

    private void nombreValido(String nombre) throws NoValidarException {
        if (esNullOrEmpty(nombre)) {
            throw new NoValidarException("Error: El nombre no puede estar vacío");
        }
        if (!soloLetras(nombre)) {
            throw new NoValidarException("Error: El nombre solo puede contener letras");
        }
    }

    private Integer idValido(String idText) throws NoValidarException {
        try {
            if (esNullOrEmpty(idText)) {
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

    public Boolean esNullOrEmpty(String palabra) {
        return (palabra == null || palabra.trim().isEmpty());
    }

    public BebidaDto crearBebidaDto(String idText, String nombre, String descripcion, String precioText,
            String categoria,
            Integer idVendedor, String graduacionAlcoholicaText, String tamanoText, String volumenText)
            throws NoValidarException {
        Integer id = idValido(idText);
        nombreValido(nombre);
        descripcionValido(descripcion);
        BigDecimal precio = precioValido(precioText);
        Double graduacionAlcoholica = graduacionAlcoholicaValida(graduacionAlcoholicaText);
        Double tamano = tamanoValido(tamanoText);
        Double volumen = volumenValido(volumenText);

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

    public Double graduacionAlcoholicaValida(String graduacionAlcoholicaText) throws NoValidarException {

        try {
            if (esNullOrEmpty(graduacionAlcoholicaText)) {
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
            if (esNullOrEmpty(tamano)) {
                throw new NoValidarException("El campo de tamano no puede estar vacio");
            }
            return Double.parseDouble(tamano);
        } catch (NumberFormatException e) {
            throw new NoValidarException("El campo tamano debe ser un numero con decimales");
        }

    }

    public Double volumenValido(String volumen) throws NoValidarException {

        try {
            if (esNullOrEmpty(volumen)) {
                throw new NoValidarException("El campo de volumen no puede estar vacio");
            }
            return Double.parseDouble(volumen);
        } catch (NumberFormatException e) {
            throw new NoValidarException("El campo volumen debe ser un numero con decimales");
        }

    }

}
