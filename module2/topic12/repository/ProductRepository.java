package topic12.repository;


import topic12.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductRepository {

    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "iPhone 15", 1200));
        products.add(new Product(2, "Samsung S24", 1100));
        products.add(new Product(3, "Xiaomi 14", 700));
        products.add(new Product(4, "Oppo Find X5", 650));
        products.add(new Product(5, "Vivo V29", 500));
        products.add(new Product(6, "MacBook Air M2", 1300));
        products.add(new Product(7, "Dell XPS 13", 1250));
        products.add(new Product(8, "HP Spectre x360", 1150));
        products.add(new Product(9, "Asus ROG Strix", 1500));
        products.add(new Product(10, "Lenovo ThinkPad X1", 1400));
        products.add(new Product(11, "iPad Pro", 900));
        products.add(new Product(12, "Samsung Tab S9", 850));
        products.add(new Product(13, "Apple Watch Series 9", 450));
        products.add(new Product(14, "Galaxy Watch 6", 400));
        products.add(new Product(15, "AirPods Pro", 250));
        products.add(new Product(16, "Sony WH-1000XM5", 350));
        products.add(new Product(17, "Logitech MX Master 3S", 120));
        products.add(new Product(18, "Razer DeathAdder V3", 90));
        products.add(new Product(19, "Keychron K8", 110));
        products.add(new Product(20, "Corsair K70 RGB", 160));
    }

    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    public boolean add(Product p) {
        products.add(p);
        return true;
    }

    public boolean delete(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public List sortByValue() {
        List<Product> result = new ArrayList<>(products);
        result.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getValue() > o2.getValue()) {
                    return 1;
                } else if (o1.getValue() < o2.getValue()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return result;
    }
    public List sortByName(){
        List<Product> result = new ArrayList<>(products);
        result.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
               return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        return result;
    }
}

