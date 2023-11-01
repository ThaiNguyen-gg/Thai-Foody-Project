package com.codegym.thai_foody_casestudy_module03.Model.Service.IplmService;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.Store;

import java.util.List;

public interface InterfaceStoreService {
    public List<Store> selectAllStore();
    public Store selectStoreById(long id);

    public List<Store> selectStoreBySearch(String search);



}
