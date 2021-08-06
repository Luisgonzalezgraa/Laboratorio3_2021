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


        RedSocial red  = new RedSocial();

        int opcionIngresada1 = 0;

        Scanner opcion1;
        String nombreL;
        String contrasenia;
        String nombreL2;
        String contrasenia2;
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
                    Scanner name = new Scanner(System.in);
                    System.out.println("Ingrese su Nombre: ");
                    nombreL = name.nextLine();
                    Scanner password = new Scanner(System.in);
                    System.out.println("Ingrese su Contraseña: ");
                    contrasenia = password.nextLine();
                    red.register(nombreL,contrasenia);

                    break;
                case 2:
                    Scanner name2 = new Scanner(System.in);
                    System.out.println("Ingrese su Nombre: ");
                    nombreL2 = name2.nextLine();
                    Scanner password2 = new Scanner(System.in);
                    System.out.println("Ingrese su Contraseña: ");
                    contrasenia2 = password2.nextLine();
                    red.login(nombreL2,contrasenia2);

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
