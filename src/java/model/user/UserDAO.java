/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import dto.UserDTO;

/**
 *
 * @author droperdev
 */
public interface UserDAO {

    public UserDTO validateCredentials(String userName, String password);
}
