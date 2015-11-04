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
public class PersonaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CrudPersona crud = new CrudPersona();

    public PersonaController() throws ClassNotFoundException, SQLException {
        crud = new CrudPersona();
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
            List<Personas> personas = new ArrayList<>();
            String action = (String) request.getParameter("action");
            Gson gson = new Gson();
            response.setContentType("application/json");

            switch (action) {
                case "administrador":
                    try {
                        //Fetch Data from User Table
                        String a = "Administrador";
                        personas = crud.getPersonas(a);
                        //Convert Java Object to Json
                        JsonElement element = gson.toJsonTree(personas, new TypeToken<List<Personas>>() {
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
                case "dueno":
                    try {
                        //Fetch Data from User Table
                        String a = "Propietario";
                        personas = crud.getPersonas(a);
                        //Convert Java Object to Json
                        JsonElement element = gson.toJsonTree(personas, new TypeToken<List<Personas>>() {
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
                case "vendedor":
                    try {
                        //Fetch Data from User Table
                        String a = "Vendedor";
                        personas = crud.getPersonas(a);
                        //Convert Java Object to Json
                        JsonElement element = gson.toJsonTree(personas, new TypeToken<List<Personas>>() {
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
                case "list":
                    try {
                        //Fetch Data from User Table
                        personas = crud.getPersonas();
                        //Convert Java Object to Json
                        JsonElement element = gson.toJsonTree(personas, new TypeToken<List<Personas>>() {
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
                    Personas persona = new Personas();
                    if (request.getParameter("Identificacion") != null) {
                        int Identificacion = Integer.parseInt(request.getParameter("Identificacion"));
                        persona.setIdentificacion(Identificacion);
                    }
                    if (request.getParameter("Nombre") != null) {
                        String Nombre = (String) request.getParameter("Nombre");
                        persona.setNombre(Nombre);
                    }
                    if (request.getParameter("Apellido") != null) {
                        String Apellido = (String) request.getParameter("Apellido");
                        persona.setApellido(Apellido);
                    }
                    if (request.getParameter("Celular") != null) {
                        String Celular = (String) request.getParameter("Celular");
                        persona.setCelular(Celular);
                    }
                    if (request.getParameter("Telefono") != null) {
                        String Telefono = (String) request.getParameter("Telefono");
                        persona.setTelefono(Telefono);
                    }
                    if (request.getParameter("Correo") != null) {
                        String Correo = (String) request.getParameter("Correo");
                        persona.setCorreo(Correo);
                    }
                    if (request.getParameter("Usuario") != null) {
                        String Usuario = (String) request.getParameter("Usuario");
                        persona.setUsuario(Usuario);
                    }
                    if (request.getParameter("Contrasena") != null) {
                        String Contrasena = (String) request.getParameter("Contrasena");
                        persona.setContrasena(Contrasena);
                    }
                    if (request.getParameter("Rol") != null) {
                        String Rol = (String) request.getParameter("Rol");
                        persona.setRol(Rol);
                    }

                    try {
                        switch (action) {
                            case "create": {
                                //Create new record
                                crud.AgregarPersona(persona);
                                personas.add(persona);
                                //Convert Java Object to Json
                                String json = gson.toJson(persona);
                                //Return Json in the format required by jTable plugin
                                String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
                                response.getWriter().print(listData);
                                break;
                            }
                            case "update": {
                                //Update existing record
                                crud.ModificarPersona(persona);
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
                        if (request.getParameter("Identificacion") != null) {
                            String IdInmueble = (String) request.getParameter("Identificacion");
                            crud.EliminarPersona(Integer.parseInt(IdInmueble));
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
