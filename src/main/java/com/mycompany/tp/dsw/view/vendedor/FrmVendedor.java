/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tp.dsw.view.vendedor;

import java.util.List;

import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.service.MemoryManager;
import com.mycompany.tp.dsw.view.itemMenu.FrmItemMenu;
import com.mycompany.tp.dsw.memory.BebidaMemory;
import com.mycompany.tp.dsw.memory.PlatoMemory;
import com.mycompany.tp.dsw.model.Vendedor;
import com.mycompany.tp.dsw.memory.VendedorMemory;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author admin
 */
public class FrmVendedor extends javax.swing.JFrame {

    private final MemoryManager memoryManager;

    private final VendedorMemory vendedorMemory;
    private final PlatoMemory platoMemory;
    private final BebidaMemory bebidaMemory;

    /**
     * Creates new form FrmVendedor
     */

    public FrmVendedor() {
        initComponents();
        configureWindow();

        memoryManager = MemoryManager.getInstance();

        bebidaMemory = memoryManager.getBebidaMemory();
        platoMemory = memoryManager.getPlatoMemory();
        vendedorMemory = memoryManager.getVendedorMemory();

        mostrarTabla();
    }

    private void configureWindow() {
        this.setTitle("Restaurantes");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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

        jPanel1 = new javax.swing.JPanel();
        btnEliminarVendedor = new javax.swing.JButton();
        btnAgregarVendedor = new javax.swing.JButton();
        btnModificarVendedor = new javax.swing.JButton();
        btnBuscarVendedor = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBuscarItemMenu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVendedorDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        btnEliminarVendedor.setText("Eliminar Vendedor");
        btnEliminarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVendedorActionPerformed(evt);
            }
        });

        btnAgregarVendedor.setText("Agregar Vendedor");
        btnAgregarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVendedorActionPerformed(evt);
            }
        });

        btnModificarVendedor.setText("Modificar Vendedor");
        btnModificarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarVendedorActionPerformed(evt);
            }
        });

        btnBuscarVendedor.setText("Buscar Vendedor");
        btnBuscarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVendedorActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBuscarItemMenu.setText("Items");
        btnBuscarItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarItemMenuActionPerformed(evt);
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
                                        .addComponent(btnAgregarVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
                                                Short.MAX_VALUE)
                                        .addComponent(btnModificarVendedor, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliminarVendedor, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBuscarVendedor, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBuscarItemMenu, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAgregarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15,
                                        Short.MAX_VALUE)
                                .addComponent(btnBuscarItemMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 55,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir)
                                .addContainerGap()));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 402));

        tbVendedorDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        {},
                        {},
                        {},
                        {}
                },
                new String[] {

                }));
        tbVendedorDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVendedorDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVendedorDatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(52, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMouseClicked
        int selectedRow = tbVendedorDatos.getSelectedRow();

        if (selectedRow != -1) {
            tbVendedorDatos.clearSelection();
        }
    }// GEN-LAST:event_formMouseClicked

    private void tbVendedorDatosMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbVendedorDatosMouseClicked
        // int select = tbVendedorDatos.getSelectedRow();

    }// GEN-LAST:event_tbVendedorDatosMouseClicked

    private void btnBuscarItemMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarItemMenuActionPerformed
        int selectedRow = tbVendedorDatos.getSelectedRow();
        if (selectedRow != -1) {

            String idVendedor = tbVendedorDatos.getValueAt(selectedRow, 0).toString();
            String nombreVendedor = tbVendedorDatos.getValueAt(selectedRow, 1).toString();
            FrmItemMenu itemMenuForm = new FrmItemMenu(platoMemory, bebidaMemory, idVendedor, nombreVendedor);
            itemMenuForm.setVisible(true);
            itemMenuForm.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    mostrarTabla(); // Refresca la tabla cuando se cierre el formulario
                }
            });
        }
    }// GEN-LAST:event_btnBuscarItemMenuActionPerformed

    private void btnEliminarVendedorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEliminarVendedorActionPerformed
        int selectedRow = tbVendedorDatos.getSelectedRow();

        if (selectedRow != -1) {
            String id = tbVendedorDatos.getValueAt(selectedRow, 0).toString();
            FrmEliminarVendedor eliminarVendedorForm = new FrmEliminarVendedor(vendedorMemory, id, this);
            eliminarVendedorForm.setVisible(true);
            eliminarVendedorForm.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    mostrarTabla(); // Refresca la tabla cuando se cierre el formulario
                }
            });
        } else {
            // Si no hay una fila seleccionada, abrir el formulario sin datos precargados
            FrmEliminarVendedor eliminarVendedorForm = new FrmEliminarVendedor(vendedorMemory, this);
            eliminarVendedorForm.setVisible(true);

            eliminarVendedorForm.addWindowListener(new java.awt.event.WindowAdapter() {

                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    mostrarTabla(vendedorMemory.obtenerTodosLosVendedores());
                }

            });
        }

    }// GEN-LAST:event_btnEliminarVendedorActionPerformed

    private void btnAgregarVendedorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarVendedorActionPerformed
        FrmAgregarVendedor agregarVendedorForm = new FrmAgregarVendedor(vendedorMemory);
        agregarVendedorForm.setVisible(true);

        agregarVendedorForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                mostrarTabla(); // Refresca la tabla cuando se cierre el formulario
            }
        });

    }// GEN-LAST:event_btnAgregarVendedorActionPerformed

    private void btnModificarVendedorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnModificarVendedorActionPerformed
        int selectedRow = tbVendedorDatos.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (selectedRow != -1) {
            // Obtener los valores de la fila seleccionada
            String id = tbVendedorDatos.getValueAt(selectedRow, 0).toString();
            String nombre = tbVendedorDatos.getValueAt(selectedRow, 1).toString();
            String direccion = tbVendedorDatos.getValueAt(selectedRow, 2).toString();
            String latitud = tbVendedorDatos.getValueAt(selectedRow, 3).toString();
            String longitud = tbVendedorDatos.getValueAt(selectedRow, 4).toString();
            String fechaRegistro = tbVendedorDatos.getValueAt(selectedRow, 5).toString();

            VendedorDto vendedorDto = new VendedorDto(id, nombre, direccion, latitud, longitud);

            // Crear y mostrar el formulario de modificación con los datos de la fila
            // seleccionada
            FrmModificarVendedor modificarVendedorForm = new FrmModificarVendedor(vendedorMemory, vendedorDto,
                    fechaRegistro);
            modificarVendedorForm.setVisible(true);

            // Agregar un WindowListener para refrescar la tabla cuando se cierre el
            // formulario
            modificarVendedorForm.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    mostrarTabla(vendedorMemory.obtenerTodosLosVendedores()); // Refresca la tabla
                }
            });
        } else {
            // Si no hay una fila seleccionada, abrir el formulario sin datos precargados
            FrmModificarVendedor modificarVendedorForm = new FrmModificarVendedor(vendedorMemory);
            modificarVendedorForm.setVisible(true);

            modificarVendedorForm.addWindowListener(new java.awt.event.WindowAdapter() {

                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    mostrarTabla(vendedorMemory.obtenerTodosLosVendedores()); // Refresca la tabla
                }

            });
        }
    }

    private void btnBuscarVendedorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarVendedorActionPerformed
        FrmBuscarVendedor buscarVendedorForm = new FrmBuscarVendedor(vendedorMemory, this);
        buscarVendedorForm.setVisible(true);

        buscarVendedorForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                mostrarTabla(); // Refresca la tabla cuando se cierre el formulario
            }
        });

    }// GEN-LAST:event_btnBuscarVendedorActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }// GEN-LAST:event_btnSalirActionPerformed

    private void mostrarTabla() {
        DefaultTableModel model;
        String[] titulo = { "ID", "NOMBRE", "DIRECCION", "LATITUD", "LONGITUD", "FECHA REGISTRO" };
        model = new DefaultTableModel(null, titulo);

        List<Vendedor> listaVendedores = vendedorMemory.obtenerTodosLosVendedores();

        if (listaVendedores == null || listaVendedores.isEmpty()) {
            // Si la lista está vacía, puedes decidir no añadir filas.
            // Esto vacía la tabla.
            tbVendedorDatos.setModel(model); // Modelo vacío
        } else {
            for (Vendedor vendedor : listaVendedores) {
                Object[] fila = new Object[8]; // Número de columnas

                // Asigna valores a cada columna de la fila
                fila[0] = vendedor.getId();
                fila[1] = vendedor.getNombre();
                fila[2] = vendedor.getDireccion();
                fila[3] = vendedor.getCoordenada().getLatitud();
                fila[4] = vendedor.getCoordenada().getLongitud();
                fila[5] = vendedor.getFechaRegistro();

                // Añade la fila al modelo de la tabla
                model.addRow(fila);
            }
            tbVendedorDatos.setModel(model);

            TableColumnModel columnModel = tbVendedorDatos.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                TableColumn column = columnModel.getColumn(i);
                int width = tbVendedorDatos.getTableHeader().getFontMetrics(tbVendedorDatos.getFont())
                        .stringWidth(tbVendedorDatos.getColumnName(i)); // Agrega padding
                column.setPreferredWidth(width);
            }
        }

    }

    public void mostrarTabla(List<Vendedor> listaVendedores) {
        DefaultTableModel model = new DefaultTableModel();
        String[] titulo = { "ID", "NOMBRE", "DIRECCION", "LATITUD", "LONGITUD", "FECHA REGISTRO" };
        model.setColumnIdentifiers(titulo); // Establece los títulos de las columnas

        // Llena el modelo con los vendedores encontrados
        for (Vendedor vendedor : listaVendedores) {
            Object[] fila = new Object[8];
            fila[0] = vendedor.getId();
            fila[1] = vendedor.getNombre();
            fila[2] = vendedor.getDireccion();
            fila[3] = vendedor.getCoordenada().getLatitud();
            fila[4] = vendedor.getCoordenada().getLongitud();
            fila[5] = vendedor.getFechaRegistro();

            model.addRow(fila); // Añade la fila al modelo
        }

        tbVendedorDatos.setModel(model); // Establece el modelo a la tabla
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
            java.util.logging.Logger.getLogger(FrmVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarVendedor;
    private javax.swing.JButton btnBuscarItemMenu;
    private javax.swing.JButton btnBuscarVendedor;
    private javax.swing.JButton btnEliminarVendedor;
    private javax.swing.JButton btnModificarVendedor;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVendedorDatos;
    // End of variables declaration//GEN-END:variables
}
