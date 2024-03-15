package Modelos;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public Cliente buscarCliente(int dni) {
        Cliente cliente = new Cliente();
        String consulta = "SELECT * FROM cliente WHERE dni = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt("IdCliente"));
                cliente.setDni(rs.getInt("Dni"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setEstado(rs.getString("Estado"));
            }
        } catch (Exception e) {
        }
        return cliente;
    }

    public Cliente validar(int dni, String password) {
        Cliente cliente = new Cliente();
        String consulta = "SELECT * FROM cliente WHERE dni = ? AND password = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setInt(1, dni);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs.next();
            do {
                cliente.setIdCliente(rs.getInt("IdCliente"));
                cliente.setDni(rs.getInt("Dni"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setEstado(rs.getString("Estado"));
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    public List listar() {
        String consulta = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("IdCliente"));
                cliente.setDni(rs.getInt("Dni"));
                cliente.setNombres(rs.getString("Nombres"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setEstado(rs.getString("Estado"));
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int agregar(Cliente cliente) {
        String sentencia = "INSERT INTO cliente (Dni, Nombres, Direccion, Estado) VALUES (?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getEstado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Cliente listarPorId(int dni) {
        Cliente cliente = new Cliente();
        String consulta = "SELECT * FROM cliente WHERE IdCliente = " + dni;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                cliente.setDni(rs.getInt(2));
                cliente.setNombres(rs.getString(3));
                cliente.setDireccion(rs.getString(4));
                cliente.setEstado(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }

    public int actualizar(Cliente cliente) {
        String sentencia = "UPDATE cliente SET Dni=?, Nombres=?, Direccion=?, Estado=? WHERE IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getEstado());
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public void eliminar(int idCliente) {
        String sql = "DELETE FROM cliente WHERE IdCliente=" + idCliente;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
