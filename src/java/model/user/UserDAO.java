/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import dto.UserDTO;
import java.util.List;

/**
 *
 * @author droperdev
 */
public interface UserDAO {

    public UserDTO validateCredentials(String userName, String password);
    public List<UserDTO> getDistributors(int roleId);
    public List<UserDTO> getAll();
    public void save(UserDTO userDTO);
    public void delete(int userId);
}
