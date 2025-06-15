package Domain.Gerenciamento;
import Domain.Heranca.Galeria;
import Domain.Heranca.Museu;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeGerenciamento {
    private final Scanner scanner;
    private final ArrayList<Museu> museuList = new ArrayList<>();
    private final ArrayList<Galeria> galeriaList = new ArrayList<>();
    private final ArrayList<Artista> artistaList = new ArrayList<>();
    private final ArrayList<ObraDeArte> obraList = new ArrayList<>();
    private final ArrayList<Exposicao> exposicaoList = new ArrayList<>();
    private final ArrayList<Visitante> visitanteList = new ArrayList<>();
    private final ArrayList<Agendamento> agendamentoList = new ArrayList<>();

    public SistemaDeGerenciamento(Scanner scanner) {
        this.scanner = scanner;
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Gerenciar Museus e Galerias");
            System.out.println("2. Gerenciar Artistas e Obras de Arte");
            System.out.println("3. Gerenciar Exposições");
            System.out.println("4. Gerenciar Visitantes e Agendamentos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> gerenciarMuseusEGalerias();
                    case 2 -> gerenciarArtistasEObras();
                    case 3 -> gerenciarExposicoes();
                    case 4 -> gerenciarVisitantesEAgendamentos();
                    case 0 -> System.out.println("Saindo do sistema....");
                    default -> System.out.println("Opção invalida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite outro numero");
                opcao = -1;
            }

        } while (opcao != 0);
    }

    private void gerenciarMuseusEGalerias() {
        System.out.println("\n----- Gerenciar Museus e Galerias -----");
        System.out.println("1- Cadastrar Museu");
        System.out.println("2- Cadastrar Galeria");
        System.out.println("3- Listar Museus");
        System.out.println("4- Listar Galerias");
        System.out.print("Escolha uma opção: ");

        int opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1 -> {
                System.out.print("Nome do museu: ");
                String nome = scanner.nextLine();
                System.out.print("Endereço: ");
                String endereco = scanner.nextLine();
                museuList.add(new Museu(nome, endereco));
                System.out.println("Museu cadastrado com sucesso!");
            }
            case 2 -> {
                System.out.print("Nome da galeria: ");
                String nome = scanner.nextLine();
                System.out.print("Endereço: ");
                String endereco = scanner.nextLine();
                galeriaList.add(new Galeria(nome, endereco));
                System.out.println("Galeria cadastrada com sucesso!");
            }
            case 3 -> {
                if (museuList.isEmpty()) {
                    System.out.println("Nenhum museu cadastrado!");
                } else {
                    for (Museu m : museuList) {
                        System.out.println("\n" + m.getInfo());
                        m.listarExposicoes();
                    }
                }
            }
            case 4 -> {
                if (galeriaList.isEmpty()) {
                    System.out.println("Nenhuma galeria cadastrada!");
                } else {
                    for (Galeria g : galeriaList) {
                        System.out.println("\n" + g.getInfo());
                        g.listarArtistas();
                    }
                }
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    private void gerenciarArtistasEObras() {
        System.out.println("\n-- Gerenciar Artistas e Obras de Arte --");
        System.out.println("1. Cadastrar Artista");
        System.out.println("2. Cadastrar Obra de Arte");
        System.out.print("Escolha uma opção: ");

        int opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1 -> {
                System.out.print("Nome do artista: ");
                String nome = scanner.nextLine();
                System.out.print("Nacionalidade: ");
                String nacionalidade = scanner.nextLine();
                Artista artista = new Artista(nome, nacionalidade);
                artistaList.add(artista);
                if (!galeriaList.isEmpty()) {
                    System.out.println("Deseja associar esse artista a alguma galeria? (s/n)");
                    String resp = scanner.nextLine();
                    if (resp.equalsIgnoreCase("s")) {
                        for (int i = 0; i < galeriaList.size(); i++) {
                            System.out.println(i + " - " + galeriaList.get(i).getNome());
                        }
                        System.out.print("Escolha a galeria: ");
                        int idx = Integer.parseInt(scanner.nextLine());
                        galeriaList.get(idx).adicionarArtista(artista);
                    }
                }
            }
            case 2 -> {
                if (artistaList.isEmpty()) {
                    System.out.println("Cadastre um artista antes de cadastrar a obra.");
                    return;
                }
                System.out.print("Título da obra: ");
                String titulo = scanner.nextLine();
                System.out.print("Ano de criação: ");
                int ano = Integer.parseInt(scanner.nextLine());
                System.out.println("Escolha o artista:");
                for (int i = 0; i < artistaList.size(); i++) {
                    System.out.println(i + " - " + artistaList.get(i).getNome());
                }
                int idxArtista = Integer.parseInt(scanner.nextLine());
                ObraDeArte obra = new ObraDeArte(titulo, ano, artistaList.get(idxArtista));
                obraList.add(obra);
                System.out.println("Obra cadastrada com sucesso!");
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    private void gerenciarExposicoes() {
        System.out.println("\n-- Gerenciar Exposições --");
        if (obraList.isEmpty()) {
            System.out.println("Cadastre obras primeiro.");
            return;
        }
        System.out.print("Título da exposição: ");
        String titulo = scanner.nextLine();
        System.out.print("Data de início: ");
        String data = scanner.nextLine();
        Exposicao exposicao = new Exposicao(titulo, data);
        System.out.println("Deseja adicionar obras à exposição? (s/n)");
        String resp = scanner.nextLine();
        if (resp.equalsIgnoreCase("s")) {
            for (int i = 0; i < obraList.size(); i++) {
                System.out.println(i + " - " + obraList.get(i).exibirInformacoes());
            }
            System.out.print("Digite o número da obra: ");
            int idx = Integer.parseInt(scanner.nextLine());
            exposicao.adicionarObra(obraList.get(idx));
        }
        exposicaoList.add(exposicao);
        System.out.println("Exposição criada.");
    }

    private void gerenciarVisitantesEAgendamentos() {
        System.out.println("\n-- Gerenciar Visitantes e Agendamentos --");
        System.out.println("1. Cadastrar Visitante");
        System.out.println("2. Agendar Visita");
        System.out.print("Escolha uma opção: ");

        int opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1 -> {
                System.out.print("Nome do visitante: ");
                String nome = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                visitanteList.add(new Visitante(nome, email));
                System.out.println("Visitante cadastrado.");
            }
            case 2 -> {
                if (visitanteList.isEmpty() || exposicaoList.isEmpty()) {
                    System.out.println("Cadastre visitantes e exposições primeiro.");
                    return;
                }
                System.out.println("Escolha o visitante:");
                for (int i = 0; i < visitanteList.size(); i++) {
                    System.out.println(i + " - " + visitanteList.get(i).getNome());
                }
                int idxVisitante = Integer.parseInt(scanner.nextLine());
                System.out.println("Escolha a exposição:");
                for (int i = 0; i < exposicaoList.size(); i++) {
                    System.out.println(i + " - " + exposicaoList.get(i).exibirInformacoes());
                }
                int idxExposicao = Integer.parseInt(scanner.nextLine());
                System.out.print("Data do agendamento: ");
                String data = scanner.nextLine();
                Agendamento agendamento = new Agendamento(visitanteList.get(idxVisitante), data, exposicaoList.get(idxExposicao));
                agendamento.confirmar();
                agendamentoList.add(agendamento);
                System.out.println("Agendamento realizado com sucesso!");
            }
            default -> System.out.println("Opção inválida.");
        }
    }
}
