package topic12.service.impl;

import topic12.entity.Product;
import topic12.repository.ProductRepository;
import topic12.service.IProductManager;

import java.util.List;

public class ProductsService implements IProductManager {
    ProductRepository productRepository = new ProductRepository();

    @Override
    public List getAll() {
        return productRepository.getAll();
    }
    @Override
    public Product getById(int id){
        return productRepository.findById(id);
    }


    @Override
    public boolean add(Product o) {
        return productRepository.add(o);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean update(Product o) {
        Product old = productRepository.findById(o.getId());
        if(old != null){
            old.setName(o.getName());
            old.setValue(o.getValue());
            return true;
        }
        return false;
    }

    @Override
    public List getAllByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> sortByValue() {
        return productRepository.sortByValue();
    }

    @Override
    public List<Product> sortByName() {
        return productRepository.sortByName();
    }


}
