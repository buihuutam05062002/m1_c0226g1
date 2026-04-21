package topic12.controller;

import topic12.entity.Product;
import topic12.service.IProductManager;
import topic12.service.impl.ProductsService;

import java.util.List;

public class ProductController {
    private IProductManager iProductManager = new ProductsService();

    public List<Product> getAll(){
        return iProductManager.getAll();
    }
    public boolean add(Product product){
        return iProductManager.add(product);
    }
    public boolean delete(int id){
        return iProductManager.delete(id);
    }
    public Product getById(int id){
        return iProductManager.getById(id);
    }
    public boolean update(Product p ){
        return iProductManager.update(p);
    }
    public List<Product> search(String name) {
        return iProductManager.getAllByName(name);
    }
    public List<Product> sortByValue(){
        return iProductManager.sortByValue();
    }
    public List<Product> sortByName(){
        return iProductManager.sortByName();
    }

}


