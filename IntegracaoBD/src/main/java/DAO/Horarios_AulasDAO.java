package DAO;

import Model.Horarios_Aulas;
import Model.Professor;
import Model.Turma;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Horarios_AulasDAO extends ConnectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertHorarios_Aulas(Horarios_Aulas horarios_Aulas) {

        connectToDB();

        String sql = "INSERT INTO HorarioAulas (sigla,idTurma,horarios) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, horarios_Aulas.getSigla());
            pst.setString(2, horarios_Aulas.getIdTurma());
            pst.setString(3, horarios_Aulas.getHorario());
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //UPDATE
    public boolean updateHorarios_Aulas(Horarios_Aulas horarios_Aulas) {
        connectToDB();
        String sql = "UPDATE HorarioAulas SET horario=? where sigla=? and idTurma=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(2, horarios_Aulas.getSigla());
            pst.setString(1, horarios_Aulas.getHorario());
            pst.setString(3, horarios_Aulas.getIdTurma());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //DELETE
    public boolean deleteHorarios_Aulas(String idTurma) {
        connectToDB();
        String sql = "DELETE FROM HorarioAulas where idTurma=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, idTurma);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //SELECT
    public ArrayList<Horarios_Aulas> selectHorarios_Aulas(Professor prof) {
        ArrayList<Horarios_Aulas> Horarios = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM HorarioAulas";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Horarios: ");
            System.out.println();

            while (rs.next()) {

                TurmaDAO turmaDAO = new TurmaDAO();
                List<Turma> turmas = new ArrayList<>();
                turmas = turmaDAO.selectTurmaNnPrinta();
                ArrayList<Horarios_Aulas> horariosTurma = new ArrayList<>();

                Horarios_Aulas Horarios_AulasAux = new Horarios_Aulas(rs.getString("sigla"), rs.getString("idTurma"), rs.getString("horarios"));

                Horarios.add(Horarios_AulasAux);

                for (int i = 0; i < turmas.size(); i++) {
                    try {
                        System.out.println("A turma " + turmas.get(i).getMateria().getSigla() + " - " + turmas.get(i).getIdTurma() + " tem aulas nos seguintes horários:");
                    } catch (Exception e) {
                    }//Não coloquei nada porque por estar em loop não quero que printe vários erros já que a interface vai ser o pronpt
                    for (int j = 0; j < Horarios.size(); j++) {
                        try {
                            if (turmas.get(i).getIdTurma() == horariosTurma.get(j).getIdTurma()) {
                                System.out.println(horariosTurma.get(j).getHorario());
                            }
                        } catch (Exception e) {
                        }//Não coloquei nada porque por estar em loop não quero que printe vários erros já que a interface vai ser o pronpt
                    }
                }

            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return Horarios;
    }
}

