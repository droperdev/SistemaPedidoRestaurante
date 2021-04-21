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
public class AddressDTO {

    private int Id;
    private String Address;
    private String References;
    private Double Latitude;
    private Double Longitude;

    public AddressDTO() {
    }

    public AddressDTO(int Id, String Address, String References, Double Latitude, Double Longitude) {
        this.Id = Id;
        this.Address = Address;
        this.References = References;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
    }

    @Override
    public String toString() {
        return "AddressDTO{" + "Id=" + Id + ", Address=" + Address + ", References=" + References + ", Latitude=" + Latitude + ", Longitude=" + Longitude + '}';
    }

    
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getReferences() {
        return References;
    }

    public void setReferences(String References) {
        this.References = References;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double Latitude) {
        this.Latitude = Latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double Longitude) {
        this.Longitude = Longitude;
    }

}
