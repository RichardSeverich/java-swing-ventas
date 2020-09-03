package vista.tablas;

import controlador.ArrayUsuarios;
import java.util.ArrayList;
import javax.swing.JButton;

import modelo.usuario.Persona;

public class TablaUsuarios {

  /**
   *.
   * @return Object[][].
   */
  public static Object[][] construir() {
    ArrayList<Persona> array = ArrayUsuarios.obtener();
    Object[][] arrayBidimensional = new Object[array.size()][11];
    for (int fila = 0; fila < array.size(); fila++) {
      JButton botonEditar = new JButton("Editar");
      JButton botonEliminar = new JButton("Eliminar");
      botonEditar.setName("Editar");
      botonEliminar.setName("Eliminar");
      Persona persona = array.get(fila);
      arrayBidimensional[fila][0] = fila + 1;
      arrayBidimensional[fila][1] = persona.ci;
      arrayBidimensional[fila][2] = persona.username;
      arrayBidimensional[fila][3] = persona.contrasena;
      arrayBidimensional[fila][4] = persona.nombres;
      arrayBidimensional[fila][5] = persona.apellidos;
      arrayBidimensional[fila][6] = persona.fechaNacimiento;
      arrayBidimensional[fila][7] = persona.email;
      arrayBidimensional[fila][8] = persona.tipo;
      arrayBidimensional[fila][9] = botonEditar;
      arrayBidimensional[fila][10] = botonEliminar;
    }
    return arrayBidimensional;
  }

}
