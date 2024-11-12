package recomendacoes;

import jogos.*;
import usuario.*;
import generos.*;

import java.util.List;

public class SistemaDeRecomendacaoFacade {
    private Usuario usuario;
    private Acao jogoFactory; 
    private EstrategiaRecomendacao estrategiaRecomendacao;


    public SistemaDeRecomendacaoFacade(Usuario usuario, Acao jogoFactory) {
        this.usuario = usuario;
        this.jogoFactory = jogoFactory;
    }

    public void registrarJogo(String nome) {
        Jogo jogo = JogoFactory.criarJogo(nome, null);
        usuario.getHistorico().adicionarJogo(jogo);
    }

    public void avaliarJogo(Jogo jogo, double nota) {
        jogo.avaliar(nota);
    }

    public void recomendarJogos() {
        List<Jogo> recomendados = estrategiaRecomendacao.recomendarJogos(usuario);
        System.out.println("Jogos recomendados:");
        for (Jogo jogo : recomendados) {
            System.out.println(jogo);
        }
    }

    public void setEstrategiaRecomendacao(EstrategiaRecomendacao estrategiaRecomendacao) {
        this.estrategiaRecomendacao = estrategiaRecomendacao;
    }
}

