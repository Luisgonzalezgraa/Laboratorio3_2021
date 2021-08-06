import java.util.ArrayList;
import java.util.Scanner;

public class RedSocial {

    //Atributos
    ArrayList<Usuario> listausuarios;
    ArrayList<Publicacion> listapublicaciones;
    ArrayList<Reaccion> listareacciones;

    public RedSocial() {
        listausuarios = new ArrayList<>();
        listapublicaciones = new ArrayList<>();
        listareacciones = new ArrayList<>();
    }

    public void register(String usuario, String contrasenia) {
        Usuario user = new Usuario();
        Usuario usuaAux;
        user.setNameUser(usuario);
        user.setPasswordUser(contrasenia);
        String nombreAux;

        if (usuario == null || usuario.isBlank()) {
            System.out.println("Usuario invalido.\n");
        } else if (contrasenia == null || contrasenia.isBlank()) {
            System.out.println("Contraseña invalida.\n");
        }

        Integer i = 0;
        Integer largo = listausuarios.size();
        while (i < largo) {
            usuaAux = listausuarios.get(i);
            nombreAux = usuaAux.getNameUser();
            if (usuario.equals(nombreAux)) {
                i = largo + 1;
                System.out.println("Usuario ya registrado intente con otro Username.\n");
            }

            i++;
        }

        if (i.intValue() == largo.intValue()) {
            listausuarios.add(user);
            System.out.println("*****************************************");
            System.out.println("*******USUARIO REGISTRADO CON EXITO******");
            System.out.println("*****************************************\n");
        }
    }

    public void login(String usuario,String contrasenia){

        Integer i  = 0;

        while(i<listausuarios.size()) {
            if(usuario.equals(listausuarios.get(i).getNameUser()) && contrasenia.equals(listausuarios.get(i).getPasswordUser())) {
                int opcionIngresada2 = 0;
                Scanner opcion2;
                while (opcionIngresada2 != 5) {
                    System.out.println("### RED SOCIAL:INTENSE-DAY ###");
                    System.out.println("## Registrado como: " + usuario);
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
                    if(opcionIngresada2 == 6){
                        opcionIngresada2 = 5;
                    }
                    switch (opcionIngresada2) {
                        case 1:

                            System.out.println("####FIN DE SIMULACIÓN####");
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
                            System.out.println("####SESIÓN CERRADA#####");
                            break;
                        default:
                            System.out.println("Opción ingresada invalida.");
                            break;
                    }

                    i++;
                }
            }
            else {
                i++;
            }
        }
        if(i == listausuarios.size()) {
            System.out.println("Usuario no registrado en la plataforma.\n");
        }


    }

}
