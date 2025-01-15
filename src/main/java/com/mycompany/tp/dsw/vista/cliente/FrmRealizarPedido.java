/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tp.dsw.vista.cliente;

import com.mycompany.tp.dsw.controller.ItemMenuController;
import com.mycompany.tp.dsw.controller.PedidoController;
import com.mycompany.tp.dsw.controller.VendedorController;
import com.mycompany.tp.dsw.dto.ItemMenuDto;
import com.mycompany.tp.dsw.dto.ItemPedidoDto;
import com.mycompany.tp.dsw.dto.PedidoDto;
import com.mycompany.tp.dsw.dto.VendedorDto;
import com.mycompany.tp.dsw.exception.NoValidarException;
import com.mycompany.tp.dsw.service.MensajeAlerta;
import com.mycompany.tp.dsw.vista.util.HeaderFormatter;
import com.mycompany.tp.dsw.vista.util.SpinnerCellEditor;
import com.mycompany.tp.dsw.vista.util.SpinnerCellRenderer;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author Usuario
 */
public class FrmRealizarPedido extends javax.swing.JFrame {

    private VendedorController vendedorController;
    private ItemMenuController itemMenuController;
    private PedidoController pedidoController;
    private final String idCliente;

    public FrmRealizarPedido(String idCliente) {
        initComponents();
        vendedorController = new VendedorController();
        itemMenuController = new ItemMenuController();
        pedidoController = new PedidoController();
        this.idCliente = idCliente;
        this.setLocationRelativeTo(null);
        initDatos();
        setearTituloTabla();
    }

