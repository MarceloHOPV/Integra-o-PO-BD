package DAO;

import Model.Materia;
import Model.Professor;
import Model.Turma;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertTurma(Turma turma) {

        connectToDB();

        String sql = "INSERT INTO Turma (idTurma,sigla,cpf,numAlunos,predio,numSala) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, turma.getIdTurma());
            pst.setString(2, turma.getMateria().getSigla());
            pst.setString(3, turma.getProfessor().getCpf());
            pst.setInt(4, turma.getNumAlunos());
            pst.setInt(5, turma.getPredio());
            pst.setInt(6, turma.getSala());

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
    public boolean updateTurma(Turma turma) {
        connectToDB();
        String sql = "UPDATE Turma SET numAlunos=?, predio=? , numSala=?where idTurma=? and sigla =?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, turma.getNumAlunos());
            pst.setInt(2, turma.getPredio());
            pst.setInt(3,turma.getSala());
            pst.setString(4,turma.getIdTurma());
            pst.setString(5,turma.getMateria().getSigla());
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
    public boolean deleteTurma(String sigla,String matricula) {
        connectToDB();
        String sql = "DELETE FROM Turma where idTurma=? and sigla =?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, matricula);
            pst.setString(2,sigla);
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
    public ArrayList<Turma> selectTurma() {
        ArrayList<Turma> turmas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Turma";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de turmas: ");
            System.out.println();

            while (rs.next()) {

                ProfessorDAO profDAO = new ProfessorDAO();
                List<Professor> prof = profDAO.selectNnPrintaProfessor();
                int profNum = 0;

                for (int i = 0; i < prof.size(); i++) {
                    try {
                        if (rs.getString("cpf").equals(prof.get(i).getCpf())) {
                            profNum = i;
                        }
                    } catch (Exception e) {
                    }
                }

                MateriaDAO materiaDAO = new MateriaDAO();
                List<Materia> mat = materiaDAO.selectNnPrintaMateria();
                int matNum = 0;

                for (int i = 0; i < mat.size(); i++) {

                    if (rs.getString("sigla").equals(mat.get(i).getSigla())) {
                        matNum = i;
                    }

                }



                Turma turmaAUX = null;
                try {
                    turmaAUX = new Turma(rs.getString("idTurma"), rs.getInt("numAlunos"), prof.get(profNum).getCpf(),
                            prof.get(profNum).getNome(), prof.get(profNum).getNumDiciplinas(), rs.getInt("numSala"), rs.getInt("predio"),
                            mat.get(matNum).getSigla(), mat.get(matNum).getPeso());

                    System.out.println("A a turma " + turmaAUX.getMateria().getSigla() + " - " + turmaAUX.getIdTurma() + " possui as seguintes informações:");
                    System.out.println("Número de alunos: " + turmaAUX.getNumAlunos());
                    System.out.println("É ministrada pelo(a) professor: " + turmaAUX.getProfessor().getNome());
                    System.out.println("E as aulas dessa turma acontecer na sala " + turmaAUX.getSala() + " do prédio " + turmaAUX.getPredio());
                    System.out.println("--------------------------------");

                    turmas.add(turmaAUX);
                }catch (IndexOutOfBoundsException e) {
                    System.out.println("A matéria ou o professor dessa turma não estão cadastrados no banco de dados\n" +
                            "Tente cadastralos e tentar novamente");
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
        return turmas;
    }


    public ArrayList<Turma> selectTurmaNnPrinta() {
        ArrayList<Turma> turmas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Turma";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);


            while (rs.next()) {

                ProfessorDAO profDAO = new ProfessorDAO();
                List<Professor> prof =  profDAO.selectNnPrintaProfessor();
                int profNum = 0;

                for (int i = 0; i < prof.size(); i++) {
                    try{
                        if(rs.getString("cpf").equals(prof.get(i).getCpf()))
                        {
                            profNum = i;
                        }
                    }catch (Exception e){}
                }

                MateriaDAO materiaDAO = new MateriaDAO();
                List<Materia> mat = materiaDAO.selectNnPrintaMateria();
                int matNum = 0;

                for (int i = 0; i < mat.size(); i++) {

                    if(rs.getString("sigla").equals(mat.get(i).getSigla()))
                    {
                        matNum = i;
                    }

                }


                Turma turmaAUX = new Turma(rs.getString("idTurma"),rs.getInt("numAlunos"),prof.get(profNum).getCpf(),
                        prof.get(profNum).getNome(),prof.get(profNum).getNumDiciplinas(),rs.getInt("numSala"),rs.getInt("predio"),
                        mat.get(matNum).getSigla(),mat.get(matNum).getPeso());//Pequeno o construtor


                turmas.add(turmaAUX);
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
        return turmas;
    }
}
