package com.mycompany.tp.dsw.dto;

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
    private String graduacionAlcoholicaText;
    private String tamanoText;
    private String volumenText;

    // Constructor para metodo agregar bebida
    public BebidaDto(String nombre, String descripcion, String precioText, String categoriaText,
            String graduacionAlcoholicaText, String tamanoText, String volumenText) {
        super(nombre, descripcion, precioText, categoriaText);
        this.graduacionAlcoholicaText = graduacionAlcoholicaText;
        this.tamanoText = tamanoText;
        this.volumenText = volumenText;
    }

    public Double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(Double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public Double getTamano() {
        return tamano;
    }

    public void setTamano(Double tamano) {
        this.tamano = tamano;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public String getGraduacionAlcoholicaText() {
        return graduacionAlcoholicaText;
    }

    public void setGraduacionAlcoholicaText(String graduacionAlcoholicaText) {
        this.graduacionAlcoholicaText = graduacionAlcoholicaText;
    }

    public String getTamanoText() {
        return tamanoText;
    }

    public void setTamanoText(String tamanoText) {
        this.tamanoText = tamanoText;
    }

    public String getVolumenText() {
        return volumenText;
    }

    public void setVolumenText(String volumenText) {
        this.volumenText = volumenText;
    }

}
