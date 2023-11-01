package com.codegym.thai_foody_casestudy_module03.Model.Entity;

public class Store {
    private long id;
    private String name;
    private int phoneNumber;
    private String district;
    private float qualityIndex;
    private String openHours;
    private String closedHours;
    private String type;

    private String imageURL;
    public Store(String name,String type , int phoneNumber , String district, float qualityIndex, String openHours, String closedHours,String imageURL ){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.district = district;
        this.qualityIndex = qualityIndex;
        this.openHours = openHours;
        this.closedHours = closedHours;
        this.imageURL = imageURL;
    }

    public Store(long id, String name,String type, int phoneNumber,String district, float qualityIndex, String openHours, String closedHours, String imageURL ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.district = district;
        this.qualityIndex = qualityIndex;
        this.openHours = openHours;
        this.closedHours = closedHours;
        this.imageURL = imageURL;
    }
    public long getId() {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public float getQualityIndex() {
        return qualityIndex;
    }

    public void setQualityIndex(float qualityIndex) {
        this.qualityIndex = qualityIndex;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getClosedHours() {
        return closedHours;
    }
    public void setClosedHours(String closedHours) {
        this.closedHours = closedHours;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return String.format("Name: %s Type: %s phone-number: %s district: %s, ",
                getName(), getType(), getPhoneNumber(), getDistrict()).toUpperCase();
    }
}
