package com.mycompany.tp.dsw.dao;

import java.util.List;

import org.hibernate.Session;

import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.model.Estado;
import com.mycompany.tp.dsw.model.Pedido;
import com.mycompany.tp.dsw.service.HibernateUtil;

public class PedidoDao extends GenericDAO<Pedido, Integer> {

    public PedidoDao() {
        super(Pedido.class);
    }

    public List<Pedido> findByCliente(Integer idCliente) throws ClienteNoEncontradoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT DISTINCT p FROM Pedido p " +
                    "JOIN FETCH p.pedidoItemPedidos pip " +
                    "JOIN FETCH pip.itemPedido ip " +
                    "JOIN FETCH ip.itemMenu im " +
                    "JOIN FETCH im.vendedor v " +
                    "WHERE p.cliente.id = :idCliente " +
                    "AND p.cliente.activo = true";

            List<Pedido> pedidos = session.createQuery(hql, Pedido.class)
                    .setParameter("idCliente", idCliente)
                    .getResultList();

            return pedidos;

        } catch (Exception e) {
            String errorMessage = "Error al intentar recuperar los pedidos para el cliente con ID: " + idCliente;
            throw new RuntimeException(errorMessage, e);
        }
    }

    public List<Pedido> findByEstado(Estado estado) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Pedido p " +
                    "WHERE p.estado = :estado ";

            List<Pedido> pedidos = session.createQuery(hql, Pedido.class)
                    .setParameter("estado", estado)
                    .getResultList();

            return pedidos;

        } catch (Exception e) {
            String errorMessage = "Error al intentar recuperar los pedidos con el estado:" + estado;
            throw new RuntimeException(errorMessage, e);
        }
    }

    public List<Pedido> findByIdVendedor(Integer idVendedor) throws PedidoNoEncontradoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM Pedido p " +
                    "JOIN FETCH p.pedidoItemPedidos pip " +
                    "JOIN FETCH pip.itemPedido ip " +
                    "JOIN FETCH ip.itemMenu im " +
                    "WHERE im.vendedor.activo = true " +
                    "AND im.vendedor.id = :idVendedor";
            List<Pedido> pedidos = session.createQuery(hql, Pedido.class)
                    .setParameter("idVendedor", idVendedor)
                    .getResultList();

            return pedidos;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar los pedidos por vendedor", e);
        }
    }

    public Pedido findPedidoByIdWithItem(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT p FROM Pedido p " +
                    "JOIN FETCH p.pedidoItemPedidos pip " +
                    "JOIN FETCH pip.itemPedido ip " +
                    "WHERE p.id = :id ";

            Pedido pedidos = session.createQuery(hql, Pedido.class)
                    .setParameter("id", id)
                    .uniqueResult();

            return pedidos;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar los pedidos por vendedor", e);
        }
    }
}
