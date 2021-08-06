public class Reaccion {

    private String nameUser;
    private float dateReac;
    private String contentReac;
    private String typeReac;

    public Reaccion(String nameUser, float dateReac, String contentReac, String typeReac, int idReac) {
        this.nameUser = nameUser;
        this.dateReac = dateReac;
        this.contentReac = contentReac;
        this.typeReac = typeReac;
        this.idReac = idReac;
    }

    private int idReac;

    public int getIdReac() {
        return idReac;
    }

    public void setIdReac(int idReac) {
        this.idReac = idReac;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public float getDateReac() {
        return dateReac;
    }

    public void setDateReac(float dateReac) {
        this.dateReac = dateReac;
    }

    public String getContentReac() {
        return contentReac;
    }

    public void setContentReac(String contentReac) {
        this.contentReac = contentReac;
    }

    public String getTypeReac() {
        return typeReac;
    }

    public void setTypeReac(String typeReac) {
        this.typeReac = typeReac;
    }




}
