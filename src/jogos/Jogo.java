package jogos;
import generos.*;

public class Jogo {
    private String nome;
    private Genero genero;
    private double avaliacao;

    public Jogo(String nome, Genero genero) {
        this.nome = nome;
        this.genero = genero;
        this.avaliacao = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void avaliar(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    @Override
    public String toString() {
        return nome + " - " + genero.getNome() + " - Avaliação: " + avaliacao;
    }
}
