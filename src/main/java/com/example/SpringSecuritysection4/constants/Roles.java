package com.example.SpringSecuritysection4.constants;

public enum Roles {
    MANAGER("manager"),
    EXECUTIVE("executive"),
    ADMIN("admin");

    private String role;
    Roles(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
