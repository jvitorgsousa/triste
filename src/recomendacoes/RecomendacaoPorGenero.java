package recomendacoes;

import jogos.*;
import usuario.*;
import generos.*;

import java.util.ArrayList;
import java.util.List;

public class RecomendacaoPorGenero implements EstrategiaRecomendacao {
    private Genero generoPreferido;

    public RecomendacaoPorGenero(Genero generoPreferido) {
        this.generoPreferido = generoPreferido;
    }

    @Override
    public List<Jogo> recomendarJogos(Usuario usuario) {
        List<Jogo> recomendados = new ArrayList<>();

        // Filtra os jogos que correspondem ao gênero preferido
        for (Jogo jogo : usuario.getHistorico().getJogosJogados()) {
            if (jogo.getGenero().getNome().equals(generoPreferido.getNome())) {
                recomendados.add(jogo);
            }
        }

        // Ordenar os jogos recomendados pela avaliação, do maior para o menor
        recomendados.sort((jogo1, jogo2) -> Double.compare(jogo2.getAvaliacao(), jogo1.getAvaliacao()));

        return recomendados;
    }
}
