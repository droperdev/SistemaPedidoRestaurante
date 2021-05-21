/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.faces.action.RequestMapping;
import dto.ClientDTO;
import dto.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.client.Client;
import model.client.ClientDAOImpl;
import model.clientAddress.ClientAddress;
import model.clientAddress.ClientAddressDAO;
import model.clientAddress.ClientAddressDAOImpl;
import model.user.UserDAOImpl;

/**
 *
 * @author droperdev
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    HttpSession session;

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
        String action = request.getParameter("action");
        switch (action) {
            case "login": {
                session = request.getSession();
                session.setAttribute("message", "");
                String userName = request.getParameter("userName");
                String password = request.getParameter("password");

                UserDAOImpl userDAO = new UserDAOImpl();
                UserDTO user = userDAO.validateCredentials(userName, password);
                if (user != null) {
                    session.setAttribute("user", user);
                    response.sendRedirect("admin/orders.jsp");
                    //request.getRequestDispatcher("main.jsp").forward(request, response);
                } else {
                    session.setAttribute("message", "Credenciales invalidas");
                    response.sendRedirect("admin/index.jsp");
                }
                break;
            }

            case "client-login": {
                session = request.getSession();
                session.setAttribute("message", "");
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                ClientDAOImpl clientDAO = new ClientDAOImpl();
                ClientDTO client = clientDAO.validateCredentials(email, password);
                if (client != null) {
                    session.setAttribute("client", client);
                    response.sendRedirect("client/main.jsp");
                } else {
                    session.setAttribute("message", "Credenciales invalidas");
                    response.sendRedirect("client/index.jsp");
                }
                break;
            }

            case "register":
                String name = request.getParameter("name");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                String address = request.getParameter("address");
                String reference = request.getParameter("reference");
                Double latitude = Double.parseDouble(request.getParameter("latitude"));
                Double longitude = Double.parseDouble(request.getParameter("longitude"));

                Client client = new Client();
                client.setName(name);
                client.setLastName(lastName);
                client.setEmail(email);
                client.setPassword(password);

                ClientDAOImpl clientDAO = new ClientDAOImpl();
                int clientId = clientDAO.save(client);
                
                ClientAddress clientAddress = new ClientAddress();
                clientAddress.setClientId(clientId);
                clientAddress.setAddress(address);
                clientAddress.setReference(reference);
                clientAddress.setLatitude(latitude);
                clientAddress.setLongitude(longitude);
                
                ClientAddressDAOImpl clientAddressDAO = new ClientAddressDAOImpl();
                clientAddressDAO.save(clientAddress);
  
                //session.setAttribute("message", "Credenciales invalidas");
                response.sendRedirect("client/index.jsp");
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
