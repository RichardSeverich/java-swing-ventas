package vista.tablas;

import controlador.ArrayVentas;

import java.util.ArrayList;
import javax.swing.JButton;

import modelo.producto.Producto;
import modelo.ventas.Venta;

public class TablasMostrarVentas {

  /**
   *.
   * @return Object[][].
   */
  public static Object[][] construirTablaVentas() {
    ArrayList<Venta> array = ArrayVentas.obtener();
    Object[][] arrayBidimensional = new Object[array.size()][5];
    for (int fila = 0; fila < array.size(); fila++) {
      Venta venta = array.get(fila);
      JButton botonEditar = new JButton("Editar");
      botonEditar.setName("Editar");
      arrayBidimensional[fila][0] = fila + 1;
      arrayBidimensional[fila][1] = venta.usuario;
      arrayBidimensional[fila][2] = venta.cliente;
      arrayBidimensional[fila][3] = venta.fecha;
      arrayBidimensional[fila][4] = botonEditar;
    }
    return arrayBidimensional;
  }

  /**
   *.
   * @param id.
   * @return arrayBidimensional.
   */
  public static Object[][] construirTablaProductos(int id) {
    ArrayList<Producto> array = ArrayVentas.obtener().get(id).arrayProductosVendidos;
    Object[][] arrayBidimensional = new Object[array.size()][4];
    for (int fila = 0; fila < array.size(); fila++) {
      Producto producto = array.get(fila);
      arrayBidimensional[fila][0] = fila + 1;
      arrayBidimensional[fila][1] = producto.nombre;
      arrayBidimensional[fila][2] = producto.cantidad;
      arrayBidimensional[fila][3] = producto.precio;
    }
    return arrayBidimensional;
  }
}
