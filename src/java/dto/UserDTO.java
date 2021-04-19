/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author droperdev
 */
public class UserDTO {

    private int Id;
    private String Name;
    private String LastName;

    public UserDTO() {
    }

    public UserDTO(int Id, String Name, String LastName) {
        this.Id = Id;
        this.Name = Name;
        this.LastName = LastName;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "Id=" + Id + ", Name=" + Name + ", LastName=" + LastName + '}';
    }
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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
    
    
}
