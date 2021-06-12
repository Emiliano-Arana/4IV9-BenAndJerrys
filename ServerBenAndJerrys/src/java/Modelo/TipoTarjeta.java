/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Emiliano
 */
public class TipoTarjeta {
    private int id_tipoTar;
    private String tipo;

    public TipoTarjeta() {
    }

    public int getId_tipoTar() {
        return id_tipoTar;
    }

    public void setId_tipoTar(int id_tipoTar) {
        this.id_tipoTar = id_tipoTar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Vector<TipoTarjeta> listaTTarjeta() throws ClassNotFoundException{
        Vector<TipoTarjeta> listaTTarjeta = new Vector<TipoTarjeta>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ctipotarjeta";
            //querry donde se obtenga a traves de join o con vista
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                TipoTarjeta ttar = new TipoTarjeta();
                ttar.setId_tipoTar(rs.getInt("id_tipotarjeta"));
                ttar.setTipo(rs.getString("tipo_tarjeta"));
                listaTTarjeta.add(ttar);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar las Tarjetas");
            System.out.println(sq.getMessage());
                    
            listaTTarjeta = null;
        
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
        return listaTTarjeta;
    }
}
