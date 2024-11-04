package com.mycompany.tp.dsw.dto;

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
     * - Idem con Boolean
     * 
     * Al asegurarse que no contengan NULL, se parsea a Double/Boolean
     * Luego setear el atributo
     */
    private String caloriasText;
    // Ver si no los necesito a los boolean, los cambio
    // Cambiar el constructor y sacar los string, dejar solo los boolean
    private String aptoCeliacoText;
    private String aptoVegetarianoText;
    private String aptoVeganoText;
    private String pesoText;

    // Constructor para metodo agregar Plato
    public PlatoDto(String nombre, String descripcion, String precioText, String categoriaText, String caloriasText,
            String aptoCeliacoText, String aptoVegetarianoText, String aptoVeganoText, String pesoText) {
        super(nombre, descripcion, precioText, categoriaText);
        this.caloriasText = caloriasText;
        this.aptoCeliacoText = aptoCeliacoText;
        this.aptoVegetarianoText = aptoVegetarianoText;
        this.aptoVeganoText = aptoVeganoText;
        this.pesoText = pesoText;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public Boolean getAptoCeliaco() {
        return aptoCeliaco;
    }

    public void setAptoCeliaco(Boolean aptoCeliaco) {
        this.aptoCeliaco = aptoCeliaco;
    }

    public Boolean getAptoVegetariano() {
        return aptoVegetariano;
    }

    public void setAptoVegetariano(Boolean aptoVegetariano) {
        this.aptoVegetariano = aptoVegetariano;
    }

    public Boolean getAptoVegano() {
        return aptoVegano;
    }

    public void setAptoVegano(Boolean aptoVegano) {
        this.aptoVegano = aptoVegano;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getCaloriasText() {
        return caloriasText;
    }

    public void setCaloriasText(String caloriasText) {
        this.caloriasText = caloriasText;
    }

    public String getAptoCeliacoText() {
        return aptoCeliacoText;
    }

    public void setAptoCeliacoText(String aptoCeliacoText) {
        this.aptoCeliacoText = aptoCeliacoText;
    }

    public String getAptoVegetarianoText() {
        return aptoVegetarianoText;
    }

    public void setAptoVegetarianoText(String aptoVegetarianoText) {
        this.aptoVegetarianoText = aptoVegetarianoText;
    }

    public String getAptoVeganoText() {
        return aptoVeganoText;
    }

    public void setAptoVeganoText(String aptoVeganoText) {
        this.aptoVeganoText = aptoVeganoText;
    }

    public String getPesoText() {
        return pesoText;
    }

    public void setPesoText(String pesoText) {
        this.pesoText = pesoText;
    }

}
