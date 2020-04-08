package com.example.emailservice.modelo;

import java.util.Objects;

public class Email {
    private Long id;
    private String msg;

    public Email(Long id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public Long getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(msg, email.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg);
    }
}
