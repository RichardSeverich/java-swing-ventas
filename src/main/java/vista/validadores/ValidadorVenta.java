package vista.validadores;

import static javax.swing.JOptionPane.showMessageDialog;

import controlador.ArrayProductosVender;
import controlador.ArrayUsuarios;
import vista.ventas.RegistrarVenta;

public class ValidadorVenta {

  private ValidadorVenta(){

  }

  /**
   *.
   * @return boolean.
   */
  public static boolean validar() {
    String cliente = RegistrarVenta.cajaCliente.getJText().getText();
    if (ArrayProductosVender.productos.size() < 1) {
      showMessageDialog(null, "Agregue productos al carrito");
      return false;
    }
    for (int indice = 0;indice < ArrayUsuarios.obtener().size();indice++) {
      if (ArrayUsuarios.usuarios.get(indice).username.equalsIgnoreCase(cliente)) {
        return true;
      }
    }
    if (cliente.equalsIgnoreCase("sin nombre")) {
      return true;
    }
    showMessageDialog(null, "cliente no valido(usar SIN NOMBRE por defecto)");
    return false;
  }
}