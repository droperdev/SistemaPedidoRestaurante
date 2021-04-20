package model.orderType;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderTypeDAOImpl implements OrderTypeDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public OrderType getOrderType(int id) {
        OrderType orderType = null;
        String query = "SELECT * FROM OrderType WHERE Id=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                orderType = new OrderType();
                orderType.setId(rs.getInt("Id"));
                orderType.setName(rs.getString("Name"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderTypeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderType;
    }
}
