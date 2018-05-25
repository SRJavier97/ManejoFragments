package unam.fi.mx.manejofragments;

public class Album {

    private String nombre;
    private String artista;
    private int foto;

    public Album(String nombre, String artista, int foto) {
        this.nombre = nombre;
        this.artista = artista;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
