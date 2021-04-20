/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.product;

import java.util.List;

/**
 *
 * @author IVAN
 */
public interface ProductDAO {
    List<Product> list(int idCategory);
}
