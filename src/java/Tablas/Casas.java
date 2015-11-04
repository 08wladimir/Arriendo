package Tablas;

public class Casas {

    public Integer IdInmueble;
    public String Direccion;
    public String Barrio;
    public Integer NHabitaciones;
    public Integer NPisos;
    public Integer Estrato;
    public Integer ValorOfrecido;
    public Integer IdPersonaDueno;
    public String Foto;
    public String Descripcion;

    public String Insertar() {

        String insertar = "INSERT INTO tblCasa VALUES (" + IdInmueble + ",'" + Direccion + "',"
                + "'" + Barrio + "'," + NHabitaciones + "," + NPisos + "," + Estrato + "," + ValorOfrecido + ","
                + IdPersonaDueno + ",'" + Foto + "','" + Descripcion + "')";

        return insertar;

    }

    public String Eliminar() {

        String eliminar = "DELETE  FROM tblCasa WHERE IdInmueble = " + IdInmueble;

        return eliminar;

    }

    public String Modificar() {

        String modificar = "UPDATE tblCasa SET IdInmueble = " + IdInmueble + ", "
                + "Direccion = '" + Direccion + "', Barrio= '" + Barrio + "', "
                + "NHabitaciones = " + NHabitaciones + ", NPisos = " + NPisos + ", "
                + "Estrato = " + Estrato + ", ValorOfrecido = " + ValorOfrecido + ", "
                + "IdPersonaDueno = " + IdPersonaDueno + ", Foto = '" + Foto + "', "
                + "Descripcion = '" + Descripcion + "' WHERE Identificacion = " + IdInmueble;

        return modificar;

    }

    public int getIdInmueble() {
        return IdInmueble;
    }

    public void setIdInmueble(int IdInmueble) {
        this.IdInmueble = IdInmueble;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }

    public int getNHabitantes() {
        return NHabitaciones;
    }

    public void setNHabitantes(int NHabitantes) {
        this.NHabitaciones = NHabitantes;
    }

    public int getNPisos() {
        return NPisos;
    }

    public void setNPisos(int NPisos) {
        this.NPisos = NPisos;
    }

    public int getEstrato() {
        return Estrato;
    }

    public void setEstrato(int Estrato) {
        this.Estrato = Estrato;
    }

    public int getValorOfrecido() {
        return ValorOfrecido;
    }

    public void setValorOfrecido(int ValorOfrecido) {
        this.ValorOfrecido = ValorOfrecido;
    }

    public int getIdPersonaDueno() {
        return IdPersonaDueno;
    }

    public void setIdPersonaDueno(int IdPersonaDueno) {
        this.IdPersonaDueno = IdPersonaDueno;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}
