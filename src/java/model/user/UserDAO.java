/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

/**
 *
 * @author droperdev
 */
public interface UserDAO {

    public User validateCredentials(String userName, String password);
}
