/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

openDetail = (orderId) => {
    console.log(orderId);
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg").addClass("modal-lg");
    $("#MyModalLabel").text("Detalle de pedido N° " + orderId);
    $("#content-modal").load("detail.jsp", {orderId});
};

openMap = (orderId) => {
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg").addClass("modal-lg");
    $("#MyModalLabel").text("Detalle de pedido N° " + orderId);
    $("#content-modal").load("map.jsp", {orderId});
}

openAssignOrder = (orderId) => {
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg").addClass("modal-md");
    $("#MyModalLabel").text("Asignar distribuidor al pedido N° " + orderId);
    $("#content-modal").load("assign.jsp", {orderId});
}

openChangeStatus = (orderId) => {
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Cambio de estado del pedido N° " + orderId);
    $("#content-modal").load("status.jsp", {orderId});
}

openCancelOrder = (orderId) => {
    $("#MyModal").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel").text("Anular pedido N° " + orderId);
    $("#content-modal").load("cancel.jsp", {orderId});
}

openUser = () => {
    $("#MyModal2").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel2").text("Registrar usuario");
    $("#content-modal").load("userAdd.jsp");
};

openDeleteUser = (userId) => {
    $("#MyModal2").modal('show');
    $(".modal-dialog").removeClass("modal-lg modal-md").addClass("modal-md");
    $("#MyModalLabel2").text("Eliminar Usuario N° " + userId);
    $("#content-modal").load("userDelete.jsp", {userId});
};