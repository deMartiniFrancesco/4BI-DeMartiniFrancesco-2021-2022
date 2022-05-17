package demartini_F_JDBC.bin;

import java.io.File;
import java.sql.*;

class JDBC {
    public JDBC() {
    }

    public int insertProdotti(Connection c, String cod, String descr, String prezzo, String scadenza, String qta, String um) throws SQLException {
        int r;
        String insertTableSQL = "INSERT INTO prodotti values (?,?,?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(insertTableSQL);
        ps.setString(1, cod);
        ps.setString(2, descr);
        ps.setString(3, prezzo);
        ps.setString(4, scadenza);
        ps.setString(5, qta);
        ps.setString(6, um);
        r = ps.executeUpdate();

        return r;
    }


    public int creaTab(Connection c) throws SQLException {
        Statement stmt;
        stmt = c.createStatement();
        String create = "CREATE TABLE alunni ("
                + "  name varchar(20) primary key,"
                + "  eta numeric(30) DEFAULT NULL,"
                + "  classe numeric (10,4) NOT NULL,"
                + "  matricola datetime NOT NULL,"
                + ") ";
        System.out.println(create);
        return stmt.executeUpdate(create);
    }


    public void visProdotti(Connection c) throws SQLException {
        Statement stmt;
        ResultSet rs;
        stmt = c.createStatement();
        rs = stmt.executeQuery("SELECT * FROM prodotti");

        while (rs.next()) {
            System.out.println(rs.getString("cod")
                    + "  " + rs.getString("descr") + "  "
                    + rs.getString("prezzo") + "  " +
                    rs.getString("qta") + "  " +
                    rs.getString("scadenza"));
        }
        stmt.close();
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
        try {
            conn = DriverManager.getConnection(
                    "jdbc:sqlite:" + projectPath + resursesPath + "magaz.db");

            JDBC jdbc = new JDBC();
            jdbc.creaTab(conn);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}