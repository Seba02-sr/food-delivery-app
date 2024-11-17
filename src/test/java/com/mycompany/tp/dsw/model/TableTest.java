package com.mycompany.tp.dsw.model;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.service.HibernateUtil;

public class TableTest {

    private static final Logger logger = Logger.getLogger(TableTest.class.getName());

    @Test
    void crearTablaTest() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;

        try {
            // 1. Abrir session en la Base de Datos
            session = sessionFactory.openSession();
            logger.info("Sesión abierta correctamente.");
        } catch (Exception e) {
            logger.info("Error al abrir la sesión");
        } finally {
            // 2. Cerrar la session
            if (session != null) {
                session.close();
                logger.info("Sesión cerrada correctamente.");
            }
            HibernateUtil.shutdown();
        }
    }

    @Test
    void crearTablaTest2() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;

        try {
            // 1. Abrir session en la Base de Datos
            session = sessionFactory.openSession();
            logger.info("Sesión abierta correctamente.");

            // Verificar si Hibernate genera el esquema
            session.beginTransaction();
            // Puedes intentar hacer alguna consulta o acción que verifique la creación de
            // la tabla.
            // Por ejemplo, verificar que la entidad Vendedor se puede persistir
            // correctamente:
            VendedorDto vendedorDto = new VendedorDto("Nombre", "Direccion", "Latitud", "Longitud");
            Vendedor vendedor = new Vendedor(vendedorDto);
            session.save(vendedor);
            session.getTransaction().commit();
            logger.info("Vendedor guardado correctamente.");

        } catch (Exception e) {
            logger.severe("Error al abrir la sesión o al realizar operaciones de persistencia.");
            e.printStackTrace();
        } finally {
            // 2. Cerrar la session
            if (session != null) {
                session.close();
                logger.info("Sesión cerrada correctamente.");
            }
            HibernateUtil.shutdown();
        }
    }

}
