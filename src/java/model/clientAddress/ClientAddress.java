package model.clientAddress;

import java.sql.Date;

public class ClientAddress {

    private int id;
    private int clientId;
    private String address;
    private String reference;
    private Double latitude;
    private Double longitude;
    private Date createdAt;

    public ClientAddress() {
    }

    @Override
    public String toString() {
        return "ClientAddress{" + "id=" + id + ", clientId=" + clientId + ", address=" + address + ", reference=" + reference + ", latitude=" + latitude + ", longitude=" + longitude + ", createdAt=" + createdAt + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
