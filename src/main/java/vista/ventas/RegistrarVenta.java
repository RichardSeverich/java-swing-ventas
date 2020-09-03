package vista.ventas;

import controlador.ArrayProductosVender;
import controlador.ArrayVentas;
import java.awt.Font;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import vista.componentes.Boton;
import vista.componentes.CajaTexto;
import vista.componentes.DateLabelFormatter;
import vista.componentes.Tabla;
import vista.componentes.Texto;
import vista.componentes.Ventana;
import vista.eventos.EventoAcceso;
import vista.eventos.EventosRegistrarVentaCarrito;
import vista.eventos.EventosRegistrarVentaTabla;
import vista.eventos.EventosRegistroVenta;
import vista.tablas.TablasRegistrarVentas;

public class RegistrarVenta {
  private static RegistrarVenta registrarVenta;
  public static Ventana miVentana;
  public static Texto nombreUsuario = new Texto("Administrador por defecto");
  public static Texto precioTotal = new Texto("Precio por defecto");
  public static CajaTexto cajaCliente;
  public static JDatePickerImpl cajaFechaVenta;
  public static CajaTexto cajaCantidad;
  public static DefaultTableModel defaultTableModelCarrito;
  public static DefaultTableModel defaultTableModelProducto;
  public static Tabla tablaProductos;
  public static Tabla tablaCarrito;
  private static String[] columnasProductos = { "ID", "NOMBRE", "DISPONIBLE",
      "PRECIO", "AGREGAR"};
  private static String[] columnasCarrito = { "ID", "NOMBRE", "CANTIDAD",
      "PRECIO", "ELIMINAR"};

  private RegistrarVenta() {
    miVentana = new Ventana("Menu principal");
    final JPanel panel = new JPanel();
    miVentana.getJFrame().add(panel);
    panel.setBounds(10, 5, 770, 155);
    panel.setLayout(null);
    cajaCliente = new CajaTexto();
    cajaCantidad = new CajaTexto();
    final UtilDateModel model = new UtilDateModel();
    final Properties properties = new Properties();
    properties.put("text.today", "Today");
    properties.put("text.month", "Month");
    properties.put("text.year", "Year");
    final JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
    cajaFechaVenta = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    model.setSelected(true);
    final Texto textoTitulo = new Texto("Registrar Venta");
    final Texto textoUsuario = new Texto("Usuario");
    final Texto textoPrecioTotal = new Texto("Precio Total");
    final Texto textoCliente = new Texto("Cliente");
    final Texto textoFechaVenta = new Texto("Fecha de venta");
    final Texto textoCantidad = new Texto("Cantidad");
    final Boton botonRegistrar = new Boton("Registrar");
    cajaCliente.getJText().setText("Sin nombre");
    cajaCantidad.getJText().setText("1");
    precioTotal.getJLabel().setText("0");
    EventosRegistroVenta registro = new EventosRegistroVenta();
    botonRegistrar.getJButton().addActionListener(registro);
    nombreUsuario.getJLabel().setLocation(200, 40);
    cajaCliente.getJText().setLocation(200, 65);
    cajaFechaVenta.setBounds(200, 95, 190, 27);
    cajaCantidad.getJText().setLocation(550, 65);
    textoTitulo.getJLabel().setLocation(320, 10);
    precioTotal.getJLabel().setLocation(550, 40);
    textoUsuario.getJLabel().setLocation(20, 40);
    textoPrecioTotal.getJLabel().setLocation(400, 40);
    textoCliente.getJLabel().setLocation(20, 70);
    textoFechaVenta.getJLabel().setLocation(20, 100);
    textoCantidad.getJLabel().setLocation(400, 70);
    // posicionando boton
    botonRegistrar.getJButton().setLocation(550, 95);
    panel.add(nombreUsuario.getJLabel());
    panel.add(cajaCliente.getJText());
    panel.add(cajaFechaVenta);
    panel.add(cajaCantidad.getJText());
    panel.add(precioTotal.getJLabel());
    panel.add(textoTitulo.getJLabel());
    panel.add(textoUsuario.getJLabel());
    panel.add(textoPrecioTotal.getJLabel());
    panel.add(textoCliente.getJLabel());
    panel.add(textoFechaVenta.getJLabel());
    panel.add(textoCantidad.getJLabel());
    panel.add(botonRegistrar.getJButton());
    // Titulo y Borde
    final String title = "Registrar";
    final Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
    tablaProductos();
    tablaCarrito();
  }

