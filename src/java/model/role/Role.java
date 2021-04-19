/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.role;

/**
 *
 * @author droperdev
 */
public class Role {
    private int Id;
    private String Name;

    @Override
    public String toString() {
        return "Role{" + "Id=" + Id + ", Name=" + Name + '}';
    }
    
    

    public Role() {
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
    
    
}
