/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.model.relacion.ItemVendedor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "vendedores")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String direccion;

    @OneToOne
    private Coordenada coordenada;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vendedor")
    private List<ItemVendedor> itemMenuVendedor;

    @Column(name = "fecha_registro", nullable = false)
    private final LocalDate fechaRegistro = LocalDate.now();

    @Builder.Default
    private Boolean activo = true;

    @Column(name = "fecha_eliminacion")
    @Builder.Default
    private LocalDate fechaEliminacion = null;

    public Vendedor(VendedorDto vendedorDto) {
        this.id = vendedorDto.getId();
        this.nombre = vendedorDto.getNombre();
        this.direccion = vendedorDto.getDireccion();
        this.coordenada = vendedorDto.getCoordenada();
        this.itemMenuVendedor = new ArrayList<>();
    }

    /**
     * Calculo de la distancia entre el Restaurante y el cliente
     * - Implementado utilizando la formula de Haversine
     * 
     * @param cliente El cliente que quiere saber la distancia hacia el restaurante
     * @return distancia en Kilometros
     */
    public Double distancia(Cliente cliente) {
        final int R = 6371; // radio de la tierra en km

        Double latV = this.getCoordenada().getLatitud();
        Double lngV = this.getCoordenada().getLongitud();
        Double latC = cliente.getCoordenada().getLatitud();
        Double lngC = cliente.getCoordenada().getLongitud();

        Double latDistance = Math.toRadians(latV - latC);
        Double lonDistance = Math.toRadians(lngV - lngC);

        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latV)) * Math.cos(Math.toRadians(latC))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    /**
     * Obtiene las bebidas del Restaurante
     * 
     * @return Lista de ItemMenu, del tipo Bebida
     */
    public List<ItemMenu> getItemBebidas() {
        List<ItemMenu> listaBebidas = new ArrayList<>();
        for (ItemVendedor item : this.itemMenuVendedor) {
            if (item.getItemMenu().getCategoria().getTipo() == TipoCategoria.BEBIDA) {
                listaBebidas.add(item.getItemMenu());
            }
        }
        return listaBebidas;
    }

    /**
     * Obtiene las comidas del Restaurante
     * - Comida = Plato
     * 
     * @return Lista de ItemMenu, del tipo Plato
     */
    public List<ItemMenu> getItemComidas() {
        List<ItemMenu> listaComidas = new ArrayList<>();
        for (ItemVendedor item : this.itemMenuVendedor) {
            if (item.getItemMenu().getCategoria().getTipo() == TipoCategoria.COMIDA) {
                listaComidas.add(item.getItemMenu());
            }
        }
        return listaComidas;
    }

    /**
     * Obtiene las comidas veganas del Restaurante
     * - Si es vegano, es vegetariano
     * 
     * @return Lista de ItemMenu, del tipo Plato, particularidad vegana
     */
    public List<ItemMenu> getItemComidasVeganas() {
        List<ItemMenu> listaComidasVeganas = new ArrayList<>();
        for (ItemVendedor item : this.itemMenuVendedor) {
            if (item.getItemMenu().getCategoria().getTipo() == TipoCategoria.COMIDA
                    && ((Plato) item.getItemMenu()).aptoVegano()) {
                listaComidasVeganas.add(item.getItemMenu());
            }
        }
        return listaComidasVeganas;
    }

    /**
     * Obtiene las bebidas sin alcohol del Restaurante
     * 
     * @return Lista de ItemMenu, del tipo Bebida, particularidad sin alcohol
     */
    public List<ItemMenu> getItemBebidasSinAlcohol() {
        List<ItemMenu> listaBebidasSinAlcohol = new ArrayList<>();
        for (ItemVendedor item : this.itemMenuVendedor) {
            if (item.getItemMenu().getCategoria().getTipo() == TipoCategoria.BEBIDA
                    && ((Bebida) item.getItemMenu()).getGraduacionAlcoholica() == 0) {
                listaBebidasSinAlcohol.add(item.getItemMenu());
            }
        }
        return listaBebidasSinAlcohol;
    }
}
