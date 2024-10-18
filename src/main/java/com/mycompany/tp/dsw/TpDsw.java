/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/
package com.mycompany.tp.dsw;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mycompany.tp.dsw.dao.BebidaDao;
import com.mycompany.tp.dsw.dao.CategoriaDao;
import com.mycompany.tp.dsw.dao.ClienteDao;
import com.mycompany.tp.dsw.dao.ItemMenuDao;
import com.mycompany.tp.dsw.dao.ItemsPedidoDao;
import com.mycompany.tp.dsw.dao.PedidoDao;
import com.mycompany.tp.dsw.dao.PlatoDao;
import com.mycompany.tp.dsw.dao.VendedorDao;
import com.mycompany.tp.dsw.exception.CategoriaNoEncontradaException;
import com.mycompany.tp.dsw.exception.ClienteNoEncontradoException;
import com.mycompany.tp.dsw.exception.ItemNoEncontradoException;
import com.mycompany.tp.dsw.exception.PedidoNoEncontradoException;
import com.mycompany.tp.dsw.exception.VendedorNoEncontradoException;
import com.mycompany.tp.dsw.memory.BebidaMemory;
import com.mycompany.tp.dsw.memory.CategoriaMemory;
import com.mycompany.tp.dsw.memory.ClienteMemory;
import com.mycompany.tp.dsw.memory.ItemMenuMemory;
import com.mycompany.tp.dsw.memory.ItemsPedidoMemory;
import com.mycompany.tp.dsw.memory.PedidoMemory;
import com.mycompany.tp.dsw.memory.PlatoMemory;
import com.mycompany.tp.dsw.memory.VendedorMemory;
import com.mycompany.tp.dsw.model.Bebida;
import com.mycompany.tp.dsw.model.Categoria;
import com.mycompany.tp.dsw.model.Cliente;
import com.mycompany.tp.dsw.model.Coordenada;
import com.mycompany.tp.dsw.model.Estado;
import com.mycompany.tp.dsw.model.ItemMenu;
import com.mycompany.tp.dsw.model.ItemPedido;
import com.mycompany.tp.dsw.model.MercadoPago;
import com.mycompany.tp.dsw.model.Pedido;
import com.mycompany.tp.dsw.model.Plato;
import com.mycompany.tp.dsw.model.TipoCategoria;
import com.mycompany.tp.dsw.model.Vendedor;

/**
 *
 * @author Cristian
 */
public class TpDsw {

        // Declaración de los DAOs
        private static final ClienteDao clienteDao = new ClienteMemory();
        private static final VendedorDao vendedorDao = new VendedorMemory();
        private static final ItemsPedidoDao itemsPedidoDao = new ItemsPedidoMemory(vendedorDao);
        private static final PedidoDao pedidoDao = new PedidoMemory();
        private static final CategoriaDao categoriaDao = new CategoriaMemory();
        private static final BebidaDao bebidaDao = new BebidaMemory();
        private static final PlatoDao platoDao = new PlatoMemory();
        private static final ItemMenuDao itemMenuDao = new ItemMenuMemory();

        public static void main(String[] args) throws ItemNoEncontradoException, ClienteNoEncontradoException,
                        VendedorNoEncontradoException, CategoriaNoEncontradaException, PedidoNoEncontradoException {
                inicializarDatos();
                realizarOperaciones(); // Operaciones de la etapa 3
        }

        private static void inicializarDatos() throws CategoriaNoEncontradaException, VendedorNoEncontradoException,
                        ClienteNoEncontradoException, PedidoNoEncontradoException {
                inicializarCategorias();

                inicializarVendedores();

                // Crear las bebidas y los platos
                inicializarPlatos();
                inicializarBebidas();

                asignarListaItemMenuAVendedor();
                // System.out.println(vendedorDao.toString());
                inicializarClientes();

                // Armar la lista de items pedidos en el dao
                // Vendedores
                Vendedor vendedor1 = vendedorDao.buscarVendedorPorId(0);
                Vendedor vendedor2 = vendedorDao.buscarVendedorPorId(1);
                // Clientes
                Cliente cliente1 = clienteDao.buscarClientePorId(0);
                pedir(cliente1, vendedor1);
                pagar(cliente1);
                pedir(cliente1, vendedor2);
                pagar(cliente1);
        }

        private static void realizarOperaciones() throws ItemNoEncontradoException {
                System.out.println("BUSCAR ITEMS PEDIDOS POR PRECIOS [2-10]");
                System.out.println(itemsPedidoDao.buscarPorPrecios(new BigDecimal(2.0), new BigDecimal(10.0)));
                System.out.println();

                System.out.println("BUSCAR ITEMS PEDIDOS AL RESTAURANTE (id = 0)");
                System.out.println(itemsPedidoDao.buscarPorRestaurante(0));
                System.out.println();

                System.out.println("FILTRAR ITEMS PEDIDOS POR NOMBRE DE VENDEDOR (Vendedor 2)");
                System.out.println(itemsPedidoDao.filtrarPorVendedor("Vendedor 2"));
                System.out.println();

                System.out.println("ORDENAR ITEMS PEDIDOS POR PRECIOS (ascendente)");
                System.out.println(itemsPedidoDao.ordenPorPrecio());
        }

