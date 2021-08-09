import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class RedSocial implements InterfazRed {

    //Atributos
    ArrayList<ArrayList<Usuario>> listausuarios;
    ArrayList<ArrayList<Publicacion>> listapublicaciones;
    ArrayList<ArrayList<Reaccion>>listareacciones;

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
        ArrayList<Usuario> lista2Usuarios = new ArrayList<>();

        if (usuario == null || usuario.isBlank()) {
            System.out.println("Usuario invalido.\n");
        } else if (contrasenia == null || contrasenia.isBlank()) {
            System.out.println("Contraseña invalida.\n");
        }

        Integer i = 0;
        Integer key = 0;
        Integer largo = listausuarios.size();
        while (i < largo) {
            Integer j = 0;
            while (j < listausuarios.get(i).size()) {
                usuaAux = listausuarios.get(i).get(j);
                nombreAux = usuaAux.getNameUser();
                if (usuario.equals(nombreAux)) {
                    j = largo + 1;
                    key = 1;
                    break;
                }
                j++;
            }
            i++;


        }
        if (key == 1){
            System.out.println("Usuario ya registrado intente con otro Username.\n");
        }
        else{
            if (i.intValue() == largo.intValue()) {
                lista2Usuarios.add(user);
                listausuarios.add(lista2Usuarios);
                System.out.println("*****************************************");
                System.out.println("*******USUARIO REGISTRADO CON EXITO******");
                System.out.println("*****************************************\n");
            }
        }



    }

    public boolean login(String usuario,String contrasenia){

        Integer i  = 0;
        while(i<listausuarios.size()) {
            Integer j = 0;
            while (j < listausuarios.get(i).size()) {
                if (usuario.equals(listausuarios.get(i).get(j).getNameUser()) && contrasenia.equals(listausuarios.get(i).get(j).getPasswordUser())) {

                    return true;
                } else {
                    j++;
                }
            }
            i ++;
        }

        if(i == listausuarios.size()) {

            return false;
        }

    return true;
    }

    public void post(String autor, String tipoPublicacion, String publicacion, Integer cantidadUsuarios){
        Date fecha = new Date();
        Publicacion publicacion1 = new Publicacion();
        publicacion1.setNamePublisher(autor);
        publicacion1.setTypePost(tipoPublicacion);
        publicacion1.setDatePost(fecha);
        publicacion1.setContent(publicacion);
        publicacion1.setIdPost(listapublicaciones.size());
        ArrayList<Publicacion> lista2Publicaciones = new ArrayList<>();

        if(cantidadUsuarios <= listausuarios.size()) {
            Integer i = 0;
            Integer key = 0;
            while (i < cantidadUsuarios) {
                String nombreL2;
                Scanner name2 = new Scanner(System.in);
                key = 0;
                System.out.println("Ingrese Usuario dirigida la publicación: ");
                nombreL2 = name2.nextLine();
                Integer j = 0;
                while (j < listausuarios.size()) {
                    Integer k = 0;
                    while (k < listausuarios.get(i).size()) {
                        if (nombreL2.equals(listausuarios.get(j).get(k).getNameUser())) {
                            publicacion1.getUsers().add(nombreL2);
                            k++;
                            key = 1;
                            break;

                        } else {
                            k++;
                        }
                    }
                    j++;

                    if (key == 1){
                        break;
                    }
                    if (j == listausuarios.size()) {
                        System.out.println("\nUsuario no existe dentro de la red social\n");
                        break;
                    }
                }

                i++;
            }
        }
        else {
            System.out.println("\n***lA CANTIDAD DE USUARIOS INGRESADOS NO SE ENCUENTRAN EN LA RED SOCIAL***\n");
        }

        lista2Publicaciones.add(publicacion1);
        listapublicaciones.add(lista2Publicaciones);

    }

    public void follow (){

    }
    public void share(){

    }


}
