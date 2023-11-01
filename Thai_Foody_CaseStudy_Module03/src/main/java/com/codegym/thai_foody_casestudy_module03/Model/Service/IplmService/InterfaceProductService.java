package com.codegym.thai_foody_casestudy_module03.Model.Service.IplmService;

import com.codegym.thai_foody_casestudy_module03.Model.Entity.Product;

import java.util.List;

public interface InterfaceProductService {
    public List<Product> selectAllProductByStoreId(long storeId);
}
