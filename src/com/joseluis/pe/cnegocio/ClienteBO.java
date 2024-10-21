
package com.joseluis.pe.cnegocio;

import java.sql.Connection;

import com.joseluis.pe.cdatosdao.ClienteDao;
import com.joseluis.pe.cmodelo.Cliente;
import com.joseluis.pe.db.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

public class ClienteBO {
    private String mensaje;
    ClienteDao clid = new ClienteDao();
    
    public String agregarCliente(Cliente cliente) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = clid.agregarCliente (c, cliente);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
    public String eliminarTipoDocomento(Cliente cliente) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = clid.eliminarCliente(c, cliente);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
    public String modificarCliente(Cliente cliente) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = clid.modificarCliente(c, cliente);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
    public void listarCliente(JTable table){
        Connection c = Conexion.getConnection();
        clid.listarCliente(c, table);
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
    
    public ArrayList<Cliente> listarClienteCombo(){
        ArrayList<Cliente> listaTipoDocumento = new ArrayList<>();
        Connection c = Conexion.getConnection();
        listaTipoDocumento = clid.listarTipoDocumentosCombo(c);
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
        return listaTipoDocumento;
    }
}
