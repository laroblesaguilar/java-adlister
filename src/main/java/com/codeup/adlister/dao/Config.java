package com.codeup.adlister.dao;

import java.sql.Connection;

public class Config {

    private String url;
    private String user;
    private String password;

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Config(){
        this.url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
        this.user = "root";
        this.password = "";
    };


//    public String getUrl() {
//        return "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
//    }
//    public String getUser() {
//        return "root";
//    }
//    public String getPassword() {
//        return "";
//    }

    public static void main(String[] args) {
        Config config = new Config();
        System.out.println(config.getPassword());
    }
}
