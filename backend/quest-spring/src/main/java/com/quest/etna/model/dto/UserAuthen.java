package com.quest.etna.model.dto;

public class UserAuthen {

    private String username;
    private String password;

    public UserAuthen(){};

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
