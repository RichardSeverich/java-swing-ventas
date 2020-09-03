package vista.componentes;

import java.awt.Font;
import javax.swing.JLabel;
//import java.awt.Dimension;

public class Texto {
  private JLabel texto;

  /**
   *
   * @param nomTexto.
   */
  public Texto(String nomTexto) {
    texto = new JLabel(nomTexto);
    // texto.setSize(new Dimension(70, 200));
    texto.setFont(new Font("Arial", Font.PLAIN, 16));
    texto.setSize(texto.getPreferredSize());
  }

  public JLabel getJLabel() {
    return texto;
  }
}
