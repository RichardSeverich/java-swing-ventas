package controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.producto.Producto;

public class ArrayProductos {
  private static ArrayProductos miArrayProductos;
  public static ArrayList<Producto> productos;
  private static String rutaDatos = "data/productos.dat";

  private ArrayProductos() {
    this.productos = new ArrayList<Producto>();
    try {
      FileInputStream fileInputStream = new FileInputStream(rutaDatos);
      ObjectInputStream leyendoArray = new ObjectInputStream(fileInputStream);
      productos = ( ArrayList<Producto> )leyendoArray.readObject();
      leyendoArray.close();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }

  /**
   *
   * @return datos.
   */
  public static ArrayList<Producto> obtener() {
    if (miArrayProductos == null) {
      miArrayProductos = new ArrayProductos();
    }
    return productos;
  }

  /**
   * Guarda usuarios en archivo.
   */
  public static void guardar() {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(rutaDatos);
      ObjectOutputStream escribiendoArray = new ObjectOutputStream(fileOutputStream);
      escribiendoArray.writeObject(productos);
      escribiendoArray.close();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }
}
