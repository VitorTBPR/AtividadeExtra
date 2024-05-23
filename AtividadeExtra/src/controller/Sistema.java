package controller;
import java.io.IOException;

import model.GerenciamentoObras;
import model.ObraDeArte;

public class Sistema {

    private static void exibirMenu() {

        System.out.println("\nSistema de museu");
        System.out.println("1) Cadastrar obra");
        System.out.println("2) Buscar obra");
        System.out.println("3) Listar todas as obras");
        System.out.println("4) Apagar obra");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");

    }

    private static void verificarOpcao(int op) {

        switch (op) {
            case 1:
                salvarObra();
                break;

            case 2:
                System.out.println("\n1) Buscar por título");
                System.out.println("2) Buscar por artista");
                System.out.println("3) Buscar por ano");
                System.out.println("4) Buscar por tipo");
                System.out.println("0) Voltar");
                System.out.print("Digite: ");
                int op2 = Console.lerInt();
                switch (op2) {
                    case 1:
                    System.out.println("\nBusca por título");
                    System.out.print("Informe o título: ");
                    String titulo = Console.lerString();
            
                    try {
            
                        ObraDeArte obra = GerenciamentoObras.buscarObra(titulo);
                        System.out.println("\nObra encontrada: " + obra);
            
                    } catch (Exception e) {
            
                        System.out.println(e.getMessage());
                    }
                        break;
                    
                    case 2:
                    System.out.println("\nBusca por artista");
                    System.out.print("Informe o artista: ");
                    String artista = Console.lerString();
            
                    try {
            
                        ObraDeArte obra = GerenciamentoObras.buscarPorArtista(artista);
                        System.out.println("\nArtista encontradado: " + obra);
            
                    } catch (Exception e) {
            
                        System.out.println(e.getMessage());
                    }
                        break;
                    
                    case 3:
                    System.out.println("\nBusca por ano");
                    System.out.print("Informe o ano da obra: ");
                    int ano = Console.lerInt();
            
                    try {
            
                        ObraDeArte obra = GerenciamentoObras.buscarPorAno(ano);
                        System.out.println("\nObra encontrada: " + obra);
            
                    } catch (Exception e) {
            
                        System.out.println(e.getMessage());
                    }
                        break;
                    
                    case 4:
                    System.out.println("\nBuscar por tipo");
                    System.out.print("Informe o tipo da obra: ");
                    String tipo = Console.lerString();
            
                    try {
            
                        ObraDeArte obra = GerenciamentoObras.buscarPorTipo(tipo);
                        System.out.println("\nObra encontrada: " + obra);
            
                    } catch (Exception e) {
            
                        System.out.println(e.getMessage());
                    }
                        break;
                    
                    case 0:
                        break;          
                    
                    default:
                    System.out.println("Opção inválida");
                        break;
                }
          
                break;
            
            case 3:
                listarTodos();
                break;

            case 4:
                apagarObra();
                break;

            case 0: 
                System.out.println("\nO Programa foi finalizado...");
                break;
        
            default:
                System.out.println("\nOpção inválida Digite novamente:");
                break;
        }

    }

    
    private static void salvarObra() {

        System.out.println("\nNova obra:");
        
        System.out.print("Informe o título: ");
        String titulo = Console.lerString();

        System.out.print("Informe o artista: ");
        String artista = Console.lerString();

        System.out.print("Informe o ano de criação: ");
        int anoDeCriacao = Console.lerInt();

        System.out.print("Informe o tipo da obra: ");
        String tipo = Console.lerString();

        System.out.print("Informe a localização da obra: ");
        String localizacao = Console.lerString();

        ObraDeArte obra = new ObraDeArte(titulo, artista, anoDeCriacao, tipo, localizacao);

        try {

            GerenciamentoObras.salvarObra(obra);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }


    }

    private static void buscarObra() {

        System.out.println("\nBuscar obra");
        System.out.print("Informe o título: ");
        String titulo = Console.lerString();

        try {

            ObraDeArte obra = GerenciamentoObras.buscarObra(titulo);
            System.out.println("\nObra encontrada: " + obra);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void listarTodos() {

        System.out.println("\nObras cadastradas:");

        try {

            for (ObraDeArte tempObra : GerenciamentoObras.listarObras())
            {
                System.out.println(tempObra);
            }
        
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private static void apagarObra() {

        System.out.println("\nApagar obra");
        System.out.print("Informe o título da obra que deseja apagar: ");
        String titulo = Console.lerString();

        try {

            GerenciamentoObras.apagarObra(titulo);
            System.out.println("\nObra excluída com sucesso!");
        
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }

    public static void executar() {

        int op;
        do {
            
            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);

        } while(op != 0);

    }


    
}
