package DAO;

import Model.Materia;

import java.sql.SQLException;
import java.util.ArrayList;

public class MateriaDAO extends ConnectionDAO{

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertMateria(Materia Materia) {

        connectToDB();

        String sql = "INSERT INTO Materia (sigla,peso) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Materia.getSigla());
            pst.setInt(2, Materia.getPeso());
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
    public boolean updateMateria(Materia Materia) {
        connectToDB();
        String sql = "UPDATE Materia SET peso=? where sigla=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(2, Materia.getSigla());
            pst.setInt(1, Materia.getPeso());
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
    public boolean deleteMateria(String sigla) {
        connectToDB();
        String sql = "DELETE FROM Materia where sigla=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sigla);
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
    public ArrayList<Materia> selectMateria() {
        ArrayList<Materia> Materias = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Materia";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Materias: ");
            System.out.println();

            while (rs.next()) {

                Materia MateriaAux = new Materia(rs.getString("sigla"),rs.getInt("peso"));

                System.out.println("Sígla da matéria = " + MateriaAux.getSigla());
                System.out.println("Peso = " + MateriaAux.getPeso());
                System.out.println("--------------------------------");

                Materias.add(MateriaAux);
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
        return Materias;
    }

    public ArrayList<Materia> selectNnPrintaMateria() {
        ArrayList<Materia> Materias = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Materia";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);



            while (rs.next()) {

                Materia MateriaAux = new Materia(rs.getString("sigla"),rs.getInt("peso"));


                Materias.add(MateriaAux);
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
        return Materias;
    }

}

