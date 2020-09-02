package vista.eventos;

import static javax.swing.JOptionPane.showMessageDialog;

import controlador.ArrayUsuarios;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import vista.componentes.GestorVentanas;
import vista.usuario.MostrarUsuarios;
import vista.usuario.RegistrarUsuario;

public class EventosMostrarUsuarios extends MouseAdapter {

  public EventosMostrarUsuarios() {

  }

  /**
   *.
   */
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = MostrarUsuarios
        .tablaUsuarios
        .tabla
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / MostrarUsuarios.tablaUsuarios.tabla.getRowHeight();
    Object value = MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, column);
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
    String ci = (String) MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, 1);
    String username = (String) MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, 2);
    String contrasena = (String) MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, 3);
    String nombres = (String) MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, 4);
    String apellidos = (String) MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, 5);
    String fechaNacimiento = (String) MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, 6);
    String email = (String) MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, 7);
    // Set valores a los componenentes del modal.
    RegistrarUsuario.cajaCi.getJText().setText(ci);
    RegistrarUsuario.cajaNickname.getJText().setText(username);
    RegistrarUsuario.cajaContrasena.getJText().setText(contrasena);
    RegistrarUsuario.cajaNombres.getJText().setText(nombres);
    RegistrarUsuario.cajaApellidos.getJText().setText(apellidos);
    RegistrarUsuario.cajaFechaNacimiento.getJFormattedTextField().setText(fechaNacimiento);
    RegistrarUsuario.cajaEmail.getJText().setText(email);
    String tipo = (String) MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, 8);
    RegistrarUsuario.tipo.setSelectedItem(tipo);
    // Abrir usuarios modal.
    EventosRegistroUsuarios.editar = true;
    int id = (int) MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, 0);
    EventosRegistroUsuarios.id = id;
    GestorVentanas.cerrarTodo();
    RegistrarUsuario.abrir();
  }

  private void eliminar(int row) {
    int id = (int) MostrarUsuarios.tablaUsuarios.tabla.getValueAt(row, 0);
    // Si = 0, No = 1
    String mensaje = "Realmente desea realizar esta accion";
    int result = JOptionPane.showConfirmDialog(null, mensaje, "Confirmacion",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (result == 0) {
      ArrayUsuarios.obtener().remove(id - 1);
      ArrayUsuarios.guardar();
      MostrarUsuarios.actualizarTabla();
      showMessageDialog(null, "Eliminado exitosamente");
    }
  }
}