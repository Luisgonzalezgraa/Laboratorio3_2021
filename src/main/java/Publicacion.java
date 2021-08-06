public class Publicacion {

    private int idPost;
    private String content;
    private String typePost;
    private float datePost;
    private String namePublisher;

    public Publicacion(int idPost, String content, String typePost, float datePost, String namePublisher) {
        this.idPost = idPost;
        this.content = content;
        this.typePost = typePost;
        this.datePost = datePost;
        this.namePublisher = namePublisher;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypePost() {
        return typePost;
    }

    public void setTypePost(String typePost) {
        this.typePost = typePost;
    }

    public float getDatePost() {
        return datePost;
    }

    public void setDatePost(float datePost) {
        this.datePost = datePost;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public void setNamePublisher(String namePublisher) {
        this.namePublisher = namePublisher;
    }




}
