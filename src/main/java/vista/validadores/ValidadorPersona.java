package vista.validadores;

import static javax.swing.JOptionPane.showMessageDialog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vista.usuario.RegistrarUsuario;

public class ValidadorPersona {

  private ValidadorPersona(){

  }

  /**
   *.
   */
  public static boolean validar() {
    String ci = RegistrarUsuario.cajaCi.getJText().getText();
    String username = RegistrarUsuario.cajaNickname.getJText().getText();
    String contrasena = RegistrarUsuario.cajaContrasena.getJText().getText();
    String nombres = RegistrarUsuario.cajaNombres.getJText().getText();
    String apellidos = RegistrarUsuario.cajaApellidos.getJText().getText();
    String fechaNacimiento =
        RegistrarUsuario.cajaFechaNacimiento.getJFormattedTextField().getText();
    String email = RegistrarUsuario.cajaEmail.getJText().getText();
    String tipoUsuario = RegistrarUsuario.tipo.getSelectedItem().toString();
    String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = emailPattern.matcher(email);
    Boolean esEmailValido = matcher.find(); // true si es valido.

    if (!ci.matches("[0-9]+") || ci.length() != 7) {
      showMessageDialog(null, "Error: CI 7 numeros");
      return false;
    } else if (username.length() < 4) {
      showMessageDialog(null, "Error: Usuername minimo 4 caracteres");
      return false;
    } else if (contrasena.length() < 4) {
      showMessageDialog(null, "Error: Contrasena minimo 4 caracteres");
      return false;
    } else if (nombres.length() < 3) {
      showMessageDialog(null, "Error: Nombres minimo 3 caracteres");
      return false;
    } else if (apellidos.length() < 3) {
      showMessageDialog(null, "Error: Apellidos minimo 3 caracteres");
      return false;
    } else if (!esEmailValido) {
      showMessageDialog(null, "Error: Email no valido");
      return false;
    } else if (fechaNacimiento.length() == 0) {
      showMessageDialog(null, "Error: Fecha nacimiento esta vacio");
      return false;
    }
    return true;
  }
}