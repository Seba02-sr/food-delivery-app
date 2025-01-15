package com.mycompany.tp.dsw.dao;

import java.util.List;

import org.hibernate.Session;

import com.mycompany.tp.dsw.model.Cliente;
import com.mycompany.tp.dsw.service.HibernateUtil;

public class ClienteDao extends GenericDAO<Cliente, Integer> {

    // Delete --> Usar deleteLogico
    // findById --> Usar findByIdAndActive
    // finaAll --> Usar findAllActive

    public ClienteDao() {
        super(Cliente.class);
    }

    public List<Cliente> findActiveByNombre(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Cliente c " +
                    "WHERE c.activo = true " +
                    "AND c.nombre LIKE :nombre";

            List<Cliente> clientes = session.createQuery(hql, Cliente.class)
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList();

            return clientes;

        } catch (Exception e) {
            String errorMessage = "Error al intentar recuperar los cliente con nombre: " + nombre;
            throw new RuntimeException(errorMessage, e);
        }
    }

}
