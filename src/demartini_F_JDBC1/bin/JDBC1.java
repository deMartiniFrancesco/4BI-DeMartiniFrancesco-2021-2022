package demartini_F_JDBC1.bin;

import java.io.File;
import java.sql.*;

class JDBC1 {

    public JDBC1(Connection conn) {
        try {
            createDatabase(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void init(Connection conn){
        try {
            permiss(conn);

            createUsers(conn);

            creaTabAutore(conn);

            createTabFrasi(conn);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void permiss(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        statement.execute("GRANT ALL PRIVILEGES ON dbfrasi. * TO 'utfrasi' @ '%';");
        statement.close();
        connection.commit();

        statement.execute("GRANT ALL PRIVILEGES ON dbfrasi. * TO 'utfrasi' @ 'localhost';");
        statement.close();
        connection.commit();


    }

    public void createDatabase(Connection connection) throws SQLException {
        String createAutore = "CREATE DATABASE IF NOT EXISTS dbfrasi;";
        PreparedStatement  statement = connection.prepareStatement(createAutore);
        statement.execute();
        System.out.println(createAutore);
        connection.commit();

        statement.execute("use dbfrasi;");
        statement.close();

        connection.commit();

    }

    public void createUsers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String createUser1 = "CREATE USER 'utfrasi'@'%' IDENTIFIED " +
                "with mysql_native_password by 'ì' ;";
        statement.executeUpdate(createUser1);
        System.out.println(createUser1);

        String createUser2 = "CREATE USER 'utfrasi'@'localhost' IDENTIFIED " +
                "with mysql_native_password by 'pwfrasi' ;";
        statement.executeUpdate(createUser2);
        System.out.println(createUser2);


    }

    public void creaTabAutore(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String createAutore = "CREATE TABLE IF NOT EXISTS autore ( " +
                "id INT NOT NULL AUTO_INCREMENT," +
                "username VARCHAR(25) unique NOT NULL," +
                "nome VARCHAR(30) NULL," +
                "cognome VARCHAR(30) NOT NULL," +
                "PRIMARY KEY (id));";
        statement.executeUpdate(createAutore);
        System.out.println(createAutore);
    }

    public void createTabFrasi(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String createFrase = "CREATE TABLE IF NOT EXISTS frase ( " +
                "id INT NOT NULL AUTO_INCREMENT, " +
                "titolo VARCHAR(50) NOT NULL, " +
                "frasecompleta TEXT NOT NULL, " +
                "lastupdate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, " +
                "idaut INT NOT NULL, " +
                "PRIMARY KEY (id), " +
                "CONSTRAINT FOREIGN KEY (idaut) REFERENCES autore (id) " +
                ");";
        statement.executeUpdate(createFrase);
        System.out.println(createFrase);
    }

    public void dropTab(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String drop = """
                drop user if exists 'utfrasi'@'%';
                drop user if exists 'utfrasi'@'localhost';
                DROP TABLE IF EXISTS frase;
                DROP TABLE IF EXISTS autore ;
                """;
        statement.executeUpdate(drop);
        System.out.println(drop);
    }

    public void insertAutore(Connection connection, String username, String nome, String cognome) throws SQLException {
        String insert = "INSERT INTO autore VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, nome);
        preparedStatement.setString(3, cognome);
        preparedStatement.executeUpdate();
        System.out.println(insert);
    }

    public void insertFrase(Connection connection, int id, String titolo, String frasecompleta, Date lastupdate, int idaut) throws SQLException {
        String insert = "INSERT INTO frase VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, titolo);
        preparedStatement.setString(3, frasecompleta);
        preparedStatement.setDate(4, lastupdate);
        preparedStatement.setInt(5, idaut);
        preparedStatement.executeUpdate();
        System.out.println(insert);
    }

    public void visualizza(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM autore");

        while (result.next()) {
            System.out.print(result);
            System.out.println();
        }
        statement.close();
    }

}

class JDBC1Test {
    public static void main(String[] args) {

        System.out.println("Start");

        //              CALCOLO PATH RELATIVO UNIVERSALE
        //----------------------------------------------------------------------
        String tempPath = new File(
                String.valueOf(JDBC1.class.getPackage()).replace("package ", "").replace(".", "/")
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
        JDBC1 jdbc1;
        try {


            conn = DriverManager.getConnection(
                    "jdbc:sqlite:local.marconivr.it", "utfrasi", "pwfrasi");

            jdbc1 = new JDBC1(conn);

            conn = DriverManager.getConnection(
                    "jdbc:sqlite:local.marconivr.it/dbfrasi", "utfrasi", "pwfrasi");


            jdbc1.visualizza(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End");

    }
}