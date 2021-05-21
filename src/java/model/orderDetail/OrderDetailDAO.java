/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.orderDetail;

import dto.OrderDetailDTO;
import java.util.List;

/**
 *
 * @author droperdev
 */
public interface OrderDetailDAO {
    public void save(int orderId, OrderDetail orderDetail);
    public List<OrderDetailDTO> get(int orderId);
}
