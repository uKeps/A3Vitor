package Domain.Heranca;

import Domain.Gerenciamento.Exposicao;

import java.util.ArrayList;

public class Museu extends InstituicaoCultural{
    private ArrayList<Exposicao> exposicaoList = new ArrayList<>();


    public Museu(String nome, String endereco) {
        super(nome, endereco);
    }


    public void listarExposicoes(){
        for (Exposicao e : exposicaoList){
            System.out.println(e.exibirInformacoes());
        }
    }
}
