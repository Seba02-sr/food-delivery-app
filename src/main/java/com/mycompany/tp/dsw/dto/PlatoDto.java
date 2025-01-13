package com.mycompany.tp.dsw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class PlatoDto extends ItemMenuDto {

    private Double calorias;
    private Boolean aptoCeliaco;
    private Boolean aptoVegetariano;
    private Boolean aptoVegano;
    private Double peso;

    /**
     * Atributos para el manejo de los errores.
     * - Un string es mas facil manejar y permite null.
     * - El parseo de un null a Double no se puede.
     * 
     * Al asegurarse que no contengan NULL, se parsea a Double
     * Luego setear el atributo
     */
    /*
     * private String caloriasText;
     * private String pesoText;
     * 
     * 
     * public PlatoDto(String nombre, String descripcion, String precioText, String
     * categoriaText, Integer idVendedor) {
     * super(nombre, descripcion, precioText, categoriaText, idVendedor);
     * }
     * 
     * // Constructor para metodo agregar Plato
     * public PlatoDto(String nombre, String descripcion, String precioText, String
     * categoriaText,
     * Integer idVendedor,
     * String caloriasText,
     * Boolean aptoCeliaco, Boolean aptoVegetariano, Boolean aptoVegano, String
     * pesoText) {
     * super(nombre, descripcion, precioText, categoriaText, idVendedor);
     * this.caloriasText = caloriasText;
     * this.aptoCeliaco = aptoCeliaco;
     * this.aptoVegetariano = aptoVegetariano;
     * this.aptoVegano = aptoVegano;
     * this.pesoText = pesoText;
     * }
     * 
     * // Constructor para modificar un Plato
     * public PlatoDto(String idText, String nombre, String descripcion, String
     * precioText, String categoriaText,
     * Integer idVendedor,
     * String caloriasText,
     * Boolean aptoCeliaco, Boolean aptoVegetariano, Boolean aptoVegano, String
     * pesoText) {
     * super(idText, nombre, descripcion, precioText, categoriaText, idVendedor);
     * this.caloriasText = caloriasText;
     * this.aptoCeliaco = aptoCeliaco;
     * this.aptoVegetariano = aptoVegetariano;
     * this.aptoVegano = aptoVegano;
     * this.pesoText = pesoText;
     * }
     * 
     * public Double getCalorias() {
     * return calorias;
     * }
     * 
     * public void setCalorias(Double calorias) {
     * this.calorias = calorias;
     * }
     * 
     * public Boolean getAptoCeliaco() {
     * return aptoCeliaco;
     * }
     * 
     * public void setAptoCeliaco(Boolean aptoCeliaco) {
     * this.aptoCeliaco = aptoCeliaco;
     * }
     * 
     * public Boolean getAptoVegetariano() {
     * return aptoVegetariano;
     * }
     * 
     * public void setAptoVegetariano(Boolean aptoVegetariano) {
     * this.aptoVegetariano = aptoVegetariano;
     * }
     * 
     * public Boolean getAptoVegano() {
     * return aptoVegano;
     * }
     * 
     * public void setAptoVegano(Boolean aptoVegano) {
     * this.aptoVegano = aptoVegano;
     * }
     * 
     * public Double getPeso() {
     * return peso;
     * }
     * 
     * public void setPeso(Double peso) {
     * this.peso = peso;
     * }
     * 
     * public String getCaloriasText() {
     * return caloriasText;
     * }
     * 
     * public void setCaloriasText(String caloriasText) {
     * this.caloriasText = caloriasText;
     * }
     * 
     * public String getPesoText() {
     * return pesoText;
     * }
     * 
     * public void setPesoText(String pesoText) {
     * this.pesoText = pesoText;
     * }
     */
}
