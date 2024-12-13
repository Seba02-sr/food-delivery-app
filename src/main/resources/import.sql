-- Insertar datos en la tabla 'coordenadas'
INSERT INTO coordenada (latitud, longitud) VALUES (40.7128, -74.0060);
INSERT INTO coordenada (latitud, longitud) VALUES (10.7128, -24.0060);

-- Insertar datos en la tabla 'categorias'
INSERT INTO categoria (nombre, descripcion, tipo_categoria) VALUES ('Bebida Con Alcohol', 'Esta bebida es con alcohol, prohibido consumo en menores', 'BEBIDA');
INSERT INTO categoria (nombre, descripcion, tipo_categoria) VALUES ('Bebida Sin Alcohol', 'Esta bebida es sin alcohol', 'BEBIDA');
INSERT INTO categoria (nombre, descripcion, tipo_categoria) VALUES ('Comida Vegana', 'Esta comida es vegana', 'COMIDA');
INSERT INTO categoria (nombre, descripcion, tipo_categoria) VALUES ('Comida Vegetariana', 'Esta comida es vegetariana, no apta veganos', 'COMIDA');
INSERT INTO categoria (descripcion, nombre, tipo_categoria) VALUES ('Comida Clasica', 'Esta comida no es apta para vegetarianos, ni apta para veganos', 'COMIDA');

-- Insertar datos en la tabla 'vendedores'
INSERT INTO vendedor (activo, coordenada_Id, fecha_eliminacion, fecha_registro, direccion, nombre) VALUES (1, 1, NULL, CURDATE(), 'Avenida Siempre Viva 742', 'Pedro Vendedor');

-- Insertar datos en la tabla 'clientes'
INSERT INTO cliente (activo, coordenada_Id, fecha_eliminacion, fecha_registro, cuit, direccion, email, nombre) VALUES (1, 2, NULL, CURDATE(), '20-12345678-9', 'Calle Ficticia 123', 'cliente@example.com', 'Juan Pérez');

-- Insertar datos en la tabla 'item_menu'
INSERT INTO item_menu (activo, categoria_id, fecha_eliminacion, precio, descripcion, nombre, vendedor_id) VALUES (1, 2, NULL, 150.00, 'Refresco de cola', 'Coca Cola', 1);
INSERT INTO item_menu (activo, categoria_id, fecha_eliminacion, precio, descripcion, nombre, vendedor_id) VALUES (1,5,NULL, 15.00 ,'Pizza clasica con queso, tomate y albahaca', 'Pizza Margarita', 1);
-- Insertar datos en la tabla 'Bebidas'
INSERT INTO Bebida (graduacion_alcoholica, id, tamano, volumen) VALUES (0.0, 1, 500, 500);
INSERT INTO Plato (aptoCeliaco, aptoVegano, aptoVegetariano, calorias, id, peso) VALUES (1, 1, 1, 700.0, 2, 700.0);
-- Insertar datos en la tabla 'Pago'
INSERT INTO Pago (fecha, monto, tipo_pago, alias, cbu, cuit) VALUES (CURDATE(), 300.00, 'Transferencia', 'Alias1', '1234567890', '20-12345678-9');

-- Insertar datos en la tabla 'Pedidos'
INSERT INTO Pedido (cliente_id, formaPago_id, estado) VALUES (1,1,'ACEPTADO');

INSERT INTO pedido_item_pedido (item_pedido_id, pedido_id) VALUES (NULL, 1);

INSERT INTO item_pedido (cantidad, itemMenu_id, pedido_id) VALUES (2, 1, 1);

UPDATE pedido_item_pedido SET item_pedido_id = 1 WHERE pedido_id = 1;

-- Insertar datos en la tabla 'platos'
