package model.client;

import java.sql.Date;

public class Client {

    private int id;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private Date birthday;
    private Date createdAt;

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + ", birthday=" + birthday + ", createdAt=" + createdAt + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
