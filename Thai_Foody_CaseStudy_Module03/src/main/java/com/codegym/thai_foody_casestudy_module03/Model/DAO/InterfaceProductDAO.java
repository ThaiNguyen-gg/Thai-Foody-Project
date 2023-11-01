package com.codegym.thai_foody_casestudy_module03.Model.DAO;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.Product;

import java.util.List;

public interface InterfaceProductDAO {

    public List<Product> getListProductByStoreId( long storeId);


}
