package com.codegym.thai_foody_casestudy_module03.Controller;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.User;
import com.codegym.thai_foody_casestudy_module03.Model.Service.StoreService;
import com.codegym.thai_foody_casestudy_module03.Model.Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "User-Servlet",urlPatterns ={"/users","/user/login","/user/logout","/user/register","/user/logged"})
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
        System.out.println(action);
        HttpSession session = request.getSession();
        try {
            switch (action) {
//            Điều hướng đến trang Login khi ở Trang menu có form = request.getContexpath=  /user/login
                case "/user/login":
                    request.getRequestDispatcher("/WEB-INF/View/Login/Login_Register_Page.jsp").forward(request, response);
//                    response.sendRedirect("/WEB-INF/View/Login/Login_Register_Page.jsp");
                    break;
                case "/user/logout":
                    session.invalidate();
                    request.setAttribute("storeList", StoreService.getInstance().selectAllStore());
                    request.getRequestDispatcher("/WEB-INF/View/Main/Main_Page.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        try {
            String action = request.getServletPath();
            System.out.println(action);
            HttpSession session = request.getSession();
            switch (action) {
                case "/user/logged":
                    signIn(request,response,session);
                    break;
                case "/user/register":
                    register(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void signIn(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String nameAccount = request.getParameter("nameAccount");
        String passWord = request.getParameter("passWord");
        User user = UserService.getInstance().selectUserByEmailOrPhoneAndPassword(nameAccount,passWord);
        System.out.println(user);

        if(user == null) {
            String messageForLoginPage = "Name Account Or PassWord is not correct!";
            request.setAttribute("messageForLoginPage",messageForLoginPage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/Login/Login_Register_Page.jsp");
            dispatcher.forward(request,response);
        } else {
            session.setAttribute("user",user);
            request.setAttribute("storeList", StoreService.getInstance().selectAllStore());
            request.getRequestDispatcher("/WEB-INF/View/Main/Main_Page.jsp").forward(request,response);

        }
    }


    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String phoneNumber =request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String passWord = request.getParameter("passWord");
        boolean registerSuccessful = UserService.getInstance().register(userName,passWord,email,phoneNumber);
        String messageForRegisterPage = registerSuccessful ? "Success! Please Login"
                                                            : "Failed! Email or Phone Number has been Registered! ";
        System.out.println(messageForRegisterPage);
        request.setAttribute("messageForRegisterPage", messageForRegisterPage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/Login/Login_Register_Page.jsp");
        dispatcher.forward(request,response);


    }
}
