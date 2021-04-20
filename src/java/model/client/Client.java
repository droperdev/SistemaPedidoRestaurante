
package model.client;

import java.sql.Date;


public class Client {
   private int Id;
   private String Name;
   private String LastName;
   private String Phone;
   private String Email;
   private Date Birthday;
   private Date CreatedAt;

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" + "Id=" + Id + ", Name=" + Name + ", LastName=" + LastName + ", Phone=" + Phone + ", Email=" + Email + ", Birthday=" + Birthday + ", CreatedAt=" + CreatedAt + '}';
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }
   
   
}

