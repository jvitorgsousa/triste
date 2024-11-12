package usuario;


public class AutenticacaoSimples implements Autenticacao {
    private String usuarioRegistrado;
    private String senhaRegistrada;

    public AutenticacaoSimples(String usuario, String senha) {
        this.usuarioRegistrado = usuario;
        this.senhaRegistrada = senha;
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        return usuario.equals(usuarioRegistrado) && senha.equals(senhaRegistrada);
    }
}