    public void initDatos() {
        List<VendedorDto> vendedores = vendedorController.obtenerTodosLosVendedores();

        for (VendedorDto v : vendedores) {
            jComboBoxRestaurantes.addItem(v.getNombre());
        }
        jComboBoxRestaurantes.addActionListener(e -> actualizarTabla());
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

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnRealizarPedido = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbPrecioTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxRestaurantes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        btnRealizarPedido.setText("Realizar Pedido");
        btnRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbPrecioTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbPrecioTotal.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addGap(169, 169, 169)
                                .addComponent(lbPrecioTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312,
                                        Short.MAX_VALUE)
                                .addComponent(btnRealizarPedido)
                                .addContainerGap()));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRealizarPedido)
                                        .addComponent(btnCancelar))
                                .addContainerGap())
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbPrecioTotal)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new java.awt.BorderLayout());

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        {},
                        {},
                        {},
                        {}
                },
                new String[] {

                }));
        tbProductos.setRowHeight(25);
        tbProductos.setRowSelectionAllowed(false);
        tbProductos.setShowGrid(true);
        tbProductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tbProductosFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(tbProductos);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jComboBoxRestaurantes.setName("Restaurantes"); // NOI18N
        jComboBoxRestaurantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRestaurantesActionPerformed(evt);
            }
        });
        jComboBoxRestaurantes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxRestaurantesPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jComboBoxRestaurantes, 0, 136, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jComboBoxRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(140, Short.MAX_VALUE)));

        jComboBoxRestaurantes.getAccessibleContext().setAccessibleName("Restaurantes");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 494,
                                                        Short.MAX_VALUE)))
                                .addContainerGap()));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductosFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_tbProductosFocusLost
        tbProductos.getCellEditor().stopCellEditing();
    }// GEN-LAST:event_tbProductosFocusLost

    private void btnRealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRealizarPedidoActionPerformed
        Map<String, List<Integer>> productosYCantidad = obtenerProductosPedidos();
        try {
            if (productosYCantidad.isEmpty()) {
                MensajeAlerta.mostrarInformacion("No se ha seleccionado ningún producto.", "Realizar pedido");
            } else {
                double totalGeneral = calcularTotalGeneral(productosYCantidad);

                // Construir un mensaje
                StringBuilder mensaje = new StringBuilder();
                productosYCantidad.forEach((producto, detalles) -> mensaje.append(producto)
                        .append(": Cantidad = ").append(detalles.get(0).intValue())
                        .append(", Subtotal = $").append(String.format("%.2f", detalles.get(1).doubleValue()))
                        .append("\n"));
                mensaje.append("TOTAL: $").append(String.format("%.2f", totalGeneral));

                MensajeAlerta.mostrarInformacion(mensaje.toString(), "Productos Seleccionados");

                // Generar y persistir el pedido, con el cliente
                PedidoDto pedidoDto;

                pedidoDto = pedidoController.generarPedido(idCliente);

                List<ItemPedidoDto> listaItemPedidoDto = pedidoController.generarItemPedidoDto(productosYCantidad);

                pedidoController.guardarPedido(pedidoDto, listaItemPedidoDto);

                MensajeAlerta.mostrarInformacion(String
                        .format("Pedido realizado exitosamente.%nID Pedido: %d%nID Cliente: %s", pedidoDto.getId(),
                                idCliente),
                        "Realizar Pedido");
                this.dispose();
            }
        } catch (NoValidarException e) {
            MensajeAlerta.mostrarError(e.getMessage(), "Error al realizar pedido");
        }
    }// GEN-LAST:event_btnRealizarPedidoActionPerformed

    private void jComboBoxRestaurantesPropertyChange(java.beans.PropertyChangeEvent evt) {// GEN-FIRST:event_jComboBoxRestaurantesPropertyChange

    }// GEN-LAST:event_jComboBoxRestaurantesPropertyChange

    private void actualizarTabla() {
        // Obtener el restaurante seleccionado
        String selectedRestaurante = (String) jComboBoxRestaurantes.getSelectedItem();

        if (selectedRestaurante != null) {
            // Buscar el vendedor correspondiente
            VendedorDto vendedor = vendedorController.buscarVendedorPorNombre(selectedRestaurante).get(0);

            // Obtener los items del menú asociados al vendedor
            List<ItemMenuDto> items = itemMenuController.obtenerItemMenuPorIdVendedor(vendedor.getId());

            // Mostrar los datos en la tabla
            mostrarTabla(items);
        }
    }

    private void jComboBoxRestaurantesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxRestaurantesActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxRestaurantesActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }// GEN-LAST:event_btnCancelarActionPerformed

    public void setearTituloTabla() {
        DefaultTableModel model = new DefaultTableModel();
        String[] titulo = { "PRODUCTO", "PRECIO", "CANTIDAD" };
        model.setColumnIdentifiers(titulo);
        tbProductos.setModel(model);

        // Personalizar el encabezado
        JTableHeader header = tbProductos.getTableHeader();
        header.setDefaultRenderer(new HeaderFormatter());
    }

    public void mostrarTabla(List<ItemMenuDto> items) {

        // Asegurarse de que la tabla tenga el modelo configurado
        if (tbProductos.getModel() == null || !(tbProductos.getModel() instanceof DefaultTableModel)) {
            setearTituloTabla(); // Configura el encabezado y el modelo si no está configurado
        }

        DefaultTableModel model = (DefaultTableModel) tbProductos.getModel(); // Recupera el modelo
        model.setRowCount(0); // Vaciar la tabla
        if (items != null && !items.isEmpty()) {
            for (ItemMenuDto item : items) {
                Object[] fila = new Object[3];
                fila[0] = item.getNombre();
                fila[1] = item.getPrecio();
                fila[2] = 0; // Valor inicial para cantidad
                model.addRow(fila); // Añade la fila al modelo
            }
        }

        // Renderizar y editar la columna de cantidad
        tbProductos.getColumnModel().getColumn(2).setCellRenderer(new SpinnerCellRenderer());
        tbProductos.getColumnModel().getColumn(2).setCellEditor(new SpinnerCellEditor());

        // Ajustar el ancho de las columnas
        ajustarAnchoColumnas(tbProductos);
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

    private Map<String, List<Integer>> obtenerProductosPedidos() {
        // Crear un mapa con el nombre del producto como clave y [cantidad, subtotal]
        // como valor
        return IntStream.range(0, tbProductos.getRowCount()) // Iterar por las filas de la tabla
                .filter(i -> Integer.parseInt(tbProductos.getValueAt(i, 2).toString()) > 0) // Filtrar donde la cantidad
                                                                                            // > 0
                .boxed() // Convertir el IntStream a Stream<Integer> para trabajar con índices
                .collect(Collectors.toMap(
                        i -> obtenerNombreProducto(i), // Clave: Producto (columna 0)
                        i -> obtenerDatosProducto(i) // Valor: Lista [cantidad, subtotal]
                ));
    }

    private String obtenerNombreProducto(int fila) {
        // Recuperar el nombre del producto de la fila
        return tbProductos.getValueAt(fila, 0).toString();
    }

    private List<Integer> obtenerDatosProducto(int fila) {
        // Recuperar los datos de cantidad y subtotal de la fila
        Integer cantidad = Integer.parseInt(tbProductos.getValueAt(fila, 2).toString()); // Cantidad
        double precioUnitario = Double.parseDouble(tbProductos.getValueAt(fila, 1).toString()); // Precio unitario
        int subtotal = (int) (cantidad * precioUnitario); // Calcular subtotal (convertir a entero)

        // Retornar la lista con la cantidad y el subtotal (como Integer)
        return List.of(cantidad, subtotal);
    }

    private double calcularTotalGeneral(Map<String, List<Integer>> productos) {
        return productos.values().stream()
                .mapToDouble(detalles -> detalles.get(1)) // Obtener el subtotal (posición 1 de la lista)
                .sum(); // Sumar todos los subtotales
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
            java.util.logging.Logger.getLogger(FrmRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRealizarPedido.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRealizarPedido("101").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRealizarPedido;
    private javax.swing.JComboBox<String> jComboBoxRestaurantes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPrecioTotal;
    private javax.swing.JTable tbProductos;
    // End of variables declaration//GEN-END:variables
}