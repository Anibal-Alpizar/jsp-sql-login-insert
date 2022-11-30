/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anibal
 */
public class ModelUsuario {

    int idUsuario;
    int idRol;
    String nombreUsuario;
    String contrasenia;

    public ModelUsuario() {

    }

    public ModelUsuario(int idUsuario, int idRol, String nombreUsuario, String contrasenia) {

        this.setIdUsuario(idUsuario);
        this.setIdRol(idRol);
        this.setNombreUsuario(nombreUsuario);
        this.setContrasenia(contrasenia);
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
}
