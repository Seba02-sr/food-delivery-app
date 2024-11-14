/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tp.dsw.view;

import com.mycompany.tp.dsw.dao.ItemMenuDao;
import com.mycompany.tp.dsw.memory.ItemMenuMemory;
import com.mycompany.tp.dsw.model.Bebida;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.Plato;

/**
 *
 * @author Usuario
 */
public class FrmVerDetalles extends javax.swing.JFrame {

    private String idItem;
    private final ItemMenuDao itemMenuDao;
    public FrmVerDetalles(String idItem) {
        initComponents();
        this.idItem = idItem;
        this.itemMenuDao = new ItemMenuMemory();
        verTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(200, 270));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(170, 270));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea.setColumns(20);
        jTextArea.setLineWrap(true);
        jTextArea.setRows(5);
        jTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void verTabla(){
        Integer id = Integer.parseInt(idItem);
        ItemMenu itemMenu = itemMenuDao.filtrarPorId(id);

        // Concatenar información en una sola cadena
        StringBuilder detalles = new StringBuilder();
        detalles.append("ID: ").append(itemMenu.getId()).append("\n");
        detalles.append("Nombre: ").append(itemMenu.getNombre()).append("\n");
        detalles.append("Precio: ").append(itemMenu.getPrecio()).append("\n");

        if (itemMenu instanceof Bebida) {
            Bebida bebida = (Bebida) itemMenu;
            detalles.append("Graduación Alcohólica: ").append(bebida.getGraduacionAlcoholica()).append("\n");
            detalles.append("Tamaño: ").append(bebida.getTamano()).append("\n");
            detalles.append("Volumen: ").append(bebida.getVolumen()).append("\n");
        } else if (itemMenu instanceof Plato) {
            Plato plato = (Plato) itemMenu;
            detalles.append("Calorías: ").append(plato.getCalorias()).append("\n");
            detalles.append("Apto Celíaco: ").append(plato.getAptoCeliaco()).append("\n");
            detalles.append("Apto Vegetariano: ").append(plato.getAptoVegetariano()).append("\n");
            detalles.append("Apto Vegano: ").append(plato.getAptoVegano()).append("\n");
            detalles.append("Peso: ").append(plato.getPeso()).append("\n");
        }
        detalles.append("Descripción: ").append(itemMenu.getDescripcion()).append("\n");


        // Actualiza el modelo de la lista
        jTextArea.setText(detalles.toString());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVerDetalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVerDetalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVerDetalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVerDetalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVerDetalles("101").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}
