package com.example.fines_saveurs.resources;

import com.example.fines_saveurs.dao.TicketDao;
import com.example.fines_saveurs.dao.TicketJdbcDao;
import com.example.fines_saveurs.model.Ticket;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("tickets")
public class TicketResources {
    private TicketJdbcDao ticketDao = new TicketJdbcDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTickets() {
        List<Ticket> ticketList = ticketDao.findAll();
        return Response
                .ok(ticketList)
                .build();
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTicket(Ticket ticket) {
        ticketDao.create(ticket);
        return Response
                .ok()
                .build();
    }
}
