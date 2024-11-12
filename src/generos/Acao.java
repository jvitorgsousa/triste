package generos;

public class Acao extends Genero {
    private String nivelDificuldade;

    public Acao() {
        this.nome = "Ação";
        this.nivelDificuldade = "Médio";
    }

    @Override
    public String getNome() {
        return nome;
    }

    public String getNivelDificuldade() {
        return nivelDificuldade;
    }

    @Override
    public String descricao() {
        return "Jogos de ação exigem reflexos rápidos e precisão. Incluem combate e desafios físicos, com nível de dificuldade: " + nivelDificuldade;
    }
}



