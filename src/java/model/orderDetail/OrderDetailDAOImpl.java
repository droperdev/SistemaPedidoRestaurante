/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.orderDetail;

import config.Conexion;
import dto.CategoryDTO;
import dto.OrderDetailDTO;
import dto.ProductDTO;
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
    public List<OrderDetailDTO> get(int orderId) {
        List<OrderDetailDTO> orderDetails = new ArrayList<>();
        OrderDetailDTO orderDetail = null;
        String query
                = "SELECT od.Id, od.Quantity, od.Price, od.CreateAt, "
                + "od.ProductId, p.Name ProductName, p.Description, p.Price, "
                + "p.CategoryId, c.Name CategoryName "
                + "FROM OrderDetail od "
                + "INNER JOIN Product p ON od.ProductId = p.Id "
                + "INNER JOIN Category c ON p.CategoryId = c.Id "
                + "WHERE od.OrderId=?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                orderDetail = new OrderDetailDTO();
                orderDetail.setId(rs.getInt("Id"));
                orderDetail.setProduct(
                        new ProductDTO(
                                rs.getInt("ProductId"),
                                new CategoryDTO(
                                        rs.getInt("CategoryId"),
                                        rs.getString("CategoryName")
                                ),
                                rs.getString("ProductName"),
                                rs.getString("Description"),
                                rs.getDouble("Price")
                        )
                );
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

    @Override
    public void save(int orderId, OrderDetail orderDetail) {
        String sql
                = "INSERT INTO OrderDetail(OrderId, ProductId, Quantity, Price) "
                + "VALUES(?, ?, ?, ?)";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, orderDetail.getProductId());
            ps.setInt(3, orderDetail.getQuantity());
            ps.setDouble(4, orderDetail.getPrice());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
