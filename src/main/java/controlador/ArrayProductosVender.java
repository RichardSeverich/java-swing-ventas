package controlador;

import java.util.ArrayList;

import modelo.producto.Producto;

public class ArrayProductosVender {
  private static ArrayProductosVender miArrayProductosVender;
  public static ArrayList<Producto> productos;

  private ArrayProductosVender() {
    this.productos = new ArrayList<Producto>();
  }

  /**
   *
   * @return datos.
   */
  public static ArrayList<Producto> obtener() {
    if (miArrayProductosVender == null) {
      miArrayProductosVender = new ArrayProductosVender();
    }
    return productos;
  }
}
