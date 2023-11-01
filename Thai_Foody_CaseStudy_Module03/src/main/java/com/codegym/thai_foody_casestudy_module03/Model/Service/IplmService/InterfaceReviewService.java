package com.codegym.thai_foody_casestudy_module03.Model.Service.IplmService;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.Product;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.Review;

import java.util.List;

public interface InterfaceReviewService {

    public  boolean addReviews(String review_text,long user_id, long store_id);
    public List<Review> selectAllReviewsByStoreId(long storeId);

}
