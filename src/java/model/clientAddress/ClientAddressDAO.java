
package model.clientAddress;


public interface ClientAddressDAO {
    public ClientAddress getAddress(int clientId);
    public ClientAddress getClientAddress(int id);
    public void save(ClientAddress clientAddress);
}
