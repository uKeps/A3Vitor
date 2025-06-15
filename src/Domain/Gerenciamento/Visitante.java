package Domain.Gerenciamento;

public class Visitante {
    private String nome;
    private String email;

    public Visitante(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

}
