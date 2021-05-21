/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.order.OrderDAOImpl;
import model.user.UserDAOImpl;

/**
 *
 * @author droperdev
 */
@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session;
        String action = request.getParameter("action");

        switch (action) {
            case "users":
                response.sendRedirect("admin/user.jsp");
                break;
            case "orders":
                response.sendRedirect("admin/orders.jsp");
                break;
            case "history":
                response.sendRedirect("admin/history.jsp");
                break;
            case "assign":
                int orderId = Integer.parseInt(request.getParameter("orderId"));
                int distributorId = Integer.parseInt(request.getParameter("distributorId"));
                OrderDAOImpl orderDAO = new OrderDAOImpl();
                orderDAO.assignDistributor(orderId, distributorId);
                orderDAO.changeStatus(orderId);
                response.sendRedirect("admin/orders.jsp");
                break;
            case "status":
                orderId = Integer.parseInt(request.getParameter("orderId"));
                new OrderDAOImpl().changeStatus(orderId);
                response.sendRedirect("admin/orders.jsp");
                break;
            case "cancel":
                orderId = Integer.parseInt(request.getParameter("orderId"));
                new OrderDAOImpl().cancelOrder(orderId);
                response.sendRedirect("admin/orders.jsp");
                break;
            case "registerUser":
                UserDAOImpl userDAO = new UserDAOImpl();
                UserDTO user = null;
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String usuario = request.getParameter("usuario");
                String password = request.getParameter("password");
                user = new UserDTO();
                user.setName(nombre);
                user.setLastName(apellido);
                user.setUserName(usuario);
                user.setPassword(password);
                userDAO.save(user);
                response.sendRedirect("admin/user.jsp");
                break;
            case "userDelete":
                int userId = Integer.parseInt(request.getParameter("userId"));
                new UserDAOImpl().delete(userId);
                response.sendRedirect("admin/user.jsp");
                break;
            case "logout":
                session = request.getSession();
                session.removeAttribute("user");
                response.sendRedirect("admin/index.jsp");
                break;

            case "logout-client":
                session = request.getSession();
                session.removeAttribute("client");
                response.sendRedirect("client/index.jsp");
                break;

            case "main":
                response.sendRedirect("client/main.jsp");
                break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
