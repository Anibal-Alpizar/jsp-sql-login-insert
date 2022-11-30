/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anibal
 */
public class ModelProveedor {

    int idProveedor;
    String dscProveedor;

    public ModelProveedor(int idProveedor, String dscProveedor) {

        this.setIdProveedor(idProveedor);
        this.setDscProveedor(dscProveedor);
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getDscProveedor() {
        return dscProveedor;
    }

    public void setDscProveedor(String dscProveedor) {
        this.dscProveedor = dscProveedor;
    }

}
