package com.codegym.thai_foody_casestudy_module03.Model.Service;

import com.codegym.thai_foody_casestudy_module03.Model.DAO.StoreDAO;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.Store;
import com.codegym.thai_foody_casestudy_module03.Model.Service.IplmService.InterfaceStoreService;
import com.codegym.thai_foody_casestudy_module03.Model.Utils.Converter;

import java.util.ArrayList;
import java.util.List;

public class StoreService implements InterfaceStoreService {

    public static StoreService getInstance() {
        return new StoreService();
    }

    @Override
    public List<Store> selectAllStore() {
        List<Store> storeList = StoreDAO.getInstance().getAll();
        return storeList;
    }
    @Override
    public Store selectStoreById(long id) {
        Store store = StoreDAO.getInstance().getStoreByID(id);
        return store;
    }

    @Override
    public List<Store> selectStoreBySearch(String search) {
        List<Store> storeList = new ArrayList<>();
        for (Store store : selectAllStore()) {
            String strStore = Converter.removeAccent(store.toString()).toUpperCase();
            String keyword = Converter.removeAccent(search).toUpperCase();
            if(strStore.contains(keyword)) {
                storeList.add(store);
            }
        }
        return storeList;

    }



}
