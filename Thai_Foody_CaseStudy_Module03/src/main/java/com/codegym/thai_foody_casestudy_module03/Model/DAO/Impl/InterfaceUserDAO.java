package com.codegym.thai_foody_casestudy_module03.Model.DAO.Impl;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.User;

public interface InterfaceUserDAO {
    boolean insert(User user);

    public User getUserByEmailOrPhoneAndPassWord(String loginName, String passWord);


}
