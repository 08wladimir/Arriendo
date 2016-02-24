/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utility.Correo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import pago.*;


/**
 *
 * @author Wladimir
 */
@WebServlet(name = "PagoEnLinea", urlPatterns = {"/PagoEnLinea"})
public class PagoEnLinea extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PagoEnLinea/PagoEnLinea.wsdl")
    private PagoEnLinea_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String respuesta;
        respuesta = enviar(
                request.getParameter("descripcion"),
                request.getParameter("refVenta"),
                request.getParameter("moneda"),
                request.getParameter("valor"),
                request.getParameter("prueba"),
                request.getParameter("usuarioId"),
                request.getParameter("nombre"),
                request.getParameter("identificacion"),
                request.getParameter("email"),
                request.getParameter("tarjeta"),
                request.getParameter("numeroCuenta"));

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Correo c = new Correo();
            c.enviar("Su pago a sido exitoso","wrodriguez@unac.edu.co" , "Pago");
            String r = null;
            
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            
            out.println("<title>Servlet PagoEnLinea</title>");
            out.println("</head>");
            out.println("<body background =\"http://www.csd.cl/fondo%20gris.jpg\">");
            out.println("<header>");
            out.println("<center><img src=\"Imagenes/Header2.png\"></center>");
            out.println("<h1>Servlet PagoEnLinea at </h1>");
            out.println("<h2>" + respuesta + "</h2>");
            out.println("<label>Valor: " + request.getParameter("valor") + "</label>");
            out.println("</header>");
            out.println("</body>");
            out.println("</html>");
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String enviar(java.lang.String descripcion, java.lang.String refVenta, java.lang.String moneda, java.lang.String valor, java.lang.String prueba, java.lang.String usuarioId, java.lang.String nombre, java.lang.String identificacion, java.lang.String email, java.lang.String tarjeta, java.lang.String numeroCuenta) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pago.PagoEnLinea port = service.getPagoEnLineaPort();
        return port.enviar(descripcion, refVenta, moneda, valor, prueba, usuarioId, nombre, identificacion, email, tarjeta, numeroCuenta);
    }

}
