package vista.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import vista.ventas.MostrarVentas;

public class EventosMostrarVenta extends MouseAdapter {

  public EventosMostrarVenta() {

  }

  /**
   *.
   */
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = MostrarVentas
        .tablaVentas
        .tabla
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / MostrarVentas.tablaVentas.tabla.getRowHeight();
    Object value = MostrarVentas.tablaVentas.tabla.getValueAt(row, column);
    if (value instanceof JButton) {
      int id = (int) MostrarVentas.tablaVentas.tabla.getValueAt(row, 0);
      MostrarVentas.actualizarTablaProductos(id - 1);
    }
  }
}
