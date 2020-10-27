/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebalogin;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;

class Controlador implements ActionListener {

    Modelo modelo;
    Vista vista;

    public Controlador(Modelo m, Vista v) {
        modelo = m;
        vista = v;

        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setSize(250, 150);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.setResizable(false);
        vista.setControlodor(this); //agregado

    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case interfazVista.Ingresar:

                //Crea el archivo txt
                File file = new File("archivoLogin.txt");
                //C:\Users\valti\OneDrive\Documentos\NetBeansProjects\pruebaLogin
                ArrayList lista = new ArrayList<>();
                int x = 0;
                try {
                    Scanner scanner = new Scanner(file);
                    String linea = scanner.nextLine();
                    Scanner delimitar = new Scanner(linea);
                    delimitar.useDelimiter("\\s*,\\s*");
                    if (vista.usuario.getText().equals(delimitar.next()) && modelo.convertirSHA256(vista.contrasena.getText()).equals(delimitar.next())) {

                        JOptionPane.showMessageDialog(null, "Fuiste aceptado(!)", "Entrando...", JOptionPane.INFORMATION_MESSAGE);
                        VistaSec p = new VistaSec(this, true);
                        p.setVisible(true);
                        p.setSize(300, 200);
                        p.setLocationRelativeTo(null);
                        p.setResizable(false);
                        x = 1;

                    } else {

                        JOptionPane.showMessageDialog(null, "Acceso denegado, usuario no registrado.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        vista.usuario.setText("");
                        vista.contrasena.setText("");
                        vista.usuario.requestFocus();
                        ;
                    }

                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    System.out.print("ERROR: " + e1.getMessage());
                }

                break;

            case interfazVista.RegistrarU:

                try {
                    FileWriter esc = new FileWriter("archivoLogin.txt", true);
                    //C:\Users\valti\OneDrive\Documentos\NetBeansProjects\pruebaLogin
                    BufferedWriter bw = new BufferedWriter(esc);
                    bw.write(vista.usuario.getText() + " , " + modelo.convertirSHA256(vista.contrasena.getText()) + "\n");

                    bw.close();
                    esc.close();

                } catch (IOException RegistrarU) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un problema.");
                }
                vista.usuario.setText("");
                vista.contrasena.setText("");
                vista.usuario.requestFocus();
                break;
        }
    }
}
