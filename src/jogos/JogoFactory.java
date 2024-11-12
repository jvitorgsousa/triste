package jogos;
import generos.*;

public class JogoFactory {
    public static Jogo criarJogo(String nome, Genero genero) {
        return new Jogo(nome, genero);
    }
}

