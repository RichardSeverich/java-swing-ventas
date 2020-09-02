package vista.componentes;

import java.awt.Font;
import javax.swing.JTextField;

public class ContenedorAcceso {
  private static ContenedorAcceso contenedor;
  static JTextField cajaUsuario;
  static JTextField cajaContrasena;

  private ContenedorAcceso() {
    cajaUsuario = new JTextField();
    cajaContrasena = new JTextField();
    cajaUsuario.setBounds(120, 10, 190, 25);
    cajaUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
    cajaContrasena.setBounds(120, 40, 190, 25);
    cajaContrasena.setFont(new Font("Arial", Font.PLAIN, 18));
  }

  /**
   *
   * @return contenedor.
   */
  public static ContenedorAcceso obtenerInstancia() {
    if (contenedor == null) {
      contenedor = new ContenedorAcceso();
    }
    return contenedor;
  }

  public static JTextField getUsuario() {
    return cajaUsuario;
  }

  public static JTextField getcontrasena() {
    return cajaContrasena;
  }
}
