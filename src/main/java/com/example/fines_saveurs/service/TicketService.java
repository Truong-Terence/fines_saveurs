package com.example.fines_saveurs.service;
import com.example.fines_saveurs.dao.CategoryDao;
import com.example.fines_saveurs.dao.TicketDao;
import com.example.fines_saveurs.dao.TicketJdbcDao;
import com.example.fines_saveurs.model.Ticket;

import java.util.List;

public class TicketService {
    private TicketDao ticketDao;

    public TicketService() {
        ticketDao = new TicketJdbcDao();
    }

    public TicketService(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public boolean createTicket(String userEmail, int adminId, String textInput) {
        Ticket ticket = new Ticket(userEmail, (long) adminId, textInput);
        return ticketDao.create(ticket);

    }

    public List<Ticket> fetchAllTickets() {
        return ticketDao.findAll();
    }

    public boolean deleteTicket(int id) {
        return ticketDao.delete(new Ticket((long) id));
    }
}
