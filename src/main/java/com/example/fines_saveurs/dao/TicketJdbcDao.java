package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.fines_saveurs.dao.DataBase.getConnection;

public class TicketJdbcDao implements TicketDao{
    private final Connection connection = getConnection();

    @Override
    public boolean create(Ticket entity) {

        String query = "INSERT INTO flavour.ticket (text_input, user_email, admin_id) VALUES (?,?,?);";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, entity.getTextInput());
            pst.setString(2, entity.getUserEmail());
            pst.setLong(3, entity.getAdminId());
            int row = pst.executeUpdate();
            if (row == 1) {
                return true;
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> tickets = new ArrayList<>();
        String query = "SELECT * FROM ticket";

        try (Statement statement = connection.createStatement()) {
             ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setId((long) resultSet.getInt("id"));
                ticket.setUserEmail(resultSet.getString("user_email"));
                ticket.setAdminId(resultSet.getInt("admin_id"));
                ticket.setTextInput(resultSet.getString("text_input"));

                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public Ticket findById(Long aLong) {
        return null;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public boolean delete(Ticket entity) {
        return false;
    }
}
