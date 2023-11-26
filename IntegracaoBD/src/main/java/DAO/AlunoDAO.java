package DAO;

import Model.Aluno;

import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertAluno(Aluno aluno) {

        connectToDB();

        String sql = "INSERT INTO Aluno (matricula,nome,dataNascimento) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, aluno.getMatricula());
            pst.setString(2, aluno.getNome_aluno());
            pst.setString(3, aluno.getDataNascimento());
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
    public boolean updateAluno(Aluno aluno) {
        connectToDB();
        String sql = "UPDATE Aluno SET dataNascimento=?, nome=? where matricula=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(3, aluno.getMatricula());
            pst.setString(2, aluno.getNome_aluno());
            pst.setString(1,aluno.getDataNascimento());
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
    public boolean deleteAluno(String matricula) {
        connectToDB();
        String sql = "DELETE FROM Aluno where matricula=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, matricula);
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
    public ArrayList<Aluno> selectAluno() {
        ArrayList<Aluno> Alunos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Aluno";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Alunos: ");
            System.out.println();

            while (rs.next()) {

                Aluno alunoAux = new Aluno(rs.getString("matricula"),rs.getString("nome"),rs.getString("dataNascimento"));

                System.out.println("Matrícula = " + alunoAux.getMatricula());
                System.out.println("Nome = " + alunoAux.getNome_aluno());
                System.out.println("Data de nascimento = " + alunoAux.getDataNascimento());
                System.out.println("--------------------------------");

                Alunos.add(alunoAux);
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
        return Alunos;
    }

    public ArrayList<Aluno> selectNnPrintaAluno() {
        ArrayList<Aluno> Alunos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Aluno";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);



            while (rs.next()) {

                Aluno alunoAux = new Aluno(rs.getString("matricula"),rs.getString("nome"),rs.getString("dataNascimento"));


                Alunos.add(alunoAux);
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
        return Alunos;
    }
}
