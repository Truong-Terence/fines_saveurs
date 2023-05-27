package com.example.fines_saveurs.model;
public class Ticket {
    private long id;
    private String userEmail;
    private int adminId;
    private String textInput;

    public Ticket() {
    }

    public Ticket(String userEmail, Long adminId, String textInput) {
        this.userEmail = userEmail;
        this.adminId = Math.toIntExact(adminId);
        this.textInput = textInput;
    }

    public Ticket(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getTextInput() {
        return textInput;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }
}

