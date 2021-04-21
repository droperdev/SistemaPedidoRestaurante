/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.category;

import java.sql.Date;

/**
 *
 * @author IVAN
 */
public class Category {

    private int id;
    private String name;
    private Date createdAt;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", createdAt=" + createdAt + '}';
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
