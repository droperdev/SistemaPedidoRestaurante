/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import config.Conexion;
import dto.AddressDTO;
import dto.ClientDTO;
import dto.OrderDTO;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.orderType.OrderType;
import model.paymentMethod.PaymentMethod;
import model.status.Status;
import model.voucher.Voucher;

/**
 *
 * @author droperdev
 */
public class OrderDAOImpl implements OrderDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<OrderDTO> getAll(int[] ids) {
        List<OrderDTO> orders = new ArrayList<>();

        OrderDTO order = null;
        String query
                = "SELECT o.Id, o.ClientId, c.Name ClientName, c.LastName, "
                + "o.AddressId, ca.Address, ca.Reference, ca.Latitude, ca.Longitude, "
                + "o.StatusId, s.Name StatusName, "
                + "o.VoucherId, v.Name VoucherName, "
                + "o.OrderTypeId, ot.Name OrderTypeName, "
                + "o.PaymentMethodId, pm.Name PaymentMethodName, "
                + "o.DistribuitorId, u.Name DistribuitorName, u.LastName DistribuitorLastName, "
                + "SUM(od.Quantity * od.Price) Total "
                + "FROM `Order` o "
                + "INNER JOIN OrderDetail od ON o.Id = od.OrderId "
                + "INNER JOIN Client c ON o.ClientId = c.Id "
                + "INNER JOIN ClientAddress ca ON o.AddressId = ca.Id "
                + "INNER JOIN Status s ON o.StatusId = s.Id "
                + "INNER JOIN Voucher v ON o.VoucherId  = v.Id "
                + "INNER JOIN OrderType ot ON o.OrderTypeId = ot.Id "
                + "INNER JOIN PaymentMethod pm ON o.PaymentMethodId = pm.Id "
                + "LEFT JOIN User u ON o.DistribuitorId = u.Id ";

