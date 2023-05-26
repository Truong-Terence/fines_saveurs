package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Admin;
import com.example.fines_saveurs.model.Ticket;
import com.example.fines_saveurs.service.AdminService;
import com.example.fines_saveurs.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddTicketServlet", urlPatterns = {"/secured/tickets"})
public class AddTicketServlet extends HttpServlet {
    private TicketService ticketService = new TicketService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ticket> tickets = ticketService.fetchAllTickets();
        req.setAttribute("tickets", tickets);
        req.getRequestDispatcher("/WEB-INF/tickets.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("userEmail");
        int adminId = Integer.parseInt(request.getParameter("adminId"));
        String textInput = request.getParameter("textInput");

        Ticket ticket = new Ticket();
        ticket.setUserEmail(userEmail);
        ticket.setAdminId(adminId);
        ticket.setTextInput(textInput);

        new TicketService().createTicket(userEmail, adminId, textInput);

        response.setStatus(HttpServletResponse.SC_OK);
    }

}
