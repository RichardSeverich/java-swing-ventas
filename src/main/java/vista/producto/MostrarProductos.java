package vista.producto;

import javax.swing.table.DefaultTableModel;

import vista.componentes.Tabla;
import vista.componentes.Ventana;
import vista.eventos.EventosMostrarProductos;
import vista.tablas.TablaProductos;

public class MostrarProductos {
  private static MostrarProductos mostrarProductos;
  public static Ventana miVentana;
  public static Tabla tablaProductos;
  public static DefaultTableModel defaultTableModel;
  private static String[] columnas = { "ID", "NOMBRE", "CANTIDAD",
      "PRECIO", "EDITAR", "ELIMINAR"};

  private MostrarProductos() {
    miVentana = new Ventana("Mostrar Productos");
    Object [][] arrayBidimensional = { {null, null, null, null,
        null, null, null, null, null, null} };
    defaultTableModel = new DefaultTableModel(arrayBidimensional, columnas) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    tablaProductos = new Tabla(arrayBidimensional, miVentana.getJFrame(),defaultTableModel);
    tablaProductos.panel.setBounds(130, 20, 525, 500);
    EventosMostrarProductos eventosProductosMostrar = new EventosMostrarProductos();
    tablaProductos.tabla.addMouseListener(eventosProductosMostrar);
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
   *
   * @return gestionarUsuarios.
   */
  public static MostrarProductos obtener() {
    if (mostrarProductos == null) {
      mostrarProductos = new MostrarProductos();
    }
    return mostrarProductos;
  }

  /**
   * .
   */
  public static void actualizarTabla() {
    Object[][] datos = TablaProductos.construir();
    defaultTableModel.setDataVector(datos, columnas);
    setPreferredWidth();
  }

  private static void setPreferredWidth() {
    // Set columns width
    tablaProductos.tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
    tablaProductos.tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
    tablaProductos.tabla.getColumnModel().getColumn(2).setPreferredWidth(90);
    tablaProductos.tabla.getColumnModel().getColumn(3).setPreferredWidth(90);
    tablaProductos.tabla.getColumnModel().getColumn(4).setPreferredWidth(90);
    tablaProductos.tabla.getColumnModel().getColumn(5).setPreferredWidth(90);
  }
}
