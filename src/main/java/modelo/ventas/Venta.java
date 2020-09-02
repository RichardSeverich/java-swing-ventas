package modelo.ventas;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.producto.Producto;

public class Venta implements Serializable {
  public String usuario;
  public String cliente;
  public String fecha;
  public ArrayList<Producto> arrayProductosVendidos;
}
