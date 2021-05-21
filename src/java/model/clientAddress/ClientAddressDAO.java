
package model.clientAddress;


public interface ClientAddressDAO {
    public ClientAddress getClientAddress(int id);
    public void save(ClientAddress clientAddress);
}
