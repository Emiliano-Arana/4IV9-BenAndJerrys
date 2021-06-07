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

import Modelo.*;
import java.sql.*;
import java.util.*;

public class AccionesAdmin {
    
    //Catalogo Sabores
    
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
    
    public static int eliminarSabor(int sabor){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from ctipo_helado where id_tipohelado = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(sabor));
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminar sabor exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar sabor");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public TipoHelado recogerSabor(int id) throws ClassNotFoundException{
        TipoHelado objSab = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ctipo_helado where id_tipohelado = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
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

    public static int actualizarSabor(TipoHelado sabor){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "update ctipo_helado set sabor_tipohelado = ?"
                    + " where id_tipohelado = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, sabor.getTipoH());
            ps.setString(2, String.valueOf(sabor.getId_tipoH()));
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion sabor exitosa");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar el sabor");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    //Catalogo Presentaciones
    
    public static int registrarPresentacion(Presentacion pre){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into cpresentacion(tipo_presentacion) "
                    + "values(?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, pre.getPresentacion());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de presentacion exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar la presentacion");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Presentacion repetidosPresentaciones(String pre) throws ClassNotFoundException{
        Presentacion objPre = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cpresentacion where tipo_presentacion = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, pre);
            rs = ps.executeQuery();
            while(rs.next()){
                objPre = new Presentacion();
                objPre.setId_presentacion(rs.getInt("id_presentacion"));
                objPre.setPresentacion(rs.getString("tipo_presentacion"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objPre = null;
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
        return objPre;
    }
    
    public static int eliminarPresentacion(int pre){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from cpresentacion where id_presentacion = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(pre));
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminar presentacion exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar presentacion");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Presentacion recogerPresentacion(int id) throws ClassNotFoundException{
        Presentacion objPre = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cpresentacion where id_presentacion = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            while(rs.next()){
                objPre = new Presentacion();
                objPre.setId_presentacion(rs.getInt("id_presentacion"));
                objPre.setPresentacion(rs.getString("tipo_presentacion"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objPre = null;
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
        return objPre;
    }

    public static int actualizarPresentacion(Presentacion pre){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "update cpresentacion set tipo_presentacion = ?"
                    + " where id_presentacion = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, pre.getPresentacion());
            ps.setString(2, String.valueOf(pre.getId_presentacion()));
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion presentacion exitosa");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar la presentacion");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    //Catalogo Tamanos
    
    public static int registrarTamano(Tamano tam){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into ctamano(nombre_tamano) "
                    + "values(?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, tam.getTam());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de empleado exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Tamano repetidosTamanos(String tam) throws ClassNotFoundException{
        Tamano objTam = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ctamano where nombre_tamano = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, tam);
            rs = ps.executeQuery();
            while(rs.next()){
                objTam = new Tamano();
                objTam.setId_tam(rs.getInt("id_tamano"));
                objTam.setTam(rs.getString("nombre_tamano"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objTam = null;
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
        return objTam;
    }
}
