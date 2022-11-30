/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anibal
 */
public class ModelProducto {

    int cod_Producto;
    int id_Proveedor;
    String nombreProducto;
    float costo;
    float utilidad;
    float impuesto;
    float precioVenta;

    public ModelProducto() {

    }

    public ModelProducto(int cod_Producto, int id_Proveedor, String nombreProducto, float costo, float utilidad,
            float impuesto, float precioVenta) {

        this.setCod_Producto(cod_Producto);
        this.setId_Proveedor(id_Proveedor);
        this.setNombreProducto(nombreProducto);
        this.setCosto(costo);
        this.setUtilidad(utilidad);
        this.setImpuesto(impuesto);
        this.setPrecioVenta(precioVenta);
    }

    public int getCod_Producto() {
        return cod_Producto;
    }

    public void setCod_Producto(int cod_Producto) {
        this.cod_Producto = cod_Producto;
    }

    public int getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(int id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
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

}
