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
public class ModelUsuarioDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public ModelUsuarioDB(Connection conn) {

        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public ModelUsuarioDB() {
        super();
    }

    public LinkedList<ModelRol> mostrarRoles() throws SNMPExceptions, SQLException {

        String select = "";
        LinkedList<ModelRol> lista = new LinkedList<ModelRol>();

        try {
            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();
            //Se crea la sentencia de búsqueda
            select = "SELECT * FROM Rol";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int idRol = rsPA.getInt("ID");
                String descripcion = rsPA.getString("Descripcion");

                ModelRol pRol = new ModelRol(idRol, descripcion);
                lista.add(pRol);
            }

            rsPA.close();
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }

        return lista;
    }

    public ModelUsuario InicioSesion(String nombreU, String clave, int idRol) throws SNMPExceptions, SQLException {

        String select = "";
        ModelUsuario oUsuario = null;

        try {

            AccesoDatos accesoDatos = new AccesoDatos();
            //Se crea la sentencia de búsqueda
            select = "SELECT * FROM Usuario "
                    + "where Nombre_Usuario = '" + nombreU + "' and Clave = '" + clave + "' and ID_Rol = " + idRol;

            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int idUsuario = rsPA.getInt("ID_Usuario");
                int tipoR = rsPA.getInt("ID_Rol");
                String nombre = rsPA.getString("Nombre_Usuario");
                String contrasenia = rsPA.getString("Clave");

                oUsuario = new ModelUsuario();

                oUsuario.setIdUsuario(idUsuario);
                oUsuario.setIdRol(tipoR);
                oUsuario.setNombreUsuario(nombre);
                oUsuario.setContrasenia(contrasenia);
            }

            rsPA.close();
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }

        return oUsuario;
    }
}
