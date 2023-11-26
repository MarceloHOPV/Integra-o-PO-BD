package DAO;

import Model.Professor;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertProfessor(Professor prof) {

        connectToDB();

        String sql = "INSERT INTO Professor (cpf,nome,numDiciplinas) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, prof.getCpf());
            pst.setString(2, prof.getNome());
            pst.setInt(3, prof.getNumDiciplinas());
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
        String sql = "UPDATE Professor SET numDiciplinas=?, nome=? where cpf=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(3, prof.getCpf());
            pst.setString(2, prof.getNome());
            pst.setInt(1,prof.getNumDiciplinas());
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
        String sql = "DELETE FROM Professor where cpf=?";
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
    public ArrayList<Professor> selectProfessor() {
        ArrayList<Professor> Professores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Professor";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Professores: ");
            System.out.println();

            while (rs.next()) {

                Professor profAux = new Professor(rs.getString("cpf"),rs.getString("nome"),rs.getInt("numDiciplinas"));

                System.out.println("nome = " + profAux.getNome());
                System.out.println("cpf = " + profAux.getCpf());
                System.out.println("Número de diciplinas = " + profAux.getNumDiciplinas());
                System.out.println("--------------------------------");

                Professores.add(profAux);
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
        return Professores;
    }

    public ArrayList<Professor> selectNnPrintaProfessor() {
        ArrayList<Professor> Professores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Professor";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Professor profAux = new Professor(rs.getString("cpf"),rs.getString("nome"),rs.getInt("numDiciplinas"));
                Professores.add(profAux);
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
        return Professores;
    }

}

