package Tablas;

import java.sql.*;

public class Personas {

    public Integer Identificacion;
    public String Nombre;
    public String Apellido;
    public String Celular;
    public String Telefono;
    public String Correo;
    public String Usuario;
    public String Contrasena;
    public String Rol;

    public String Insertar() {

        String insertar = "INSERT INTO tblPersona VALUES (" + Identificacion + ",'" + Nombre + "',"
                + "'" + Apellido + "','" + Celular + "','" + Telefono + "','" + Correo + "','" + Usuario + "',"
                + "'" + Contrasena + "','" + Rol + "')";

        return insertar;

    }

    public String Eliminar() {

        String eliminar = "DELETE  FROM tblPersona WHERE Identificacion = " + Identificacion;

        return eliminar;

    }

    public String Modificar() {

        String modificar = "UPDATE tblPersonas SET Identificacion = " + Identificacion + ", "
                + "Nombre = '" + Nombre + "', Apellido= '" + Apellido + "', "
                + "Celular = '" + Celular + "', Telefono = '" + Telefono + "', "
                + "Correo = '" + Correo + "', Usuario = '" + Usuario + "', "
                + "Contrasena = '" + Contrasena + "', Rol = '" + Rol + "' "
                + "WHERE Identificacion = " + Identificacion;

        return modificar;

    }

    public String Login(Connection con, String usu, String cont) throws SQLException {

        Statement statement = con.createStatement();
        ResultSet resultado = statement.executeQuery("SELECT * FROM tblPersona "
                + "WHERE Usuario ='" + usu + "'and Contrasena = '" + cont + "' ");
        String rol = "Vacio";
        String pagina = "a";
        if (resultado.next()) {
            rol = resultado.getString("Rol");
        }

        switch (rol) {
            case "Administrador":
                pagina = "AAdministrador";
                break;
            case "Vendedor":
                pagina = "VArriendos";
                break;
            case "Propietario":
                pagina = "DCasas";
                break;
            default:
                pagina = "Error";
                break;
        }

        return pagina;

    }

    public int getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(int Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

}
