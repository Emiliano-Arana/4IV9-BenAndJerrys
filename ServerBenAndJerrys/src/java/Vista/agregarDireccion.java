/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.AccionesUsu;
import Modelo.Direccion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adrai
 */
public class agregarDireccion extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String id_alc, id_col, num_ext, num_int, calle;
            
            calle = request.getParameter("Calle");
            num_ext = request.getParameter("noExt");
            num_int = request.getParameter("noInt");
            id_alc = request.getParameter("alcaldia");
            id_col = request.getParameter("colonia");
            
            AccionesUsu acc = new AccionesUsu();
            
            Direccion busc = acc.registrarDireccion(dir);
            
                if(busc==null){
                    Direccion objDir = new Direccion();

                    objDir.setCalle(calle);
                    objDir.setNum_ext(Integer.parseInt(num_ext));
                    objDir.setNum_int(Integer.parseInt(num_int));
                    objDir.setId_alc(id_alc);
                    objDir.setId_col(id_col);

                    int estatus = AccionesUsu.registrarDireccion(objDir);


                    if(estatus > 0){
                        response.sendRedirect("cPresentaciones.jsp?act=false");
                    }else{
                        response.sendRedirect("cPresentaciones.jsp?act=false");
                    }
                }else{
                    response.sendRedirect("cPresentaciones.jsp?act=false");
        }   }
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

}
