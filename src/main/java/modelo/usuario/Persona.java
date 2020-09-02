package modelo.usuario;

import java.io.Serializable;

public abstract class Persona implements Serializable {
  public String ci;
  public String username;
  public String contrasena;
  public String nombres;
  public String apellidos;
  public String fechaNacimiento;
  public String email;
  public String tipo;
}
