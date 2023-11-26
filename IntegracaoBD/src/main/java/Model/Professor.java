package Model;

import DAO.HabilidadesDAO;
import Inteface.Cabelo;
import Inteface.Codar;
import Inteface.Derivar;
import Inteface.Integrar;

import java.util.ArrayList;
import java.util.List;

public class Professor implements Cabelo, Derivar, Integrar, Codar {

    HabilidadesDAO habilidadesDAO = new HabilidadesDAO();
    private String cpf;
    private String Nome;
    private int numDiciplinas;
    private String Habilidade;
    List<String> habilidades = new ArrayList<>();

    public Professor(String cpf, String nome, int numDiciplinas) {
        this.cpf = cpf;
        this.Nome = nome;
        this.numDiciplinas = numDiciplinas;
    }

    public Professor(String cpf,String Habilidade) {
        this.cpf = cpf;
        this.Habilidade = Habilidade;
    }

    //Stters
    //Esse seter vai ser usado pois podemos atribuir habilidades ao nosso professor mas ele pode não ter nenhuma também
    public void setHabilidade(String habilidade) {
        Habilidade = habilidade;
    }

    //Getters
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return Nome;
    }

    public int getNumDiciplinas() {
        return numDiciplinas;
    }

    public String getHabilidade() {
        return Habilidade;
    }


    @Override
    public void qtdCabelo() {
        habilidades = habilidadesDAO.selectNnPrintaProfessor(this.cpf);
        for (String hab : this.habilidades) {
            try {
                if (hab.equals("Careca")) {
                    System.out.println("O professor " + this.getNome() + " não possuí mais nem um fio de cabelo");
                } else if (hab.equals("Calvo")) {
                    System.out.println("O professor " + this.getNome() + " ainda possui um pouco de cabelo mas jaja fica sem");
                } else {
                    System.out.println("O professor " + this.getNome() + " tem bastante cabelo ainda");
                }
            }catch(NullPointerException e){}
        }
    }


    @Override
    public void podeCodar() {
        habilidades = habilidadesDAO.selectNnPrintaProfessor(this.cpf);
        for (String hab : this.habilidades) {
            if (hab.equals("Coder")) {
                System.out.println("O professor " + this.getNome() + " sabe codar");
            } else
                System.out.println("O professor " + this.getNome() + " não sabe codar e odeio quem coda");
        }
    }

    @Override
    public void consegueDerivar() {
        habilidades = habilidadesDAO.selectNnPrintaProfessor(this.cpf);
        for (String hab : this.habilidades) {
            if (hab.equals("Derivar")) {
                System.out.println("O professor " + this.getNome() + " sabe derivar");
            } else
                System.out.println("O professor " + this.getNome() + " nunca mais derivou depois que formou");
        }

    }

    @Override
    public void consegueIntegrar() {

        habilidades = habilidadesDAO.selectNnPrintaProfessor(this.cpf);
        for (String hab : this.habilidades) {
            if (hab.equals("Integrar")) {
                System.out.println("O professor " + this.getNome() + " sabe Integrar");
            } else
                System.out.println("O professor " + this.getNome() + " nunca mais Integrou depois que formou");
        }
    }
}
