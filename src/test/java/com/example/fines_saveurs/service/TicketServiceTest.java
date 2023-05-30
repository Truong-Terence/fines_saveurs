package com.example.fines_saveurs.service;

import com.example.fines_saveurs.dao.TicketJdbcDao;
import com.example.fines_saveurs.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    @Mock
    private TicketJdbcDao ticketDaoMock;

    @InjectMocks
    private TicketService underTest;
    @Test
    void shouldReturnTrueGivenParams() {
        String userEmail = "";
        int adminId = 1;
        String textInput = "";

        when(ticketDaoMock.create(any(Ticket.class))).thenReturn(true);

        boolean result = underTest.createTicket(userEmail, adminId, textInput);

        assertTrue(result);
    } // createTicket

    @Test
    void shouldReturnFalseGivenParams() {
        String userEmail = "";
        int adminId = 1;
        String textInput = "";

        when(ticketDaoMock.create(any(Ticket.class))).thenReturn(false);

        boolean result = underTest.createTicket(userEmail, adminId, textInput);

        assertFalse(result);
    } // createTicket

    @Test
    void shouldReturnAllTickets() {
        List<Ticket> expectedTickets = new ArrayList<>();
        expectedTickets.add(new Ticket(1L, "", 1, ""));
        expectedTickets.add(new Ticket(2L, "", 2, ""));

        when(ticketDaoMock.findAll()).thenReturn(expectedTickets);

        List<Ticket> result = underTest.fetchAllTickets();

        assertEquals(expectedTickets, result);
    } // fetchAllTickets

    @Test
    void shouldReturnTrueGivenId() {
        int ticketId = 1;

        when(ticketDaoMock.delete(any(Ticket.class))).thenReturn(true);

        boolean result = underTest.deleteTicket(ticketId);

        assertTrue(result);
    } // deleteTicket

    @Test
    void shouldReturnFalseGivenId() {
        int ticketId = 1;

        when(ticketDaoMock.delete(any(Ticket.class))).thenReturn(false);

        boolean result = underTest.deleteTicket(ticketId);

        assertFalse(result);
    } // deleteTicket

}