/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class CasaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CrudCasa crud = new CrudCasa();

    public CasaController() throws ClassNotFoundException, SQLException {
        crud = new CrudCasa();
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
            List<Casas> casas = new ArrayList<>();
            String action = (String) request.getParameter("action");
            Gson gson = new Gson();
            response.setContentType("application/json");

            switch (action) {
                case "list":
                    try {
                        //Fetch Data from User Table
                        casas = crud.getCasas();
                        //Convert Java Object to Json
                        JsonElement element = gson.toJsonTree(casas, new TypeToken<List<Casas>>() {
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
                    Casas casa = new Casas();
                    if (request.getParameter("IdInmueble") != null) {
                        int IdInmueble = Integer.parseInt(request.getParameter("IdInmueble"));
                        casa.setIdInmueble(IdInmueble);
                    }
                    if (request.getParameter("Direccion") != null) {
                        String Direccion = (String) request.getParameter("Direccion");
                        casa.setDireccion(Direccion);
                    }
                    if (request.getParameter("Barrio") != null) {
                        String Barrio = (String) request.getParameter("Barrio");
                        casa.setBarrio(Barrio);
                    }
                    if (request.getParameter("NHabitaciones") != null) {
                        int NHabitaciones = Integer.parseInt(request.getParameter("NHabitaciones"));
                        casa.setNHabitantes(NHabitaciones);
                    }
                    if (request.getParameter("NPisos") != null) {
                        int NPisos = Integer.parseInt(request.getParameter("NPisos"));
                        casa.setNPisos(NPisos);
                    }
                    if (request.getParameter("Estrato") != null) {
                        int Estrato = Integer.parseInt(request.getParameter("Estrato"));
                        casa.setEstrato(Estrato);
                    }
                    if (request.getParameter("ValorOfrecido") != null) {
                        int ValorOfrecido = Integer.parseInt(request.getParameter("ValorOfrecido"));
                        casa.setValorOfrecido(ValorOfrecido);
                    }
                    if (request.getParameter("IdPersonaDueno") != null) {
                        int IdPersonaDueno = Integer.parseInt(request.getParameter("IdPersonaDueno"));
                        casa.setIdPersonaDueno(IdPersonaDueno);
                    }
                    if (request.getParameter("Foto") != null) {
                        String Foto = (String) request.getParameter("Foto");
                        casa.setFoto(Foto);
                    }
                    if (request.getParameter("Descripcion") != null) {
                        String Descripcion = (String) request.getParameter("Descripcion");
                        casa.setDescripcion(Descripcion);
                    }
                    try {
                        switch (action) {
                            case "create": {
                                //Create new record
                                crud.AgregarCasa(casa);
                                casas.add(casa);
                                //Convert Java Object to Json
                                String json = gson.toJson(casa);
                                //Return Json in the format required by jTable plugin
                                String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
                                response.getWriter().print(listData);
                                break;
                            }
                            case "update": {
                                //Update existing record
                                crud.ModificarCasa(casa);
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
                        if (request.getParameter("IdInmueble") != null) {
                            String IdInmueble = (String) request.getParameter("IdInmueble");
                            crud.EliminarCasa(Integer.parseInt(IdInmueble));
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
