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

    private int Id;
    private Role Role;
    private String Name;
    private String LastName;

    public UserDTO() {
    }

    public UserDTO(int Id, Role Role, String Name, String LastName) {
        this.Id = Id;
        this.Role = Role;
        this.Name = Name;
        this.LastName = LastName;
    }

    public UserDTO(int Id, String Name, String LastName) {
        this.Id = Id;
        this.Name = Name;
        this.LastName = LastName;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "Id=" + Id + ", Role=" + Role + ", Name=" + Name + ", LastName=" + LastName + '}';
    }

    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        this.Role = role;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFullName() {
        return Name + " " + LastName;
    }

}
