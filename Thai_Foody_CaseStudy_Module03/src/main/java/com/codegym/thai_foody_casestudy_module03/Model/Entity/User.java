package com.codegym.thai_foody_casestudy_module03.Model.Entity;

public class User {
    private long id;
    private String name;
    private String passWord;
    private String email;
    private String phoneNumber;

    private String imageURl;


    public User() {}


    public User(String name, String passWord, String email, String phone, String imageURl ){
        this.name = name;
        this.phoneNumber = phone;
        this.email = email;
        this.passWord = passWord;
        this.imageURl = imageURl;
    }

    public User(long id, String name, String passWord, String email, String phoneNumber, String imageURl) {
        this.id = id;
        this.imageURl = imageURl;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passWord = passWord;
    }

    public User(String name, String passWord, String email, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passWord = passWord;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    @Override
    public String toString() {
        return String.format("Id=%d: { Name:%s, email: %s, phone: %s, passWord: %s}",
                getId(),
                getName(),
                getEmail(),
                getPhoneNumber(),
                getPassWord()
        );
    }


}
