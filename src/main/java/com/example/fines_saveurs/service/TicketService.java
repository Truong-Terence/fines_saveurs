package com.example.fines_saveurs.service;
import com.example.fines_saveurs.dao.TicketJdbcDao;
import com.example.fines_saveurs.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private final TicketJdbcDao ticketDao = new TicketJdbcDao();

    public boolean createTicket(String userEmail, int adminId, String textInput) {
        Ticket ticket = new Ticket(userEmail, (long) adminId, textInput);
        return ticketDao.create(ticket);

    }

    public List<Ticket> fetchAllTickets() {
        return ticketDao.findAll();
    }
}
