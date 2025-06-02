package Domain.Heranca;

public abstract class InstituicaoCultural {
    private String nome;
    private String endereco;

    public InstituicaoCultural(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getInfo() {
        return "Nome: " + nome + ", Endereço: " + endereco;
    }
}
