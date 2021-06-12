/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Vector;
import Control.Conexion;
import java.sql.*;

/**
 *
 * @author Emiliano
 */
public class Presentacion {
    private int id_presentacion;
    private String presentacion;

    public Presentacion() {
    }

    public int getId_presentacion() {
        return id_presentacion;
    }

    public void setId_presentacion(int id_presentacion) {
        this.id_presentacion = id_presentacion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    
    public Vector<Presentacion> listaPresentaciones() throws ClassNotFoundException{
        Vector<Presentacion> listaPresentaciones = new Vector<Presentacion>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cpresentacion";
            //querry donde se obtenga a traves de join o con vista
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Presentacion presentacion = new Presentacion();
                presentacion.setId_presentacion(rs.getInt("id_presentacion"));
                presentacion.setPresentacion(rs.getString("tipo_presentacion"));
                listaPresentaciones.add(presentacion);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaPresentaciones = null;
        
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
        return listaPresentaciones;
    }
}
