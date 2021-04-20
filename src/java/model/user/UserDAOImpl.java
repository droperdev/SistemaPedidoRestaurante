/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import config.Conexion;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.role.Role;

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
    public UserDTO validateCredentials(String userName, String password) {
        UserDTO user = null;
        String query
                = "SELECT u.Id, u.Name, u.LastName, u.RolId, r.Name RoleName FROM User u "
                + "INNER JOIN Role r ON r.Id = u.RolId "
                + "WHERE u.UserName=? AND u.Password=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new UserDTO();
                user.setId(rs.getInt("Id"));
                user.setRole(new Role(rs.getInt("RolId"), rs.getString("RoleName")));
                user.setName(rs.getString("Name"));
                user.setLastName(rs.getString("LastName"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
