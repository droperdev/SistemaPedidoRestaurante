/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.OrderDTO;
import dto.OrderDetailDTO;
import dto.UserDTO;
import java.util.List;
import model.order.OrderDAOImpl;
import model.orderDetail.OrderDetail;
import model.orderDetail.OrderDetailDAOImpl;
import model.role.Role;
import model.role.RoleDAOImpl;
import model.user.UserDAOImpl;

/**
 *
 * @author droperdev
 */
public class Test {

    public static void main(String[] args) {

        RoleDAOImpl roleDAO = new RoleDAOImpl();
        Role role = roleDAO.getRole(1);

        System.out.println("Role: " + role.toString());

        UserDAOImpl userDAO = new UserDAOImpl();
        UserDTO user = userDAO.validateCredentials("plumbre", "123456");

        System.out.println("User: " + user.toString());

        OrderDAOImpl orderDAO = new OrderDAOImpl();
        int[] ids = {1, 2, 3};
        List<OrderDTO> orders = orderDAO.getAll(ids);

        for (OrderDTO order : orders) {
            System.out.println("Order: " + order.toString());
        }

        OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
        List<OrderDetailDTO> orderDetails = orderDetailDAO.get(5);
        for (OrderDetailDTO orderDetail : orderDetails) {
            System.out.println("OrderDetail: " + orderDetail.toString());
        }

        OrderDTO order = new OrderDAOImpl().get(1);

        System.out.println("Order: " + order.toString());
        
        new OrderDAOImpl().assignDistributor(1, 5);
        
        List<UserDTO> users = userDAO.getDistributors(2);
         for (UserDTO userX : users) {
            System.out.println("users: " + userX.toString());
        }

    }
}
