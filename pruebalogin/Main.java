/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebalogin;
//paquete

/**
 *
 * @author valti
 */
public class Main {

    public static void main(String[] args) {
        Vista v = new Vista();
        Modelo m = new Modelo();
        new Controlador(m, v);
    }

}
