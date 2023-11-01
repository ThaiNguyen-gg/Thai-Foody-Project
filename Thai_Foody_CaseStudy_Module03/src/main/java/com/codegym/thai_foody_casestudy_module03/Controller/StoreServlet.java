package com.codegym.thai_foody_casestudy_module03.Controller;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.Product;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.Review;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.Store;
import com.codegym.thai_foody_casestudy_module03.Model.Service.ProductService;
import com.codegym.thai_foody_casestudy_module03.Model.Service.ReviewService;
import com.codegym.thai_foody_casestudy_module03.Model.Service.StoreService;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Home-Servlet",urlPatterns ={"/home","","/store/detail","/store/search"})
public class StoreServlet extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
                case "/home" :
                    showAllStores(request,response);
                    break;
                case "/store/detail" :
                    showDetailStore(request,response);
                    break;
                case "/store/search" :
                    showStoreBySearch(request,response);
                    break;
                default:
//                    // hiểu là khi người dùng nhập 1 cái link đó - animetvn.com tức là sent request dau tien - thi tu servlet này và ngay đay sẽ nhận request đầu tiên
                    showAllStores(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showAllStores(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException  {
        HttpServletMapping mapping = request.getHttpServletMapping();
        String servletName = mapping.getServletName();
        String pattern = mapping.getPattern();
        System.out.println(servletName + " servletName");
        System.out.println(pattern + " Servlet Pattern");
        List<Store> storeList = StoreService.getInstance().selectAllStore();
        request.setAttribute("storeList",storeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/Main/Main_Page.jsp");
        dispatcher.forward(request,response);

    }

    private void showDetailStore(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException   {
        System.out.println(request.getParameter("id"));
//        String id01 = request.getParameter("id").substring(0, 2);
        long idStore = Long.parseLong(request.getParameter("id"));
//        Long id = Long.parseLong(id01);
        System.out.println(idStore);
        Store store = StoreService.getInstance().selectStoreById(idStore);
        HttpServletMapping mapping = request.getHttpServletMapping();
        String servletName = mapping.getServletName();
        String pattern = mapping.getPattern();
        System.out.println(servletName + " servletName");
        System.out.println(pattern + " Servlet Pattern");
//        Show productList
        List<Product> productListByIdStore = ProductService.getInstance().selectAllProductByStoreId(idStore);
        List<Review> reviewListByIdStore = ReviewService.getInstance().selectAllReviewsByStoreId(idStore);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/Detail/Detail_Store.jsp");
        request.setAttribute("store",store);
        request.setAttribute("productListByIdStore",productListByIdStore);
        request.setAttribute("listReview",reviewListByIdStore);
        dispatcher.forward(request,response);
    }

    public void showStoreBySearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("search") != null) {
            String search = request.getParameter("search");
            List<Store> stores = StoreService.getInstance().selectStoreBySearch(search);
            if (stores.isEmpty()) {
                String messageBySearch = "Your Search hasn't been found \"" + search +"\"";
                request.setAttribute("messageBySearch",messageBySearch);
            }
            request.setAttribute("storeList",stores);
        }
        else {
            request.setAttribute("storeList",StoreService.getInstance().selectAllStore());
        }

        request.getRequestDispatcher("/WEB-INF/View/Main/Main_Page.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
    }

    public void destroy() {
    }
}