package model;

public class Pintura extends ObraDeArte {

    private String tecnica;

    public Pintura(String titulo, String artista, int anoDeCriacao, String tipo, String localizacao, String tecnica) {
        super(titulo, artista, anoDeCriacao, tipo, localizacao);
        this.tecnica = tecnica;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    @Override
    public String toString() {
        return "Técnica: " + tecnica;
    }


    

}
