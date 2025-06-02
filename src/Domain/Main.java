package Domain;

import Domain.Gerenciamento.*;
import Domain.Heranca.Galeria;
import Domain.Heranca.Museu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Museu> museuList = new ArrayList<>();
        ArrayList<Galeria> galeriaList = new ArrayList<>();
        ArrayList<Artista> artistaList = new ArrayList<>();
        ArrayList<ObraDeArte> obraList = new ArrayList<>();
        ArrayList<Exposicao> exposicaoList = new ArrayList<>();
        ArrayList<Visitante> visitanteList = new ArrayList<>();
        ArrayList<Agendamento> agendamentoList = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Cadastrar Museu");
            System.out.println("2. Cadastrar Galeria");
            System.out.println("3. Cadastrar Artista");
            System.out.println("4. Cadastrar Obra de Arte");
            System.out.println("5. Criar Exposição");
            System.out.println("6. Cadastrar Visitante");
            System.out.println("7. Agendar Visita");
            System.out.println("8. Listar Museus");
            System.out.println("9. Listar Galerias");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

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

                case 4 -> {
                    if (artistaList.isEmpty()) {
                        System.out.println("Cadastre um artista antes de cadastrar a obra.");
                        break;
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

                case 5 -> {
                    if (obraList.isEmpty()) {
                        System.out.println("Cadastre obras primeiro.");
                        break;
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

                case 6 -> {
                    System.out.print("Nome do visitante: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    visitanteList.add(new Visitante(nome, email));
                    System.out.println("Visitante cadastrado.");
                }

                case 7 -> {
                    if (visitanteList.isEmpty() || exposicaoList.isEmpty()) {
                        System.out.println("Cadastre visitantes e exposições primeiro.");
                        break;
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
                }

                case 8 -> {
                    if (museuList.isEmpty()){
                        System.out.println("Nenhum museu cadastrado!");
                    }else {
                    for (Museu m : museuList) {
                        System.out.println("\n" + m.getInfo());
                        m.listarExposicoes();
                        }
                    }
                }

                case 9 -> {
                    if (galeriaList.isEmpty()){
                        System.out.println("Nenhuma galeria cadastrada!");
                    }else {
                    for (Galeria g : galeriaList) {
                        System.out.println("\n" + g.getInfo());
                        g.listarArtistas();
                        }
                    }
                }

                case 0 -> System.out.println("Saindo do sistema...");

                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}