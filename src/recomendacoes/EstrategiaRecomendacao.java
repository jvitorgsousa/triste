package recomendacoes;
import jogos.*;
import usuario.*;

import java.util.List;

public interface EstrategiaRecomendacao {
    List<Jogo> recomendarJogos(Usuario usuario);
}

