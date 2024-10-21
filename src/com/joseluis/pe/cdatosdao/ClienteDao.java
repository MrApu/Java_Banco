
package com.joseluis.pe.cdatosdao;


import com.joseluis.pe.cmodelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDao {
    private String mensaje;
    
    public String agregarCliente(Connection conn, Cliente cliente){
        PreparedStatement ps = null;
        String sql = "INSERT INTO CLIENTE(DNI,NOMBRE,APELLIDOS,TELEFONO,DIRECCION)"
                + "VALUES(?,?,?,?,?,?)";
        try {
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getDireccion());
                        
            ps.execute();
            ps.close();
            mensaje = "Los datos del cliente se guardaron satisfactoriamente";
        } catch (Exception e) {
            mensaje = "Alto! error al crear los datos del cliente. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
    
    public String eliminarCliente(Connection conn, Cliente cliente){
        PreparedStatement ps = null;
        String sql = "DELETE FROM BILLETE WHERE NRO_BILLETE = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getDireccion());
            ps.setInt(6, cliente.getId_tipo_cliente());
            ps.execute();
            ps.close();
            mensaje = "El Cliente fue eliminado corectamente";
        } catch (Exception e) {
            mensaje = "Alto! error al eliminar al cliente. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
        
    }
    
    public String modificarCliente(Connection conn, Cliente cliente){
        PreparedStatement ps = null;
        String sql = "UPDATE ClIENTE "
                + " SET DNI=?, NOMBRE=?, APELLIDOS=?, TELEFONO=?, DIRECCION=? "
                + " WHERE ID_TIPO_CLIENTE=?";
        try {
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getDireccion());
            ps.setInt(6, cliente.getId_tipo_cliente());
            
            ps.execute();
            ps.close();
            mensaje = "Los datos del cliente fueron actualizados correctamente";
        } catch (Exception e) {
            mensaje = "Alto! error al actualizar los datos del cliente. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
    
    public void listarCliente(Connection conn, JTable table){
        DefaultTableModel model;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String[] columnas = {"DNI","NOMBRE","APELLIDOS","TELEFONO","DIRECCION","ID_TIPO_CLIENTE"};
        model = new DefaultTableModel(null,columnas);
        
        String sql = "SELECT c.NOMBRE AS NOMBRE_CLIENTE, c.APELLIDOS AS APELLIDOS_CLIENTE, co.NOMBRE AS NOMBRE_COMPAÑIA FROM BILLETE b " +
                        "INNER JOIN TIPO_DOCUMENTO td ON pd.ID_TIPO_DOCUMENTO = td.ID_TIPO_DOCUMENTO ";
                        
        String[] datosCLI = new String[2];
        
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                datosCLI[0] = resultSet.getString("NUMERO_DOCUMENTO")+"";
                datosCLI[1] = resultSet.getString("NOMBRE")+"";
                model.addRow(datosCLI);
            }
            table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Cliente> listarTipoDocumentosCombo(Connection conn){
        ArrayList<Cliente> listaTipoCliente = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        
        String sql = "SELECT ID_TIPO_DOCUMENTO, NOMBRE FROM TIPO_DOCUMENTO " +
                     " ORDER BY ORDEN";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Cliente cli = new Cliente();
                cli.setId_tipo_cliente(resultSet.getInt("ID_TIPO_CLIENTE"));
                cli.setNombre(resultSet.getString("NOMBRE"));
                listaTipoCliente.add(cli);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            System.out.println(e.getMessage());
        }
        return listaTipoCliente;
    }
    
    
}
