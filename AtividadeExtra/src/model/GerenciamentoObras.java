package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GerenciamentoObras {
    private static final String ARQUIVO = "obras.txt";

    public static void salvarObra(ObraDeArte obra) throws IOException {

        try (FileWriter fw = new FileWriter(ARQUIVO, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(obra + "\n");

        }

    }

    public static ArrayList<ObraDeArte> listarObras() throws IOException, Exception {

        ArrayList<ObraDeArte> listaObras = new ArrayList<>();

        try (FileReader fr = new FileReader(ARQUIVO);
             BufferedReader br = new BufferedReader(fr)) {

                String linha;
                while ((linha = br.readLine()) != null) {
                    
                    ObraDeArte obra = ObraDeArte.fromString(linha);
                    listaObras.add(obra);
                }
        } 

        if (listaObras.isEmpty()) {
            throw new Exception("\nNão há obras cadastradas");
        }

        return listaObras;

    }

    public static ObraDeArte buscarObra(String titulo) throws Exception {

        ArrayList<ObraDeArte> listaObras = listarObras();

        for (ObraDeArte tempObraDeArte : listaObras) {

            if(tempObraDeArte.getTitulo().equals(titulo)) {

                return tempObraDeArte;
            }
        }

        throw new Exception("\nObra " + titulo + " não localizada!");

    }

    public static void apagarObra(String titulo) throws Exception{

        ArrayList<ObraDeArte> listaObras = listarObras();       
    
        boolean encontrou = false;
        for (ObraDeArte temp : listaObras) {

            if(temp.getTitulo().equals(titulo)) {
                listaObras.remove(temp);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            throw new Exception("\nObra com o título " + titulo + " não localizada!");
        }

        try (FileWriter fw = new FileWriter(ARQUIVO);
        BufferedWriter bw = new BufferedWriter(fw)) {

            for (ObraDeArte o : listaObras) {

                bw.write(o + "\n");
            }
        }
    }

    public static ObraDeArte buscarPorArtista(String artista) throws Exception {
        ArrayList<ObraDeArte> listaObras = listarObras();

        for (ObraDeArte tempArtista : listarObras()){
            if(tempArtista.getArtista().equals(artista)){
                return tempArtista;
            }
        }

        throw new Exception("Artista "+artista+"  não localizado");

    }
    
    public static ObraDeArte buscarPorAno(int anoDeCriacao) throws Exception {
        ArrayList<ObraDeArte> listaObras = listarObras();

        for (ObraDeArte tempAno : listarObras()){
            if(tempAno.getAnoDeCriacao() == anoDeCriacao){
                return tempAno;
            }
        }

        throw new Exception("Nenhuma obra com o ano de  "+anoDeCriacao+" localizada");

    }

    public static ObraDeArte buscarPorTipo(String tipo) throws Exception{
        ArrayList<ObraDeArte> listaObras = listarObras();

        for (ObraDeArte tempTipo : listarObras()){
            if(tempTipo.getTipo().equals(tipo)){
                return tempTipo;
            }
        }

        throw new Exception("Nenhuma obra com o tipo de "+" ' '  "+tipo+" localizada");
    }


}

