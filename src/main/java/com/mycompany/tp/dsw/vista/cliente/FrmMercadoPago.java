/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tp.dsw.vista.cliente;

import java.math.BigDecimal;

import com.mycompany.tp.dsw.controller.ClienteController;
import com.mycompany.tp.dsw.controller.PagoController;
import com.mycompany.tp.dsw.controller.PedidoController;
import com.mycompany.tp.dsw.dto.ClienteDto;
import com.mycompany.tp.dsw.dto.MercadoPagoDto;
import com.mycompany.tp.dsw.dto.PedidoDto;
import com.mycompany.tp.dsw.exception.NoValidarException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.service.MensajeAlerta;

/**
 *
 * @author Usuario
 */
public class FrmMercadoPago extends javax.swing.JFrame {

    private String idPedido;
    private String idCliente;
    private PedidoController pedidoController;
    private ClienteController clienteController;
    private PagoController pagoController;

    public FrmMercadoPago() {

    }

    public FrmMercadoPago(String idPedido, String idCliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        pedidoController = new PedidoController();
        clienteController = new ClienteController();
        pagoController = new PagoController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("ALIAS :");

        txtAlias.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 213,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 53, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnCancelar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnPagar)))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnPagar))
                                .addContainerGap()));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }// GEN-LAST:event_btnCancelarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPagarActionPerformed
        try {
            PedidoDto pedidoDto = pedidoController.obtenerPedidoPorId(idPedido);
            ClienteDto clienteDto = clienteController.buscarClientePorId(idCliente);

            String alias = txtAlias.getText();

            MercadoPagoDto mercadoPagoDto = pagoController.crearMercadoPagoDto(alias);

            pedidoDto.setFormaPagoDto(mercadoPagoDto);

            BigDecimal totalAPagar = pedidoController.calcularTotalAPagar(pedidoDto);

            MensajeAlerta.mostrarConfirmacion(
                    "Pagar con mercado pago tiene un recargo del 4%.\nMonto total a pagar: " + totalAPagar,
                    "Pagar con Transferencia", this);

            pedidoController.actualizarPedido(pedidoDto, clienteDto);
            this.dispose();
        } catch (PedidoNoEncontradoException e) {
            MensajeAlerta.mostrarError(e.getMessage(), "Error Pagar Mercado Pago");
        } catch (NoValidarException e) {
            MensajeAlerta.mostrarError(e.getMessage(), "Error al Pagar con Mercado Pago");
        }

    }// GEN-LAST:event_btnPagarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMercadoPago.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMercadoPago.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMercadoPago.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMercadoPago.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMercadoPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAlias;
    // End of variables declaration//GEN-END:variables
}
