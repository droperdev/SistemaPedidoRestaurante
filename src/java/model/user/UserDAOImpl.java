/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.role.RoleDAOImpl;

/**
 *
 * @author droperdev
 */
public class UserDAOImpl implements UserDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public User validateCredentials(String userName, String password) {
        User user = null;
        String query = "SELECT * FROM User WHERE UserName=? AND Password=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("Id"));
                user.setRoleId(rs.getInt("RolId"));
                user.setName(rs.getString("Name"));
                user.setLastName(rs.getString("LastName"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setCreatedAt(rs.getDate("CreateAt"));
                user.setStatus(rs.getBoolean("Status"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
