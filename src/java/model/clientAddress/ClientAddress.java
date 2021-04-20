
package model.clientAddress;

import java.sql.Date;


public class ClientAddress {
   private int Id;
   private int ClientId;
   private String Address;
   private String Reference;
   private Double Latitude;
   private Double Longitude;
   private Date CreatedAt;

    public ClientAddress() {
    }

    @Override
    public String toString() {
        return "ClientAddress{" + "Id=" + Id + ", ClientId=" + ClientId + ", Address=" + Address + ", Reference=" + Reference + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", CreatedAt=" + CreatedAt + '}';
    }

    
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int ClientId) {
        this.ClientId = ClientId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getReference() {
        return Reference;
    }

    public void setReference(String Reference) {
        this.Reference = Reference;
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

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }
   
    
}   
