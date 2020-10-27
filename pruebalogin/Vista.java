/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebalogin;

import javax.swing.*;

import pruebalogin.Controlador;

import java.awt.*;

public class Vista extends JFrame implements interfazVista {

    public JButton ingresar;
    public JButton registrar;
    public JTextField usuario;
    public JPasswordField contrasena;
    public JLabel Us;
    public JLabel Pa;
    public JPanel contenedor;

    Vista() {
        super("VLCA");

        setLayout(new FlowLayout());

        Us = new JLabel("Usuario: ");
        Us.setBounds(35, 60, 85, 15);
        add(Us);

        usuario = new JTextField(10);
        usuario.setBounds(130, 55, 100, 20);
        add(usuario);

        Pa = new JLabel("Contraseña: ");
        Pa.setBounds(35, 100, 80, 15);
        add(Pa);

        contrasena = new JPasswordField(10);
        contrasena.setBounds(130, 95, 100, 20);
        add(contrasena);

        registrar = new JButton(RegistrarU);
        add(registrar);

        ingresar = new JButton(Ingresar);
        add(ingresar);

    }

    @Override
    public void setControlodor(pruebalogin.Controlador c) {
        usuario.addActionListener(c);
        registrar.addActionListener(c);
        ingresar.addActionListener(c);

    }

}
