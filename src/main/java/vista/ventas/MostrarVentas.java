package vista.ventas;

import controlador.ArrayProductosVender;

import javax.swing.table.DefaultTableModel;

import vista.componentes.Tabla;
import vista.componentes.Texto;
import vista.componentes.Ventana;
import vista.eventos.EventosMostrarVenta;
import vista.tablas.TablasMostrarVentas;

public class MostrarVentas {
  private static MostrarVentas mostrarVentas;
  public static Ventana miVentana;
  public static DefaultTableModel defaultTableModelVenta;
  public static DefaultTableModel defaultTableModelProducto;
  public static Tabla tablaVentas;
  public static Tabla tablaProductos;
  public static Texto precioTotal = new Texto("Precio por defecto");
  private static String[] columnasVentas = { "ID", "USUARIO", "CLIENTE",
      "FECHA", "EDITAR"};
  private static String[] columnasProductos = { "ID", "NOMBRE", "CANTIDAD",
      "PRECIO"};

  private MostrarVentas() {
    miVentana = new Ventana("Menu principal");
    precioTotal.getJLabel().setText("0");
    tablaVentas();
    tablaProductos();
  }

  private void tablaVentas() {
    Object [][] arrayBidimensional = { {null, null, null, null, null} };
    defaultTableModelVenta = new DefaultTableModel(arrayBidimensional, columnasVentas) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    tablaVentas = new Tabla(arrayBidimensional, miVentana.getJFrame(),defaultTableModelVenta);
    tablaVentas.panel.setBounds(10, 40, 400, 400);
    EventosMostrarVenta eventosMostrarVenta = new EventosMostrarVenta();
    tablaVentas.tabla.addMouseListener(eventosMostrarVenta);
  }

  /**
   *.
   */
  public static void actualizarTablaVentas() {
    Object[][] datos = TablasMostrarVentas.construirTablaVentas();
    defaultTableModelVenta.setDataVector(datos, columnasVentas);
    setPreferredWidthVentas();
  }

  private static void setPreferredWidthVentas() {
    tablaVentas.tabla.getColumnModel().getColumn(0).setPreferredWidth(35);
    tablaVentas.tabla.getColumnModel().getColumn(1).setPreferredWidth(94);
    tablaVentas.tabla.getColumnModel().getColumn(2).setPreferredWidth(85);
    tablaVentas.tabla.getColumnModel().getColumn(3).setPreferredWidth(70);
    tablaVentas.tabla.getColumnModel().getColumn(4).setPreferredWidth(88);
  }

  private static void setPreferredWidthProductos() {
    tablaProductos.tabla.getColumnModel().getColumn(0).setPreferredWidth(35);
    tablaProductos.tabla.getColumnModel().getColumn(1).setPreferredWidth(94);
    tablaProductos.tabla.getColumnModel().getColumn(2).setPreferredWidth(85);
    tablaProductos.tabla.getColumnModel().getColumn(3).setPreferredWidth(70);
  }

  private void tablaProductos() {
    Object [][] arrayBidimensional = { {null, null, null, null} };
    defaultTableModelProducto =
        new DefaultTableModel(arrayBidimensional, columnasProductos) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    tablaProductos =
        new Tabla(arrayBidimensional, miVentana.getJFrame(),defaultTableModelProducto);
    tablaProductos.panel.setBounds(410, 40, 370, 400);
  }

  /**
   *.
   * @param id.
   */
  public static void actualizarTablaProductos(int id) {
    Object[][] datos = TablasMostrarVentas.construirTablaProductos(id);
    defaultTableModelProducto.setDataVector(datos, columnasProductos);
    setPreferredWidthProductos();
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
    for (int indice = 0;indice < ArrayProductosVender.productos.size();indice++) {
      int cantidad =
          Integer.parseInt(ArrayProductosVender.productos.get(indice).cantidad);
      int precio =
          Integer.parseInt(ArrayProductosVender.productos.get(indice).precio);
      costoTotal = costoTotal + (precio * cantidad);
    }
    precioTotal.getJLabel().setText(Integer.toString(costoTotal));
  }

  /**
   * .
   */
  public static MostrarVentas obtener() {
    if (mostrarVentas == null) {
      mostrarVentas = new MostrarVentas();
    }
    return mostrarVentas;
  }
}
