package vista.componentes;

import vista.Principal;
import vista.producto.MostrarProductos;
import vista.producto.RegistrarProducto;
import vista.usuario.MostrarUsuarios;
import vista.usuario.RegistrarUsuario;
import vista.ventas.MostrarVentas;
import vista.ventas.RegistrarVenta;

public class GestorVentanas {

  /**
   * cerrar todo.
   */
  public static void cerrarTodo() {
    RegistrarUsuario.cerrar();
    MostrarUsuarios.cerrar();
    RegistrarProducto.cerrar();
    MostrarProductos.cerrar();
    RegistrarVenta.cerrar();
    MostrarVentas.cerrar();
    Principal.cerrar();
  }
}
