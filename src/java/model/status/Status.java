/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.status;

/**
 *
 * @author IVAN
 */
public class Status {

    private int id;
    private String name;

    public Status() {
    }

    public Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Status{" + "id=" + id + ", Name=" + name + '}';
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

    public String getClassName() {
        String className = "";
        switch (id) {
            case 1:
                className = "badge p-2 badge-pill badge-warning";
                break;
            case 2:
                className = "badge p-2 badge-pill badge-info";
                break;
            case 3:
                className = "badge p-2 badge-pill badge-success";
                break;
            case 4:
                className = "badge p-2 badge-pill badge-success";
                break;
            case 5:
                className = "badge p-2 badge-pill badge-danger";
                break;
        }
        return className;
    }

}
