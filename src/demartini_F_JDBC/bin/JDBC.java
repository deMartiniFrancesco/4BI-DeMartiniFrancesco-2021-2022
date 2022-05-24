package demartini_F_JDBC.bin;

import java.io.File;
import java.sql.*;

class JDBC {
    public JDBC() {
    }

    public void insertAlunno(Connection c, String nome, String cognome, String matricola) throws SQLException {
        String insert = "INSERT INTO alunni values (?,?,?)";
        PreparedStatement ps = c.prepareStatement(insert);
        ps.setString(1, nome);
        ps.setString(2, cognome);
        ps.setString(3, matricola);
        ps.executeUpdate();
        System.out.println(insert);
    }


    public void creaTab(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String create = "CREATE TABLE alunni ("
                + "  name varchar (20) primary key,"
                + "  cognome varchar (20) NOT NULL,"
                + "  matricola char (6) NOT NULL"
                + ") ";
        statement.executeUpdate(create);
        System.out.println(create);
    }

    public void dropTab(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String drop = "DROP TABLE alunni;";
        statement.executeUpdate(drop);
        System.out.println(drop);
    }


    public void visAlunni(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM alunni");

        while (result.next()) {
            System.out.printf("Nome: %s cognome: %s matricola: %s%n",
                    result.getString("name"),
                    result.getString("cognome"),
                    result.getString("matricola"));
        }
        statement.close();
    }


}

class JDBCTest {
    public static void main(String[] args) {

        System.out.println("Start");

        //              CALCOLO PATH RELATIVO UNIVERSALE
        //----------------------------------------------------------------------
        String tempPath = new File(
                String.valueOf(JDBC.class.getPackage()).replace("package ", "").replace(".", "/")
        ).getParent();
        File uesrPath = new File(System.getProperty("user.dir"));
        String projectPath = uesrPath.getName().equals(tempPath) ?
                uesrPath.getPath() :
                new File(uesrPath.getPath() + "/src").exists() ?
                        uesrPath.getPath() + "/src/" + tempPath :
                        uesrPath.getPath() + tempPath;
        //----------------------------------------------------------------------

        // COSTANTI
        String resursesPath = "/file/";

        Connection conn;
        JDBC jdbc;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:sqlite:" + projectPath + resursesPath + "magaz.db");

            jdbc = new JDBC();
            try {
                jdbc.creaTab(conn);
            } catch (SQLException e) {
                //Gia esisstente;
            }
            jdbc.visAlunni(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }







    }
}