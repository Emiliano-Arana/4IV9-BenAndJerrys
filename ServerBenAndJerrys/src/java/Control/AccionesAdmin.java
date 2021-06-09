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
    
    //CRUD Producto
    
    public static int registrarProducto(Producto pro){
        int estatus = 0;
        try{
            
            Connection con = Conexion.getConection();
            String q = "insert into mproducto(id_tipohelado,id_promocion,id_cantidad,id_tamano,id_presentacion,precio_producto,stock) "
                    + "values(?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(pro.getId_Tipo()));
            ps.setString(2, String.valueOf(pro.getId_promocion()));
            ps.setString(3, String.valueOf(pro.getId_cant()));
            ps.setString(4, String.valueOf(pro.getId_tam()));
            ps.setString(5, String.valueOf(pro.getId_presentacion()));
            ps.setString(6, String.valueOf(pro.getPrecio()));
            ps.setString(7, String.valueOf(pro.getStock()));
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de empleado exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Producto repetidosProductos(String sab,String tam, String pre) throws ClassNotFoundException{
        Producto objPro = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from mproducto where id_tipohelado = ? AND id_tamano = ? AND id_presentacion = ?";
            ps = con.prepareStatement(q);
            
            ps.setString(1, sab);
            ps.setString(2, tam);
            ps.setString(3, pre);
            
            rs = ps.executeQuery();
            while(rs.next()){
                objPro = new Producto();
                objPro.setId_producto(rs.getInt("id_tipohelado"));
                objPro.setId_Tipo(rs.getInt("id_tipohelado"));
                objPro.setId_cant(rs.getInt("id_cantidad"));
                objPro.setId_tam(rs.getInt("id_tamano"));
                objPro.setId_presentacion(rs.getInt("id_presentacion"));
                objPro.setId_promocion(rs.getInt("id_promocion"));
                objPro.setPrecio(rs.getFloat("precio_producto"));                  
                objPro.setStock(rs.getInt("stock"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objPro = null;
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
        return objPro;
    }
    
    public static int eliminarProducto(int pro){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from mproducto where id_producto = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(pro));
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminar producto exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar producto");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Producto recogerProducto(int id) throws ClassNotFoundException{
        Producto objPro = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from mproducto where id_producto = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            while(rs.next()){
                objPro = new Producto();
                objPro.setId_producto(rs.getInt("id_producto"));
                objPro.setId_Tipo(rs.getInt("id_tipohelado"));
                objPro.setId_cant(rs.getInt("id_cantidad"));
                objPro.setId_tam(rs.getInt("id_tamano"));
                objPro.setId_presentacion(rs.getInt("id_presentacion"));
                objPro.setId_promocion(rs.getInt("id_promocion"));
                objPro.setPrecio(rs.getFloat("precio_producto"));                  
                objPro.setStock(rs.getInt("stock"));
                break;
            }
        }catch(SQLException sq){
            System.out.println("Error al verificar al producto");
            System.out.println(sq.getMessage());
            objPro = null;
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
        return objPro;
    }
    
    public static int actualizarProducto(Producto pro){
        int estatus = 0;
        boolean bool = false;
        try{
            AccionesAdmin acc = new AccionesAdmin();
            
            Producto rec = acc.recogerProducto(pro.getId_producto());
             
            if(rec.getId_Tipo()==pro.getId_Tipo()&rec.getId_tam()==pro.getId_tam()&rec.getId_presentacion()==pro.getId_presentacion()){
                bool = true;
            }else{
                Producto rep = acc.repetidosProductos(String.valueOf(pro.getId_Tipo()),String.valueOf(pro.getId_tam()),String.valueOf(pro.getId_presentacion()));
                if(rep==null){
                    bool = true;
                }
            }
            
            if(bool){
                Connection con = Conexion.getConection();
                String q = "update mproducto set id_tipohelado = ?, id_promocion = ?, id_cantidad = ?, id_tamano = ?, id_presentacion = ?, precio_producto = ?, stock = ?"
                        + " where id_producto = ?";

                PreparedStatement ps = con.prepareStatement(q);

                ps.setString(1, String.valueOf(pro.getId_Tipo()));
                ps.setString(2, String.valueOf(pro.getId_promocion()));
                ps.setString(3, String.valueOf(pro.getId_cant()));
                ps.setString(4, String.valueOf(pro.getId_tam()));
                ps.setString(5, String.valueOf(pro.getId_presentacion()));
                ps.setString(6, String.valueOf(pro.getPrecio()));
                ps.setString(7, String.valueOf(pro.getStock()));
                ps.setString(8, String.valueOf(pro.getId_producto()));

                estatus = ps.executeUpdate();
                System.out.println("Actualizacion producto exitosa");
                con.close();
            }
        }catch(Exception ed){
            System.out.println("Error al actualizar el producto");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    //CRUD Usuario
    
    public static int eliminarUsu(int id){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from musuario where id_usuario = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(id));
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminar usu exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar usu");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Usuario repetidosUsu(String usu) throws ClassNotFoundException{
        Usuario objUsu = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from musuario where user_usuario = ?";
            ps = con.prepareStatement(q);
            ps.setString(1,usu);
            rs = ps.executeQuery();
            while(rs.next()){
                objUsu = new Usuario();
                objUsu.setId_usu(rs.getInt("id_usuario"));
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

    public Usuario recogerUsu(int id) throws ClassNotFoundException{
        Usuario objUsu = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from musuario where id_usuario = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            while(rs.next()){
                objUsu = new Usuario();
                objUsu.setId_usu(rs.getInt("id_usuario"));
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
    
    public static int actualizarUsu(Usuario usu){
        int estatus = 0;
        boolean bool = false;
        try{
            
            AccionesAdmin acc = new AccionesAdmin();
            
            Usuario rec = acc.recogerUsu(usu.getId_usu());
             
            if(rec.getId_usu()==usu.getId_usu()){
                bool = true;
            }else{
                Usuario rep = acc.repetidosUsu(String.valueOf(usu.getId_usu()));
                if(rep==null){
                    bool = true;
                }
            }
            
            if(bool){
                Connection con = Conexion.getConection();
                String q = "update musuario set user_usuario = ?, pass_usuario = ?"
                        + " where id_usuario = ?";

                PreparedStatement ps = con.prepareStatement(q);

                ps.setString(1, usu.getUsu());
                ps.setString(2, usu.getPass());
                ps.setString(3, String.valueOf(usu.getId_usu()));

                estatus = ps.executeUpdate();
                System.out.println("Actualizacion usu exitosa");
                con.close();
            }
        }catch(Exception ed){
            System.out.println("Error al actualizar el usu");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }

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

    public static int eliminarTamano(int tam){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from ctamano where id_tamano = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(tam));
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminar tamano exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar tamano");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }

    public Tamano recogerTamano(int id) throws ClassNotFoundException{
        Tamano objTam = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ctamano where id_tamano = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
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
    
    public static int actualizarTamano(Tamano tam){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "update ctamano set nombre_tamano = ?"
                    + " where id_tamano = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, tam.getTam());
            ps.setString(2, String.valueOf(tam.getId_tam()));
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion tamano exitosa");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar el tamano");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    //Catalogo Cantidades
    
    public static int registrarCantidad(Cantidad cant){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into ccantidad(valor_cantidad,unidad_cantidad) "
                    + "values(?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(cant.getValor()));
            ps.setString(2, cant.getUnidad());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de empleado exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Cantidad repetidosCantidades(String val, String u) throws ClassNotFoundException{
        Cantidad objCant= null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ccantidad where valor_cantidad = ? AND unidad_cantidad = ?";
            ps = con.prepareStatement(q);
            
            ps.setString(1, val);
            ps.setString(2, u);
            
            rs = ps.executeQuery();
            while(rs.next()){
                objCant = new Cantidad();
                objCant.setId_cant(rs.getInt("id_cantidad"));
                objCant.setValor(Integer.parseInt(rs.getString("valor_cantidad")));
                objCant.setUnidad(rs.getString("unidad_cantidad"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objCant = null;
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
        return objCant;
    }
    
    public static int eliminarCantidad(int cant){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from ccantidad where id_cantidad = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(cant));
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminar cantidad exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar cantidad");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Cantidad recogerCantidad(int id) throws ClassNotFoundException{
        Cantidad objCant = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ccantidad where id_cantidad = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            while(rs.next()){
                objCant = new Cantidad();
                objCant.setId_cant(rs.getInt("id_cantidad"));
                objCant.setValor(rs.getInt("valor_cantidad"));
                objCant.setUnidad(rs.getString("unidad_cantidad"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objCant = null;
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
        return objCant;
    }
    
    public static int actualizarCantidad(Cantidad cant){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "update ccantidad set valor_cantidad = ?, unidad_cantidad = ?"
                    + " where id_cantidad = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(cant.getValor()));
            ps.setString(2, cant.getUnidad());
            ps.setString(3, String.valueOf(cant.getId_cant()));
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion cantidad exitosa");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar el cantidad");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    //Catalogo Promociones
    
    public static int registrarPromocion(Promocion promo){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "insert into cpromocion(tipo_promocion) "
                    + "values(?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, promo.getPromocion());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro de empleado exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar al empleado");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public Promocion repetidosPromociones(String promo) throws ClassNotFoundException{
        Promocion objPromo = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cpromocion where tipo_promocion = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, promo);
            rs = ps.executeQuery();
            while(rs.next()){
                objPromo = new Promocion();
                objPromo.setId_promocion(rs.getInt("id_promocion"));
                objPromo.setPromocion(rs.getString("tipo_promocion"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objPromo = null;
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
        return objPromo;
    }
    
    public static int eliminarPromocion(int promo){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "delete from cpromocion where id_promocion = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, String.valueOf(promo));
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminar promocion exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al eliminar promocion");
            System.out.println(ed.getMessage());
        }
        return estatus;
        
    }
    
    public Promocion recogerPromocion(int id) throws ClassNotFoundException{
        Promocion objPromo = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cpromocion where id_promocion = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
            rs = ps.executeQuery();
            while(rs.next()){
                objPromo = new Promocion();
                objPromo.setId_promocion(rs.getInt("id_promocion"));
                objPromo.setPromocion(rs.getString("tipo_promocion"));
                break;
            }
        
        }catch(SQLException sq){
            System.out.println("Error al verificar al usuario");
            System.out.println(sq.getMessage());
            objPromo = null;
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
        return objPromo;
    }
    
    public static int actualizarPromocion(Promocion promo){
        int estatus = 0;
        try{
            Connection con = Conexion.getConection();
            String q = "update cpromocion set tipo_promocion = ?"
                    + " where id_promocion = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, promo.getPromocion());
            ps.setString(2, String.valueOf(promo.getId_promocion()));
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion promocion exitosa");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al actualizar el promocion");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
}
