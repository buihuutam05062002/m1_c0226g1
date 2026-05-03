package topic17.service.impl;

import topic17.entity.Product;
import topic17.repository.ProductRepository;
import topic17.service.IProductManager;

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
        if (productRepository.findById(id) == null) {
            System.err.println("Product ID " + id + " not found.");
            return false;
        }
        return productRepository.delete(id);
    }
    @Override
    public boolean update(Product o) {
        Product old = productRepository.findById(o.getId());
        if(old != null){
            productRepository.update(o);
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
