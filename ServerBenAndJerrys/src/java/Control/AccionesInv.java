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

import Modelo.Usuario;
import java.sql.*;
import java.util.*;

public class AccionesInv {
    public static int registrarUsuario(Usuario usu){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into musuario(nombre_usuario,appat_usuario,apmat_usuario,fecha_nacimiento_usuario,tel_usuario,cel_usuario,user_usuario,pass_usuario) "
                    + "values(?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, usu.getNom());
            ps.setString(2, usu.getAppat());
            ps.setString(3, usu.getApmat());
            ps.setString(4, usu.getFN());
            ps.setString(5, String.valueOf(usu.getTel()));
            ps.setString(6, String.valueOf(usu.getCel()));
            ps.setString(7, usu.getUsu());
            ps.setString(8, usu.getPass());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de empleado exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Usuario verificarEUsuario(String usu) throws ClassNotFoundException{
        Usuario objUsu = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from musuario where user_usuario = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, usu);
            rs = ps.executeQuery();
            while(rs.next()){
                objUsu = new Usuario();
                objUsu.setId_usu(rs.getInt("id_usuario"));
                objUsu.setNom(rs.getString("nombre_usuario"));
                objUsu.setAppat(rs.getString("appat_usuario"));
                objUsu.setApmat(rs.getString("apmat_usuario"));
                objUsu.setFN(rs.getString("fecha_nacimiento_usuario"));
                objUsu.setTel(rs.getInt("tel_usuario"));
                objUsu.setCel(rs.getInt("cel_usuario"));
                objUsu.setId_dir(rs.getInt("id_direccion"));
                objUsu.setId_tarjeta(rs.getInt("id_tarjeta"));
                objUsu.setUsu(rs.getString("user_usuario"));
                objUsu.setPass(rs.getString("pass_usuario"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objUsu = null;
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
        return objUsu;
    }
    
    public Usuario verificarUsuario(String usu, String pass) throws ClassNotFoundException{
        Usuario objUsu = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from musuario where user_usuario = ? AND pass_usuario = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, usu);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                objUsu = new Usuario();
                objUsu.setId_usu(rs.getInt("id_usuario"));
                objUsu.setNom(rs.getString("nombre_usuario"));
                objUsu.setAppat(rs.getString("appat_usuario"));
                objUsu.setApmat(rs.getString("apmat_usuario"));
                objUsu.setFN(rs.getString("fecha_nacimiento_usuario"));
                objUsu.setTel(rs.getInt("tel_usuario"));
                objUsu.setCel(rs.getInt("cel_usuario"));
                objUsu.setId_dir(rs.getInt("id_direccion"));
                objUsu.setId_tarjeta(rs.getInt("id_tarjeta"));
                objUsu.setUsu(rs.getString("user_usuario"));
                objUsu.setPass(rs.getString("pass_usuario"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objUsu = null;
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
        return objUsu;
    }
}
