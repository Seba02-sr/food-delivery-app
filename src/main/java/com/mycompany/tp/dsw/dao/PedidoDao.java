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
            String hql = "FROM Pedido p " +
                    "WHERE p.cliente.id = :idCliente " +
                    "AND p.cliente.activo = true";

            List<Pedido> pedidos = session.createQuery(hql, Pedido.class)
                    .setParameter("idCliente", idCliente)
                    .getResultList();

            if (pedidos.isEmpty()) {
                throw new ClienteNoEncontradoException("No se encontraron pedidos del cliente con ID:" + idCliente);
            }
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

            if (pedidos.isEmpty()) {
                throw new PedidoNoEncontradoException("No se encontraron pedido con estado:" + estado);
            }
            return pedidos;

        } catch (Exception e) {
            String errorMessage = "Error al intentar recuperar los pedidos con el estado:" + estado;
            throw new RuntimeException(errorMessage, e);
        }
    }

    public List<Pedido> findByIdVendedor(Integer idVendedor) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Consulta HQL para obtener los pedidos asociados al vendedor con el ID dado
            String hql = "SELECT p FROM Pedido p " +
                    "JOIN p.pedidoItemPedidos pip " +
                    "JOIN pip.itemPedido ip " +
                    "JOIN ip.itemMenu im " +
                    "JOIN im.itemVendedores iv " +
                    "WHERE iv.vendedor.id = :idVendedor" +
                    "AND iv.vendedor.activo = true";

            // Ejecutar la consulta y devolver la lista de pedidos
            List<Pedido> pedidos = session.createQuery(hql, Pedido.class)
                    .setParameter("idVendedor", idVendedor)
                    .getResultList();

            if (pedidos.isEmpty()) {
                throw new PedidoNoEncontradoException("No se encontraron pedidos al vendedor:" + idVendedor);
            }
            return pedidos;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar los pedidos por vendedor", e);
        }
    }
}
