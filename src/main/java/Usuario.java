import java.util.ArrayList;

public class Usuario {

    private String nameUser;
    private String passwordUser;
    private ArrayList<Publicacion> listPosts;

    public Usuario(String nameUser, String passwordUser, ArrayList<Publicacion> listPosts, int idUser) {
        this.nameUser = nameUser;
        this.passwordUser = passwordUser;
        this.listPosts = listPosts;
        this.idUser = idUser;
    }

    public ArrayList<Publicacion> getListPosts() {
        return listPosts;
    }

    public void setListPosts(ArrayList<Publicacion> listPosts) {
        this.listPosts = listPosts;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    private int idUser;

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

}
