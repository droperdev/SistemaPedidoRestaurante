/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.role.Role;
import model.role.RoleDAOImpl;
import model.user.User;
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
        User user = userDAO.validateCredentials("plumbre", "123456");

        System.out.println("User: " + user.toString());
    }
}
