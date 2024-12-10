package com.mycompany.tp.dsw.memory;

import com.mycompany.tp.dsw.dao.GenericDAO;
import com.mycompany.tp.dsw.service.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {
    private final Class<T> persistentClass;

    protected GenericDAOImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public void save(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al guardar la entidad", e);
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Actualizar la entidad directamente
            session.update(entity); // Hibernate buscará la entidad por el ID y la actualizará si existe
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al actualizar la entidad", e);
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al eliminar la entidad", e);
        }
    }

    // Me parece que de aca a abajo no se puede tener, sino todas entidades que
    // tienen dao tienen que extender de activable
    @Override
    public void deleteLogico(ID id) {
        // Actualizar el campo "activo" a false en vez de eliminar la entidad
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            T entity = session.get(persistentClass, id);

            if (entity != null && entity.getActivo()) {
                Transaction transaction = session.beginTransaction();

                // Marcamos la entidad como "eliminada"
                entity.setActivo(false);
                entity.setFechaEliminacion(LocalDate.now());

                // Actualizamos la entidad
                session.update(entity);

                transaction.commit();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la entidad", e);
        }
    }

    @Override
    public T findById(ID id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            T entity = session.get(persistentClass, id);
            // Verificar si la entidad está activa
            if (entity != null && entity.getActivo()) {
                return entity;
            }
            return null; // O lanzar una excepción si prefieres
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Crear una consulta que recupere solo las entidades activas
            String hql = "from " + persistentClass.getName() + " where activo = true";
            return session.createQuery(hql, persistentClass).list();
        }
    }
}
