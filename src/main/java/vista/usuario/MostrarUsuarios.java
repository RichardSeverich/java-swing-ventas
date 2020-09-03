package vista.usuario;

import javax.swing.table.DefaultTableModel;

import vista.componentes.Tabla;
import vista.componentes.Ventana;
import vista.eventos.EventosMostrarUsuarios;
import vista.tablas.TablaUsuarios;

public class MostrarUsuarios {
  private static MostrarUsuarios mostrarUsuarios;
  public static Ventana miVentana;
  public static Tabla tablaUsuarios;
  public static DefaultTableModel defaultTableModel;
  private static String[] columnas = { "ID", "CI", "USERNAME", "CONTRASENA", "NOMBRES", "APELLIDOS",
      "FECHA NACIMIENTO", "E-MAIL", "TIPO", "EDITAR", "ELIMINAR" };

  private MostrarUsuarios() {
    miVentana = new Ventana("Mostrar Usuarios");
    Object [][] arrayBidimensional = { {null, null, null, null,
        null, null, null, null, null, null} };
    defaultTableModel = new DefaultTableModel(arrayBidimensional, columnas) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    tablaUsuarios = new Tabla(arrayBidimensional, miVentana.getJFrame(),defaultTableModel);
    EventosMostrarUsuarios eventosUsuariosMostrar = new EventosMostrarUsuarios();
    tablaUsuarios.tabla.addMouseListener(eventosUsuariosMostrar);
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
  public static MostrarUsuarios obtener() {
    if (mostrarUsuarios == null) {
      mostrarUsuarios = new MostrarUsuarios();
    }
    return mostrarUsuarios;
  }

  /**
   * .
   */
  public static void actualizarTabla() {
    Object[][] datos = TablaUsuarios.construir();
    defaultTableModel.setDataVector(datos, columnas);
    setPreferredWidth();
  }

  private static void setPreferredWidth() {
    // Set columns width
    tablaUsuarios.tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
    tablaUsuarios.tabla.getColumnModel().getColumn(1).setPreferredWidth(70);
    tablaUsuarios.tabla.getColumnModel().getColumn(2).setPreferredWidth(90);
    tablaUsuarios.tabla.getColumnModel().getColumn(3).setPreferredWidth(120);
    tablaUsuarios.tabla.getColumnModel().getColumn(4).setPreferredWidth(120);
    tablaUsuarios.tabla.getColumnModel().getColumn(5).setPreferredWidth(120);
    tablaUsuarios.tabla.getColumnModel().getColumn(6).setPreferredWidth(125);
    tablaUsuarios.tabla.getColumnModel().getColumn(7).setPreferredWidth(170);
    tablaUsuarios.tabla.getColumnModel().getColumn(8).setPreferredWidth(90);
    tablaUsuarios.tabla.getColumnModel().getColumn(9).setPreferredWidth(90);
    tablaUsuarios.tabla.getColumnModel().getColumn(10).setPreferredWidth(90);
  }
}
