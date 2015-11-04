package Utility;

import Tablas.Personas;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Connection con;

    public static Connection Conexion() throws ClassNotFoundException, SQLException {

        if (con != null) {
            return con;
        } else {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=dbArrendamiento;user=Wlacho;password=wladimir";
            con = DriverManager.getConnection(connectionURL);

            return con;
        }
    }

    public String entrada(String NomUsu) {

        String Nom = null;

        Statement st;
        try {
            st = con.createStatement();
            ResultSet resulta = st.executeQuery("select * from tblPersona where Usuario ='" + NomUsu + "'");

            if (resulta.next()) {
                Nom = resulta.getString("Nombre");   
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Nom;
    }

}
