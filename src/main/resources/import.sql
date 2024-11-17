-- Insertar datos en la tabla 'coordenadas'
INSERT INTO coordenadas (latitud, longitud) VALUES (40.7128, -74.0060);

-- Insertar datos en la tabla 'categorias'
INSERT INTO categorias (descripcion, nombre, tipo_categoria) VALUES ('Bebida refrescante', 'Refresco', 'BEBIDA');

-- Insertar datos en la tabla 'vendedores'
INSERT INTO vendedores (activo, coordenada_Id, fecha_eliminacion, fecha_registro, direccion, nombre) VALUES (1, 1, NULL, CURDATE(), 'Avenida Siempre Viva 742', 'Pedro Vendedor');

-- Insertar datos en la tabla 'clientes'
INSERT INTO clientes (activo, coordenada_Id, fecha_eliminacion, fecha_registro, cuit, direccion, email, nombre) VALUES (1, 1, NULL, CURDATE(), '20-12345678-9', 'Calle Ficticia 123', 'cliente@example.com', 'Juan Pérez');

-- Insertar datos en la tabla 'item_menu'
INSERT INTO item_menu (activo, categoria_id, fecha_eliminacion, precio, descripcion, nombre) VALUES (1, 1, NULL, 150.00, 'Refresco de cola', 'Coca Cola');

-- Insertar datos en la tabla 'Bebidas'
INSERT INTO Bebidas (graduacion_alcoholica, id, tamano, volumen) VALUES (0.0, 1, 500, 500);

-- Insertar datos en la tabla 'Pago'
INSERT INTO Pago (fecha, monto, tipo_pago, alias, cbu, cuit) VALUES (CURDATE(), 300.00, 'Transferencia', 'Alias1', '1234567890', '20-12345678-9');

-- Insertar datos en la tabla 'pedidos'
INSERT INTO pedidos (cliente_id, formaPago_id, estado) VALUES (1, 1, 'RECIBIDO');

-- Insertar datos en la tabla 'item_pedidos'
INSERT INTO item_pedidos (cantidad, itemMenu_id, pedido_id) VALUES (2, 1, 1);

-- Insertar datos en la tabla 'item_vendedor'
INSERT INTO item_vendedor (activo, fecha_eliminacion, item_menu_id, vendedor_id) VALUES (1, NULL, 1, 1);

-- Insertar datos en la tabla 'pedido_item_pedido'
INSERT INTO pedido_item_pedido (item_pedido_id, pedido_id) VALUES (1, 1);

-- Insertar datos en la tabla 'platos'
INSERT INTO platos (aptoCeliaco, aptoVegano, aptoVegetariano, calorias, id, peso) VALUES (1, 1, 1, 250.0, 1, 150);