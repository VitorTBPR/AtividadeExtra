package model;

public class Fotografia extends ObraDeArte {
    private String estudio;
    private String camera;
    
    public Fotografia(String titulo, String artista, int anoDeCriacao, String tipo, String localizacao, String estudio,
            String camera) {
        super(titulo, artista, anoDeCriacao, tipo, localizacao);
        this.estudio = estudio;
        this.camera = camera;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "estudio: " + estudio + ", camera: " + camera;
    }

    

    
}
