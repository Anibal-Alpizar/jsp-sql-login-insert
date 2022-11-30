/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.SNMPExceptions;
import Model.ModelRol;
import Model.ModelUsuario;
import Model.ModelUsuarioDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author anibal
 */
public class beanIngreso {

    int idUsuario = 0;
    int idRol = 0;
    String nombreUsuario = "";
    String contrasenia = "";

    LinkedList<SelectItem> listaRoles = new LinkedList<>();

    public beanIngreso() {

    }

    public LinkedList<SelectItem> getListaRoles() throws SNMPExceptions, SQLException {

        int codigoRol = 0;
        String dscRol = "";

        LinkedList<ModelRol> lista = new LinkedList<ModelRol>();
        ModelUsuarioDB uDB = new ModelUsuarioDB();

        lista = uDB.mostrarRoles();

        LinkedList resultList = new LinkedList();

        resultList.add(new SelectItem(0, "Seleccione el Rol"));

        for (Iterator iter = lista.iterator(); iter.hasNext();) {

            ModelRol rol = (ModelRol) iter.next();

            codigoRol = rol.getIdRol();
            dscRol = rol.getDscRol();

            resultList.add(new SelectItem(codigoRol, dscRol));
        }

        return resultList;
    }

    public void setListaRoles(LinkedList<SelectItem> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void inicioSesion() throws SNMPExceptions, SQLException, IOException {

        ModelUsuarioDB uDB = new ModelUsuarioDB();
        ModelUsuario mUsuario = uDB.InicioSesion(this.nombreUsuario, this.contrasenia, this.idRol);

        if (mUsuario != null) {

            this.limpiarCampos();

            FacesContext.getCurrentInstance().getExternalContext().redirect("pageMantenimiento.xhtml");
        } else {

            FacesContext.getCurrentInstance().getExternalContext().redirect("pageError.xhtml");
        }
    }

    public void limpiarCampos() {

        this.setNombreUsuario("");
        this.setContrasenia("");
        this.setIdRol(0);
    }

    public void regresar() throws IOException {

        FacesContext.getCurrentInstance().getExternalContext().redirect("pageIngreso.xhtml");
    }

}
