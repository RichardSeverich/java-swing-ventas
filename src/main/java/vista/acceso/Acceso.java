package vista.acceso;

import java.awt.Dimension;
import javax.swing.JFrame;

import vista.Principal;
import vista.componentes.Boton;
import vista.componentes.ContenedorAcceso;
import vista.componentes.Texto;
import vista.eventos.EventoAcceso;
import vista.producto.MostrarProductos;
import vista.producto.RegistrarProducto;
import vista.usuario.MostrarUsuarios;
import vista.usuario.RegistrarUsuario;
import vista.ventas.MostrarVentas;
import vista.ventas.RegistrarVenta;

public class Acceso {
  private static Acceso acceso;
  static JFrame jFrameIngreso;

  private Acceso() {
    // creaddo mi frame de ingreso
    jFrameIngreso = new JFrame();
    jFrameIngreso.setTitle("Ingreso");
    jFrameIngreso.setSize(328, 150);
    jFrameIngreso.setResizable(false);
    jFrameIngreso.setLayout(null);
    // creando mi componente textos
    Texto usuario = new Texto("Usuario:");
    Texto contrasena = new Texto("Contrasena:");
    usuario.getJLabel().setLocation(10, 10);
    contrasena.getJLabel().setLocation(10, 40);
    // creando contenedores
    ContenedorAcceso.obtenerInstancia();
    // agregando boton
    Boton ingresar = new Boton("Ingresar");
    ingresar.getJButton().setLocation(208, 70);
    ingresar.getJButton().setSize(new Dimension(100, 30));
    // añadiendo todo jFrameIngreso.add();
    jFrameIngreso.add(ContenedorAcceso.getUsuario());
    jFrameIngreso.add(ContenedorAcceso.getcontrasena());
    jFrameIngreso.add(usuario.getJLabel());
    jFrameIngreso.add(contrasena.getJLabel());
    jFrameIngreso.add(ingresar.getJButton());
    // añadiendo evento
    EventoAcceso evento = new EventoAcceso();
    ingresar.getJButton().addActionListener(evento);
    jFrameIngreso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrameIngreso.setLocationRelativeTo(null);
    jFrameIngreso.setVisible(true);
  }

  public static void cerrar() {
    jFrameIngreso.setVisible(false);
  }

  public static void abrir() {
    jFrameIngreso.setVisible(true);
  }

  /**
   *
   * @return acceso.
   */
  public static Acceso obtener() {
    if (acceso == null) {
      acceso = new Acceso();
    }
    return acceso;
  }

  /**
   *.
   */
  public static void iniciar() {
    RegistrarUsuario.obtener();
    MostrarUsuarios.obtener();
    RegistrarProducto.obtener();
    MostrarProductos.obtener();
    RegistrarVenta.obtener();
    MostrarVentas.obtener();
    Principal.obtener();
  }
}
