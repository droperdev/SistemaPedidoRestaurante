/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.status;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IVAN
 */
public class StatusDAOImpl implements StatusDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List<Status> list() {
        
        ArrayList<Status> lista = new ArrayList<>();
        Status status = null;
        String query = "SELECT * FROM Status ";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                status = new Status();
                status.setId(rs.getInt("Id"));
                status.setName(rs.getString("Name"));
                lista.add(status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
