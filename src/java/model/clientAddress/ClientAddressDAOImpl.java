

package model.clientAddress;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientAddressDAOImpl implements ClientAddressDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public ClientAddress getClientAddress(int id) {
        ClientAddress clientAddress = null;
<<<<<<< HEAD
        String query = "SELECT * FROM Client WHERE Id=?";
=======
        String query = "SELECT * FROM ClientAddress WHERE Id=?";
>>>>>>> develop
        con = cn.getConnection();
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientAddress = new ClientAddress();
                clientAddress.setId(rs.getInt("Id"));
                clientAddress.setClientId(rs.getInt("ClientId"));
                clientAddress.setAddress(rs.getString("Address"));
                clientAddress.setReference(rs.getString("Reference"));
                clientAddress.setLatitude(rs.getDouble("Latitude"));
                clientAddress.setLongitude(rs.getDouble("Longitude"));
                clientAddress.setCreatedAt(rs.getDate("CreatedAt"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientAddressDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientAddress;
}
}