package usuario;

import java.util.*;

public class GerenciadorDeUsuarios {
    private List<Usuario> usuariosCadastrados = new ArrayList<>();

    public Usuario buscarUsuarioPorNome(String nome) {
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null; 
    }

    public void adicionarUsuario(Usuario usuario) {
        usuariosCadastrados.add(usuario);
    }
}
