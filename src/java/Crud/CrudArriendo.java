package Crud;

import Utility.*;
import Tablas.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Wladimir
 */
public class CrudArriendo {

    private Connection con;

    public CrudArriendo() throws ClassNotFoundException, SQLException {
        con = Conexion.Conexion();
    }

    public void AgregarArriendo(Arriendo arriendo) throws ClassNotFoundException, SQLException {

        String a = "INSERT INTO tblArriendo "
                + "([IdArriendo],[FechaIngreso],[PermanenciaMinima],[PorcentajeInteresMora],[Renta],"
                + "[DiaCorte],[IdInquilino],[IdCasa],[Estado])";

        try {

            PreparedStatement preparedStatement = con
                    .prepareStatement(a + " values (?,?,?,?,?,?,?,?,? )");

            preparedStatement.setInt(1, arriendo.IdArriendo);
            preparedStatement.setString(2, arriendo.FechaIngreso);
            preparedStatement.setInt(3, arriendo.PermanenciaMinima);
            preparedStatement.setInt(4, arriendo.PorcentajeInteresMora);
            preparedStatement.setInt(5, arriendo.Renta);
            preparedStatement.setInt(6, arriendo.DiaCorte);
            preparedStatement.setInt(7, arriendo.IdInquilino);
            preparedStatement.setInt(8, arriendo.IdCasa);
            preparedStatement.setString(9, arriendo.Estado);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void EliminarPersona(int IdArriendo) throws ClassNotFoundException, SQLException {

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("DELETE  FROM tblArriendo WHERE IdArriendo =?");

            preparedStatement.setInt(1, IdArriendo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void ModificarArriendo(Arriendo arriendo) throws ClassNotFoundException, SQLException {

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("UPDATE tblArriendo SET "
                            + "IdArriendo =  ISNULL(?, IdArriendo ), "
                            + "FechaIngreso= ISNULL(?, FechaIngreso ), "
                            + "PermanenciaMinima = ISNULL(?, PermanenciaMinima ), "
                            + "Renta = ISNULL(?, Renta ), "
                            + "DiaCorte = ISNULL(?, DiaCorte ), "
                            + "IdInquilino = ISNULL(?, IdInquilino ), "
                            + "IdCasa = ISNULL(?, IdCasa ), "
                            + "Estado = ISNULL(?, Estado )"
                            + "where IdArriendo= ISNULL(?, IdArriendo )");
            
            if (arriendo.IdArriendo == null) {
                preparedStatement.setNull(1, Types.INTEGER);
            } else {
                preparedStatement.setInt(1, arriendo.IdArriendo);
            }

            if (arriendo.FechaIngreso == null) {
                preparedStatement.setNull(2, Types.VARCHAR);
            } else {
                preparedStatement.setString(2, arriendo.FechaIngreso);
            }

            if (arriendo.PermanenciaMinima == null) {
                preparedStatement.setNull(3, Types.INTEGER);
            } else {
                preparedStatement.setInt(3, arriendo.PermanenciaMinima);
            }

            if (arriendo.PorcentajeInteresMora == null) {
                preparedStatement.setNull(4, Types.INTEGER);
            } else {
                preparedStatement.setInt(4, arriendo.PorcentajeInteresMora);
            }
            if (arriendo.Renta == null) {
                preparedStatement.setNull(5, Types.INTEGER);
            } else {
                preparedStatement.setInt(5, arriendo.Renta);
            }
            if (arriendo.DiaCorte == null) {
                preparedStatement.setNull(6, Types.INTEGER);
            } else {
                preparedStatement.setInt(6, arriendo.DiaCorte);
            }

            if (arriendo.IdInquilino == null) {
                preparedStatement.setNull(7, Types.INTEGER);
            } else {
                preparedStatement.setInt(7, arriendo.IdInquilino);
            }

            if (arriendo.IdCasa == null) {
                preparedStatement.setNull(8, Types.INTEGER);
            } else {
                preparedStatement.setInt(8, arriendo.IdCasa);
            }

            if (arriendo.Estado == null) {
                preparedStatement.setNull(9, Types.VARCHAR);
            } else {
                preparedStatement.setString(9, arriendo.Estado);
            }
            if (arriendo.IdArriendo == null) {
                preparedStatement.setNull(10, Types.INTEGER);
            } else {
                preparedStatement.setInt(10, arriendo.IdArriendo);
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Arriendo> getArriendo() throws ClassNotFoundException, SQLException {

        List<Arriendo> arriendos = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet resul = st.executeQuery("SELECT * FROM tblArriendo");
        while (resul.next()) {
            Arriendo arriendo = new Arriendo();
            arriendo.setIdArriendo(resul.getInt("IdArriendo"));
            arriendo.setFechaIngreso(resul.getString("FechaIngreso"));
            arriendo.setPermanenciaMinima(resul.getInt("PermanenciaMinima"));
            arriendo.setPorcentajeInteresMora(resul.getInt("PorcentajeInteresMora"));
            arriendo.setRenta(resul.getInt("Renta"));
            arriendo.setDiaCorte(resul.getInt("DiaCorte"));
            arriendo.setIdInquilino(resul.getInt("IdInquilino"));
            arriendo.setIdCasa(resul.getInt("IdCasa"));
            arriendo.setEstado(resul.getString("Estado"));
            arriendos.add(arriendo);
        }

        return arriendos;
    }

    public Arriendo getArriendo(int Arriendo) throws ClassNotFoundException, SQLException {

        Arriendo arriendo = new Arriendo();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM tblArriendo IdArriendo=?");
        ps.setInt(1, Arriendo);
        ResultSet resul = ps.executeQuery();
        if (resul.next()) {
            arriendo.setIdArriendo(resul.getInt("IdArriendo"));
            arriendo.setFechaIngreso(resul.getString("FechaIngreso"));
            arriendo.setPermanenciaMinima(resul.getInt("PermanenciaMinima"));
            arriendo.setPorcentajeInteresMora(resul.getInt("setPorcentajeInteresMora"));
            arriendo.setRenta(resul.getInt("Renta"));
            arriendo.setDiaCorte(resul.getInt("DiaCorte"));
            arriendo.setIdInquilino(resul.getInt("setIdInquilino"));
            arriendo.setIdCasa(resul.getInt("IdCasa"));
            arriendo.setEstado(resul.getString("Estado"));
        }

        return arriendo;
    }

}
