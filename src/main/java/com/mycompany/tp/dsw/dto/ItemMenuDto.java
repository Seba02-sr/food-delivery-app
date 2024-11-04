package com.mycompany.tp.dsw.dto;

import java.math.BigDecimal;

import com.mycompany.tp.dsw.model.Categoria;
import com.mycompany.tp.dsw.model.Vendedor;

public abstract class ItemMenuDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Categoria categoria;
    private Vendedor vendedor;

    /**
     * Atributos para el manejo de los errores.
     * - Un string es mas facil manejar y permite null.
     * - El parseo de un null a Integer no se puede.
     * 
     * Al asegurarse que no contengan NULL, se parsea a Double/Integer
     * Luego setear el atributo
     */

    private String idText;
    private String precioText;
    private String categoriaText;

    // Constructor para metodo agregar ItemMenu
    public ItemMenuDto(String nombre, String descripcion, String precioText, String categoriaText, Vendedor vendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioText = precioText;
        this.categoriaText = categoriaText;
        this.vendedor = vendedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getIdText() {
        return idText;
    }

    public void setIdText(String idText) {
        this.idText = idText;
    }

    public String getPrecioText() {
        return precioText;
    }

    public void setPrecioText(String precioText) {
        this.precioText = precioText;
    }

    public String getCategoriaText() {
        return categoriaText;
    }

    public void setCategoriaText(String categoriaText) {
        this.categoriaText = categoriaText;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

}