        String concat = "";
        for (int id : ids) {
            concat += id + ",";
        }
        concat += concat.substring(0, concat.length() - 1);
        query += "WHERE o.StatusId IN(" + concat + ")";
        query += "GROUP BY o.Id";

        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new OrderDTO();
                order.setId(rs.getInt("Id"));
                order.setClient(
                        new ClientDTO(
                                rs.getInt("ClientId"),
                                rs.getString("ClientName"),
                                rs.getString("LastName")
                        )
                );
                order.setAddress(
                        new AddressDTO(
                                rs.getInt("AddressId"),
                                rs.getString("Address"),
                                rs.getString("Reference"),
                                rs.getDouble("Latitude"),
                                rs.getDouble("Longitude")
                        )
                );
                order.setStatus(
                        new Status(
                                rs.getInt("StatusId"),
                                rs.getString("StatusName")
                        )
                );
                order.setVoucher(
                        new Voucher(
                                rs.getInt("VoucherId"),
                                rs.getString("VoucherName")
                        )
                );
                order.setOrderType(
                        new OrderType(
                                rs.getInt("OrderTypeId"),
                                rs.getString("OrderTypeName")
                        )
                );
                order.setPaymentMethod(
                        new PaymentMethod(
                                rs.getInt("PaymentMethodId"),
                                rs.getString("PaymentMethodName")
                        )
                );
                order.setDistributor(
                        new UserDTO(
                                rs.getInt("DistribuitorId"),
                                rs.getString("DistribuitorName"),
                                rs.getString("DistribuitorLastName")
                        )
                );
                order.setTotal(rs.getDouble("Total"));
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;

    }

    @Override
    public OrderDTO get(int orderId) {
        OrderDTO order = null;
        String query
                = "SELECT o.Id, o.ClientId, c.Name ClientName, c.LastName, "
                + "o.AddressId, ca.Address, ca.Reference, ca.Latitude, ca.Longitude, "
                + "o.StatusId, s.Name StatusName, "
                + "o.VoucherId, v.Name VoucherName, "
                + "o.OrderTypeId, ot.Name OrderTypeName, "
                + "o.PaymentMethodId, pm.Name PaymentMethodName, "
                + "o.DistribuitorId, u.Name DistribuitorName, u.LastName DistribuitorLastName "
                + "FROM `Order` o "
                + "INNER JOIN Client c ON o.ClientId = c.Id "
                + "INNER JOIN ClientAddress ca ON o.AddressId = ca.Id "
                + "INNER JOIN Status s ON o.StatusId = s.Id "
                + "INNER JOIN Voucher v ON o.VoucherId  = v.Id "
                + "INNER JOIN OrderType ot ON o.OrderTypeId = ot.Id "
                + "INNER JOIN PaymentMethod pm ON o.PaymentMethodId = pm.Id "
                + "LEFT JOIN User u ON o.DistribuitorId = u.Id "
                + "WHERE o.Id = ?";

        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new OrderDTO();
                order.setId(rs.getInt("Id"));
                order.setClient(
                        new ClientDTO(
                                rs.getInt("ClientId"),
                                rs.getString("ClientName"),
                                rs.getString("LastName")
                        )
                );
                order.setAddress(
                        new AddressDTO(
                                rs.getInt("AddressId"),
                                rs.getString("Address"),
                                rs.getString("Reference"),
                                rs.getDouble("Latitude"),
                                rs.getDouble("Longitude")
                        )
                );
                order.setStatus(
                        new Status(
                                rs.getInt("StatusId"),
                                rs.getString("StatusName")
                        )
                );
                order.setVoucher(
                        new Voucher(
                                rs.getInt("VoucherId"),
                                rs.getString("VoucherName")
                        )
                );
                order.setOrderType(
                        new OrderType(
                                rs.getInt("OrderTypeId"),
                                rs.getString("OrderTypeName")
                        )
                );
                order.setPaymentMethod(
                        new PaymentMethod(
                                rs.getInt("PaymentMethodId"),
                                rs.getString("PaymentMethodName")
                        )
                );
                order.setDistributor(
                        new UserDTO(
                                rs.getInt("DistribuitorId"),
                                rs.getString("DistribuitorName"),
                                rs.getString("DistribuitorLastName")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }

    @Override
    public void assignDistributor(int orderId, int distributorId) {
        String query
                = "UPDATE `Order` o SET o.DistribuitorId =? "
                + "WHERE o.Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, distributorId);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void changeStatus(int orderId) {
        String query
                = "UPDATE `Order` o SET o.StatusId =o.StatusId + 1 "
                + "WHERE o.Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cancelOrder(int orderId) {
        String query
                = "UPDATE `Order` o SET o.StatusId = 5 "
                + "WHERE o.Id = ?";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int save(Order order) {
        int id = 0;
        String sql
                = "INSERT INTO `Order`(ClientId, AddressId, StatusId,VoucherId, OrderTypeId, PaymentMethodId) "
                + "VALUES(?,?,?,?,?,?)";
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getClientId());
            ps.setInt(2, order.getAddressId());
            ps.setInt(3, 1);
            ps.setInt(4, order.getVoucherId());
            ps.setInt(5, order.getOrderTypeId());
            ps.setInt(6, order.getPaymentMethodId());
            ps.execute();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public List<OrderDTO> getAll(int clientId) {
       List<OrderDTO> orders = new ArrayList<>();

        OrderDTO order = null;
        String query
                = "SELECT o.Id, o.ClientId, c.Name ClientName, c.LastName, "
                + "o.AddressId, ca.Address, ca.Reference, ca.Latitude, ca.Longitude, "
                + "o.StatusId, s.Name StatusName, "
                + "o.VoucherId, v.Name VoucherName, "
                + "o.OrderTypeId, ot.Name OrderTypeName, "
                + "o.PaymentMethodId, pm.Name PaymentMethodName, "
                + "o.DistribuitorId, u.Name DistribuitorName, u.LastName DistribuitorLastName, "
                + "SUM(od.Quantity * od.Price) Total "
                + "FROM `Order` o "
                + "INNER JOIN OrderDetail od ON o.Id = od.OrderId "
                + "INNER JOIN Client c ON o.ClientId = c.Id "
                + "INNER JOIN ClientAddress ca ON o.AddressId = ca.Id "
                + "INNER JOIN Status s ON o.StatusId = s.Id "
                + "INNER JOIN Voucher v ON o.VoucherId  = v.Id "
                + "INNER JOIN OrderType ot ON o.OrderTypeId = ot.Id "
                + "INNER JOIN PaymentMethod pm ON o.PaymentMethodId = pm.Id "
                + "LEFT JOIN User u ON o.DistribuitorId = u.Id "
                + "WHERE o.ClientId = ? ";
        query += "GROUP BY o.Id";
        

        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, clientId);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new OrderDTO();
                order.setId(rs.getInt("Id"));
                order.setClient(
                        new ClientDTO(
                                rs.getInt("ClientId"),
                                rs.getString("ClientName"),
                                rs.getString("LastName")
                        )
                );
                order.setAddress(
                        new AddressDTO(
                                rs.getInt("AddressId"),
                                rs.getString("Address"),
                                rs.getString("Reference"),
                                rs.getDouble("Latitude"),
                                rs.getDouble("Longitude")
                        )
                );
                order.setStatus(
                        new Status(
                                rs.getInt("StatusId"),
                                rs.getString("StatusName")
                        )
                );
                order.setVoucher(
                        new Voucher(
                                rs.getInt("VoucherId"),
                                rs.getString("VoucherName")
                        )
                );
                order.setOrderType(
                        new OrderType(
                                rs.getInt("OrderTypeId"),
                                rs.getString("OrderTypeName")
                        )
                );
                order.setPaymentMethod(
                        new PaymentMethod(
                                rs.getInt("PaymentMethodId"),
                                rs.getString("PaymentMethodName")
                        )
                );
                order.setDistributor(
                        new UserDTO(
                                rs.getInt("DistribuitorId"),
                                rs.getString("DistribuitorName"),
                                rs.getString("DistribuitorLastName")
                        )
                );
                order.setTotal(rs.getDouble("Total"));
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

}
