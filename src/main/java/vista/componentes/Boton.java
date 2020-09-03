package vista.componentes;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

public class Boton {
  private JButton miJButton;

  public Boton(String nomBoton) {
    miJButton = new JButton(nomBoton);
    miJButton.setSize(new Dimension(190, 30));
  }

  /**
   *
   * @return miButton.
   */
  public JButton getJButton() {
    // miJButton.setBackground(new Color(0, 0, 0));
    // miJButton.setForeground(new Color(255, 255, 255));
    miJButton.setFont(new Font("Arial", Font.PLAIN, 14));
    return miJButton;
  }
}
