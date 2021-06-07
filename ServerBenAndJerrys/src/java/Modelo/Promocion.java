/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Emiliano
 */

import java.util.Vector;
import Control.Conexion;
import java.sql.*;

public class Promocion {
    private int id_promocion;
    private String promocion;

    public Promocion() {
    }

    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }
    
    public Vector<Promocion> listaPromociones() throws ClassNotFoundException{
        Vector<Promocion> listaPromociones = new Vector<Promocion>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cpromocion";
            //querry donde se obtenga a traves de join o con vista
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Promocion promo = new Promocion();
                promo.setId_promocion(rs.getInt("id_promocion"));
                promo.setPromocion(rs.getString("tipo_promocion"));
                listaPromociones.add(promo);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaPromociones = null;
        
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(Exception e){
                System.out.println("Error no encuentra la clase");
                System.out.println(e.getMessage());
            }
        }
        return listaPromociones;
    }
}