        private static void inicializarVendedores() {
                // Coordenadas
                Coordenada coordenada1 = new Coordenada(10.0, 20.0);
                Coordenada coordenada2 = new Coordenada(30.0, 40.0);
                Coordenada coordenada3 = new Coordenada(50.0, 60.0);

                // Instanciando vendedores
                vendedorDao.crearVendedor(new Vendedor(1, "Vendedor 1", "Calle Falsa 123", coordenada1));
                vendedorDao.crearVendedor(new Vendedor(2, "Vendedor 2", "Avenida Siempre Viva 456", coordenada2));
                vendedorDao.crearVendedor(new Vendedor(3, "Vendedor 3", "Plaza Principal 789", coordenada3));
        }

        private static void asignarListaItemMenuAVendedor() throws VendedorNoEncontradoException {
                List<ItemMenu> items = itemMenuDao.obtenerTodosLosItemMenu();
                Vendedor vendedor1 = vendedorDao.buscarVendedorPorId(0);
                Vendedor vendedor2 = vendedorDao.buscarVendedorPorId(1);
                List<ItemMenu> itemsV1 = new ArrayList<>();
                List<ItemMenu> itemsV2 = new ArrayList<>();
                Integer iterador = 0;
                for (ItemMenu itemMenu : items) {
                        if (iterador % 2 == 0) {
                                itemMenu.setVendedor(vendedor1); // Setear al item su vendedor
                                itemsV1.add(itemMenu); // Construir la lista del vendedor 1
                        } else {
                                itemMenu.setVendedor(vendedor2); // Setear al item su vendedor
                                itemsV2.add(itemMenu); // Construir la lista del vendedor 2
                        }
                        iterador++;
                }
                // Setear a los vendedores sus items
                vendedor1.setItemsMenu(itemsV1);
                vendedor2.setItemsMenu(itemsV2);
        }

        private static void inicializarClientes() {
                // Coordenada
                Coordenada coordenada1 = new Coordenada(-31.628761, -60.701608);

                // Instanciando un cliente
                clienteDao.crearCliente(new Cliente(1, "Cliente 1", "cuit-1", "Calle falsa 4", "cliente1@gmail.com",
                                coordenada1));
        }

        private static void inicializarCategorias() {
                categoriaDao.crearCategoria(
                                new Categoria(1, "comidaVegana", "Esta comida es vegana", TipoCategoria.COMIDA));
                categoriaDao.crearCategoria(new Categoria(2, "comidaVegetariana",
                                "Esta comida es vegetariana, no apta veganos", TipoCategoria.COMIDA));
                categoriaDao.crearCategoria(new Categoria(2, "comidaClasica",
                                "Esta comida no es apta para vegetarianos, ni apta para veganos",
                                TipoCategoria.COMIDA));
                categoriaDao.crearCategoria(new Categoria(3, "bebidaSinAlcohol", "Esta bebida es sin alcohol",
                                TipoCategoria.BEBIDA));
                categoriaDao.crearCategoria(new Categoria(3, "bebidaConAlcohol",
                                "Esta bebida es con alcohol, prohibido consumo en menores", TipoCategoria.BEBIDA));
        }

