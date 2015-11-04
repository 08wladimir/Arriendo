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
public class ArriendoController extends HttpServlet{

    private static final long serialVersionUID = 1L;
    private CrudArriendo crud = new CrudArriendo();

    public ArriendoController() throws ClassNotFoundException, SQLException {
        crud = new CrudArriendo();
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
            List<Arriendo> arriendos = new ArrayList<>();
            String action = (String) request.getParameter("action");
            Gson gson = new Gson();
            response.setContentType("application/json");

            switch (action) {
                case "list":
                    try {
                        //Fetch Data from User Table
                        arriendos = crud.getArriendo();
                        //Convert Java Object to Json
                        JsonElement element = gson.toJsonTree(arriendos, new TypeToken<List<Arriendo>>() {
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
                    Arriendo arriendo = new Arriendo();
                    if (request.getParameter("IdArriendo") != null) {
                        int IdArriendo = Integer.parseInt(request.getParameter("IdArriendo"));
                        arriendo.setIdArriendo(IdArriendo);
                    }
                    if (request.getParameter("FechaIngreso") != null) {
                        String FechaIngreso = (String) request.getParameter("FechaIngreso");
                        arriendo.setFechaIngreso(FechaIngreso);
                    }
                    if (request.getParameter("PermanenciaMinima") != null) {
                        int PermanenciaMinima = Integer.parseInt(request.getParameter("PermanenciaMinima"));
                        arriendo.setPermanenciaMinima(PermanenciaMinima);
                    }
                    if (request.getParameter("PorcentajeInteresMora") != null) {
                        int PorcentajeInteresMora = Integer.parseInt(request.getParameter("PorcentajeInteresMora"));
                        arriendo.setPorcentajeInteresMora(PorcentajeInteresMora);
                    }
                    if (request.getParameter("Renta") != null) {
                        int Renta = Integer.parseInt(request.getParameter("Renta"));
                        arriendo.setRenta(Renta);
                    }
                    if (request.getParameter("DiaCorte") != null) {
                        int DiaCorte = Integer.parseInt(request.getParameter("DiaCorte"));
                        arriendo.setDiaCorte(DiaCorte);
                    }
                    if (request.getParameter("IdInquilino") != null) {
                        int IdInquilino = Integer.parseInt(request.getParameter("IdInquilino"));
                        arriendo.setIdInquilino(IdInquilino);
                    }
                    if (request.getParameter("IdCasa") != null) {
                        int IdCasa = Integer.parseInt(request.getParameter("IdCasa"));
                        arriendo.setIdCasa(IdCasa);
                    }
                    if (request.getParameter("Estado") != null) {
                        String Estado = (String) request.getParameter("Estado");
                        arriendo.setEstado(Estado);
                    }

                    try {
                        switch (action) {
                            case "create": {
                                //Create new record
                                crud.AgregarArriendo(arriendo);
                                arriendos.add(arriendo);
                                //Convert Java Object to Json
                                String json = gson.toJson(arriendo);
                                //Return Json in the format required by jTable plugin
                                String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
                                response.getWriter().print(listData);
                                break;
                            }
                            case "update": {
                                //Update existing record
                                crud.ModificarArriendo(arriendo);
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
                        if (request.getParameter("IdArriendo") != null) {
                            String IdArriendo = (String) request.getParameter("IdArriendo");
                            crud.EliminarPersona(Integer.parseInt(IdArriendo));
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
