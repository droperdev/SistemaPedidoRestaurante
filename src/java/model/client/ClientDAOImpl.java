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
import model.user.UserDAOImpl;

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

    @Override
    public int save(Client client) {
        int id = 0;
        String sql
                = "INSERT INTO Client(Name, LastName,Phone,Email, Password) "
                + "VALUES('" + client.getName() + "', '" + client.getLastName() + "', '-' , '" + client.getEmail() + "', '" + client.getPassword() + "')";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.execute();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

}
