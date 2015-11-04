package Tablas;

public class Arriendo {

    public Integer IdArriendo;
    public String FechaIngreso;
    public Integer PermanenciaMinima;
    public Integer PorcentajeInteresMora;
    public Integer Renta;
    public Integer DiaCorte;
    public Integer IdInquilino;
    public Integer IdCasa;
    public String Estado;

    public String Insertar() {

        String insertar = "INSERT INTO tblCasa VALUES (" + IdArriendo + ",'" + FechaIngreso + "', "
                + PermanenciaMinima + "," + PorcentajeInteresMora + "," + Renta + "," + DiaCorte + "," + IdInquilino + ","
                + IdCasa + ",'" + Estado + "')";

        return insertar;

    }

    public String Eliminar() {

        String eliminar = "DELETE  FROM tblCasa WHERE IdInmueble = " + IdArriendo;

        return eliminar;

    }

    public String Modificar() {

        String modificar = "UPDATE tblCasa SET IdAriendo = " + IdArriendo + ", "
                + "FechaIngreso = '" + FechaIngreso + "', PermaneciaMinima= " + PermanenciaMinima + ", "
                + "PorcentajeInteresMora = " + PorcentajeInteresMora + ", Renta = " + Renta + ", "
                + "DiaCorte = " + DiaCorte + ", IdInquilino = " + IdInquilino + ", "
                + "IdCasa = " + IdCasa + ", Casa = '" + Estado + "' "
                + "WHERE Identificacion = " + IdArriendo;

        return modificar;

    }

    public int getIdArriendo() {
        return IdArriendo;
    }

    public void setIdArriendo(int IdArriendo) {
        this.IdArriendo = IdArriendo;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public int getPermanenciaMinima() {
        return PermanenciaMinima;
    }

    public void setPermanenciaMinima(int PermanenciaMinima) {
        this.PermanenciaMinima = PermanenciaMinima;
    }

    public int getPorcentajeInteresMora() {
        return PorcentajeInteresMora;
    }

    public void setPorcentajeInteresMora(int PorcentajeInteresMora) {
        this.PorcentajeInteresMora = PorcentajeInteresMora;
    }

    public int getRenta() {
        return Renta;
    }

    public void setRenta(int Renta) {
        this.Renta = Renta;
    }

    public int getDiaCorte() {
        return DiaCorte;
    }

    public void setDiaCorte(int DiaCorte) {
        this.DiaCorte = DiaCorte;
    }

    public int getIdInquilino() {
        return IdInquilino;
    }

    public void setIdInquilino(int IdInquilino) {
        this.IdInquilino = IdInquilino;
    }

    public int getIdCasa() {
        return IdCasa;
    }

    public void setIdCasa(int idCasa) {
        this.IdCasa = idCasa;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
