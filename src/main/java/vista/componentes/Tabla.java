package vista.componentes;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Tabla {

  public JTable tabla;
  public JPanel panel;

  /**
   *
   * @param arrayBidimensional.
   * @param columnas.
   * @param miJFrame.
   */
  public Tabla(Object[][] arrayBidimensional, JFrame miJFrame,
      DefaultTableModel defaultTableModel) {
    panel = new JPanel();
    panel.setBounds(60, 20, 670, 500);
    miJFrame.add(panel);
    panel.setLayout(new BorderLayout());
    String title = "Mostrar";
    Border border = BorderFactory.createTitledBorder(title);
    panel.setBorder(border);
    tabla = new JTable();
    tabla.setDefaultRenderer(Object.class, new Render());
    tabla.setModel(defaultTableModel);
    JScrollPane scrollPane = new JScrollPane(tabla,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    panel.add(scrollPane);
  }

  public JTable getJTable() {
    return tabla;
  }
}
