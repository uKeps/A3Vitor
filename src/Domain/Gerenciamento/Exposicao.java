package Domain.Gerenciamento;

import Domain.Exibivel.Exibivel;

import java.util.ArrayList;

public class Exposicao implements Exibivel {
    private String titulo;
    private String dataInicio;
    private ArrayList<ObraDeArte> obraDeArteList = new ArrayList<>();

    public Exposicao(String titulo, String dataInicio) {
        this.titulo = titulo;
        this.dataInicio = dataInicio;
    }

    public void adicionarObra(ObraDeArte obraDeArte){
        obraDeArteList.add(obraDeArte);
    }

    public ArrayList<ObraDeArte> getObraDeArteList() {
        return obraDeArteList;
    }

    @Override
    public String exibirInformacoes() {
        return "Exposição: " + titulo + " | Início: " + dataInicio;
    }
}
