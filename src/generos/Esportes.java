package generos;

public class Esportes extends Genero {
    private String tipoEsporte;

    public Esportes() {
        this.nome = "Esportes";
        this.tipoEsporte = "Futebol";
    }

    @Override
    public String getNome() {
        return nome;
    }

    public String getTipoEsporte() {
        return tipoEsporte;
    }

    @Override
    public String descricao() {
        return "Simulações de esportes reais que destacam habilidades e estratégias, com ênfase no trabalho em equipe. Esporte representado: " + tipoEsporte;
    }
}


