package vista.eventos;

import static javax.swing.JOptionPane.showMessageDialog;

import controlador.ArrayProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.producto.Producto;
import vista.producto.RegistrarProducto;
import vista.validadores.ValidadorProducto;

public class EventosRegistroProductos implements ActionListener {

  public static boolean editar;
  public static int id;

  public EventosRegistroProductos() {
    this.editar = false;
    this.id = 0;
  }

  /**
   *
   * @param evento.
   */
  public void actionPerformed(ActionEvent evento) {
    if (ValidadorProducto.validar()) {
      Producto productoNuevo = new Producto();
      productoNuevo.nombre = RegistrarProducto.cajaNombre.getJText().getText();
      productoNuevo.cantidad = RegistrarProducto.cajaCantidad.getJText().getText();
      productoNuevo.precio = RegistrarProducto.cajaPrecio.getJText().getText();
      if (this.editar) {
        this.modificar(productoNuevo);
      } else {
        this.crear(productoNuevo);
      }
      RegistrarProducto.limpiarCajas();
    }
  }

  private void crear(Producto productoNuevo) {
    ArrayProductos.obtener().add(productoNuevo);
    ArrayProductos.guardar();
    showMessageDialog(null, "Registrado exitosamente");
  }

  private void modificar(Producto productoNuevo) {
    ArrayProductos.obtener().set(id - 1, productoNuevo);
    ArrayProductos.guardar();
    editar = false;
    showMessageDialog(null, "Editado exitosamente");
  }

}
