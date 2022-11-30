/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.SNMPExceptions;
import Model.ModelProducto;
import Model.ModelProductoDB;
import Model.ModelProveedor;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import javax.faces.model.SelectItem;

/**
 *
 * @author anibal
 */
public class beanMantenimiento {


int codigoProducto = 0;
    int idProveedor = 0;
    String nombreProducto = "";
    float costo = 0;
    float utilidad = 0;
    float impuesto = 0;
    float precioVenta = 0;
    String resumen = "";
    
    LinkedList<SelectItem> listaProveedores = new LinkedList();
    
    public beanMantenimiento() {
        
    }

    public LinkedList<SelectItem> getListaProveedores() throws SNMPExceptions, SQLException {
        
        int codigoProveedor = 0;
        String dscProveedor = "";
        
        LinkedList<ModelProveedor> lista = new LinkedList<ModelProveedor>();
        ModelProductoDB pDB = new ModelProductoDB();
        
        lista = pDB.mostrarProveedores();
        
        LinkedList resultList = new LinkedList();
        
        resultList.add( new SelectItem(0, "Seleccione el Proveedor") );
        
        for (Iterator iter = lista.iterator(); iter.hasNext();) {
        
            ModelProveedor proveedor = (ModelProveedor) iter.next();
            
            codigoProveedor = proveedor.getIdProveedor();
            dscProveedor = proveedor.getDscProveedor();
            
            resultList.add(new SelectItem(codigoProveedor, dscProveedor));
        }
        
        return resultList;
    }

    public void setListaProveedores(LinkedList<SelectItem> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(float utilidad) {
        this.utilidad = utilidad;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
    public int generar() throws SNMPExceptions, SQLException {
        
        ModelProductoDB pDB = new ModelProductoDB();
        
        int min = 1000;
	int max = 5000;
        int valor;
        
        Random random = new Random();

	valor = (random.nextInt(max + min) + 1);
        
        return valor;
    }
    
    public void verificarCodigo() throws SNMPExceptions, SQLException {
        
        ModelProductoDB pDB = new ModelProductoDB();
        
        int valor;

	valor = this.generar();
        
        boolean verificar = pDB.verificarCodigoProducto(valor);
        
        if (!verificar) {
            
            this.setCodigoProducto(valor);
        }
        else {
            
            this.resumen = "ERROR! El codigo generado ya existe en la Base de Datos, intentelo nuevamente.";
        }
    }
    
    public void nuevo() {
        
        this.codigoProducto = 0;
        this.idProveedor = 0;
        this.nombreProducto = "";
        this.costo = 0;
        this.utilidad = 0;
        this.impuesto = 0;
        this.precioVenta = 0;
        this.resumen = "";
    }
    
    public void salvar() throws SNMPExceptions, SQLException {
        
        ModelProductoDB pDB = new ModelProductoDB();
        ModelProducto oProducto = new ModelProducto();
        
        String info = "Error de validación de: ";
        boolean verificado = false;
        int valor = 0;
        
        float pCosto = 0;
        float pUtilidad = this.utilidad;
        float pImpuesto = this.impuesto;
        float porcentaje1 = 0;
        float porcentaje2 = 0;
        float total = 0;
        
        if (this.codigoProducto < 1000) {
            info += "codigo producto - ";
            valor = 1;
        }
        else if (this.codigoProducto > 5000) {
            info += "codigo producto - ";
            valor = 1;
        }
        
        if (this.nombreProducto.equals("") || this.nombreProducto.equals(" ")) {
            info += "nombre producto - ";
            valor = 1;
        }
        
        if (this.costo == 0) {
            info += "costo - ";
            valor = 1;
        }
        
        if (this.utilidad < 1) {
            info +=  "utilidad - ";
            valor = 1;
        }
        else if (this.utilidad > 99) {
            info +=  "utilidad - ";
            valor = 1;
        }
        
        if (this.impuesto < 10) {
            info +=  "impuesto - ";
            valor = 1;
        }
        else if (this.impuesto > 20) {
            info +=  "impuesto - ";
            valor = 1;
        }
        
        if (valor == 0) {
            
            verificado = true;
        }
        
        if (verificado) {
            
            pUtilidad = pUtilidad / 100;
            pImpuesto = pImpuesto / 100;
            pCosto = this.costo;
            porcentaje1 = pCosto * pUtilidad;
            porcentaje2 = pCosto * pImpuesto;
            total = pCosto + porcentaje1 + porcentaje2;
            
            this.setPrecioVenta(total);
            
            oProducto.setCod_Producto(this.codigoProducto);
            oProducto.setId_Proveedor(this.idProveedor);
            oProducto.setNombreProducto(this.nombreProducto);
            oProducto.setCosto(this.costo);
            oProducto.setUtilidad(this.utilidad);
            oProducto.setImpuesto(this.impuesto);
            oProducto.setPrecioVenta(this.precioVenta);
            
            pDB.insertarProducto(oProducto);
            
            this.setResumen("Información salvada.");
        }
        else {
            
            this.setResumen(info);
        }
        
    }
    
    public void imprimir() throws SNMPExceptions, SQLException {
        
        ModelProductoDB pDB = new ModelProductoDB();
        ModelProducto oProducto = null;
        
        String info = "Error…Código de producto NO existe.";
        String prov = "";
        
        oProducto = pDB.consultarProducto(this.codigoProducto);
        
        if (oProducto != null) {
            
            if (oProducto.getId_Proveedor() == 1) {
                
                prov = "Nacional";
            }
            else if (oProducto.getId_Proveedor() == 2) {
                
                prov = "Extranjero";
            }
            
            info = "Codigo de Producto: " + oProducto.getCod_Producto() + 
                   "\nNombre del Producto: " + oProducto.getNombreProducto() +
                   "\nProveedor: " + prov + "\nCosto: " + oProducto.getCosto() +
                   "\nUtilidad: " + oProducto.getUtilidad() +
                   "\nIVA: " + oProducto.getImpuesto() +
                   "\nPrecio de Venta: " + oProducto.getPrecioVenta();
            
            this.setResumen(info);
        }
        else {
            
            this.setResumen(info);
        }
    }
    
    public void ayuda() {
        
        String datos;
        
        datos = "Mensaje de ayuda";
        
        this.setResumen(datos);
    }
    
    public String retornar() {
        
        this.nuevo();
        
        return "pageIngreso.xhtml";
    }


    
}
