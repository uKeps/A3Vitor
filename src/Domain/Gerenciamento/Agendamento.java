package Domain.Gerenciamento;

public class Agendamento {
    private String data;
    private Visitante visitante;
    private Exposicao exposicao;

    public Agendamento(Visitante visitante, String data, Exposicao exposicao) {
        this.visitante = visitante;
        this.data = data;
        this.exposicao = exposicao;
    }

    public void confirmar(){
        System.out.println("Agendamento confirmado para " + visitante.getNome());
    }
}
