/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tp.dsw.view;

import com.mycompany.tp.dsw.memory.BebidaMemory;
import com.mycompany.tp.dsw.memory.PlatoMemory;
import com.mycompany.tp.dsw.model.Bebida;
import com.mycompany.tp.dsw.model.Plato;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.mycompany.tp.dsw.model.ItemMenu;

/**
 *
 * @author Usuario
 */
public class FrmItemMenu extends javax.swing.JFrame {

    private final PlatoMemory platoMemory;
    private final BebidaMemory bebidaMemory;
    private final Integer idVendedor;

    public FrmItemMenu(PlatoMemory platoMemory, BebidaMemory bebidaMemory, String idVendedor, String nombreVendedor) {
        initComponents();
        configureWindow();
        this.platoMemory = platoMemory;
        this.bebidaMemory = bebidaMemory;
        this.idVendedor = Integer.parseInt(idVendedor);
        jLabelVendedorData.setText("Vendedor: " + nombreVendedor + " ID: " + idVendedor);
        inicializarTabla();
    }

    private void configureWindow() {
        this.setTitle("Item Menu");
        this.setLocationRelativeTo(null);
        this.setSize(750, 460);
        this.setResizable(false);
    }

    public void inicializarTabla() {
        // Obtiene el valor por defecto del JComboBox
        String defaultItem = (String) jComboBoxPlatoBebida.getSelectedItem();
        if ("Plato".equals(defaultItem)) {
            List<Plato> platos = platoMemory.obtenerPlatoPorIdVendedor(idVendedor);
            System.out.println("Platos en el frm: " + platos);
            mostrarItemMenuEnPantalla(platos);
        } else if ("Bebida".equals(defaultItem)) {
            List<Bebida> bebidas = bebidaMemory.obtenerBebidaPorIdVendedor(idVendedor);
            mostrarItemMenuEnPantalla(bebidas);
        }

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
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jComboBoxPlatoBebida = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItemDatos = new javax.swing.JTable();
        btnVerDetalles = new javax.swing.JButton();
        jLabelVendedorData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEliminar.setText("Eliminar Item");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar Item");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar Item");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar Item");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jComboBoxPlatoBebida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plato", "Bebida" }));
        jComboBoxPlatoBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPlatoBebidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
                                                Short.MAX_VALUE)
                                        .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxPlatoBebida, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22,
                                        Short.MAX_VALUE)
                                .addComponent(jComboBoxPlatoBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnSalir)
                                .addContainerGap()));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbItemDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        {},
                        {},
                        {},
                        {}
                },
                new String[] {

                }));
        jScrollPane1.setViewportView(tbItemDatos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, 500, 321));

        btnVerDetalles.setText("Ver Detalles");
        btnVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetallesActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, -1, -1));
        jPanel2.add(jLabelVendedorData, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 356, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 7, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarActionPerformed

    }// GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed
        String tipoCategoria = jComboBoxPlatoBebida.getSelectedItem().toString();
        if (tipoCategoria.equalsIgnoreCase("Plato")) {
            tipoCategoria = "Comida";
        }

        FrmAgregarItem agregarItemForm = new FrmAgregarItem(tipoCategoria, idVendedor, this);
        agregarItemForm.setVisible(true);

        List<Plato> platos = platoMemory.obtenerPlatoPorIdVendedor(idVendedor);

        agregarItemForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                mostrarItemMenuEnPantalla(platos); // Refresca la tabla cuando se cierre el formulario
            }
        });

    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnModificarActionPerformed
        int selectedRow = tbItemDatos.getSelectedRow();

        if (selectedRow != -1) {
            // 1. Obtener el id de la fila seleccionada
            String idText = tbItemDatos.getValueAt(selectedRow, 0).toString();
            Integer id = Integer.parseInt(idText);

            // 2. Obtener la instancia del item
            String tipoCategoria = jComboBoxPlatoBebida.getSelectedItem().toString();
            switch (tipoCategoria) {
                case "Plato":
                    FrmModificarPlato modificarPlatoForm = new FrmModificarPlato(id);
                    modificarPlatoForm.setVisible(true);
                    break;
                case "bebida":
                    break;
                default:

            }

        }
    }// GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }// GEN-LAST:event_btnSalirActionPerformed

    private void jComboBoxPlatoBebidaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxPlatoBebidaActionPerformed
        String selectedItem = (String) jComboBoxPlatoBebida.getSelectedItem();

        switch (selectedItem) {
            case "Plato":
                List<Plato> platos = platoMemory.obtenerPlatoPorIdVendedor(idVendedor);
                mostrarItemMenuEnPantalla(platos);
                break;
            case "Bebida":
                List<Bebida> bebidas = bebidaMemory.obtenerBebidaPorIdVendedor(idVendedor);
                mostrarItemMenuEnPantalla(bebidas);
                break;
            default:
                break;
        }
    }// GEN-LAST:event_jComboBoxPlatoBebidaActionPerformed

    private void btnVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVerDetallesActionPerformed
        int selectedRow = tbItemDatos.getSelectedRow();

        if (selectedRow != -1) {
            String id = tbItemDatos.getValueAt(selectedRow, 0).toString();
            FrmVerDetalles verDetallesForm = new FrmVerDetalles(id);
            verDetallesForm.setVisible(true);
        }
    }// GEN-LAST:event_btnVerDetallesActionPerformed

    private void mostrarItemMenuEnPantalla(List<? extends ItemMenu> listaItemMenu) {
        DefaultTableModel model;
        String[] titulo;

        String selectedItem = (String) jComboBoxPlatoBebida.getSelectedItem();
        if ("Bebida".equals(selectedItem)) {
            titulo = new String[] { "ID", "NOMBRE", "VOLUMEN", "DESCRIPCION", "PRECIO" };
        } else {
            titulo = new String[] { "ID", "NOMBRE", "CALORÍAS", "DESCRIPCION", "PRECIO" };
        }

        model = new DefaultTableModel(null, titulo);

        if (listaItemMenu.isEmpty()) {
            // Tabla vacía
            tbItemDatos.setModel(model);
        } else {
            for (ItemMenu item : listaItemMenu) {
                Object[] fila = new Object[5]; // Número de columnas

                fila[0] = item.getId();
                fila[1] = item.getNombre();
                fila[3] = item.getDescripcion();
                fila[4] = item.getPrecio();

                if (item instanceof Bebida) {
                    fila[2] = ((Bebida) item).getVolumen();
                } else if (item instanceof Plato) {
                    fila[2] = ((Plato) item).getCalorias(); // Calorías en lugar de volumen
                }

                model.addRow(fila);
            }
            tbItemDatos.setModel(model);
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmItemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmItemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmItemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmItemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmItemMenu(new PlatoMemory(), new BebidaMemory(), "101", "nombre").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JComboBox<String> jComboBoxPlatoBebida;
    private javax.swing.JLabel jLabelVendedorData;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbItemDatos;
    // End of variables declaration//GEN-END:variables
}
