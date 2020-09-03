package vista.componentes;

import java.awt.Font;
import javax.swing.JTextField;

public class CajaTexto {

  JTextField caja;

  /**
   * caja texto.
   */
  public CajaTexto() {
    caja = new JTextField();
    caja.setSize(190, 25);
    caja.setFont(new Font("Arial", Font.PLAIN, 14));
  }

  public JTextField getJText() {
    return caja;
  }
}
