package Domain.Gerenciamento;

import Domain.Exibivel.Exibivel;

public class ObraDeArte implements Exibivel {
    private String titulo;
    private int anoCriacao;
    private Artista artista;

    public ObraDeArte(String titulo, int anoCriacao, Artista artista) {
        this.titulo = titulo;
        this.anoCriacao = anoCriacao;
        this.artista = artista;
    }

    @Override
    public String exibirInformacoes() {
        return titulo + " (" + anoCriacao + ") - por " + artista.getNome();
    }
}
