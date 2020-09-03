package vista.componentes;

import javax.swing.JFrame;

public class Ventana {
  public JFrame miJFrame;

  /**
   *
   * @param titulo.
   */
  public Ventana(String titulo) {
    miJFrame = new JFrame();
    miJFrame.setTitle(titulo);
    miJFrame.setSize(800, 600);
    miJFrame.setResizable(false);
    miJFrame.setLayout(null);
    miJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    miJFrame.setLocationRelativeTo(null);
    miJFrame.setJMenuBar(Barra.getJMenu());
  }

  public JFrame getJFrame() {
    return miJFrame;
  }
}
