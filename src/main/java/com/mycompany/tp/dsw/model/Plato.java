/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.dsw.model;

import java.math.BigDecimal;

import com.mycompany.tp.dsw.dto.PlatoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name = "platos")
public class Plato extends ItemMenu {

    @Column(nullable = false)
    @Min(0)
    private Double calorias;

    @Column(nullable = false)
    private Boolean aptoCeliaco;

    @Column(nullable = false)
    private Boolean aptoVegetariano;

    @Column(nullable = false)
    private Boolean aptoVegano;

    @Column(nullable = false)
    @DecimalMin(value = "0.05", message = "El peso debe ser al menos 50g")
    @DecimalMax(value = "10.00", message = "El peso no puede exceder 10kg")
    private Double peso;

    // Constructor para modificar Plato
    public Plato(PlatoDto platoDto) {
        super(platoDto.getId(),
                platoDto.getNombre(),
                platoDto.getDescripcion(),
                platoDto.getPrecio(),
                platoDto.getCategoria());
        this.calorias = platoDto.getCalorias();
        this.aptoCeliaco = platoDto.getAptoCeliaco();
        this.aptoVegetariano = platoDto.getAptoVegetariano();
        this.aptoVegano = platoDto.getAptoVegano();
        this.peso = platoDto.getPeso();
    }

    public Plato(String nombre, Double calorias, Boolean aptoCeliaco, Boolean aptoVegetariano, Boolean aptoVegano,
            Double peso,
            Integer id, BigDecimal precio, String descripcion, Categoria categoria) {
        super(id, nombre, descripcion, precio, categoria);
        this.calorias = calorias;
        this.aptoCeliaco = aptoCeliaco;
        this.aptoVegetariano = aptoVegetariano;
        this.aptoVegano = aptoVegano;
        this.peso = peso;
    }

    /**
     * Metodo que setea si el Plato es apto vegetariano
     * - Plato que no es apto vegetariano, tampoco es apto vegano
     * 
     * @param aptoVegetariano
     */
    public void setAptoVegetariano(Boolean aptoVegetariano) {
        this.aptoVegetariano = aptoVegetariano;
        if (!aptoVegetariano) {
            this.aptoVegano = false;
        }
    }

    /**
     * Metodo que setea si el Plato es apto vegano
     * - Plato que es apto vegano, tambien es apto vegetariano
     * 
     * @param aptoVegano
     */
    public void setAptoVegano(Boolean aptoVegano) {
        this.aptoVegano = aptoVegano;
        if (aptoVegano) {
            this.aptoVegetariano = true;
        }
    }

    /**
     * Metodo de la regla de negocio
     * - Tiene en cuenta el peso del envase, 10%
     * Formula -> <peso del plato> * 1.1
     * 
     * @return Valor del peso real, teniendo en cuenta el envase
     */
    @Override
    public Double peso() {
        return this.peso * 1.1;
    }

    /**
     * Indica si el item es de tipo Comida
     * 
     * @return 'true' siempre ya que es plato
     */
    @Override
    public boolean esComida() {
        return true;
    }

    /**
     * Indica si el item es de tipo Bebida
     * 
     * @return 'false' siempre ya que es plato
     */
    @Override
    public boolean esBebida() {
        return false;
    }

    /**
     * Regla de negocio
     * - Igual a un getAptoVegano
     */
    @Override
    public boolean aptoVegano() {
        return aptoVegano;
    }

}
