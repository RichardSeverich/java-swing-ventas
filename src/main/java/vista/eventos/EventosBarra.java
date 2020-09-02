package vista.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Principal;
import vista.acceso.Acceso;
import vista.componentes.GestorVentanas;
import vista.producto.MostrarProductos;
import vista.producto.RegistrarProducto;
import vista.usuario.MostrarUsuarios;
import vista.usuario.RegistrarUsuario;
import vista.ventas.MostrarVentas;
import vista.ventas.RegistrarVenta;

public class EventosBarra implements ActionListener {

  /**
   * .
   */
  public void actionPerformed(ActionEvent evento) {
    GestorVentanas.cerrarTodo();
    switch (evento.getActionCommand()) {
      case "Inicio":
        Principal.abrir();
        break;
      case "Login":
        Acceso.abrir();
        break;
      case "Registrar usuario":
        EventosRegistroUsuarios.editar = false;
        RegistrarUsuario.limpiarCajas();
        RegistrarUsuario.abrir();
        break;
      case "Mostrar usuarios":
        MostrarUsuarios.actualizarTabla();
        MostrarUsuarios.abrir();
        break;
      case "Registrar productos":
        EventosRegistroProductos.editar = false;
        RegistrarProducto.limpiarCajas();
        RegistrarProducto.abrir();
        break;
      case "Mostrar productos":
        MostrarProductos.actualizarTabla();
        MostrarProductos.abrir();
        break;
      case "Registrar venta":
        RegistrarVenta.actualizarTablaProductos();
        RegistrarVenta.actualizarTablaCarrito();
        RegistrarVenta.cambioUsuario();
        RegistrarVenta.abrir();
        break;
      case "Mostrar ventas":
        MostrarVentas.actualizarTablaVentas();
        MostrarVentas.abrir();
        break;
      case "Salir":
        System.exit(0);
        break;
      default:
    }
  }
}
