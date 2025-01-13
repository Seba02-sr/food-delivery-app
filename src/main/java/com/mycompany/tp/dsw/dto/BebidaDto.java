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

public class BebidaDto extends ItemMenuDto {
    private Double graduacionAlcoholica;
    private Double tamano;
    private Double volumen;

    /**
     * Atributos para el manejo de los errores.
     * - Un string es mas facil manejar y permite null.
     * - El parseo de un null a Double no se puede.
     * 
     * Al asegurarse que no contengan NULL, se parsea a Double
     * Luego setear el atributo
     */
    /*
     * private String graduacionAlcoholicaText;
     * private String tamanoText;
     * private String volumenText;
     */

    /*
     * public BebidaDto() {
     * 
     * }
     * 
     * public BebidaDto(String nombre, String descripcion, String precioText, String
     * categoriaText, Integer idVendedor) {
     * super(nombre, descripcion, precioText, categoriaText, idVendedor);
     * }
     * 
     * // Constructor para metodo agregar bebida
     * public BebidaDto(String nombre, String descripcion, String precioText, String
     * categoriaText, Integer idVendedor,
     * String graduacionAlcoholicaText, String tamanoText, String volumenText) {
     * super(nombre, descripcion, precioText, categoriaText, idVendedor);
     * this.graduacionAlcoholicaText = graduacionAlcoholicaText;
     * this.tamanoText = tamanoText;
     * this.volumenText = volumenText;
     * }
     * 
     * // Constructor para metodo modificar bebida
     * public BebidaDto(String idText, String nombre, String descripcion, String
     * precioText, String categoriaText,
     * Integer idVendedor,
     * String graduacionAlcoholicaText, String tamanoText, String volumenText) {
     * super(idText, nombre, descripcion, precioText, categoriaText, idVendedor);
     * this.graduacionAlcoholicaText = graduacionAlcoholicaText;
     * this.tamanoText = tamanoText;
     * this.volumenText = volumenText;
     * }
     * 
     * public Double getGraduacionAlcoholica() {
     * return graduacionAlcoholica;
     * }
     * 
     * public void setGraduacionAlcoholica(Double graduacionAlcoholica) {
     * this.graduacionAlcoholica = graduacionAlcoholica;
     * }
     * 
     * public Double getTamano() {
     * return tamano;
     * }
     * 
     * public void setTamano(Double tamano) {
     * this.tamano = tamano;
     * }
     * 
     * public Double getVolumen() {
     * return volumen;
     * }
     * 
     * public void setVolumen(Double volumen) {
     * this.volumen = volumen;
     * }
     * 
     * public String getGraduacionAlcoholicaText() {
     * return graduacionAlcoholicaText;
     * }
     * 
     * public void setGraduacionAlcoholicaText(String graduacionAlcoholicaText) {
     * this.graduacionAlcoholicaText = graduacionAlcoholicaText;
     * }
     * 
     * public String getTamanoText() {
     * return tamanoText;
     * }
     * 
     * public void setTamanoText(String tamanoText) {
     * this.tamanoText = tamanoText;
     * }
     * 
     * public String getVolumenText() {
     * return volumenText;
     * }
     * 
     * public void setVolumenText(String volumenText) {
     * this.volumenText = volumenText;
     * }
     */

}
