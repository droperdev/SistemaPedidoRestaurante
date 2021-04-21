/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.client;

import config.Conexion;
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

}
