package generos;

public class Aventura extends Genero {
    private boolean elementosDeExploracao;

    public Aventura() {
        this.nome = "Aventura";
        this.elementosDeExploracao = true;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public boolean temElementosDeExploracao() {
        return elementosDeExploracao;
    }

    @Override
    public String descricao() {
        return "Jogos de aventura combinam narrativa envolvente e exploração, com missões e locais ocultos para descobrir. Exploração: " + (elementosDeExploracao ? "Sim" : "Não");
    }
}

