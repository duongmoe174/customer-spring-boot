package com.duong.customerboot.model;

import javax.persistence.*;

@Entity
@Table (name = "appuser")
public class AppUser {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    @ManyToOne
    private AppRole appRole;

    public AppUser(Long id, String name, String password, AppRole appRole) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.appRole = appRole;
    }

    public AppUser() {
    }

    public AppUser(String name, String password, AppRole appRole) {
        this.name = name;
        this.password = password;
        this.appRole = appRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", appRole=" + appRole +
                '}';
    }
}
