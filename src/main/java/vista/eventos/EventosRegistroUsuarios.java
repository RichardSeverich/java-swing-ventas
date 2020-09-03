package vista.eventos;

import static javax.swing.JOptionPane.showMessageDialog;

import controlador.ArrayUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.usuario.Administrador;
import modelo.usuario.Cliente;
import modelo.usuario.Empleado;
import modelo.usuario.Persona;
import vista.usuario.RegistrarUsuario;
import vista.validadores.ValidadorPersona;

public class EventosRegistroUsuarios implements ActionListener {

  public static boolean editar;
  public static int id;

  public EventosRegistroUsuarios() {
    this.editar = false;
    this.id = 0;
  }

  /**
   *
   * @param evento.
   */
  public void actionPerformed(ActionEvent evento) {
    if (ValidadorPersona.validar()) {
      String forma = (String) RegistrarUsuario.tipo.getSelectedItem();
      Persona personaNueva = this.fabrica(forma);
      personaNueva.ci = RegistrarUsuario.cajaCi.getJText().getText();
      personaNueva.username = RegistrarUsuario.cajaNickname.getJText().getText();
      personaNueva.contrasena = RegistrarUsuario.cajaContrasena.getJText().getText();
      personaNueva.nombres = RegistrarUsuario.cajaNombres.getJText().getText();
      personaNueva.apellidos = RegistrarUsuario.cajaApellidos.getJText().getText();
      personaNueva.fechaNacimiento
        = RegistrarUsuario.cajaFechaNacimiento.getJFormattedTextField().getText();
      personaNueva.email = RegistrarUsuario.cajaEmail.getJText().getText();
      personaNueva.tipo = RegistrarUsuario.tipo.getSelectedItem().toString();
      if (this.editar) {
        this.modificar(personaNueva);
      } else {
        this.crear(personaNueva);
      }
      RegistrarUsuario.limpiarCajas();
    }
  }

  private void crear(Persona personaNueva) {
    ArrayUsuarios.obtener().add(personaNueva);
    ArrayUsuarios.guardar();
    showMessageDialog(null, "Registrado exitosamente");
  }

  private void modificar(Persona personaNueva) {
    ArrayUsuarios.obtener().set(id - 1, personaNueva);
    ArrayUsuarios.guardar();
    editar = false;
    showMessageDialog(null, "Editado exitosamente");
  }

  private Persona fabrica(String forma) {
    Persona personaNueva;
    switch (forma) {
      case "Empleado":
        personaNueva = new Empleado();
        break;
      case "Administrador":
        personaNueva = new Administrador();
        break;
      case "Cliente":
        personaNueva = new Cliente();
        break;
      default:
        personaNueva = new Empleado();
        break;
    }
    return personaNueva;
  }

}
