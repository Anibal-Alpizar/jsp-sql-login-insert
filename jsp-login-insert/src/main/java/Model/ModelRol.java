/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anibal
 */
public class ModelRol {

    int idRol;
    String dscRol;

    public ModelRol(int idRol, String dscRol) {

        this.setIdRol(idRol);
        this.setDscRol(dscRol);
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getDscRol() {
        return dscRol;
    }

    public void setDscRol(String dscRol) {
        this.dscRol = dscRol;
    }

}
