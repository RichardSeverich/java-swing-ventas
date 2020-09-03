package vista.tablas;

import controlador.ArrayProductos;
import java.util.ArrayList;
import javax.swing.JButton;

import modelo.producto.Producto;

public class TablaProductos {

  /**
   *.
   * @return Object[][].
   */
  public static Object[][] construir() {
    ArrayList<Producto> array = ArrayProductos.obtener();
    Object[][] arrayBidimensional = new Object[array.size()][6];
    for (int fila = 0; fila < array.size(); fila++) {
      JButton botonEditar = new JButton("Editar");
      botonEditar.setName("Editar");
      JButton botonEliminar = new JButton("Eliminar");
      botonEliminar.setName("Eliminar");
      Producto producto = array.get(fila);
      arrayBidimensional[fila][0] = fila + 1;
      arrayBidimensional[fila][1] = producto.nombre;
      arrayBidimensional[fila][2] = producto.cantidad;
      arrayBidimensional[fila][3] = producto.precio;
      arrayBidimensional[fila][4] = botonEditar;
      arrayBidimensional[fila][5] = botonEliminar;
    }
    return arrayBidimensional;
  }

}
