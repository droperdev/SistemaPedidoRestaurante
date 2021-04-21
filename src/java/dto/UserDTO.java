/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.role.Role;

/**
 *
 * @author droperdev
 */
public class UserDTO {

    private int id;
    private Role role;
    private String name;
    private String lastName;

    public UserDTO() {
    }

    public UserDTO(int id, Role role, String name, String lastName) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.lastName = lastName;
    }

    public UserDTO(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", role=" + role + ", name=" + name + ", lastName=" + lastName + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.name + " " + this.lastName;
    }

}
