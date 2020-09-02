package modelo.usuario;

public class Empleado extends Persona {

  public String sueldo;

  public Empleado() {
    this.tipo = "Empleado";
    this.sueldo = "400Bs";
  }
}
