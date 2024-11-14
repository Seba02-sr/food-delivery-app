/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tp.dsw.view;

import java.util.Map;

import com.mycompany.tp.dsw.memory.VendedorMemory;
import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.service.MemoryManager;
import com.mycompany.tp.dsw.service.ValidarVendedor;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FrmAgregarVendedor extends javax.swing.JFrame {

    private final VendedorMemory vendedorMemory;
    private final MemoryManager memoryManager;

    public FrmAgregarVendedor(VendedorMemory vendedorMemory) {
        initComponents();
        this.setTitle("Agregar Vendedor");
        this.setLocationRelativeTo(null);
        this.setSize(440, 280);
        this.setResizable(false);
        memoryManager = MemoryManager.getInstance();
        this.vendedorMemory = memoryManager.getVendedorMemory();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtLongitud = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLatitud = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(440, 235));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(440, 235));
        jPanel1.setPreferredSize(new java.awt.Dimension(440, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Longitud:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 70, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 198, 150, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

        txtLongitud.setForeground(new java.awt.Color(51, 51, 51));
        txtLongitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLongitudActionPerformed(evt);
            }
        });
        jPanel1.add(txtLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 220, -1));

        jLabel4.setText("Latitud:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 70, -1));

        txtLatitud.setForeground(new java.awt.Color(51, 51, 51));
        txtLatitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLatitudActionPerformed(evt);
            }
        });
        jPanel1.add(txtLatitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 220, -1));

        jLabel3.setText("Direccion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 70, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 198, 150, -1));

        txtNombre.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 220, -1));

        txtDireccion.setForeground(new java.awt.Color(51, 51, 51));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtDireccionActionPerformed

    private void txtLongitudActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtLongitudActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtLongitudActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtNombreActionPerformed

    private void txtLatitudActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtLatitudActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtLatitudActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {

        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String latitudTexto = txtLatitud.getText();
        String longitudTexto = txtLongitud.getText();

        VendedorDto vendedorDto = new VendedorDto(nombre, direccion, latitudTexto, longitudTexto);

        Map<String, String> errores = ValidarVendedor.esGuardarValido(vendedorDto);

        if (errores.isEmpty()) {
            vendedorMemory.registrarVendedor(vendedorDto);
            JOptionPane.showMessageDialog(null, "Vendedor creado exitosamente");
            this.dispose();
        } else {
            errores.forEach((campo, mensaje) -> JOptionPane.showMessageDialog(null, mensaje, "Error en " + campo,
                    JOptionPane.ERROR_MESSAGE));
        }

    }// GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }// GEN-LAST:event_btnCancelarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarVendedor.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarVendedor.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarVendedor.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarVendedor.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmAgregarVendedor(new VendedorMemory()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
