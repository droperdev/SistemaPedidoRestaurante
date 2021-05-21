/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


openCart = () => {
     $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg").addClass("modal-lg");
    $("#MyModalLabel").text("Carrito de compras");
    $("#content-modal").load("cart.jsp");
}


loadProducts = (categoryId) => {
    console.log(categoryId);
    $("#products").load("products.jsp", {categoryId});
};

window.onload = () => {
    loadProducts(1);
}