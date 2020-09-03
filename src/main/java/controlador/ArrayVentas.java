package controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.ventas.Venta;

public class ArrayVentas {
  private static ArrayVentas miArrayVentas;
  public static ArrayList<Venta> ventas;
  private static String rutaDatos = "data/ventas.dat";

  private ArrayVentas() {
    this.ventas = new ArrayList<Venta>();
    try {
      FileInputStream fileInputStream = new FileInputStream(rutaDatos);
      ObjectInputStream leyendoArray = new ObjectInputStream(fileInputStream);
      ventas = ( ArrayList<Venta> )leyendoArray.readObject();
      leyendoArray.close();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }

  /**
   *
   * @return ventas.
   */
  public static ArrayList<Venta> obtener() {
    if (miArrayVentas == null) {
      miArrayVentas = new ArrayVentas();
    }
    return ventas;
  }

  /**
   * Guarda ventas en archivo.
   */
  public static void guardar() {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(rutaDatos);
      ObjectOutputStream escribiendoArray = new ObjectOutputStream(fileOutputStream);
      escribiendoArray.writeObject(ventas);
      escribiendoArray.close();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }
}
