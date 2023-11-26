package Model;

import java.util.ArrayList;
import java.util.List;

public class Horarios_Aulas {

    //Essa classe vou tentar fazer usando a logica de chave estrangeira aplicada em BD
    private String sigla;
    private String idTurma;
    private String horario;

    public Horarios_Aulas(String sigla, String idTurma, String horario) {
        this.sigla = sigla;
        this.idTurma = idTurma;
        this.horario = horario;
    }

    public String getSigla() {
        return sigla;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public String getHorario() {
        return horario;
    }
}
