package com.mycompany.tp.dsw.dao;

import java.util.List;

import org.hibernate.Session;

import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.model.Cliente;
import com.mycompany.tp.dsw.service.HibernateUtil;

public class ClienteDao extends GenericDAO<Cliente, Integer> {

    public ClienteDao() {
        super(Cliente.class);
    }

    // Delete --> Usar deleteLogico
    // findById --> Usar findByIdAndActive
    // finaAll --> Usar findAllActive
    public List<Cliente> findActiveByNombre(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Cliente c " +
                    "WHERE c.activo = true " +
                    "AND c.nombre LIKE :nombre";

            List<Cliente> clientes = session.createQuery(hql, Cliente.class)
                    .setParameter("nombre", "%" + nombre + "%")
                    .getResultList();

            if (clientes.isEmpty()) {
                throw new ClienteNoEncontradoException("No se encontraron clientes con nombre:" + nombre);
            }
            return clientes;

        } catch (Exception e) {
            String errorMessage = "Error al intentar recuperar los cliente con nombre: " + nombre;
            throw new RuntimeException(errorMessage, e);
        }
    }

}
