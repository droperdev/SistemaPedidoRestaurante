/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.order;

import dto.OrderDTO;
import java.util.List;

/**
 *
 * @author droperdev
 */
public interface OrderDAO {
    public OrderDTO get(int orderId);
    public List<OrderDTO> getAll(int[] ints);
}
