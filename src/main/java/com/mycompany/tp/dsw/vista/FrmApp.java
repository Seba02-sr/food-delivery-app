/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tp.dsw.vista;

import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class FrmApp extends javax.swing.JFrame {

    final static String VENDEDORES = "Vendedores";
    final static String CLIENTES = "Clientes";
    JplVendedor vendedorPane;
    JplCliente clientePane;
    JplItemMenu itemMenuPane;

    public FrmApp() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(1000, 540);
        setResizable(false);

        vendedorPane = new JplVendedor(this);
        clientePane = new JplCliente(); // Si hay error puede ser por aca ##############
        itemMenuPane = new JplItemMenu(this);

        jTabbedPane.add(VENDEDORES, vendedorPane);
        jTabbedPane.add(CLIENTES, clientePane);

        jTabbedPane.addChangeListener(e -> cambiarVentana(jTabbedPane.getSelectedIndex()));
    }

    private void cambiarVentana(int selectedIndex) {
        // Aquí se puede agregar lógica adicional si es necesario
        if (selectedIndex == 0) {
            // Muestra la vista de Vendedores
            vendedorPane.setVisible(true);
            clientePane.setVisible(false);
        } else if (selectedIndex == 1) {
            // Muestra la vista de Clientes
            vendedorPane.setVisible(false);
            clientePane.setVisible(true);
        }
    }

    public void cambiarPanel(javax.swing.JPanel panel) {
        setContentPane(panel); // Cambiamos el contenido principal
        revalidate(); // Actualizamos la vista
        repaint(); // Redibujamos el JFrame
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
        jTabbedPane = new javax.swing.JTabbedPane();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 460));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 130, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }// GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmApp().setVisible(true);
            }
        });
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
