/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import java.lang.reflect.Field;
import java.sql.Date;

/**
 *
 * @author droperdev
 */
public class User {

    private int Id;
    private int RoleId;
    private String Name;
    private String LastName;
    private String UserName;
    private String Password;
    private Date CreatedAt;
    private boolean Status;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + Id + ", RoleId=" + RoleId + ", Name=" + Name + ", LastName=" + LastName + ", UserName=" + UserName + ", Password=" + Password + ", CreatedAt=" + CreatedAt + ", Status=" + Status + '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int RoleId) {
        this.RoleId = RoleId;
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

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

}
