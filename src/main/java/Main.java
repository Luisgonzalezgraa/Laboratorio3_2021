/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;



public class Main {
    /**
     *
     * @author Luis Gonzalez1
     */

    public static void main(String[] args) {




        int opcionIngresada1 = 0;

        Scanner opcion1;

        opcion1 = new Scanner(System.in);
        //SE CREA EL MENÚ
        while (opcionIngresada1 != 3) {
            System.out.println("####BIENVENIDO HA SIMULADOR DE RED SOCIAL##########");
            System.out.println("1. Registrarse");
            System.out.println("2. Ingresar");
            System.out.println("3. Salir de programa");
            System.out.println("INTRODUZCA SU OPCIÓN: ");
            opcionIngresada1 = opcion1.nextInt();
            switch (opcionIngresada1) {
                case 1:
                    System.out.println("####FIN DE SIMULACIÓN####");
                    break;
                case 2:
                    System.out.println("####FIN DE SIMULACIÓN####");

                    break;
                case 3:
                    System.out.println("####FIN DE SIMULACIÓN####");
                    break;
                default:
                    System.out.println("Opción ingresada invalida.");
                    break;
            }
        }
    }
}
