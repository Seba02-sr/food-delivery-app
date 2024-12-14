package com.mycompany.tp.dsw.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mycompany.tp.dsw.exception.ItemNoEncontradoException;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.service.HibernateUtil;

public class ItemMenuDao extends GenericDAO<ItemMenu, Integer> {

    public ItemMenuDao() {
        super(ItemMenu.class);
    }

    // Delete --> Usar deleteLogico
    // findAll --> Usar findAllActive
    // findById --> Usar findByIdAndActive
    public List<ItemMenu> findActiveByNombre2(String nombre, Integer id) { // Creo que no se usa
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM ItemMenu im " +
                    "WHERE im.nombre LIKE :nombre " +
                    "AND im.activo = true " +
                    "AND im.vendedor.id = :id " +
                    "AND im.vendedor.activo = true";

            List<ItemMenu> itemsMenu = session.createQuery(hql, ItemMenu.class)
                    .setParameter("nombre", "%" + nombre + "%")
                    .setParameter("id", id)
                    .getResultList();

            if (itemsMenu.isEmpty()) {
                throw new ItemNoEncontradoException("No se ha encontrado el item menu con nombre: " + nombre);
            }
            return itemsMenu;
        } catch (Exception e) {
            String errorMessage = "Error al intentar recuperar los item menu con nombre: " + nombre;
            throw new RuntimeException(errorMessage, e);
        }
    }

    public List<ItemMenu> findByVendedorId(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM ItemMenu im " +
                    "WHERE im.vendedor.id = :id " +
                    "AND im.vendedor.activo = true";

            List<ItemMenu> itemsMenu = session.createQuery(hql, ItemMenu.class)
                    .setParameter("id", id)
                    .getResultList();

            return itemsMenu;
        } catch (HibernateException e) {
            String errorMessage = "Error al intentar recuperar los item menu del vendedor con id: " + id;
            throw new RuntimeException(errorMessage, e);
        }
    }

    public List<ItemMenu> findActiveByNombre(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM ItemMenu im " +
                    "WHERE im.nombre LIKE :nombre " +
                    "AND im.activo = true";

            List<ItemMenu> itemsMenu = session.createQuery(hql, ItemMenu.class)
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList();

            return itemsMenu;
        } catch (Exception e) {
            String errorMessage = "Error al intentar recuperar los item menu con nombre: " + nombre;
            throw new RuntimeException(errorMessage, e);
        }
    }
}
