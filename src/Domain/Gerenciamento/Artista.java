package Domain.Gerenciamento;

import Domain.Exibivel.Exibivel;

public class Artista implements Exibivel {
    private String nome;
    private String nacionalidade;

    public Artista(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String exibirInformacoes() {
        return "Artista: " + nome + " (" + nacionalidade + ")";
    }
}
