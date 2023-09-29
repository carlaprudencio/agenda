package estrutura.agenda;

public class Contato {
    private String nome;
    private String telefone;
    private String nascimento;
    private String email;
    private String celular;

    public Contato(String nome, String telefone, String nascimento, String email, String celular) {
        this.nome = nome;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.email = email;
        this.celular = celular;
    }

    public String toString() {
        return "Nome: " + nome + "\nTelefone: " + telefone + "\nNascimento: " + nascimento +
                "\nEmail: " + email + "\nCelular: " + celular;
    }
}
