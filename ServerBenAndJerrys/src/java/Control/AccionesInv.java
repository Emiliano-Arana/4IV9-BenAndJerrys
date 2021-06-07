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
            Connection con = Conexion.getConnection();
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
}
