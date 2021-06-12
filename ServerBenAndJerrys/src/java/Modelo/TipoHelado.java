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

public class TipoHelado {
    private int id_tipoH;
    private String tipoH;

    public TipoHelado() {
    }

    public int getId_tipoH() {
        return id_tipoH;
    }

    public void setId_tipoH(int id_tipoH) {
        this.id_tipoH = id_tipoH;
    }

    public String getTipoH() {
        return tipoH;
    }

    public void setTipoH(String tipoH) {
        this.tipoH = tipoH;
    }
    
    public Vector<TipoHelado> listaSabores() throws ClassNotFoundException{
        Vector<TipoHelado> listaSabores = new Vector<TipoHelado>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ctipo_helado";
            //querry donde se obtenga a traves de join o con vista
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                TipoHelado sabor = new TipoHelado();
                sabor.setId_tipoH(rs.getInt("id_tipohelado"));
                sabor.setTipoH(rs.getString("sabor_tipohelado"));
                listaSabores.add(sabor);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaSabores = null;
        
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
        return listaSabores;
    }
}
