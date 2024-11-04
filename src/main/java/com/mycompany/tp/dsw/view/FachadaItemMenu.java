package com.mycompany.tp.dsw.view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.mycompany.tp.dsw.dao.ItemMenuDao;
import com.mycompany.tp.dsw.dto.BebidaDto;
import com.mycompany.tp.dsw.dto.ItemMenuDto;
import com.mycompany.tp.dsw.dto.PlatoDto;
import com.mycompany.tp.dsw.memory.BebidaMemory;
import com.mycompany.tp.dsw.memory.CategoriaMemory;
import com.mycompany.tp.dsw.memory.PlatoMemory;
import com.mycompany.tp.dsw.memory.VendedorMemory;
import com.mycompany.tp.dsw.model.Bebida;
import com.mycompany.tp.dsw.model.Plato;
import com.mycompany.tp.dsw.model.Vendedor;
import com.mycompany.tp.dsw.util.CrudOperation;

/**
 * Clase que funciona de fachada de la clase Item Menu
 * - Subclases: Plato, Bebida.
 * 
 * Se encarga de las operaciones CRUD.
 * Llama al metodo correspondiente de cada subclase
 */
public class FachadaItemMenu {

    private PlatoMemory platoMemory;
    private BebidaMemory bebidaMemory;
    private CategoriaMemory categoriaMemory;
    private VendedorMemory vendedorMemory;
    private Integer idVendedor;

    // private Map<String, Map<String, CrudOperation<?>>> operaciones;

    public FachadaItemMenu() {

    }

    public FachadaItemMenu(Integer idVendedor) {
        platoMemory = new PlatoMemory();
        bebidaMemory = new BebidaMemory();
        categoriaMemory = new CategoriaMemory();
        vendedorMemory = new VendedorMemory();
        this.idVendedor = idVendedor;

    }

    public void crearItemMenu(BebidaDto bebidaDto) {

        // Parsear los datos y setearlos

        // Atributos ItemMenu
        bebidaDto.setPrecio(new BigDecimal(bebidaDto.getPrecioText()));
        bebidaDto.setCategoria(categoriaMemory.obtenerCategoriaPorNombre(bebidaDto.getCategoriaText()));

        Vendedor vendedor = vendedorMemory.buscarVendedorPorId(idVendedor);
        bebidaDto.setVendedor(vendedor);

        // Atributos Bebida
        bebidaDto.setGraduacionAlcoholica(Double.parseDouble(bebidaDto.getGraduacionAlcoholicaText()));
        bebidaDto.setVolumen(Double.parseDouble(bebidaDto.getVolumenText()));
        bebidaDto.setTamano(Double.parseDouble(bebidaDto.getTamanoText()));

        Bebida bebida = new Bebida(bebidaDto);

        bebidaMemory.crearBebida(bebida);

    }

    public void crearItemMenu(PlatoDto platoDto) {
        // Parsear los datos y setearlos

        // Atributos ItemMenu
        platoDto.setPrecio(new BigDecimal(platoDto.getPrecioText()));
        platoDto.setCategoria(categoriaMemory.obtenerCategoriaPorNombre(platoDto.getCategoriaText()));

        // Atributos Plato
        platoDto.setCalorias(Double.parseDouble(platoDto.getCaloriasText()));
        platoDto.setAptoCeliaco(platoDto.getAptoCeliaco());
        platoDto.setPeso(Double.parseDouble(platoDto.getPesoText()));

        switch (platoDto.getCaloriasText()) {
            case "Comida Vegana":
                platoDto.setAptoVegano(true);
                platoDto.setAptoVegetariano(true);
                break;
            case "Comida Vegetariana":
                platoDto.setAptoVegetariano(true);
                break;
            default:
                platoDto.setAptoVegano(false);
                platoDto.setAptoVegetariano(false);
                break;
        }

    }

}
