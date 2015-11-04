
package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import Crud.*;
import Tablas.*;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author Wladimir
 */
public class PagosController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private CrudPagos crud = new CrudPagos();

    public PagosController() throws ClassNotFoundException, SQLException {
        crud = new CrudPagos();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action") != null) {
            List<Pagos> pagos = new ArrayList<>();
            String action = (String) request.getParameter("action");
            Gson gson = new Gson();
            response.setContentType("application/json");

            switch (action) {
                case "list":
                    try {
                        //Fetch Data from User Table
                        pagos = crud.getPagos();
                        //Convert Java Object to Json
                        JsonElement element = gson.toJsonTree(pagos, new TypeToken<List<Pagos>>() {
                        }.getType());
                        JsonArray jsonArray = element.getAsJsonArray();
                        String listData = jsonArray.toString();
                        //Return Json in the format required by jTable plugin
                        listData = "{\"Result\":\"OK\",\"Records\":" + listData + "}";
                        response.getWriter().print(listData);
                    } catch (ClassNotFoundException | SQLException | IOException ex) {
                        String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getMessage() + "}";
                        response.getWriter().print(error);
                        ex.printStackTrace();
                    }
                    break;
                case "create":
                case "update":
                    Pagos pago = new Pagos();
                    if (request.getParameter("IdPago") != null) {
                        int IdPago = Integer.parseInt(request.getParameter("IdPago"));
                        pago.setIdPago(IdPago);
                    }
                    if (request.getParameter("FechaPago") != null) {
                        String FechaPago = (String) request.getParameter("FechaPago");
                        pago.setFechaPago(FechaPago);
                    }
                    if (request.getParameter("ValorPagadoArriendo") != null) {
                        int ValorPagadoArriendo = Integer.parseInt(request.getParameter("ValorPagadoArriendo"));
                        pago.setValorPagadoArriendo(ValorPagadoArriendo);
                    }
                    if (request.getParameter("ValorInteres") != null) {
                        int ValorInteres = Integer.parseInt(request.getParameter("ValorInteres"));
                        pago.setValorInteres(ValorInteres);
                    }
                    if (request.getParameter("IdArriendo") != null) {
                        int IdArriendo = Integer.parseInt(request.getParameter("IdArriendo"));
                        pago.setIdArriendo(IdArriendo);
                    }
                    try {
                        switch (action) {
                            case "create": {
                                //Create new record
                                crud.AgregarPagos(pago);
                                pagos.add(pago);
                                //Convert Java Object to Json
                                String json = gson.toJson(pago);
                                //Return Json in the format required by jTable plugin
                                String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
                                response.getWriter().print(listData);
                                break;
                            }
                            case "update": {
                                //Update existing record
                                crud.ModificarPagos(pago);
                                String listData = "{\"Result\":\"OK\"}";
                                response.getWriter().print(listData);
                                break;
                            }
                        }
                    } catch (ClassNotFoundException | SQLException | IOException ex) {
                        String error = "{\"Result\":\"ERROR\",\"Message\":" + Arrays.toString(ex.getStackTrace()) + "}";
                        response.getWriter().print(error);
                    }
                    break;
                case "delete":
                    //Delete record
                    try {
                        if (request.getParameter("IdPago") != null) {
                            String IdInmueble = (String) request.getParameter("IdPago");
                            crud.EliminarPagos(Integer.parseInt(IdInmueble));
                            String listData = "{\"Result\":\"OK\"}";
                            response.getWriter().print(listData);
                        }
                    } catch (NumberFormatException | ClassNotFoundException | SQLException | IOException ex) {
                        String error = "{\"Result\":\"ERROR\",\"Message\":" + Arrays.toString(ex.getStackTrace()) + "}";
                        response.getWriter().print(error);
                    }
                    break;
            }
        }
    }
    
}
