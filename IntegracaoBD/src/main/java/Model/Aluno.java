package Model;

import Inteface.Cabelo;
import Inteface.Codar;
import Inteface.Derivar;
import Inteface.Integrar;

public class Aluno implements  Derivar, Integrar, Codar {

    private String matricula;
    private String nome_aluno;
    private String dataNascimento;

    public Aluno(String matricula, String nome_aluno, String dataNascimento) {
        this.matricula = matricula;
        this.nome_aluno = nome_aluno;
        this.dataNascimento = dataNascimento;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void podeCodar() {
        System.out.println("Ainda está aprendendo a codar");
    }

    @Override
    public void consegueDerivar() {
        System.out.println("Ainda está aprendendo a derivar");
    }

    @Override
    public void consegueIntegrar() {
        System.out.println("Ainda está aprendendo a integrar");

    }
}
