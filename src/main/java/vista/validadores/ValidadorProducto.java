package vista.validadores;

import static javax.swing.JOptionPane.showMessageDialog;

import vista.producto.RegistrarProducto;

public class ValidadorProducto {

  private ValidadorProducto(){

  }

  /**
   *.
   * @return boolean.
   */
  public static boolean validar() {
    String nombre = RegistrarProducto.cajaNombre.getJText().getText();
    String cantidad = RegistrarProducto.cajaCantidad.getJText().getText();
    String precio = RegistrarProducto.cajaPrecio.getJText().getText();
    if (nombre.length() < 4) {
      showMessageDialog(null, "Error: Nombre minimo 4 caracteres");
      return false;
    } else if (!cantidad.matches("[0-9]+") || cantidad.length() < 1) {
      showMessageDialog(null, "Error: Cantidad minimo 1 numero");
      return false;
    } else if (!precio.matches("[0-9]+") || precio.length() < 1) {
      showMessageDialog(null, "Error: precio minimo 1 numero");
      return false;
    }
    return true;
  }
}