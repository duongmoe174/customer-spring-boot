package com.duong.customerboot.model;

import javax.persistence.*;

@Entity
@Table(name = "customer" )
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String image;
    @ManyToOne
    private Province province;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String image, Province province) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
        this.province = province;
    }

    public Customer(String name, String email, String image, Province province) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.province = province;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", province=" + province +
                '}';
    }
}
