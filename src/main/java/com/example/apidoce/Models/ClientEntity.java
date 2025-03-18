package com.example.apidoce.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente")
public class ClientEntity {
    @Id
    private String id;
    private String email;
    private String password;
    private boolean adm;

    public ClientEntity() {
    }

    public ClientEntity(String id, String email, String password, boolean adm) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.adm = adm;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
