package vista.componentes;

import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import vista.eventos.EventosBarra;

public class Barra {
  private JMenuBar barra;

  private Barra() {
    Font letra = new Font("", Font.PLAIN, 16);
    barra = new JMenuBar();
    JMenu menu = new JMenu("Principal");
    menu.setFont(letra);
    JMenu menu1 = new JMenu("Usuarios");
    menu1.setFont(letra);
    JMenu menu2 = new JMenu("Productos");
    menu2.setFont(letra);
    JMenu menu3 = new JMenu("Ventas");
    menu3.setFont(letra);
    EventosBarra misEventos = new EventosBarra();
    JMenuItem inicio = new JMenuItem("Inicio");
    inicio.addActionListener(misEventos);
    JMenuItem login = new JMenuItem("Login");
    login.addActionListener(misEventos);
    JMenuItem salir = new JMenuItem("Salir");
    salir.addActionListener(misEventos);
    JMenuItem menuRegistrarUsuario = new JMenuItem("Registrar usuario");
    menuRegistrarUsuario.addActionListener(misEventos);
    JMenuItem menuMostrarUsuario = new JMenuItem("Mostrar usuarios");
    menuMostrarUsuario.addActionListener(misEventos);
    JMenuItem menuRegistrarProducto = new JMenuItem("Registrar productos");
    menuRegistrarProducto.addActionListener(misEventos);
    JMenuItem menuMostrarProducto = new JMenuItem("Mostrar productos");
    menuMostrarProducto.addActionListener(misEventos);
    JMenuItem menuRegistrarVentas = new JMenuItem("Registrar venta");
    menuRegistrarVentas.addActionListener(misEventos);
    JMenuItem menuMostrarVentas = new JMenuItem("Mostrar ventas");
    menuMostrarVentas.addActionListener(misEventos);
    menu.add(inicio);
    menu.add(login);
    menu.add(salir);
    menu1.add(menuRegistrarUsuario);
    menu1.add(menuMostrarUsuario);
    menu2.add(menuRegistrarProducto);
    menu2.add(menuMostrarProducto);
    menu3.add(menuRegistrarVentas);
    menu3.add(menuMostrarVentas);
    barra.add(menu);
    barra.add(menu1);
    barra.add(menu2);
    barra.add(menu3);
  }

  public static JMenuBar getJMenu() {
    return new Barra().barra;
  }
}
