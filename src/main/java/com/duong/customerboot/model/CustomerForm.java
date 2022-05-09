package com.duong.customerboot.model;


import org.springframework.web.multipart.MultipartFile;

public class CustomerForm {
    private Long id;
    private String name;
    private String email;
    private MultipartFile image;
    private Province province;

    public CustomerForm() {
    }

    public CustomerForm(Long id, String name, String email, MultipartFile image, Province province) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
        this.province = province;
    }

    public CustomerForm(String name, String email, MultipartFile image, Province province) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
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
        return "CustomerForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", image=" + image +
                ", province=" + province +
                '}';
    }
}
