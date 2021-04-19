/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.role;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author droperdev
 */
public class RoleDAOImpl implements RoleDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Role getRole(int id) {
        Role role = null;
        String query = "SELECT * FROM Role WHERE Id=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                role = new Role();
                role.setId(rs.getInt("Id"));
                role.setName(rs.getString("Name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }

}
