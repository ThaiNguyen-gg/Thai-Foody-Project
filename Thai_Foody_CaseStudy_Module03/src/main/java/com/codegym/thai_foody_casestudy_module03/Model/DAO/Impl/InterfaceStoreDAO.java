package com.codegym.thai_foody_casestudy_module03.Model.DAO.Impl;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.Store;

import java.util.List;

public interface InterfaceStoreDAO {
    public List<Store> getAll();
    public  Store getStoreByID(long id);



}
