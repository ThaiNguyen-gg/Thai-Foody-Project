package com.codegym.thai_foody_casestudy_module03.Model.DAO.Impl;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.Review;

import java.util.List;

public interface InterfaceReviewDAO {
    // thêm Review vào dtb
    public boolean insertReview(Review review);

    // show review theo id Store
    public List<Review> getListReviewsByStoreId(long id);






}
