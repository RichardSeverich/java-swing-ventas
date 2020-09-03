package vista.eventos;

import static javax.swing.JOptionPane.showMessageDialog;

import controlador.ArrayProductos;
import controlador.ArrayProductosVender;
import controlador.ArrayVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.producto.Producto;
import modelo.ventas.Venta;
import vista.validadores.ValidadorVenta;
import vista.ventas.RegistrarVenta;

public class EventosRegistroVenta implements ActionListener {

  public static boolean editar;
  public static int id;

  public EventosRegistroVenta() {
    this.editar = false;
    this.id = 0;
  }

  /**
   *
   * @param evento.
   */
  public void actionPerformed(ActionEvent evento) {
    if (ValidadorVenta.validar()) {
      Venta ventaNueva = new Venta();
      ventaNueva.usuario = RegistrarVenta.nombreUsuario.getJLabel().getText();
      ventaNueva.cliente = RegistrarVenta.cajaCliente.getJText().getText();
      ventaNueva.fecha =
      RegistrarVenta.cajaFechaVenta.getJFormattedTextField().getText();
      ventaNueva.arrayProductosVendidos =
          (ArrayList<Producto>) ArrayProductosVender.productos.clone();
      this.crear(ventaNueva);
      ArrayProductosVender.productos.clear();
      RegistrarVenta.actualizarTablaCarrito();
      ArrayProductos.guardar();
      RegistrarVenta.precioTotal.getJLabel().setText("0");
    }
  }

  private void crear(Venta ventaNueva) {
    ArrayVentas.obtener().add(ventaNueva);
    ArrayVentas.guardar();
    ArrayProductos.guardar();
    showMessageDialog(null, "Registrado exitosamente");
  }
}
