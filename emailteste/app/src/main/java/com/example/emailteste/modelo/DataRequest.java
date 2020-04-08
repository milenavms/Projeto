package com.example.emailteste.modelo;

import java.util.ArrayList;

public class DataRequest {
    private String titulo;
    private ArrayList<Email> emails;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }

    public DataRequest(String titulo, ArrayList<Email> emails) {
        this.titulo = titulo;
        this.emails = emails;
    }

    public DataRequest() {
    }
}
