package com.example.permission_service.entity;

public class user_role {
    private Integer id;
    private Long user_id;
    private int role_id;
    private Integer user_role_id = 2; //默认值2=普通用户

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Integer getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Integer user_role_id) {
        this.user_role_id = user_role_id;
    }

    @Override
    public String toString() {
        return "user_role{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", role_id=" + role_id +
                ", user_role_id=" + user_role_id +
                '}';
    }
}
