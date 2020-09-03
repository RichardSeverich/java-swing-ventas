package vista.eventos;

import controlador.ArrayProductos;
import controlador.ArrayProductosVender;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import vista.ventas.RegistrarVenta;

public class EventosRegistrarVentaCarrito extends MouseAdapter {

  public EventosRegistrarVentaCarrito() {

  }

  /**
   *.
   */
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = RegistrarVenta
        .tablaProductos
        .tabla
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / RegistrarVenta.tablaProductos.tabla.getRowHeight();
    Object value = RegistrarVenta.tablaProductos.tabla.getValueAt(row, column);
    if (value instanceof JButton) {
      this.editar(row);
      RegistrarVenta.costoTotal();
      RegistrarVenta.actualizarTablaCarrito();
      RegistrarVenta.actualizarTablaProductos();
    }
  }

  private void editar(int row) {
    int id = (int) RegistrarVenta.tablaCarrito.tabla.getValueAt(row, 0);
    int cantidadCarrito =
        Integer.parseInt(ArrayProductosVender.productos.get(id - 1).cantidad);
    String nombre =  ArrayProductosVender.productos.get(id - 1).nombre;
    for (int indice = 0;indice < ArrayProductos.productos.size();indice++) {
      if (ArrayProductos.productos.get(indice).nombre.equals(nombre)) {
        int cantidadProducto =
            Integer.parseInt(ArrayProductos.productos.get(indice).cantidad);
        ArrayProductos.productos.get(indice).cantidad =
            Integer.toString(cantidadCarrito + cantidadProducto);
      }
    }
    ArrayProductosVender.productos.remove(id - 1);
  }
}
