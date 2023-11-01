package com.codegym.thai_foody_casestudy_module03.Controller;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.Review;
import com.codegym.thai_foody_casestudy_module03.Model.Service.ReviewService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReviewServlet", urlPatterns = "/store/ReviewServlet")
public class ReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getServletPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
        System.out.println(action);
        String review_text = request.getParameter("content");
        System.out.println(review_text);
//        long storeId = request.getDateHeader("idStore");
        long storeId = Long.parseLong(request.getParameter("idStore"));
        long userId = Long.parseLong(request.getParameter("idUserAccount"));
        boolean insertReview = ReviewService.getInstance().addReviews(review_text,userId,storeId);
        if(insertReview) {
            System.out.println("you win ");
        }
        List<Review> reviewListByIdStore = ReviewService.getInstance().selectAllReviewsByStoreId(storeId);
        request.setAttribute("listReview",reviewListByIdStore);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/Detail/Comment.jsp");
        dispatcher.forward(request,response);


    }
}