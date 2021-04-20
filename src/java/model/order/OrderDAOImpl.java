/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import config.Conexion;
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
import model.paymentMethod.PaymentMethod;
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
                = "SELECT o.Id, o.ClientId, c.Name ClientName, c.LastName, o.AddressId, "
                + "o.VoucherId, v.Name VoucherName, "
                + "o.PaymentMethodId, pm.Name PaymentMethodName, "
                + "o.DistribuitorId, u.Name DistribuitorName, u.LastName DistribuitorLastName "
                + "FROM `Order` o "
                + "INNER JOIN Client c ON c.Id = o.ClientId "
                + "INNER JOIN Voucher v ON v.Id = o.VoucherId "
                + "INNER JOIN PaymentMethod pm ON pm.Id = o.PaymentMethodId "
                + "INNER JOIN User u ON u.Id = o.DistribuitorId ";

        String concat = "";
        for (int id : ids) {
            concat += id + ",";
        }
        concat += concat.substring(0, concat.length() - 1);
        query += "WHERE o.StatusId IN(" + concat + ")";

        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new OrderDTO();
                order.setId(rs.getInt("Id"));
                order.setClient(new ClientDTO(rs.getInt("ClientId"), rs.getString("ClientName"), rs.getString("LastName")));
                order.setAddressId(rs.getInt("AddressId"));
                order.setVoucher(new Voucher(rs.getInt("VoucherId"), rs.getString("VoucherName")));
                order.setPaymentMethod(new PaymentMethod(rs.getInt("PaymentMethodId"), rs.getString("PaymentMethodName")));
                order.setDistributor(new UserDTO(rs.getInt("DistribuitorId"), rs.getString("DistribuitorName"), rs.getString("DistribuitorLastName")));
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;

    }

}
