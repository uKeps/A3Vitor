package Domain.Heranca;

import Domain.Gerenciamento.Artista;

import java.util.ArrayList;

public class Galeria extends InstituicaoCultural{
    private ArrayList<Artista> artistasList = new ArrayList<>();

    public Galeria(String nome, String endereco) {
        super(nome, endereco);
    }

    public void adicionarArtista(Artista artista){
        artistasList.add(artista);
    }

    public void listarArtistas(){
        for (Artista a : artistasList){
            System.out.println(a.exibirInformacoes());
        }
    }
}
