package com.mycompany.tp.dsw.model;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import com.mycompany.tp.dsw.service.HibernateUtil;

public class TableTest {

    private static final Logger logger = Logger.getLogger(TableTest.class.getName());

    @Test
    void crearTablaTest() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;

        try {
            session = sessionFactory.openSession();
            logger.info("Sesión abierta correctamente.");
        } catch (Exception e) {
            logger.info("Error al abrir la sesión");
        } finally {
            if (session != null) {
                session.close();
                logger.info("Sesión cerrada correctamente.");
            }
            HibernateUtil.shutdown();
        }
    }

}
