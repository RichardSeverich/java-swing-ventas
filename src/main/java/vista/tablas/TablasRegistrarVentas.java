package vista.tablas;

import controlador.ArrayProductos;
import controlador.ArrayProductosVender;

import java.util.ArrayList;
import javax.swing.JButton;

import modelo.producto.Producto;

public class TablasRegistrarVentas {

  /**
   *.
   * @return Object[][].
   */
  public static Object[][] construirTablaProductos() {
    ArrayList<Producto> array = ArrayProductos.obtener();
    Object[][] arrayBidimensional = new Object[array.size()][5];
    for (int fila = 0; fila < array.size(); fila++) {
      Producto producto = array.get(fila);
      arrayBidimensional[fila][0] = fila + 1;
      arrayBidimensional[fila][1] = producto.nombre;
      arrayBidimensional[fila][2] = producto.cantidad;
      arrayBidimensional[fila][3] = producto.precio;
      JButton botonAgregar = new JButton("Agregar");
      arrayBidimensional[fila][4] = botonAgregar;
    }
    return arrayBidimensional;
  }

  /**
   *.
   * @return arrayBidimensional.
   */
  public static Object[][] construirTablaCarrito() {
    ArrayList<Producto> array = ArrayProductosVender.obtener();
    Object[][] arrayBidimensional = new Object[array.size()][5];
    for (int fila = 0; fila < array.size(); fila++) {
      Producto producto = array.get(fila);
      arrayBidimensional[fila][0] = fila + 1;
      arrayBidimensional[fila][1] = producto.nombre;
      arrayBidimensional[fila][2] = producto.cantidad;
      arrayBidimensional[fila][3] = producto.precio;
      JButton botonAgregar = new JButton("Eliminar");
      arrayBidimensional[fila][4] = botonAgregar;
    }
    return arrayBidimensional;
  }
}
