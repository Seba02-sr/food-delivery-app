package com.mycompany.tp.dsw.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
    /**
     * Guarda una entidad en la base de datos.
     * 
     * @param entity Entidad a guardar.
     */
    void save(T entity);

    /**
     * Actualiza una entidad existente en la base de datos.
     * 
     * @param entity Entidad a actualizar.
     */
    void update(T entity);

    /**
     * Elimina una entidad de la base de datos.
     * 
     * @param entity Entidad a eliminar.
     */
    void delete(T entity);

    /**
     * Elimina logicamente una entidad de la base de datos.
     * - Marca el atributo activo como false
     * 
     * @param entity Entidad a eliminar
     */
    void deleteLogico(ID id);

    /**
     * Busca una entidad por su ID.
     * 
     * @param id Identificador de la entidad.
     * @return La entidad encontrada o null si no existe.
     */
    T findById(ID id);

    /**
     * Recupera todas las entidades del tipo dado.
     * 
     * @return Lista de todas las entidades.
     */
    List<T> findAll();
}