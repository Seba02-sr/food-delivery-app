/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tp.dsw.vista.cliente;

import com.mycompany.tp.dsw.controller.PedidoController;
import com.mycompany.tp.dsw.dto.PedidoDto;
import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.exception.NoValidarException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.service.MensajeAlerta;
import com.mycompany.tp.dsw.vista.util.HeaderFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class FrmVerPedidos extends javax.swing.JFrame {

    private String idCliente;
    private PedidoController pedidoController;

    public FrmVerPedidos(String idCliente) {
        initComponents();

        pedidoController = new PedidoController();
        this.idCliente = idCliente;
        this.setLocationRelativeTo(null);
        setearTituloTabla();
        initDatos();
        poputTable();
    }

    public void initDatos() {
        try {
            List<PedidoDto> pedidosDto = pedidoController.obtenerPedidosPorCliente(idCliente);
            mostrarTabla(pedidosDto);
        } catch (ClienteNoEncontradoException e) {
            MensajeAlerta.mostrarError("Cliente no encontrado. \nID: " + idCliente, "Error Ver Pedidos");
        } catch (NoValidarException e) {
            MensajeAlerta.mostrarError(e.getMessage(), "Error al ver pedidos");
        }

    }

    public void poputTable() {
        jPopupMenu.add(jmiVerDetalles);
        tbPedidos.setComponentPopupMenu(jPopupMenu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPopupMenu = new javax.swing.JPopupMenu();
        jmiVerDetalles = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        jmiVerDetalles.setText("Ver Detalles");
        jmiVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVerDetallesActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(518, 260));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 640, Short.MAX_VALUE));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE));

        jPanel2.setPreferredSize(new java.awt.Dimension(518, 260));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 640, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE));

        jPanel1.setLayout(new java.awt.BorderLayout());

        tbPedidos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {

                }));
        tbPedidos.setRowHeight(25);
        jScrollPane1.setViewportView(tbPedidos);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCancelar)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 640,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 640,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addContainerGap())
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(326, 326, 326)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jmiVerDetallesActionPerformed
        int selectedRow = tbPedidos.getSelectedRow();
        if (selectedRow != -1) {
            String idPedido = tbPedidos.getValueAt(selectedRow, 0).toString();
            FrmVerDetallesPedido verDetallePedidoForm = new FrmVerDetallesPedido(idPedido, idCliente);
            verDetallePedidoForm.setVisible(true);
            this.dispose();
        } else {
            MensajeAlerta.mostrarInformacion("Por favor seleccione un pedido", "Error al ver detalles del pedido");
        }
    }// GEN-LAST:event_jmiVerDetallesActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }// GEN-LAST:event_btnCancelarActionPerformed

    public void setearTituloTabla() {
        DefaultTableModel model = new DefaultTableModel();
        String[] titulo = { "PEDIDO", "RESTAURANTE", "TOTAL", "CANTIDAD ARTICULOS", "ESTADO" };
        model.setColumnIdentifiers(titulo);
        tbPedidos.setModel(model);

        // Personalizar el encabezado
        JTableHeader header = tbPedidos.getTableHeader();
        header.setDefaultRenderer(new HeaderFormatter());
    }

    public void mostrarTabla(List<PedidoDto> pedidos) {
        // Asegurarse de que la tabla tenga el modelo configurado
        if (tbPedidos.getModel() == null || !(tbPedidos.getModel() instanceof DefaultTableModel)) {
            setearTituloTabla(); // Configura el encabezado y el modelo si no está configurado
        }

        DefaultTableModel model = (DefaultTableModel) tbPedidos.getModel(); // Recupera el modelo
        try {
            if (pedidos != null && !pedidos.isEmpty()) {
                for (PedidoDto pedido : pedidos) {
                    Object[] fila = new Object[5];
                    fila[0] = pedido.getId();
                    fila[1] = pedidoController.obtenerNombreVendedor(pedido);
                    fila[2] = pedidoController.calcularTotalAPagarSinRecargo(pedido);
                    fila[3] = pedidoController.obtenerCantidadItems(pedido);
                    fila[4] = pedido.getEstado();
                    model.addRow(fila);
                }
            }
        } catch (PedidoNoEncontradoException e) {
            MensajeAlerta.mostrarError(e.getMessage(), "Error al ver pedidos");
        }

        tbPedidos.setModel(model);
        // Ajustar el ancho de las columnas
        ajustarAnchoColumnas(tbPedidos);
    }

    private void ajustarAnchoColumnas(JTable tabla) {
        // Itera sobre cada columna
        for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
            TableColumn tableColumn = tabla.getColumnModel().getColumn(columna);
            int anchoPreferido = tabla.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(tabla, tableColumn.getHeaderValue(), false, false, -1, columna)
                    .getPreferredSize().width;

            tableColumn.setPreferredWidth(anchoPreferido);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVerPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVerPedidos("101").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmiVerDetalles;
    private javax.swing.JTable tbPedidos;
    // End of variables declaration//GEN-END:variables
}
