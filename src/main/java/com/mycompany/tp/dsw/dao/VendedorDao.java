package com.mycompany.tp.dsw.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mycompany.tp.dsw.memory.GenericDAOImpl;
import com.mycompany.tp.dsw.model.Vendedor;
import com.mycompany.tp.dsw.service.HibernateUtil;

public class VendedorDao extends GenericDAOImpl<Vendedor, Integer> {

    public VendedorDao() {
        super(Vendedor.class);
    }

    public List<Vendedor> findByNombre(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Crear la consulta HQL
            String hql = "FROM Vendedor v WHERE LOWER(v.nombre) LIKE :nombre";
            Query<Vendedor> query = session.createQuery(hql, Vendedor.class);

            // Asignar el parámetro de búsqueda, asegurándose de que se busque de forma
            // insensible a mayúsculas
            query.setParameter("nombre", "%" + nombre.toLowerCase() + "%");

            // Ejecutar la consulta y devolver los resultados
            List<Vendedor> resultados = query.list();

            return resultados;
        }
    }
}