  private void tablaProductos() {
    Object [][] arrayBidimensional = { {null, null, null, null,
        null, null, null, null, null, null} };
    defaultTableModelProducto = new DefaultTableModel(arrayBidimensional, columnasProductos) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
      }
    };
    tablaProductos = new Tabla(arrayBidimensional, miVentana.getJFrame(),defaultTableModelProducto);
    EventosRegistrarVentaTabla eventosRegistrarVentaTabla = new EventosRegistrarVentaTabla();
    tablaProductos.panel.setBounds(10, 165, 385, 350);
    tablaProductos.tabla.addMouseListener(eventosRegistrarVentaTabla);
  }

  /**
   *.
   */
  public static void actualizarTablaProductos() {
    Object[][] datos = TablasRegistrarVentas.construirTablaProductos();
    defaultTableModelProducto.setDataVector(datos, columnasProductos);
    setPreferredWidth(tablaProductos);
  }

  private static void setPreferredWidth(Tabla tabla) {
    tabla.tabla.getColumnModel().getColumn(0).setPreferredWidth(35);
    tabla.tabla.getColumnModel().getColumn(1).setPreferredWidth(94);
    tabla.tabla.getColumnModel().getColumn(2).setPreferredWidth(85);
    tabla.tabla.getColumnModel().getColumn(3).setPreferredWidth(70);
    tabla.tabla.getColumnModel().getColumn(4).setPreferredWidth(88);;
  }

  private void tablaCarrito() {
    Object [][] arrayBidimensional = { {null, null, null, null,
        null, null, null, null, null, null} };
    defaultTableModelCarrito = new DefaultTableModel(arrayBidimensional, columnasCarrito) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    tablaCarrito = new Tabla(arrayBidimensional, miVentana.getJFrame(),defaultTableModelCarrito);
    EventosRegistrarVentaCarrito eventosRegistrarVentaCarrito =
        new EventosRegistrarVentaCarrito();
    tablaCarrito.panel.setBounds(395, 165, 385, 350);
    tablaCarrito.tabla.addMouseListener(eventosRegistrarVentaCarrito);
  }

  /**
   *.
   */
  public static void actualizarTablaCarrito() {
    Object[][] datos = TablasRegistrarVentas.construirTablaCarrito();
    defaultTableModelCarrito.setDataVector(datos, columnasCarrito);
    setPreferredWidth(tablaCarrito);
  }

  public static void cambioUsuario() {
    nombreUsuario.getJLabel().setText(EventoAcceso.nombreUsuario);
  }

  /**
   * .
   */
  public static void cerrar() {
    if (miVentana.getJFrame().isVisible() == true) {
      miVentana.getJFrame().setVisible(false);
    }
  }

  public static void abrir() {
    miVentana.getJFrame().setVisible(true);
  }

  /**
   *.
   */
  public static void costoTotal() {
    int costoTotal = 0;
    for (int indice = 0;indice < ArrayProductosVender.obtener().size();indice++) {
      int cantidad =
          Integer.parseInt(ArrayProductosVender.obtener().get(indice).cantidad);
      int precio =
          Integer.parseInt(ArrayProductosVender.productos.get(indice).precio);
      costoTotal = costoTotal + (precio * cantidad);
    }
    precioTotal.getJLabel().setText(Integer.toString(costoTotal));
  }

  /**
   * .
   */
  public static RegistrarVenta obtener() {
    if (registrarVenta == null) {
      registrarVenta = new RegistrarVenta();
    }
    return registrarVenta;
  }
}
