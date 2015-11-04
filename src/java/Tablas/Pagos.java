package Tablas;

public class Pagos {
    
    public Integer IdPago;
    public String FechaPago;
    public Integer ValorPagadoArriendo;
    public Integer ValorInteres;
    public Integer IdArriendo;

    public String Insertar() {

        String insertar = "INSERT INTO tblCasa VALUES (" + IdPago + ",'" + FechaPago + "', "
                + ValorPagadoArriendo + "," + ValorInteres + "," + IdArriendo + ")";

        return insertar;

    }

    public String Eliminar() {

        String eliminar = "DELETE  FROM tblCasa WHERE IdInmueble = " + IdPago;

        return eliminar;

    }

    public String Modificar() {

        String modificar = "UPDATE tblCasa SET IdPago = " + IdPago + ", "
                + "FechaPago = '" + FechaPago + "', "
                + "ValorPagadoArriendo= " + ValorPagadoArriendo + ", "
                + "ValorInteres = " + ValorInteres + ", "
                + "IdArriendo = " + IdArriendo + " "
                + "WHERE Identificacion = " + IdPago;

        return modificar;

    }
    
    public int getIdPago() {
        return IdPago;
    }

    public void setIdPago(int IdPago) {
        this.IdPago = IdPago;
    }

    public String getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(String FechaPago) {
        this.FechaPago = FechaPago;
    }

    public int getValorPagadoArriendo() {
        return ValorPagadoArriendo;
    }

    public void setValorPagadoArriendo(int ValorPagadoArriendo) {
        this.ValorPagadoArriendo = ValorPagadoArriendo;
    }

    public int getValorInteres() {
        return ValorInteres;
    }

    public void setValorInteres(int ValorInteres) {
        this.ValorInteres = ValorInteres;
    }

    public int getIdArriendo() {
        return IdArriendo;
    }

    public void setIdArriendo(int IdArriendo) {
        this.IdArriendo = IdArriendo;
    }

}
