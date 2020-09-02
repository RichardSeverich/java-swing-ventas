package controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.usuario.Persona;

public class ArrayUsuarios {
  private static ArrayUsuarios miArrayUsuarios;
  public static ArrayList<Persona> usuarios;
  private static String rutaDatos = "data/usuarios.dat";

  private ArrayUsuarios() {
    this.usuarios = new ArrayList<Persona>();
    try {
      FileInputStream fileInputStream = new FileInputStream(rutaDatos);
      ObjectInputStream leyendoArray = new ObjectInputStream(fileInputStream);
      usuarios = ( ArrayList<Persona> )leyendoArray.readObject();
      leyendoArray.close();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }

  /**
   *
   * @return usuarios.
   */
  public static ArrayList<Persona> obtener() {
    if (miArrayUsuarios == null) {
      miArrayUsuarios = new ArrayUsuarios();
    }
    return usuarios;
  }

  /**
   * Guarda usuarios en archivo.
   */
  public static void guardar() {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(rutaDatos);
      ObjectOutputStream escribiendoArray = new ObjectOutputStream(fileOutputStream);
      escribiendoArray.writeObject(usuarios);
      escribiendoArray.close();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }
}
