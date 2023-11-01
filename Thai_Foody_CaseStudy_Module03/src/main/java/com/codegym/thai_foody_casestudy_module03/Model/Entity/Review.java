package com.codegym.thai_foody_casestudy_module03.Model.Entity;

public class Review {
    private long id;
    private String review_text;
    private long storeId;
    private long userId;
    private String created_at;
    private String userName;
    private String userImage_URL;
    public Review(long id, String review_text, long storeId, long userId, String created_at) {
        this.id = id;
        this.review_text = review_text;
        this.storeId = storeId;
        this.userId = userId;
        this.created_at = created_at;
    }

    //Contructor nay dùng để Select lên để hiện lên trang Comment
    public Review(String review_text, String created_at, String userName, String userImage_URL) {
        this.review_text = review_text;
        this.userName = userName;
        this.created_at = created_at;
        this.userImage_URL = userImage_URL;
    }
    // Constructor nay dùng để insert xuống Database
    public Review(String review_text, long storeId, long userId) {
        this.review_text = review_text;
        this.storeId = storeId;
        this.userId = userId;
    }

    public Review() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage_URL() {
        return userImage_URL;
    }

    public void setUserImage_URL(String userImage_URL) {
        this.userImage_URL = userImage_URL;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }


    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getUserId() {
        return userId;
    }


    public String toString() {
        return String.format(
                "This Reviews have: { user id %d, store id %d, text: %s }",
                getId(),getStoreId(),getReview_text()
        );
    }
}
