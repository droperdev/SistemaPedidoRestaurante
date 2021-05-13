/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.client;

import dto.ClientDTO;

/**
 *
 * @author Administrador
 */
public interface ClientDAO {
     public Client getClient(int id);
     public ClientDTO validateCredentials(String email, String password);
}
