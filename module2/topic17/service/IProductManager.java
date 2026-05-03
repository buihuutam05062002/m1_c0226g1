package topic17.service;

import topic17.entity.Product;

import java.util.List;

public interface IProductManager<T> {
    List<T> getAll();
    boolean add(Product t);
    boolean delete(int id);
    boolean update(Product t);
    Product getById(int id);
    List<Product> getAllByName(String name);

    List<Product> sortByValue();

    List<Product> sortByName();
}
