/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author anibal
 */
public class ModelProductoDB {

private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public ModelProductoDB(Connection conn) {

        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public ModelProductoDB() {
        super();
    }
    
    public LinkedList<ModelProveedor> mostrarProveedores() throws SNMPExceptions, SQLException {
        
        String select = "";
        LinkedList<ModelProveedor> lista = new LinkedList<ModelProveedor>();
        
        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT * FROM Proveedor";
            
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int idRol = rsPA.getInt("ID");
                String descripcion = rsPA.getString("DESCRIPCION");

                ModelProveedor pRol = new ModelProveedor(idRol, descripcion);
                lista.add(pRol);
            }
            
            rsPA.close();

        } 
        catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } 
        catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        }
        finally {

        }
        
        return lista;
    }
    
    public void insertarProducto(ModelProducto pProducto) throws SNMPExceptions, SQLException {
        
        String insert = "";
        
        try {
            
            AccesoDatos accesoDatos = new AccesoDatos();
            
            insert = "Insert into Producto values(" + pProducto.getCod_Producto() + ", " + 
                     pProducto.getId_Proveedor() + ", '" + pProducto.getNombreProducto() + "', " +
                     pProducto.getCosto() + ", " + pProducto.getUtilidad() + ", " + pProducto.getImpuesto() +
                     ", " + pProducto.getPrecioVenta() + ")";
            
            accesoDatos.ejecutaSQL(insert);
        }
        catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } 
        catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } 
        finally {

        }
    }
    
    public ModelProducto consultarProducto(int cod) throws SNMPExceptions, SQLException {
        
        ModelProducto pProducto = null;
        String select = "";
        
        try {
            
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT * FROM Producto Where Codigo_Producto = " + cod;
            
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            
            while (rsPA.next()) {
                
                int codigo = rsPA.getInt("Codigo_Producto");
                int idP = rsPA.getInt("ID_Proveedor");
                String nombP = rsPA.getString("Nombre_Producto");
                float costo = rsPA.getFloat("Costo");
                float util = rsPA.getFloat("Utilidad");
                float iva = rsPA.getFloat("Impuesto");
                float precioV = rsPA.getFloat("Precio_Venta");
                
                pProducto = new ModelProducto(codigo, idP, nombP, costo, util, iva, precioV);
            }
            
            rsPA.close();
        }
        catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } 
        catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } 
        finally {

        }
        
        return pProducto;
    }
    
    public boolean verificarCodigoProducto(int cod) throws SNMPExceptions, SQLException {
        
        boolean verificado = false;
        String select = "";
        
        try {
            
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT Codigo_Producto FROM Producto Where Codigo_Producto = " + cod;
            
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            
            while (rsPA.next()) {
                
                int codigo = rsPA.getInt("Codigo_Producto");
                
                if (codigo == cod) {
                    
                    verificado = true;
                }
            }
            
            rsPA.close();
        }
        catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } 
        catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } 
        finally {

        }
        
        return verificado;
    }
    
}
