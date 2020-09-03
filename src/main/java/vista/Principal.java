package vista;

import javax.swing.JFrame;

import vista.componentes.Boton;
import vista.componentes.Texto;
import vista.componentes.Ventana;
import vista.eventos.EventosBarra;

public class Principal {
  private static Principal principal;
  public static Ventana miVentana;

  private Principal() {
    miVentana = new Ventana("Menu principal");
    // texto
    Texto textoMenu = new Texto("*******BIENVENIDO*******");
    textoMenu.getJLabel().setLocation(20, 10);
    // boton
    Boton miBoton1 = new Boton("Salir");
    miBoton1.getJButton().setLocation(600, 450);
    // añadiendo eventos
    EventosBarra misEventos = new EventosBarra();
    miBoton1.getJButton().addActionListener(misEventos);
    // añadiendo todo a mi JFrame
    JFrame miJFrame = miVentana.getJFrame();
    miJFrame.add(textoMenu.getJLabel());
    miJFrame.add(miBoton1.getJButton());
    // miJFrame.setVisible(true);
  }

  /**
   * cerrar.
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
   * @return principal.
   */
  public static Principal obtener() {
    if (principal == null) {
      principal = new Principal();
    }
    return principal;
  }
}
