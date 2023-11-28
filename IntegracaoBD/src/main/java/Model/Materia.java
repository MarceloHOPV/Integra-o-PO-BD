package Model;

public class Materia {

    private String sigla;
    private int peso;
    private String cordenador;

    public Materia(String sigla, int peso) {
        this.sigla = sigla;
        this.peso = peso;
    }

    public Materia(String sigla, int peso, String cordenador) {
        this.sigla = sigla;
        this.peso = peso;
        this.cordenador = cordenador;
    }

    public String getSigla() {
        return sigla;
    }

    public int getPeso() {
        return peso;
    }

    public String getCordenador() {
        return cordenador;
    }
}
