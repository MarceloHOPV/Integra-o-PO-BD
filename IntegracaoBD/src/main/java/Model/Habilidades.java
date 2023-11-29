package Model;

public class Habilidades {

    String cpf;
    String Habilidades;

    public Habilidades(String cpf, String habilidades) {
        this.cpf = cpf;
        Habilidades = habilidades;
    }

    public String getCpf() {
        return cpf;
    }

    public String getHabilidades() {
        return Habilidades;
    }
}
