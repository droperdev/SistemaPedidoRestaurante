/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.orderDetail;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.product.Product;
import model.product.ProductDAOImpl;

/**
 *
 * @author droperdev
 */
public class OrderDetailDAOImpl implements OrderDetailDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<OrderDetail> get(int orderId) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = null;
        String query = "SELECT * FROM OrderDetail WHERE OrderId=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                orderDetail = new OrderDetail();
                orderDetail.setId(rs.getInt("Id"));
                orderDetail.setOrderId(rs.getInt("OrderId"));
                orderDetail.setProductId(rs.getInt("ProductId"));
                orderDetail.setQuantity(rs.getInt("Quantity"));
                orderDetail.setPrice(rs.getDouble("Price"));
                orderDetail.setCreatedAt(rs.getDate("CreateAt"));
                orderDetails.add(orderDetail);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderDetails;
    }

}
