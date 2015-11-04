package Crud;

import Utility.*;
import Tablas.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Wladimir
 */
public class CrudPersona {

    private Connection con;

    public CrudPersona() throws ClassNotFoundException, SQLException {
        con = Conexion.Conexion();
    }

    public void AgregarPersona(Personas persona) throws ClassNotFoundException, SQLException {

        String a = "INSERT INTO tblpersona "
                + "([Identificacion],[Nombre],[Apellido],[Celular],[Telefono],"
                + "[Correo],[Usuario],[Contrasena],[Rol])";

        try {

            PreparedStatement preparedStatement = con
                    .prepareStatement(a + " values (?,?,?,?,?,?,?,?,? )");

            preparedStatement.setInt(1, persona.Identificacion);
            preparedStatement.setString(2, persona.Nombre);
            preparedStatement.setString(3, persona.Apellido);
            preparedStatement.setString(4, persona.Celular);
            preparedStatement.setString(5, persona.Telefono);
            preparedStatement.setString(6, persona.Correo);
            preparedStatement.setString(7, persona.Usuario);
            preparedStatement.setString(8, persona.Contrasena);
            preparedStatement.setString(9, persona.Rol);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void EliminarPersona(int Identificacion) throws ClassNotFoundException, SQLException {

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("DELETE  FROM tblPersona WHERE Identificacion =?");

            preparedStatement.setInt(1, Identificacion);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void ModificarPersona(Personas persona) throws ClassNotFoundException, SQLException {

        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("UPDATE tblPersona SET "
                            + "Identificacion =  ISNULL(?, Identificacion ), "
                            + "Nombre= ISNULL(?, Nombre ), "
                            + "Apellido = ISNULL(?, Apellido ), "
                            + "Telefono = ISNULL(?, Telefono ), "
                            + "Correo = ISNULL(?, Correo ), "
                            + "Usuario = ISNULL(?, Usuario ), "
                            + "Contraseña = ISNULL(?, Contraseña ), "
                            + "Rol = ISNULL(?, Rol )"
                            + "where Identificacion= ISNULL(?, Identificacion )");
            if (persona.Identificacion == null) {
                preparedStatement.setNull(1, Types.INTEGER);
            } else {
                preparedStatement.setInt(1, persona.Identificacion);
            }

            if (persona.Nombre == null) {
                preparedStatement.setNull(2, Types.VARCHAR);
            } else {
                preparedStatement.setString(2, persona.Nombre);
            }

            if (persona.Apellido == null) {
                preparedStatement.setNull(3, Types.VARCHAR);
            } else {
                preparedStatement.setString(3, persona.Apellido);
            }

            if (persona.Celular == null) {
                preparedStatement.setNull(4, Types.VARCHAR);
            } else {
                preparedStatement.setString(4, persona.Celular);
            }
            if (persona.Telefono == null) {
                preparedStatement.setNull(5, Types.VARCHAR);
            } else {
                preparedStatement.setString(5, persona.Telefono);
            }
            if (persona.Correo == null) {
                preparedStatement.setNull(6, Types.VARCHAR);
            } else {
                preparedStatement.setString(6, persona.Correo);
            }

            if (persona.Usuario == null) {
                preparedStatement.setNull(7, Types.VARCHAR);
            } else {
                preparedStatement.setString(7, persona.Usuario);
            }

            if (persona.Contrasena == null) {
                preparedStatement.setNull(8, Types.VARCHAR);
            } else {
                preparedStatement.setString(8, persona.Contrasena);
            }

            if (persona.Rol == null) {
                preparedStatement.setNull(9, Types.VARCHAR);
            } else {
                preparedStatement.setString(9, persona.Rol);
            }
            if (persona.Identificacion == null) {
                preparedStatement.setNull(10, Types.INTEGER);
            } else {
                preparedStatement.setInt(10, persona.Identificacion);
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Personas> getPersonas() throws ClassNotFoundException, SQLException {

        List<Personas> personas = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet resul = st.executeQuery("SELECT * FROM tblPersona");
        while (resul.next()) {
            Personas persona = new Personas();
            persona.setIdentificacion(resul.getInt("Identificacion"));
            persona.setNombre(resul.getString("Nombre"));
            persona.setApellido(resul.getString("Apellido"));
            persona.setCelular(resul.getString("Celular"));
            persona.setTelefono(resul.getString("Telefono"));
            persona.setCorreo(resul.getString("Correo"));
            persona.setUsuario(resul.getString("Usuario"));
            persona.setContrasena(resul.getString("Contrasena"));
            persona.setRol(resul.getString("Rol"));
            personas.add(persona);
        }

        return personas;
    }
    
    public List<Personas> getPersonas(String p) throws ClassNotFoundException, SQLException {

        List<Personas> personas = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet resul = st.executeQuery("SELECT * FROM tblPersona WHERE Rol = '"+ p+"'");
        while (resul.next()) {
            Personas persona = new Personas();
            persona.setIdentificacion(resul.getInt("Identificacion"));
            persona.setNombre(resul.getString("Nombre"));
            persona.setApellido(resul.getString("Apellido"));
            persona.setCelular(resul.getString("Celular"));
            persona.setTelefono(resul.getString("Telefono"));
            persona.setCorreo(resul.getString("Correo"));
            persona.setUsuario(resul.getString("Usuario"));
            persona.setContrasena(resul.getString("Contrasena"));
            persona.setRol(resul.getString("Rol"));
            personas.add(persona);
        }

        return personas;
    }

    public Personas getPersona(int Identificacion) throws ClassNotFoundException, SQLException {

        Personas persona = new Personas();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM tblPersona WHERE Identificacion=?");
        ps.setInt(1, Identificacion);
        ResultSet resul = ps.executeQuery();
        if (resul.next()) {
            persona.setIdentificacion(resul.getInt("Identificacion"));
            persona.setNombre(resul.getString("Nombre"));
            persona.setApellido(resul.getString("Apellido"));
            persona.setCelular(resul.getString("Celular"));
            persona.setTelefono(resul.getString("Telefono"));
            persona.setCorreo(resul.getString("Correo"));
            persona.setUsuario(resul.getString("Usuario"));
            persona.setContrasena(resul.getString("Contrasena"));
            persona.setRol(resul.getString("Rol"));
        }

        return persona;
    }

}
