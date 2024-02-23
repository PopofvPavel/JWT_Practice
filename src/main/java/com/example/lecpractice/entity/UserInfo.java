package com.example.lecpractice.entity;

import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;

}
