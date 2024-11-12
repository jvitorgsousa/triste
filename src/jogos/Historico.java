package jogos;

import java.util.ArrayList;
import java.util.List;

public class Historico {
    private List<Jogo> jogosJogados = new ArrayList<>();

    public void adicionarJogo(Jogo jogo) {
        jogosJogados.add(jogo);
    }

    public List<Jogo> getJogosJogados() {
        return jogosJogados;
    }
}

