import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class RedSocial implements InterfazRed {

    //Atributos
    private ArrayList<ArrayList<Usuario>> listausuarios;
    private ArrayList<ArrayList<Publicacion>> listapublicaciones;
    private ArrayList<ArrayList<Reaccion>>listareacciones;
    private String user;

    public ArrayList<ArrayList<Usuario>> getListausuarios() {
        return listausuarios;
    }

    public ArrayList<ArrayList<Publicacion>> getListapublicaciones() {
        return listapublicaciones;
    }

    public ArrayList<ArrayList<Reaccion>> getListareacciones() {
        return listareacciones;
    }

    public String getUser() {
        return user;
    }

    public void setListausuarios(ArrayList<ArrayList<Usuario>> listausuarios) {
        this.listausuarios = listausuarios;
    }

    public void setListapublicaciones(ArrayList<ArrayList<Publicacion>> listapublicaciones) {
        this.listapublicaciones = listapublicaciones;
    }

    public void setListareacciones(ArrayList<ArrayList<Reaccion>> listareacciones) {
        this.listareacciones = listareacciones;
    }

    public void setAutor(String user) {
        this.user = user;
    }

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
        user.setIdUser(listausuarios.size());
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

    public void post(String tipoPublicacion, String publicacion, Integer cantidadUsuarios){
        Date fecha = new Date();
        Publicacion publicacion1 = new Publicacion();
        publicacion1.setNamePublisher(user);
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
                        key = 2;
                        break;
                    }
                }

                i++;
            }
            if (cantidadUsuarios == 0){
                publicacion1.getUsers().add("Todos");
                lista2Publicaciones.add(publicacion1);
                listapublicaciones.add(lista2Publicaciones);
            }

            if (key == 2){
                System.out.println("\nUsuario no existe dentro de la red social\n");
            }

            else{
                lista2Publicaciones.add(publicacion1);
                listapublicaciones.add(lista2Publicaciones);
                Integer aux = 0;
                while (aux < listausuarios.size()){
                    Integer aux2 = 0;
                    while (aux2 < listausuarios.get(aux).size()) {
                        if (user.equals(listausuarios.get(aux).get(aux2).getNameUser())) {
                            listausuarios.get(aux).get(aux2).getListPosts().add(publicacion1);
                            break;
                        } else {
                            aux2++;
                        }
                    }
                    aux ++;

                }
                System.out.println("\n***PUBLICACIÓN INGRESADA CORRECTAMENTE***\n");
            }
        }
        else {
            System.out.println("\n***lA CANTIDAD DE USUARIOS INGRESADOS NO SE ENCUENTRAN EN LA RED SOCIAL***\n");
        }




    }

    public void follow (String usuario){
        Date fecha = new Date();
        Reaccion reaccion = new Reaccion();
        reaccion.setDateReac(fecha);
        reaccion.setNameUser(user);
        reaccion.setIdReac(listareacciones.size());
        reaccion.setTypeReac("Follow");
        ArrayList<Reaccion> listaDeReacciones = new ArrayList<>();
        if(user.equals(usuario)){
            System.out.println("\n!!!ERROR NO SE PUEDE SEGUIR A USTED MISMO!!!\n");
        }
        else {
            Integer i = 0 ;
            Integer key = 0;
            while(i<listausuarios.size()){
                Integer j = 0;
                while (j<listausuarios.get(i).size()){
                    if (usuario.equals(listausuarios.get(i).get(j).getNameUser())){
                        reaccion.setContentReac(user + " sigue a "+ usuario);
                        listaDeReacciones.add(reaccion);
                        listareacciones.add(listaDeReacciones);
                        System.out.println("\n***USTED SIGUE A " + usuario + " AHORA***\n");
                        key = 1;
                        break;
                    }
                    else {
                        j++;
                    }
                }
                if (key == 1){
                    break;
                }
                i++;
                if (i == listausuarios.size()) {
                    key = 2;
                    break;
                }

            }
            if (key == 2){
                System.out.println("\nUsuario no existe dentro de la red social\n");
            }
        }

    }
    public void share(Integer idPost,ArrayList<String> usuariosCom){
        Date fecha = new Date();
        Publicacion compartido = new Publicacion();
        compartido.setNamePublisher(user);
        compartido.setTypePost("Share");
        compartido.setDatePost(fecha);
        ArrayList<Publicacion> listaDeCompartidos= new ArrayList<>();
        Integer key = 0;
        Integer i = 0;
        while (i < listapublicaciones.size()){
            Integer j = 0;
            while (j<(listapublicaciones.get(i).size())){
                if (idPost.equals(listapublicaciones.get(i).get(j).getIdPost())){
                    compartido.setUsers(usuariosCom);
                    compartido.setIdPost(listapublicaciones.size());
                    compartido.setContent(listapublicaciones.get(i).get(j).getContent());
                    listaDeCompartidos.add(compartido);
                    listapublicaciones.add(listaDeCompartidos);
                    System.out.println("\n***SE COMPARTIO CORRECTAMENTE LA PUBLICACION CON ID " + idPost + "***\n" );
                    key = 1;
                    break;

                }
                else {
                    j++;
                }

            }
            if (key == 1){
                break;
            }
            i ++;
            if (i == listapublicaciones.size()) {
                key = 2;
                break;
            }

        }
        if (key == 2){
            System.out.println("\n!!! NO EXISTE ID ASOCIADA A LA PUBLICACIÓN!!!\n");
        }
    }

    public void visualize(Integer tipo){

        if (tipo == 0) {
            Integer iU = 0;
            while (iU < listausuarios.size()) {
                Integer jU = 0;
                while (jU  < listausuarios.get(iU).size()) {
                    System.out.println(listausuarios.get(iU).get(jU ).toString());
                    jU ++;
                }
                iU++;
            }
            if (listausuarios.size() == 0){
                System.out.println("\n****NO EXISTEN USUARIOS DENTRO DE LA RED SOCIAL****\n");
            }
            Integer i = 0;
            while (i < listapublicaciones.size()) {
                Integer j = 0;
                while (j < listapublicaciones.get(i).size()) {
                    System.out.println(listapublicaciones.get(i).get(j).toString());

                    j++;
                }
                i++;
            }
            if (listapublicaciones.size() == 0){
                System.out.println("\n****NO EXISTEN PUBLICACIONES DENTRO DE LA RED SOCIAL****\n");
            }
            Integer wr = 0;
            while (wr < listareacciones.size()) {
                Integer zr = 0;
                while (zr < listareacciones.get(wr).size()) {
                    System.out.println(listareacciones.get(wr).get(zr).toString());

                    zr++;
                }
                wr++;
            }
            if (listareacciones.size() == 0){
                System.out.println("\n****NO EXISTEN REACCIONES DENTRO DE LA PLATAFORMA****\n");
            }


        }
        else {
            Integer iU = 0;
            while (iU < listausuarios.size()) {
                Integer jU = 0;
                while (jU  < listausuarios.get(iU).size()) {
                    if (user.equals(listausuarios.get(iU).get(jU).getNameUser())) {
                        System.out.println(listausuarios.get(iU).get(jU).toString());
                        jU++;
                    }
                    else{
                        jU ++;
                    }
                }
                iU++;
            }
            Integer i = 0;
            while (i < listapublicaciones.size()) {
                Integer j = 0;
                while (j < listapublicaciones.get(i).size()) {
                    if (user.equals(listausuarios.get(i).get(j).getNameUser())) {
                        System.out.println(listapublicaciones.get(i).get(j).toString());
                        j++;
                    }
                    else{
                        j ++;
                    }
                }
                i++;
            }
            if (listapublicaciones.size() == 0){
                System.out.println("\n****USUARIO NO REGISTRA PUBLICACIONES****\n");
            }
            Integer wr = 0;
            while (wr < listareacciones.size()) {
                Integer zr = 0;
                while (zr < listareacciones.get(wr).size()) {
                    if (user.equals(listausuarios.get(wr).get(zr).getNameUser())) {
                        System.out.println(listareacciones.get(wr).get(zr).toString());
                        zr++;
                    }
                    else{
                        zr ++;
                    }
                }
                wr++;
            }
            if (listareacciones.size() == 0){
                System.out.println("\n****USUARIO NO REGISTRA REACCIONES****\n");
            }

        }

    }


}
