/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Usuario;
import Control.AccionesInv;

/**
 *
 * @author Emiliano
 */
public class registrarUsu extends HttpServlet {

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
            
            String nom,appat,apmat,fn,tel,cel,usu,pass;
            
            nom = request.getParameter("nombreUsu");
            appat = request.getParameter("appatUsu");
            apmat = request.getParameter("apmatUsu");
            fn = request.getParameter("fnUsu");
            tel = request.getParameter("telUsu");
            cel = request.getParameter("celUsu");
            usu = request.getParameter("usu");
            pass = request.getParameter("pass");
            
            Usuario objUsu = new Usuario();
            
            objUsu.setNom(nom);
            objUsu.setAppat(appat);
            objUsu.setApmat(apmat);
            objUsu.setFN(fn);
            objUsu.setTel(Integer.parseInt(tel));
            objUsu.setCel(Integer.parseInt(cel));
            objUsu.setUsu(usu);
            objUsu.setPass(pass);
            
            int estatus = AccionesInv.registrarUsuario(objUsu);
            
            
            if(estatus > 0){
                response.sendRedirect("inicioSesion.html");
            }else{
                response.sendRedirect("index.html");
            }
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

}
