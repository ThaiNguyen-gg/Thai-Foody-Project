package com.codegym.thai_foody_casestudy_module03.Model.Service;

import com.codegym.thai_foody_casestudy_module03.Model.DAO.UserDAO;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.User;
import com.codegym.thai_foody_casestudy_module03.Model.Service.IplmService.InterfaceUserService;

public class UserService implements InterfaceUserService {
    public static UserService getInstance() {
        return new UserService();
    }
    @Override
    public  boolean register(String name,String passWord,String email, String phoneNumber) {
        User user = new User(name,passWord,email,phoneNumber);
        return UserDAO.getInstance().insert(user);
    }

    @Override
    public User selectUserByEmailOrPhoneAndPassword(String loginName, String password){
        return UserDAO.getInstance().getUserByEmailOrPhoneAndPassWord(loginName,password);
    }

}
