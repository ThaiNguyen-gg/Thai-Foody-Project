package com.codegym.thai_foody_casestudy_module03.Model.Service;

import com.codegym.thai_foody_casestudy_module03.Model.DAO.Impl.ProductDAO;
import com.codegym.thai_foody_casestudy_module03.Model.Entity.Product;
import com.codegym.thai_foody_casestudy_module03.Model.Service.IplmService.InterfaceProductService;
import java.util.List;

public class ProductService  implements InterfaceProductService {
    public static ProductService getInstance()  {
        return new ProductService();
    }
    @Override
    public List<Product> selectAllProductByStoreId(long storeId) {
        List<Product> products = ProductDAO.getInstance().getListProductByStoreId(storeId);
        return products;
    }


}
