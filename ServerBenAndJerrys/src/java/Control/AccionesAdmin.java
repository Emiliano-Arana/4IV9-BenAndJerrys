/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Emiliano
 */

import Modelo.TipoHelado;
import java.sql.*;
import java.util.*;

public class AccionesAdmin {
    
    public static int registrarSabor(TipoHelado sabor){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into ctipo_helado(sabor_tipohelado) "
                    + "values(?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, sabor.getTipoH());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de empleado exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public TipoHelado repetidosSabores(String sabor) throws ClassNotFoundException{
        TipoHelado objSab = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ctipo_helado where sabor_tipohelado = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, sabor);
            rs = ps.executeQuery();
            while(rs.next()){
                objSab = new TipoHelado();
                objSab.setId_tipoH(rs.getInt("id_tipohelado"));
                objSab.setTipoH(rs.getString("sabor_tipohelado"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objSab = null;
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(Exception e){
                System.out.println("No encontro la clase");
                System.out.println(e.getMessage());
            
            }
        }
        return objSab;
    }
}
