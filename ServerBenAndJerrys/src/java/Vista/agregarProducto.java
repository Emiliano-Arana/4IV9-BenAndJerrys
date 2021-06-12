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
import Modelo.Producto;
import Control.AccionesAdmin;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emiliano
 */
public class agregarProducto extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String id_sab,id_promo,id_cant,id_tam,id_pre,stock,precio;
            
            id_sab = request.getParameter("sabor");
            id_promo = request.getParameter("promocion");
            id_cant = request.getParameter("cantidad");
            id_tam = request.getParameter("tamano");
            id_pre = request.getParameter("presentacion");
            stock = request.getParameter("stock");
            precio = request.getParameter("precio");
            
            AccionesAdmin acc = new AccionesAdmin();
            
            Producto busc = acc.repetidosProductos(id_sab,id_tam,id_pre);
            
                if(busc==null){
                    Producto objPro = new Producto();

                    objPro.setId_Tipo(Integer.parseInt(id_sab));
                    objPro.setId_promocion(Integer.parseInt(id_promo));
                    objPro.setId_cant(Integer.parseInt(id_cant));
                    objPro.setId_tam(Integer.parseInt(id_tam));
                    objPro.setId_presentacion(Integer.parseInt(id_pre));
                    objPro.setStock(Integer.parseInt(stock));
                    objPro.setPrecio(Float.parseFloat(precio));

                    int estatus = AccionesAdmin.registrarProducto(objPro);


                    if(estatus > 0){
                        response.sendRedirect("adminProductos.jsp?busc=false&filt=false");
                    }else{
                        response.sendRedirect("index.html");
                    }
                }else{
                    response.sendRedirect("adminProductos.jsp?busc=false&filt=false");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
