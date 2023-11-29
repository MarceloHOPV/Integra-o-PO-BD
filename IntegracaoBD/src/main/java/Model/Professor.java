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
    private final String cpf;
    private String Nome;
    private int numDiciplinas;
    private String Habilidade;
    List<Habilidades> habilidades = new ArrayList<>();

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
        Habilidades habilidade = habilidadesDAO.returnHabilidadeDAO(this.cpf);
        String Cabelo = "";
                try {
                    if (habilidade.getHabilidades().equals("Careca")) {
                        Cabelo = "Careca";
                    } else if (habilidade.getHabilidades().equals("Calvo")) {
                        Cabelo = "Calvo";
                    } else {
                       Cabelo = "nda";
                    }

                } catch (NullPointerException e) {
                }
        if (Cabelo.equals("Careca")) {
            System.out.println("O professor " + this.getNome() + " não possuí mais nem um fio de cabelo");
        } else if (Cabelo.equals("Calvo")) {
            System.out.println("O professor " + this.getNome() + " ainda possui um pouco de cabelo mas jaja fica sem");
        } else if(Cabelo.equals("nda")){
            System.out.println("O professor " + this.getNome() + " tem bastante cabelo ainda");
        }else
            System.out.println("Professor não possui habilidades");
    }


    @Override
    public void podeCodar() {
        Habilidades habilidade = habilidadesDAO.returnHabilidadeDAO(this.cpf);
        String codar = "";
                if (habilidade.getHabilidades().equals("Codar")) {
                    codar = "Codar";
                } else {
                    codar = "nda";
            }
        if(codar.equals("Codar")) {
            System.out.println("O professor " + this.getNome() + " sabe codar");
        } else if(codar.equals("nda")) {
            System.out.println("O professor " + this.getNome() + " não sabe codar e odeio quem coda");
        }else
            System.out.println("Professor não possui habilidades");
    }

    @Override
    public void consegueDerivar() {
        Habilidades habilidade = habilidadesDAO.returnHabilidadeDAO(this.cpf);
        String derivar = "";
                if (habilidade.getHabilidades().equals("Derivar")) {
                    derivar = "Derivar";
                } else
                    derivar = "nda";

        if (derivar.equals("Derivar")) {
            System.out.println("O professor " + this.getNome() + " sabe derivar");
        } else if(derivar.equals("nda"))
            System.out.println("O professor " + this.getNome() + " nunca mais derivou depois que formou");
        else
            System.out.println("Professor não possui habilidades");

    }

    @Override
    public void consegueIntegrar() {

        Habilidades habilidade = habilidadesDAO.returnHabilidadeDAO(this.cpf);
        String integrar = "";

                if (habilidade.getHabilidades().equals("Integrar")) {
                    integrar = "Integrar";
                } else
                    integrar = "nda";

        if (integrar.equals("Integrar")) {
            System.out.println("O professor " + this.getNome() + " sabe Integrar");
        } else if(integrar.equals("nda"))
            System.out.println("O professor " + this.getNome() + " nunca mais Integrou depois que formou");
        else
            System.out.println("Professor não possui habilidades");
    }
}
