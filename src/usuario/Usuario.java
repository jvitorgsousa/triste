package usuario;

import jogos.*;

public class Usuario {
    private String nome;
    private Historico historico;
    private Autenticacao autenticacao;

    public Usuario(String nome, Autenticacao autenticacao) {
        this.nome = nome;
        this.historico = new Historico();
        this.autenticacao = autenticacao;
    }

    public boolean autenticar(String usuario, String senha) {
        return autenticacao.autenticar(usuario, senha);
    }

    public String getNome() {
        return nome;
    }

    public Historico getHistorico() {
        return historico;
    }
}



