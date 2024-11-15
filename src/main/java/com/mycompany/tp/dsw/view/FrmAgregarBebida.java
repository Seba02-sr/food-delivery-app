/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tp.dsw.view;

import com.mycompany.tp.dsw.dto.BebidaDto;
import com.mycompany.tp.dsw.memory.BebidaMemory;
import com.mycompany.tp.dsw.service.MemoryManager;

/**
 *
 * @author Usuario
 */
public class FrmAgregarBebida extends javax.swing.JDialog {

    private final MemoryManager memoryManager;
    private final BebidaMemory bebidaMemory;
    private final BebidaDto bebidaDto;
    private FrmItemMenu itemMenuForm;

    public FrmAgregarBebida(BebidaDto bebidaDto, FrmAgregarItem agregarItemForm) {
        super(agregarItemForm, true);
        initComponents();
        memoryManager = MemoryManager.getInstance();
        this.bebidaDto = bebidaDto;
        bebidaMemory = memoryManager.getBebidaMemory();

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        txtTamaño = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtVolumen = new javax.swing.JTextField();
        jSpinnerGraduacionAlcoholica = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(440, 235));
        jPanel1.setPreferredSize(new java.awt.Dimension(440, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Graduacion Alcoholica:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, -1));

        jLabel3.setText("Tamaño:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 70, -1));

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 100, -1));

        txtTamaño.setForeground(new java.awt.Color(51, 51, 51));
        txtTamaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamañoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 220, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 100, -1));

        jLabel4.setText("Volumen:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 70, -1));

        txtVolumen.setForeground(new java.awt.Color(51, 51, 51));
        txtVolumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVolumenActionPerformed(evt);
            }
        });
        jPanel1.add(txtVolumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 220, -1));
        jPanel1.add(jSpinnerGraduacionAlcoholica, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 452, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 204, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
    }// GEN-LAST:event_btnAtrasActionPerformed

    private void txtTamañoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtTamañoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtTamañoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGuardarActionPerformed
        String graduacionAlcoholica = jSpinnerGraduacionAlcoholica.getValue().toString();
        String tamano = txtTamaño.getText();
        String volumen = txtVolumen.getText();

        bebidaDto.setGraduacionAlcoholicaText(graduacionAlcoholica);
        bebidaDto.setTamanoText(tamano);
        bebidaDto.setVolumenText(volumen);

        bebidaMemory.registrarBebida(bebidaDto);
        itemMenuForm.inicializarTabla();
        this.dispose();
    }// GEN-LAST:event_btnGuardarActionPerformed

    private void txtVolumenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtVolumenActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtVolumenActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAgregarBebida.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarBebida.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarBebida.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgregarBebida.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAgregarBebida(new BebidaDto(),
                        new FrmAgregarItem(null, null, null)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerGraduacionAlcoholica;
    private javax.swing.JTextField txtTamaño;
    private javax.swing.JTextField txtVolumen;
    // End of variables declaration//GEN-END:variables
}
