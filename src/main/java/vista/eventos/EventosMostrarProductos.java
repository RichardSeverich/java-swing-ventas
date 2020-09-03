package vista.eventos;

import static javax.swing.JOptionPane.showMessageDialog;

import controlador.ArrayProductos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import vista.componentes.GestorVentanas;
import vista.producto.MostrarProductos;
import vista.producto.RegistrarProducto;

public class EventosMostrarProductos extends MouseAdapter {

  public EventosMostrarProductos() {

  }

  /**
   *.
   */
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = MostrarProductos
        .tablaProductos
        .tabla
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / MostrarProductos.tablaProductos.tabla.getRowHeight();
    Object value = MostrarProductos.tablaProductos.tabla.getValueAt(row, column);
    if (value instanceof JButton) {
      JButton button = (JButton) value;
      String nombreBoton = button.getName();
      if (nombreBoton == "Editar") {
        this.editar(row);
      } else if (nombreBoton == "Eliminar") {
        this.eliminar(row);
      }
    }
  }

  private void editar(int row) {
    String nombre = (String) MostrarProductos.tablaProductos.tabla.getValueAt(row, 1);
    String cantidad = (String) MostrarProductos.tablaProductos.tabla.getValueAt(row, 2);
    String precio = (String) MostrarProductos.tablaProductos.tabla.getValueAt(row, 3);
    // Set valores a los componenentes del modal.
    RegistrarProducto.cajaNombre.getJText().setText(nombre);
    RegistrarProducto.cajaCantidad.getJText().setText(cantidad);
    RegistrarProducto.cajaPrecio.getJText().setText(precio);
    // Abrir productos modal.
    EventosRegistroProductos.editar = true;
    int id = (int) MostrarProductos.tablaProductos.tabla.getValueAt(row, 0);
    EventosRegistroProductos.id = id;
    GestorVentanas.cerrarTodo();
    RegistrarProducto.abrir();
  }

  private void eliminar(int row) {
    int id = (int) MostrarProductos.tablaProductos.tabla.getValueAt(row, 0);
    // Si = 0, No = 1
    String mensaje = "Realmente desea realizar esta accion";
    int result = JOptionPane.showConfirmDialog(null, mensaje, "Confirmacion",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (result == 0) {
      ArrayProductos.obtener().remove(id - 1);
      ArrayProductos.guardar();
      MostrarProductos.actualizarTabla();
      showMessageDialog(null, "Eliminado exitosamente");
    }
  }
}