        private static void inicializarBebidas() throws CategoriaNoEncontradaException, VendedorNoEncontradoException {

                // Obtención de las categorias
                Categoria bebidaSinAlcohol = categoriaDao.obtenerCategoriaPorNombre("bebidaSinAlcohol");
                Categoria bebidaConAlcohol = categoriaDao.obtenerCategoriaPorNombre("bebidaConAlcohol");

                // Obtencion del vendedor
                /*
                 * Vendedor vendedor1 = vendedorDao.buscarVendedorPorId(0);
                 * Vendedor vendedor2 = vendedorDao.buscarVendedorPorId(1);
                 */

                bebidaDao.crearBebida(new Bebida("Jugo de Naranja", 0.0, 500.0, 0.5, 1,
                                new BigDecimal("50.00"), "Jugo de Naranja sin azúcar", bebidaSinAlcohol));

                bebidaDao.crearBebida(new Bebida("Jugo de Manzana", 0.0, 500.0, 0.5, 2,
                                new BigDecimal("50.00"), "Jugo de Manzana sin azúcar", bebidaSinAlcohol));

                bebidaDao.crearBebida(new Bebida("Cerveza Rubia", 5.0, 330.0, 0.33, 3,
                                new BigDecimal("80.00"), "Cerveza rubia con un sabor suave y refrescante",
                                bebidaConAlcohol));

                bebidaDao.crearBebida(new Bebida("Cerveza Negra", 7.0, 330.0, 0.33, 4,
                                new BigDecimal("120.00"), "Cerveza negra con un sabor fuerte y tostado",
                                bebidaConAlcohol));

                bebidaDao.crearBebida(new Bebida("Cerveza Lager", 5.0, 500.0, 500.0, 1,
                                new BigDecimal("3.50"), "Cerveza rubia, refrescante y ligera.", bebidaConAlcohol));

                bebidaDao.crearBebida(new Bebida("Vino Tinto", 13.5, 750.0, 750.0, 2,
                                new BigDecimal("15.00"), "Vino tinto malbec reserva.", bebidaConAlcohol));

                bebidaDao.crearBebida(new Bebida("Coca-Cola", 0.0, 350.0, 350.0, 3,
                                new BigDecimal("2.00"), "Refresco de cola con gas.", bebidaSinAlcohol));

                bebidaDao.crearBebida(new Bebida("Agua Mineral", 0.0, 500.0, 500.0, 4,
                                new BigDecimal("1.50"), "Agua mineral natural sin gas.", bebidaSinAlcohol));

                bebidaDao.crearBebida(new Bebida("Gin Tonic", 40.0, 250.0, 250.0, 5,
                                new BigDecimal("8.00"), "Gin tonic clásico con limón y hielo.", bebidaConAlcohol));
        }

        public static void inicializarPlatos() throws CategoriaNoEncontradaException, VendedorNoEncontradoException {

                // Obtención de las categorias, hacer un dao de categoria
                Categoria comidaVegana = categoriaDao.obtenerCategoriaPorNombre("comidaVegana");
                Categoria comidaVegetariana = categoriaDao.obtenerCategoriaPorNombre("comidaVegetariana");
                Categoria comidaClasica = categoriaDao.obtenerCategoriaPorNombre("comidaClasica");

                // Obtencion del vendedor
                /*
                 * Vendedor vendedor1 = vendedorDao.buscarVendedorPorId(0);
                 * Vendedor vendedor2 = vendedorDao.buscarVendedorPorId(1);
                 */

                platoDao.crearPlato(new Plato("Ensalada Vegana", 150.0, true, true, true, 0.25, 5,
                                new BigDecimal("120.00"), "Ensalada de vegetales frescos", comidaVegana));

                platoDao.crearPlato(new Plato("Hamburguesa Vegetariana", 450.0, true, true, false, 0.3, 6,
                                new BigDecimal("200.00"), "Hamburguesa de lentejas con queso",
                                comidaVegetariana));

                platoDao.crearPlato(new Plato("Milanesa con pure", 680.0, false, false, false, 400.0, 3,
                                new BigDecimal("18.75"), "Milanesa de ternera con puré casero.", comidaClasica));

                platoDao.crearPlato(new Plato("Tarta de manzana", 250.0, false, true, false, 150.0, 4,
                                new BigDecimal("8.00"), "Tarta de manzana casera con helado.", comidaClasica));

                platoDao.crearPlato(new Plato("Pizza Margarita", 500.0, false, true, true, 500.0, 5,
                                new BigDecimal("20.00"), "Pizza Margarita con salsa de tomate y queso.",
                                comidaVegetariana));

                platoDao.crearPlato(new Plato("Ensalada César", 320.5, true, true, true, 320.5, 5,
                                new BigDecimal("15.00"), "Ensalada César con pollo.", comidaClasica));
        }

        public static void pedir(Cliente cliente, Vendedor vendedor) throws VendedorNoEncontradoException,
                        ClienteNoEncontradoException, PedidoNoEncontradoException {

                // Crear el ticket pedido
                pedidoDao.crearPedido(new Pedido(0, Estado.RECIBIDO, cliente));
                Integer clienteID = cliente.getId();
                Pedido pedido1 = pedidoDao.filtrarPedidosPorCliente(clienteID).getLast();

                Random rand = new Random();

                // Pedir todo lo que tiene el vendedor
                List<ItemMenu> itemsMenu = itemMenuDao.filtrarPorVendedor(vendedor);

                for (ItemMenu itemMenu : itemsMenu) {
                        // El id lo maneja el gestor
                        Integer cant = 1 + rand.nextInt(5); // Randomizador del 1 al 4
                        ItemPedido itemPedido = new ItemPedido(0, cant, itemMenu, pedido1);
                        itemsPedidoDao.crearItemPedido(itemPedido);
                }
        }

        public static void pagar(Cliente cliente) {
                Pedido pedidoAPagar = pedidoDao.buscarPedidoPorId(0);

        }
}
