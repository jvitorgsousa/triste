package recomendacoes;

import jogos.*;
import usuario.*;

import java.util.ArrayList;
import java.util.List;

public class RecomendacaoPorAvaliacao implements EstrategiaRecomendacao {
    @Override
    public List<Jogo> recomendarJogos(Usuario usuario) {
        List<Jogo> recomendados = new ArrayList<>();

        for (Jogo jogo : usuario.getHistorico().getJogosJogados()) {
            if (jogo.getAvaliacao() >= 4.0) {
                recomendados.add(jogo);
            } 
        }

        recomendados.sort((jogo1, jogo2) -> Double.compare(jogo2.getAvaliacao(), jogo1.getAvaliacao()));

        return recomendados;
    }
}

