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
        String tipoPost;
        String post;
        int cantU;
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
                    if(red.login(nombreL2, contrasenia2)) {
                        int opcionIngresada2 = 0;
                        Scanner opcion2;
                        while (opcionIngresada2 != 6 && opcionIngresada2 != 5) {
                            System.out.println("### RED SOCIAL:INTENSE-DAY ###");
                            System.out.println("## Registrado como: " + nombreL2);
                            System.out.println("Escoja su opción: ");
                            System.out.println("1. Realizar Publicación");
                            System.out.println("2. Seguir a un usuario");
                            System.out.println("3. Compartir publicación");
                            System.out.println("4. Visualizar red social");
                            System.out.println("5. Cerrar sesión");
                            System.out.println("6. Salir del programa");
                            System.out.println("INTRODUZCA SU OPCIÓN: ");
                            opcion2 = new Scanner(System.in);
                            opcionIngresada2 = opcion2.nextInt();

                            switch (opcionIngresada2) {
                                case 1:

                                    Scanner Tipopost = new Scanner(System.in);
                                    System.out.println("Ingrese tipo publicación: ");
                                    tipoPost = Tipopost.nextLine();
                                    Scanner post2 = new Scanner(System.in);
                                    System.out.println("Ingrese su Publicación: ");
                                    post = post2.nextLine();
                                    Scanner cantidad = new Scanner(System.in);
                                    System.out.println("Ingrese cantidad de usuarios dirigidos la publicación: ");
                                    cantU = cantidad.nextInt();
                                    red.post(nombreL2,tipoPost,post,cantU);

                                    break;
                                case 2:
                                    System.out.println("####FIN DE SIMULACIÓN####");
                                    break;
                                case 3:
                                    System.out.println("####FIN DE SIMULACIÓN####");
                                    break;
                                case 4:
                                    System.out.println("####FIN DE SIMULACIÓN####");
                                    break;
                                case 5:
                                    System.out.println("####SESIÓN CERRADA#####");
                                    break;
                                case 6:
                                    opcionIngresada1 = 3;
                                    break;
                                default:
                                    System.out.println("Opción ingresada invalida.");
                                    break;
                            }


                        }
                    }
                    else{
                        System.out.println("\n*****Usuario no registrado en la plataforma******\n");
                    }
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
