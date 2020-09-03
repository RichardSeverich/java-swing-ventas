package vista.producto;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import vista.componentes.Boton;
import vista.componentes.CajaTexto;
import vista.componentes.Texto;
import vista.componentes.Ventana;
import vista.eventos.EventosRegistroProductos;

public class RegistrarProducto {
  private static RegistrarProducto registrarProducto;
  public static Ventana miVentana;
  public static CajaTexto cajaNombre;
  public static CajaTexto cajaCantidad;
  public static CajaTexto cajaPrecio;

  private RegistrarProducto() {
    miVentana = new Ventana("Menu principal");
    JPanel panel = new JPanel();
    miVentana.getJFrame().add(panel);
    panel.setBounds(180, 20, 400, 300);
    panel.setLayout(null);
    // instanciando cajas de texto
    cajaNombre = new CajaTexto();
    cajaCantidad = new CajaTexto();
    cajaPrecio = new CajaTexto();
    // intanciando textos
    Texto textoTitulo = new Texto("Registrar Producto");
    Texto textoNombre = new Texto("Nombre");
    Texto textoCantidad = new Texto("Cantidad");
    Texto textoPrecio = new Texto("Precio");
    // instanciando botones
    Boton botonRegistrar = new Boton("Registrar");
    EventosRegistroProductos registro = new EventosRegistroProductos();
    botonRegistrar.getJButton().addActionListener(registro);
    // posicionando cajas de texto
    cajaNombre.getJText().setLocation(200, 80);
    cajaCantidad.getJText().setLocation(200, 120);
    cajaPrecio.getJText().setLocation(200, 160);
    // posicionando textos
    textoTitulo.getJLabel().setLocation(200, 30);
    textoNombre.getJLabel().setLocation(20, 80);
    textoCantidad.getJLabel().setLocation(20, 120);
    textoPrecio.getJLabel().setLocation(20, 160);
    // posicionando boton
    botonRegistrar.getJButton().setLocation(200, 210);
    // añadiendo todo a mi JFrame
    panel.add(cajaNombre.getJText());
    panel.add(cajaCantidad.getJText());
    panel.add(cajaPrecio.getJText());
    panel.add(textoTitulo.getJLabel());
    panel.add(textoNombre.getJLabel());
    panel.add(textoCantidad.getJLabel());
    panel.add(textoPrecio.getJLabel());
    panel.add(botonRegistrar.getJButton());
    // Titulo y Borde
    String title = "Registrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
  }

  /**
   * .
   */
  public static void cerrar() {
    if (miVentana.getJFrame().isVisible() == true) {
      miVentana.getJFrame().setVisible(false);
    }
  }

  public static void abrir() {
    miVentana.getJFrame().setVisible(true);
  }

  /**
   *
   * @return registrarProducto.
   */
  public static RegistrarProducto obtener() {
    if (registrarProducto == null) {
      registrarProducto = new RegistrarProducto();
    }
    return registrarProducto;
  }

  /**
   *.
   */
  public static void limpiarCajas() {
    cajaNombre.getJText().setText("");
    cajaCantidad.getJText().setText("");
    cajaPrecio.getJText().setText("");
  }
}
