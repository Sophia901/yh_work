package com.example.permission_service.entity;

public class roles {
    private int role_id;
    private String role_code;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    @Override
    public String toString() {
        return "roles{" +
                "role_id=" + role_id +
                ", role_code='" + role_code + '\'' +
                '}';
    }
}
