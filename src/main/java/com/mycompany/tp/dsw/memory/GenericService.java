package com.mycompany.tp.dsw.memory;

import java.io.Serializable;
import java.util.List;

import com.mycompany.tp.dsw.dao.GenericDAO;

public abstract class GenericService<T, ID extends Serializable> { // Creo que no necesito esta clase
    private final GenericDAO<T, ID> genericDAO;

    public GenericService(Class<T> persistentClass) {
        this.genericDAO = new GenericDAO<>(persistentClass);
    }

    /**
     * Guarda una entidad en la base de datos.
     * 
     * @param entity Entidad a guardar.
     */
    public void save(T entity) {
        genericDAO.save(entity);
    }

    /**
     * Actualiza una entidad existente en la base de datos.
     * 
     * @param entity Entidad a actualizar.
     */
    public void update(T entity) {
        genericDAO.update(entity);
    }

    /**
     * Elimina una entidad de la base de datos.
     * 
     * @param entity Entidad a eliminar.
     */
    public void delete(T entity) {
        genericDAO.delete(entity);
    }

    /**
     * Busca una entidad por su ID.
     * 
     * @param id ID de la entidad.
     * @return Entidad encontrada o null si no existe.
     */
    public T findById(ID id) {
        return genericDAO.findById(id);
    }

    /**
     * Obtiene todas las entidades de la tabla.
     * 
     * @return Lista de entidades.
     */
    public List<T> findAll() {
        return genericDAO.findAll();
    }
    // Me parece que de aca a abajo no se puede tener, sino todas entidades que
    // tienen dao tienen que extender de activable
    /*
     * public void deleteLogico(ID id) {
     * // Actualizar el campo "activo" a false en vez de eliminar la entidad
     * try (Session session = HibernateUtil.getSessionFactory().openSession()) {
     * T entity = session.get(persistentClass, id);
     * 
     * if (entity != null && entity.getActivo()) {
     * Transaction transaction = session.beginTransaction();
     * 
     * // Marcamos la entidad como "eliminada"
     * entity.setActivo(false);
     * entity.setFechaEliminacion(LocalDate.now());
     * 
     * // Actualizamos la entidad
     * session.update(entity);
     * 
     * transaction.commit();
     * }
     * } catch (Exception e) {
     * throw new RuntimeException("Error al eliminar la entidad", e);
     * }
     * }
     * 
     * public T findById(ID id) {
     * try (Session session = HibernateUtil.getSessionFactory().openSession()) {
     * T entity = session.get(persistentClass, id);
     * // Verificar si la entidad está activa
     * if (entity != null && entity.getActivo()) {
     * return entity;
     * }
     * return null; // O lanzar una excepción si prefieres
     * }
     * }
     * 
     * public List<T> findAll() {
     * try (Session session = HibernateUtil.getSessionFactory().openSession()) {
     * // Crear una consulta que recupere solo las entidades activas
     * String hql = "from " + persistentClass.getName() + " where activo = true";
     * return session.createQuery(hql, persistentClass).list();
     * }
     * }
     */
}
