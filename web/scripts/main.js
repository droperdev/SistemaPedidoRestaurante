/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

openDetail = (orderId) => {
    console.log(orderId);
    $("#MyModal").modal('show');
    $("#MyModalLabel").text("Detalle de pedido N°" + orderId);
    $("#content-modal").load("detail.jsp", {orderId});
};