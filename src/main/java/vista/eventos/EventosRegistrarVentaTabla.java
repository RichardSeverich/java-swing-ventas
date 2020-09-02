package vista.eventos;

import controlador.ArrayProductos;
import controlador.ArrayProductosVender;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.producto.Producto;
import vista.ventas.RegistrarVenta;

public class EventosRegistrarVentaTabla extends MouseAdapter {
  private List<Producto> array = new ArrayList<>();

  public EventosRegistrarVentaTabla() {

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
      if (this.productoExiste(row)) {
        this.editar(row);
      } else {
        this.addCarrito(row);
      }
      RegistrarVenta.costoTotal();
      RegistrarVenta.actualizarTablaCarrito();
      RegistrarVenta.actualizarTablaProductos();
    }
  }

  private void addCarrito(int row) {
    int id = (int) RegistrarVenta.tablaProductos.tabla.getValueAt(row, 0);
    int cantidadProducto = Integer.parseInt(ArrayProductos.productos.get(id - 1).cantidad);
    int cantidadVenta = Integer.parseInt(RegistrarVenta.cajaCantidad.getJText().getText());
    if (cantidadProducto - cantidadVenta > -1) {
      ArrayProductos.productos.get(id - 1).cantidad =
      Integer.toString(cantidadProducto - cantidadVenta);
      String nombre = (String) RegistrarVenta.tablaProductos.tabla.getValueAt(row, 1);
      String cantidad = RegistrarVenta.cajaCantidad.getJText().getText();
      String precio = (String) RegistrarVenta.tablaProductos.tabla.getValueAt(row, 3);
      Producto productoCarrito = new Producto();
      productoCarrito.nombre = nombre;
      productoCarrito.cantidad = cantidad;
      productoCarrito.precio = precio;
      ArrayProductosVender.productos.add(productoCarrito);
    } else {
      JOptionPane.showMessageDialog(null, "no hay productos suficientes");
    }
  }

  private void editar(int row) {
    int id = (int) RegistrarVenta.tablaProductos.tabla.getValueAt(row, 0);
    int cantidadProducto = Integer.parseInt(ArrayProductos.productos.get(id - 1).cantidad);
    int cantidadVenta = Integer.parseInt(RegistrarVenta.cajaCantidad.getJText().getText());
    if (cantidadProducto - cantidadVenta > -1) {
      ArrayProductos.productos.get(id - 1).cantidad =
      Integer.toString(cantidadProducto - cantidadVenta);
      String nombre =  ArrayProductos.productos.get(id - 1).nombre;
      for (int indice = 0;indice < ArrayProductosVender.productos.size();indice++) {
        if (ArrayProductosVender.productos.get(indice).nombre.equals(nombre)) {
          int cantidadCarrito =
              Integer.parseInt(ArrayProductosVender.productos.get(indice).cantidad);
          ArrayProductosVender.productos.get(indice).cantidad =
              Integer.toString(cantidadCarrito + cantidadVenta);
        }
      }
    } else {
      JOptionPane.showMessageDialog(null, "no hay productos suficientes");
    }
  }

  private boolean productoExiste(int row) {
    String username = (String) RegistrarVenta.tablaProductos.tabla.getValueAt(row, 1);
    array = ArrayProductosVender.productos
        .stream()
        .filter(producto -> producto.nombre.equals(username))
        .collect(Collectors.toList());
    return array.size() > 0;
  }
}
