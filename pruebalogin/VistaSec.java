/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebalogin;

import javax.swing.*;
import java.awt.*;

public class VistaSec extends JDialog {

    public static void main(String[] args) {
        VistaSec n = new VistaSec(null, true);

        n.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        n.setSize(350, 200);
        n.setResizable(false);

    }

    public JLabel Hola;

    public VistaSec(Controlador controlador, boolean modal) {

        JLabel Presentation = new JLabel("          Hola, estas dentro de la lista de usuarios ^^");
        Presentation.setLocale(null);
        add(Presentation);

    }

}
