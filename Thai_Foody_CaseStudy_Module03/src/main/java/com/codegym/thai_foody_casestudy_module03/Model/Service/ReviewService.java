package com.codegym.thai_foody_casestudy_module03.Model.Service;

import com.codegym.thai_foody_casestudy_module03.Model.DAO.ReviewDAO;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.Review;
import com.codegym.thai_foody_casestudy_module03.Model.Service.IplmService.InterfaceReviewService;

import java.util.List;

public class ReviewService implements InterfaceReviewService {

   public static ReviewService getInstance() {
       return new ReviewService();
   }
    @Override
    public boolean addReviews(String review_text, long user_id, long store_id) {
        Review review = new Review(review_text,store_id,user_id);
        return ReviewDAO.getInstance().insertReview(review);
    }


    @Override
    public List<Review> selectAllReviewsByStoreId(long storeId) {
        List<Review> reviewListByStoreId = ReviewDAO.getInstance().getListReviewsByStoreId(storeId);
        return reviewListByStoreId;
    }
}
