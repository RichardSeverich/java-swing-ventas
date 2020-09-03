package vista.usuario;

import java.awt.Font;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import vista.componentes.Boton;
import vista.componentes.CajaTexto;
import vista.componentes.DateLabelFormatter;
import vista.componentes.Texto;
import vista.componentes.Ventana;
import vista.eventos.EventosRegistroUsuarios;

public class RegistrarUsuario {
  private static RegistrarUsuario registrarUsuario;
  public static Ventana miVentana;
  public static CajaTexto cajaCi;
  public static CajaTexto cajaNickname;
  public static CajaTexto cajaContrasena;
  public static CajaTexto cajaNombres;
  public static CajaTexto cajaApellidos;
  public static JDatePickerImpl cajaFechaNacimiento;
  public static CajaTexto cajaEmail;
  public static JComboBox tipo;

  private RegistrarUsuario() {
    miVentana = new Ventana("Menu principal");
    JPanel panel = new JPanel();
    miVentana.getJFrame().add(panel);
    panel.setBounds(180, 20, 400, 500);
    panel.setLayout(null);
    tipo = new JComboBox<>();
    tipo.setModel(new DefaultComboBoxModel<>(new String[]
        { "Empleado", "Administrador", "Cliente" }));
    tipo.setFont(new Font("Arial", Font.PLAIN, 14));
    // instanciando cajas de texto
    cajaCi = new CajaTexto();
    cajaNickname = new CajaTexto();
    cajaContrasena = new CajaTexto();
    cajaNombres = new CajaTexto();
    cajaApellidos = new CajaTexto();
    cajaEmail = new CajaTexto();
    UtilDateModel model = new UtilDateModel();
    Properties properties = new Properties();
    properties.put("text.today", "Today");
    properties.put("text.month", "Month");
    properties.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
    cajaFechaNacimiento = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    model.setSelected(true);
    // instanciando botones
    Boton botonRegistrar = new Boton("Registrar");
    EventosRegistroUsuarios registro = new EventosRegistroUsuarios();
    botonRegistrar.getJButton().addActionListener(registro);
    // posicionando cajas de texto
    cajaCi.getJText().setLocation(200, 80);
    cajaNickname.getJText().setLocation(200, 120);
    cajaContrasena.getJText().setLocation(200, 160);
    cajaNombres.getJText().setLocation(200, 200);
    cajaApellidos.getJText().setLocation(200, 240);
    cajaFechaNacimiento.setBounds(200, 280, 190, 25);
    cajaEmail.getJText().setLocation(200, 320);
    tipo.setBounds(200, 360, 190, 25);
    // intanciando y posicionando textos
    Texto textoTitulo = new Texto("Registrar Usuario");
    textoTitulo.getJLabel().setLocation(200, 30);
    Texto textoci = new Texto("CI");
    textoci.getJLabel().setLocation(20, 80);
    Texto textoNickname = new Texto("Nickname");
    textoNickname.getJLabel().setLocation(20, 120);
    Texto textoContrasena = new Texto("Contrasena");
    textoContrasena.getJLabel().setLocation(20, 160);
    Texto textoNombres = new Texto("Nombres");
    textoNombres.getJLabel().setLocation(20, 200);
    Texto textoApellidos = new Texto("Apellidos");
    textoApellidos.getJLabel().setLocation(20, 240);
    Texto textoFechaNacimiento = new Texto("Fecha nacimiento");
    textoFechaNacimiento.getJLabel().setLocation(20, 280);
    Texto textoEmail = new Texto("E-mail");
    textoEmail.getJLabel().setLocation(20, 320);
    Texto textoTipo = new Texto("Tipo");
    textoTipo.getJLabel().setLocation(20, 360);
    // posicionando boton
    botonRegistrar.getJButton().setLocation(200, 410);
    // añadiendo todo a mi JFrame
    panel.add(cajaCi.getJText());
    panel.add(cajaNickname.getJText());
    panel.add(cajaContrasena.getJText());
    panel.add(cajaNombres.getJText());
    panel.add(cajaApellidos.getJText());
    panel.add(cajaFechaNacimiento);
    panel.add(cajaEmail.getJText());
    panel.add(textoTitulo.getJLabel());
    panel.add(textoci.getJLabel());
    panel.add(textoNickname.getJLabel());
    panel.add(textoContrasena.getJLabel());
    panel.add(textoNombres.getJLabel());
    panel.add(textoApellidos.getJLabel());
    panel.add(textoFechaNacimiento.getJLabel());
    panel.add(textoEmail.getJLabel());
    panel.add(tipo);
    panel.add(textoTipo.getJLabel());
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
   * .
   */
  public static RegistrarUsuario obtener() {
    if (registrarUsuario == null) {
      registrarUsuario = new RegistrarUsuario();
    }
    return registrarUsuario;
  }

  /**
   *.
   */
  public static void limpiarCajas() {
    cajaCi.getJText().setText("");
    cajaNickname.getJText().setText("");
    cajaContrasena.getJText().setText("");
    cajaNombres.getJText().setText("");
    cajaApellidos.getJText().setText("");
    cajaEmail.getJText().setText("");
    tipo.setSelectedItem("");
  }
}
