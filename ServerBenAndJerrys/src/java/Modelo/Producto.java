/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Vector;
import Control.Conexion;
import java.sql.*;
import Control.AccionesAdmin;

/**
 *
 * @author Emiliano
 */
public class Producto {
    private int id_producto,id_Tipo,id_promocion,id_cant,id_tam,id_presentacion,stock;
    private float precio;

    public Producto() {
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_Tipo() {
        return id_Tipo;
    }

    public void setId_Tipo(int id_Tipo) {
        this.id_Tipo = id_Tipo;
    }

    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    public int getId_cant() {
        return id_cant;
    }

    public void setId_cant(int id_cant) {
        this.id_cant = id_cant;
    }

    public int getId_tam() {
        return id_tam;
    }

    public void setId_tam(int id_tam) {
        this.id_tam = id_tam;
    }

    public int getId_presentacion() {
        return id_presentacion;
    }

    public void setId_presentacion(int id_presentacion) {
        this.id_presentacion = id_presentacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public Vector<ProductoTabla> listaProductos() throws ClassNotFoundException{
        Vector<ProductoTabla> listaProductos = new Vector<ProductoTabla>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AccionesAdmin acc = new AccionesAdmin();
        try{
            con = Conexion.getConection();
            String q = "select * from mproducto";
            //querry donde se obtenga a traves de join o con vista
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto pro = new Producto();
                pro.setId_producto(rs.getInt("id_producto"));
                pro.setId_Tipo(rs.getInt("id_tipohelado"));
                pro.setId_promocion(rs.getInt("id_promocion"));
                pro.setId_cant(rs.getInt("id_cantidad"));
                pro.setId_tam(rs.getInt("id_tamano"));
                pro.setId_presentacion(rs.getInt("id_presentacion"));
                pro.setPrecio(rs.getFloat("precio_producto"));
                pro.setStock(rs.getInt("stock"));
                
                ProductoTabla producto = new ProductoTabla();
                
                producto.setId_producto(pro.getId_producto());
                producto.setSabor(acc.recogerSabor(pro.getId_Tipo()).getTipoH());
                producto.setPromo(acc.recogerPromocion(pro.getId_promocion()).getPromocion());
                producto.setCantidad(String.valueOf(acc.recogerCantidad(pro.getId_cant()).getValor()) + acc.recogerCantidad(pro.getId_cant()).getUnidad());
                producto.setTam(acc.recogerTamano(pro.getId_tam()).getTam());
                producto.setPresentacion(acc.recogerPresentacion(pro.getId_presentacion()).getPresentacion());
                producto.setPrecio(pro.getPrecio());
                producto.setStock(pro.getStock());
                
                
                listaProductos.add(producto);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaProductos = null;
        
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
        return listaProductos;
    }
    
    public Vector<ProductoTabla> listaProductosFilt(String sab, String pre, String tam) throws ClassNotFoundException{
        Vector<ProductoTabla> listaProductos = new Vector<ProductoTabla>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String q;
        AccionesAdmin acc = new AccionesAdmin();
        boolean cads = true;
        
        System.out.println(sab);
        System.out.println(pre);
        System.out.println(tam);
        
        if(sab.equals("todos")&&pre.equals("todos")&&tam.equals("todos")){
            cads = false;
        }
        
        try{
            con = Conexion.getConection();
            if(cads){
                boolean prim = false;
                String sabS, preS, tamS;
                
                if(sab.equals("todos")){
                    sabS = "";
                }else{
                    sabS = " WHERE id_tipohelado = "+sab;
                    prim = true;
                }
                if(pre.equals("todos")){
                    preS = "";
                }else{
                    if(prim){
                        preS = " AND id_presentacion = "+pre;
                    }else{
                        preS = " WHERE id_presentacion = "+pre;
                    }
                    prim = true;
                }
                if(tam.equals("todos")){
                    tamS = "";
                }else{
                    if(prim){
                        tamS = " AND id_tamano = "+tam;
                    }else{
                        tamS = " WHERE id_tamano = "+tam;
                    }
                }
                
                q = "select * from mproducto"+sabS+preS+tamS;
                //querry donde se obtenga a traves de join o con vista
            }else{
                q = "select * from mproducto";
            }
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto pro = new Producto();
                pro.setId_producto(rs.getInt("id_producto"));
                pro.setId_Tipo(rs.getInt("id_tipohelado"));
                pro.setId_promocion(rs.getInt("id_promocion"));
                pro.setId_cant(rs.getInt("id_cantidad"));
                pro.setId_tam(rs.getInt("id_tamano"));
                pro.setId_presentacion(rs.getInt("id_presentacion"));
                pro.setPrecio(rs.getFloat("precio_producto"));
                pro.setStock(rs.getInt("stock"));
                
                ProductoTabla producto = new ProductoTabla();
                
                producto.setId_producto(pro.getId_producto());
                producto.setSabor(acc.recogerSabor(pro.getId_Tipo()).getTipoH());
                producto.setPromo(acc.recogerPromocion(pro.getId_promocion()).getPromocion());
                producto.setCantidad(String.valueOf(acc.recogerCantidad(pro.getId_cant()).getValor()) + acc.recogerCantidad(pro.getId_cant()).getUnidad());
                producto.setTam(acc.recogerTamano(pro.getId_tam()).getTam());
                producto.setPresentacion(acc.recogerPresentacion(pro.getId_presentacion()).getPresentacion());
                producto.setPrecio(pro.getPrecio());
                pro.setStock(pro.getStock());
                
                
                listaProductos.add(producto);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaProductos = null;
        
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
        return listaProductos;
    }
}
