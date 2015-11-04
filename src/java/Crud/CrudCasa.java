package Crud;

import Utility.*;
import Tablas.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Wladimir
 */
public class CrudCasa {

    private Connection con;

    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public CrudCasa() throws ClassNotFoundException, SQLException {
        con = Conexion.Conexion();
    }

    public void AgregarCasa(Casas casa) throws ClassNotFoundException, SQLException {

        String a = "INSERT INTO [dbo].[tblCasa]"
                + "([Direccion],[Barrio],[NHabitaciones],[NPisos],"
                + "[Estrato],[ValorOfrecido],[IdPersonaDueno],"
                + "[Foto],[Descripcion])";

        try {

            PreparedStatement preparedStatement = con
                    .prepareStatement(a + " values (?,?,?,?,?,?,?,?,? )");

            preparedStatement.setString(1, casa.Direccion);
            preparedStatement.setString(2, casa.Barrio);
            preparedStatement.setInt(3, (int)casa.NHabitaciones);
            preparedStatement.setInt(4, (int)casa.NPisos);
            preparedStatement.setInt(5, (int)casa.Estrato);
            preparedStatement.setInt(6, (int)casa.ValorOfrecido);
            preparedStatement.setInt(7, (int)casa.IdPersonaDueno);
            preparedStatement.setNull(8, Types.VARBINARY);
            preparedStatement.setString(9, casa.Descripcion);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void EliminarCasa(int IdInmueble) throws ClassNotFoundException, SQLException {

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("DELETE  FROM tblCasa WHERE IdInmueble =?");

            preparedStatement.setInt(1, IdInmueble);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void ModificarCasa(Casas casa) throws ClassNotFoundException, SQLException {

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("UPDATE tblCasa SET "
                            + "Direccion =  ISNULL(?, Direccion ), "
                            + "Barrio= ISNULL(?, Barrio ), "
                            + "NHabitaciones = ISNULL(?, NHabitaciones ), "
                            + "NPisos = ISNULL(?, NPisos ), "
                            + "Estrato = ISNULL(?, Estrato ), "
                            + "ValorOfrecido = ISNULL(?, ValorOfrecido ), "
                            + "IdPersonaDueno = ISNULL(?, IdPersonaDueno ), "
                            + "Foto = ISNULL(?, Foto ), "
                            + "Descripcion = ISNULL(?, Descripcion )"
                            + "where IdInmueble= ISNULL(?, IdInmueble )");
            if (casa.Direccion == null) {
                preparedStatement.setNull(1, Types.VARCHAR);
            }
            else{
                 preparedStatement.setString(1, casa.Direccion);
            }
           
            if (casa.Barrio == null) {
                preparedStatement.setNull(2, Types.VARCHAR);
            }
            else{
                 preparedStatement.setString(2, casa.Barrio);
            }
            
            if (casa.NHabitaciones == null) {
                preparedStatement.setNull(3, Types.INTEGER);
            }
            else{
                 preparedStatement.setInt(3, casa.NHabitaciones);
            }
            
            if (casa.NPisos == null) {
                preparedStatement.setNull(4, Types.INTEGER);
            }
            else{
                 preparedStatement.setInt(4, casa.NPisos);
            }
            if (casa.Estrato == null) {
                preparedStatement.setNull(5, Types.INTEGER);
            }
            else{
                 preparedStatement.setInt(5, casa.Estrato);
            }
            if (casa.ValorOfrecido == null) {
                preparedStatement.setNull(6, Types.INTEGER);
            }
            else{
                 preparedStatement.setInt(6, casa.ValorOfrecido);
            }
            
            if (casa.IdPersonaDueno == null) {
                preparedStatement.setNull(7, Types.INTEGER);
            }
            else{
                 preparedStatement.setInt(7, casa.IdPersonaDueno);
            }
            
            if (casa.Foto == null) {
                preparedStatement.setNull(8, Types.VARBINARY);
            }
            else{
                 preparedStatement.setNull(8, Types.VARBINARY);
            }
            
            if (casa.Descripcion == null) {
                preparedStatement.setNull(9, Types.VARCHAR);
            }
            else{
                 preparedStatement.setString(9, casa.Descripcion);
            }
            if (casa.IdInmueble == null) {
                preparedStatement.setNull(10, Types.INTEGER);
            }
            else{
                 preparedStatement.setInt(10, casa.IdInmueble);
            }
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Casas> getCasas() throws ClassNotFoundException, SQLException {

        List<Casas> casas = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet resul = st.executeQuery("SELECT * FROM tblCasa");
        while (resul.next()) {
            Casas casa = new Casas();
            casa.setIdInmueble(resul.getInt("IdInmueble"));
            casa.setDireccion(resul.getString("Direccion"));
            casa.setBarrio(resul.getString("Barrio"));
            casa.setNHabitantes(resul.getInt("NHabitaciones"));
            casa.setNPisos(resul.getInt("NPisos"));
            casa.setEstrato(resul.getInt("Estrato"));
            casa.setValorOfrecido(resul.getInt("ValorOfrecido"));
            casa.setIdPersonaDueno(resul.getInt("IdPersonaDueno"));
            casa.setFoto(resul.getString("Foto"));
            casa.setDescripcion(resul.getString("Descripcion"));
            casas.add(casa);
        }

        return casas;
    }

    public Casas getCasa(int idCasa) throws ClassNotFoundException, SQLException {

        Casas casa = new Casas();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM tblCasa WHERE IdInmueble=?");
        ps.setInt(1, idCasa);
        ResultSet resul = ps.executeQuery();
        if (resul.next()) {
            casa.setIdInmueble(resul.getInt("IdInmueble"));
            casa.setDireccion(resul.getString("Direccion"));
            casa.setBarrio(resul.getString("Barrio"));
            casa.setNHabitantes(resul.getInt("NHabitaciones"));
            casa.setNPisos(resul.getInt("NPisos"));
            casa.setEstrato(resul.getInt("Estrato"));
            casa.setValorOfrecido(resul.getInt("ValorOfrecido"));
            casa.setIdPersonaDueno(resul.getInt("IdPersonaDueno"));
            casa.setFoto(resul.getString("Foto"));
            casa.setDescripcion(resul.getString("Descripcion"));
        }

        return casa;
    }

}
