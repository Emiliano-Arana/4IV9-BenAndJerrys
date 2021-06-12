/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Direccion;
import Modelo.Promocion;
import Modelo.Tarjeta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Emiliano
 */
public class AccionesUsu {
    
    public static int registrarTarjeta(Tarjeta tar){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into mtarjeta(titular_tarjeta,numero_tarjeta,fecha_vencimiento_tarjeta,codigo_seguridad_tarjeta,id_tipotaarjeta,id_banco) "
                    + "values(?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(tar.getTitular()));
            ps.setString(2, String.valueOf(tar.getNum_tar()));
            ps.setString(3, String.valueOf(tar.getFV()));
            ps.setString(4, String.valueOf(tar.getCod_seg()));
            ps.setString(5, String.valueOf(tar.getId_tipo()));
            ps.setString(6, String.valueOf(tar.getId_banco()));

           
            estatus = ps.executeUpdate();
            System.out.println("Registro de tarjeta exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar la tarjeta");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
        public Tarjeta verificarETarjeta(String tar) throws ClassNotFoundException{
        Tarjeta objTar = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from mtarjeta where numero_tarjeta = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, tar);
            rs = ps.executeQuery();
            while(rs.next()){
                objTar = new Tarjeta();
                objTar.setId_tar(rs.getInt("id_tarjeta"));
                objTar.setTitular(rs.getString("titular_tarjeta"));
                objTar.setNum_tar(rs.getString("numero_tarjeta"));
                objTar.setFV(rs.getString("fecha_vencimiento_tarjeta"));
                objTar.setCod_seg(rs.getInt("codigo_seguridad_tarjeta"));
                objTar.setId_tipo(rs.getInt("id_tipotarjeta"));
                objTar.setId_banco(rs.getInt("id_banco"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar la tarjeta");
            System.out.println(sq.getMessage());
            objTar = null;
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
        return objTar;
    }
    
        public static int registrarDireccion(Direccion dir){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into ddirecciones(calle_direccion,numero_ext_direccion,numero_int_direccion,id_alcaldia,id_colonia) "
                    + "values(?,?,?,?,?,)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(dir.getCalle()));
            ps.setString(2, String.valueOf(dir.getNum_ext()));
            ps.setString(3, String.valueOf(dir.getNum_int()));
            ps.setString(4, String.valueOf(dir.getId_alcaldia()));
            ps.setString(5, String.valueOf(dir.getId_colonia()));

           
            estatus = ps.executeUpdate();
            System.out.println("Registro de direccion exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar la direccion");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
        
}
