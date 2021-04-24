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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    public List<UserDTO> getDistributors(int roleId) {
        List<UserDTO> users = new ArrayList<>();
        UserDTO user = null;
        String query
                = "SELECT u.Id, u.Name, u.LastName, u.RolId, r.Name RoleName FROM User u "
                + "INNER JOIN Role r ON u.RolId = r.Id "
                + "WHERE u.RolId = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new UserDTO();
                user.setId(rs.getInt("Id"));
                user.setRole(new Role(rs.getInt("RolId"), rs.getString("RoleName")));
                user.setName(rs.getString("Name"));
                user.setLastName(rs.getString("LastName"));
                users.add(user);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> users = new ArrayList<>();
        UserDTO user = null;
        String query = "SELECT u.Id, u.Name, u.LastName, u.UserName, u.RolId, r.Name RoleName FROM User u "
                + "INNER JOIN Role r ON u.RolId = r.Id ";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new UserDTO();
                user.setId(rs.getInt("Id"));
                user.setRole(new Role(rs.getInt("RolId"), rs.getString("RoleName")));
                user.setName(rs.getString("Name"));
                user.setLastName(rs.getString("LastName"));
                user.setUserName(rs.getString("UserName"));
                users.add(user);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public void save(UserDTO userDTO) {
        String sql
                = "INSERT INTO `User`(RolId, NAME,lastname,username, password, profilepicture) "
                + "VALUES('1', '" + userDTO.getName() + "', '" + userDTO.getLastName() + "', '" + userDTO.getUserName() + "','" + userDTO.getPassword() + "','https://www.seekpng.com/png/full/356-3562377_personal-user.png')";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int userId) {
        String sql
                = "DELETE FROM `User` WHERE Id=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
