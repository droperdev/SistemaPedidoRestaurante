/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.client;

import config.Conexion;
import dto.ClientDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class ClientDAOImpl implements ClientDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Client getClient(int id) {
        Client client = null;
        String query = "SELECT * FROM Client WHERE Id=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                client = new Client();
                client.setId(rs.getInt("Id"));
                client.setName(rs.getString("Name"));
                client.setLastName(rs.getString("LastName"));
                client.setPhone(rs.getString("Phone"));
                client.setEmail(rs.getString("Email"));
                client.setBirthday(rs.getDate("Birthay"));
                client.setCreatedAt(rs.getDate("CreatedAt"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }

     @Override
    public ClientDTO validateCredentials(String email, String password) {
       ClientDTO client = null;
        String query
                = "SELECT c.Id, c.Name, c.LastName, c.Email FROM Client c "
                + "WHERE c.Email=? AND c.Password=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                client = new ClientDTO();
                client.setId(rs.getInt("Id"));
                client.setName(rs.getString("Name"));
                client.setLastName(rs.getString("LastName"));
                client.setEmail(rs.getString("Email"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }

}
