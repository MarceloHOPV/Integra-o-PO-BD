package DAO;

import Model.Professor;

import java.sql.SQLException;
import java.util.ArrayList;

public class HabilidadesDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertHabilidade(Professor prof) {

        connectToDB();

        String sql = "INSERT INTO Habilidades (cpf,Habilidade) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, prof.getCpf());
            pst.setString(2, prof.getHabilidade());
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
    public boolean updateProfessor(Professor prof) {
        connectToDB();
        String sql = "UPDATE Professor SET Habilidade where cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(2, prof.getCpf());
            pst.setString(1, prof.getHabilidade());
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
    public boolean deleteProfessor(String cpf) {
        connectToDB();
        String sql = "DELETE FROM Habilidades where cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
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

    public ArrayList<String> selectNnPrintaProfessor(String cpf) {
        ProfessorDAO professorDAO = new ProfessorDAO();
        ArrayList<Professor> Professores = new ArrayList<>();
        ArrayList<String> Habilidades = new ArrayList<>();
        String CPF = null;
        connectToDB();
        String sql = "SELECT * FROM Habilidades";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            for (Professor prof : professorDAO.selectNnPrintaProfessor()) {
                try {
                    if(prof.getCpf().equals(cpf))
                    {
                        CPF = cpf;
                    }
                }catch (NullPointerException e){
                    System.out.println("Professor não cadastrado");
                }
            }

            while (rs.next()) {
                try {
                    if (rs.getString("cpf").equals(CPF)) ;

                    Habilidades.add(rs.getString("Habilidade"));
                }catch (NullPointerException e){}

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
        return Habilidades;
    }

}

