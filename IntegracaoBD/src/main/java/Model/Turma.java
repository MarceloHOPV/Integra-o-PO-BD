package Model;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String idTurma;
    private int numAlunos;
    private int sala;
    private int predio;
    //A matéria está associada ao peso por agregação
    Professor professor;
    Materia materia;
    List<Aluno> alunos = new ArrayList<>();

    public Turma(String idTurma, int numAlunos, String cpfProf, String nomeProf,int numDiciplinas, int sala, int predio,String sigla,int peso) {
        this.idTurma = idTurma;
        this.numAlunos = numAlunos;
        professor = new Professor(cpfProf,nomeProf,numDiciplinas);
        this.sala = sala;
        this.predio = predio;
        materia = new Materia(sigla,peso);
    }

    public Turma(String idTurma, int numAlunos, String cpfProf, String nomeProf, int numDiciplinas, int sala, int predio) {
        this.idTurma = idTurma;
        this.numAlunos = numAlunos;
        this.sala = sala;
        this.predio = predio;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public int getNumAlunos() {
        return numAlunos;
    }

    public int getSala() {
        return sala;
    }

    public int getPredio() {
        return predio;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Materia getMateria() {
        return materia;
    }
}
