package generos;

public class RPG extends Genero {
    private String tipoPersonagem;

    public RPG() {
        this.nome = "RPG";
        this.tipoPersonagem = "Guerreiro";
    }

    @Override
    public String getNome() {
        return nome;
    }

    public String getTipoPersonagem() {
        return tipoPersonagem;
    }

    @Override
    public String descricao() {
        return "Jogos de RPG enfatizam criação de personagens, desenvolvimento de habilidades e narrativas em mundos fictícios. Tipo de personagem: " + tipoPersonagem;
    }
}

