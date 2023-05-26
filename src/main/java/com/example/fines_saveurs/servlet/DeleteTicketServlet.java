package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = DeleteTicketServlet.URL)
public class DeleteTicketServlet extends HttpServlet {
    public static final String URL = "/secured/delete-ticket";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        TicketService ticketService = new TicketService();
        ticketService.deleteTicket(id);
        response.sendRedirect(request.getContextPath() + "/secured/tickets");
    }

}
