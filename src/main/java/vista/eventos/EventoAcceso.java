package vista.eventos;

import controlador.ArrayUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

import modelo.usuario.Persona;
import vista.Principal;
import vista.acceso.Acceso;
import vista.componentes.ContenedorAcceso;

public class EventoAcceso implements ActionListener {
  private List<Persona> array = new ArrayList<>();
  public static String nombreUsuario;
  String user = "charly";
  String password = "123";

  /**
   * .
   */
  public void actionPerformed(ActionEvent evento) {
    String usuario = ContenedorAcceso.getUsuario().getText();
    String contrasena = ContenedorAcceso.getcontrasena().getText();
    limpiarArray();
    if (user.equals(usuario) && password.equals(contrasena)) {
      nombreUsuario = "Charly";
      iniciar();
    } else if (usuarioExiste(usuario, contrasena)) {
      nombreUsuario = array.get(0).nombres;
      iniciar();
    } else {
      JOptionPane.showMessageDialog(null, "Contrasena o usuario incorrectos");
    }
  }

  private boolean usuarioExiste(String username, String password) {
    array = ArrayUsuarios.obtener()
        .stream()
        .filter(usuario -> usuario.username.equals(username)
        && usuario.contrasena.equals(password))
        .collect(Collectors.toList());
    return array.size() > 0;
  }

  private void iniciar() {
    Acceso.cerrar();
    Principal.abrir();
  }

  private void limpiarArray() {
    if (array.size() > 0) {
      array.remove(0);
    }
  }
}
