package com.codegym.thai_foody_casestudy_module03.Model.Service.IplmService;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.User;

public interface InterfaceUserService {

  public  boolean register(String name, String passWord, String email, String phoneNumber);


  public User selectUserByEmailOrPhoneAndPassword(String loginName, String password);

}
