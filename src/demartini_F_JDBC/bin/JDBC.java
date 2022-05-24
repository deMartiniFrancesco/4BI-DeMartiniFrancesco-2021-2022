package demartini_F_JDBC.bin;

import java.io.File;
import java.sql.*;

class JDBC {
    public JDBC() {
    }

    public int insertAlunno(Connection c, String nome, String cognome, String matricola) throws SQLException {
        int r;
        String insert = "INSERT INTO alunni values (?,?,?)";
        PreparedStatement ps = c.prepareStatement(insert);
        ps.setString(1, nome);
        ps.setString(2, cognome);
        ps.setString(3, matricola);
        System.out.println(insert);
        r = ps.executeUpdate();

        return r;
    }


    public void creaTab(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String create = "CREATE TABLE alunni ("
                + "  name varchar (20) primary key,"
                + "  cognome varchar (20) NOT NULL,"
                + "  matricola char (6) NOT NULL"
                + ") ";
        System.out.println(create);
        statement.executeUpdate(create);
    }

    public void dropTab(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String drop = "DROP TABLE alunni;";
        System.out.println(drop);
        statement.executeUpdate(drop);
    }


    public void visProdotti(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM alunni");

        while (result.next()) {
            System.out.printf("Nome %s cognome %s matricola %s%n",
                    result.getString("nome"),
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
            jdbc.insertAlunno(conn, "Alessandro", "Nicolis", "19383");

        } catch (Exception e) {
            e.printStackTrace();
        }







    }
}