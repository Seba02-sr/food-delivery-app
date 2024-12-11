package com.mycompany.tp.dsw.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.model.Vendedor;
import com.mycompany.tp.dsw.service.HibernateUtil;

public class VendedorDao extends GenericDAO<Vendedor, Integer> {

    public VendedorDao() {
        super(Vendedor.class);
    }

    public List<Vendedor> findActiveByNombre(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Crear la consulta HQL
            String hql = "FROM Vendedor v " +
                    "WHERE v.activo = true " +
                    "AND LOWER(v.nombre) LIKE :nombre";
            Query<Vendedor> query = session.createQuery(hql, Vendedor.class);

            // Asignar el parámetro de búsqueda, asegurándose de que se busque de forma
            // insensible a mayúsculas
            query.setParameter("nombre", "%" + nombre.toLowerCase() + "%");

            // Ejecutar la consulta y devolver los resultados
            List<Vendedor> resultados = query.list();

            if (resultados.isEmpty()) {
                throw new VendedorNoEncontradoException("No se ha encontrado el vendedor con nombre: " + nombre);
            }
            return resultados;
        } catch (Exception e) {
            String errorMessage = "Error al intentar recuperar el vendedor con el nombre: " + nombre;
            throw new RuntimeException(errorMessage, e);
        }
    }

    // Delete --> Usar deleteLogico
    // FindById --> Usar findByIdAndActive
    // FindAll --> Usar findAllActive

}
