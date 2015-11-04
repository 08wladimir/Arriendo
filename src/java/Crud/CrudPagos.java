package Crud;

import Utility.*;
import Tablas.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Wladimir
 */
public class CrudPagos {
    
    private Connection con;

    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public CrudPagos() throws ClassNotFoundException, SQLException {
        con = Conexion.Conexion();
    }

    public void AgregarPagos(Pagos pago) throws ClassNotFoundException, SQLException {

        String a = "INSERT INTO [dbo].[tblPagos]"
                + "([FechaPago],[ValorPagadoArriendo],[ValorInteres],[IdArriendo])";

        try {

            PreparedStatement preparedStatement = con
                    .prepareStatement(a + " values (?,?,?,? )");

            preparedStatement.setString(1, pago.FechaPago);
            preparedStatement.setInt(2, (int)pago.ValorPagadoArriendo);
            preparedStatement.setInt(3, (int)pago.ValorInteres);
            preparedStatement.setInt(4, (int)pago.IdArriendo);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void EliminarPagos(int IdPago) throws ClassNotFoundException, SQLException {

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("DELETE  FROM tblPagosERE IdPago =?");

            preparedStatement.setInt(1, IdPago);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void ModificarPagos(Pagos pago) throws ClassNotFoundException, SQLException {

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("UPDATE tblPagos SET "
                            + "FechaPago =  ISNULL(?, FechaPago), "
                            + "ValorPagadoArriendo= ISNULL(?, ValorPagadoArriendo), "
                            + "ValorInteres = ISNULL(?, ValorInteres), "
                            + "IdArriendo = ISNULL(?, IdArriendo) "
                            + "where IdPago= ISNULL(?, IdPago)");
            if (pago.FechaPago == null) {
                preparedStatement.setNull(1, Types.VARCHAR);
            }
            else{
                 preparedStatement.setString(1, pago.FechaPago);
            }
            
            if (pago.ValorPagadoArriendo == null) {
                preparedStatement.setNull(3, Types.INTEGER);
            }
            else{
                 preparedStatement.setInt(3, pago.ValorPagadoArriendo);
            }
            
            if (pago.ValorInteres == null) {
                preparedStatement.setNull(4, Types.INTEGER);
            }
            else{
                 preparedStatement.setInt(4, pago.ValorInteres);
            }
            if (pago.IdArriendo == null) {
                preparedStatement.setNull(5, Types.INTEGER);
            }
            else{
                 preparedStatement.setInt(5, pago.IdArriendo);
            }
            
            if (pago.IdPago == null) {
                preparedStatement.setNull(10, Types.INTEGER);
            }
            else{
                 preparedStatement.setInt(10, pago.IdPago);
            }
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Pagos> getPagos() throws ClassNotFoundException, SQLException {

        List<Pagos> pagos = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet resul = st.executeQuery("SELECT * FROM tblPagos");
        while (resul.next()) {
            Pagos pago = new Pagos();
            pago.setIdPago(resul.getInt("IdPago"));
            pago.setFechaPago(resul.getString("FechaPago"));
            pago.setValorPagadoArriendo(resul.getInt("ValorPagadoArriendo"));
            pago.setValorInteres(resul.getInt("ValorInteres"));
            pago.setIdArriendo(resul.getInt("IdArriendo"));
            pagos.add(pago);
        }

        return pagos;
    }

    public Pagos getPagos(int idPagos) throws ClassNotFoundException, SQLException {

        Pagos pago = new Pagos();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM tblPagos WHERE IdPago=?");
        ps.setInt(1, idPagos);
        ResultSet resul = ps.executeQuery();
        if (resul.next()) {
            pago.setIdArriendo(resul.getInt("IdPago"));
            pago.setFechaPago(resul.getString("FechaPago"));
            pago.setValorPagadoArriendo(resul.getInt("ValorPagadoArriendo"));
            pago.setValorInteres(resul.getInt("ValorInteres"));
            pago.setIdArriendo(resul.getInt("IdArriendo"));
        }

        return pago;
    }
    
}
