package topic17.repository;


import topic17.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductRepository {
    private static final String FILE_PATH = "src/topic17/repository/products.dat";
    private List<Product> products = new ArrayList<>();


    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    public ProductRepository() {
        loadFromFile();
    }


    public boolean add(Product p) {
        products.add(p);
        saveToFile();
        return true;
    }

    public boolean delete(int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        if (removed) saveToFile();
        return removed;
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

    public List sortByName() {
        List<Product> result = new ArrayList<>(products);
        result.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                int flag = o1.getName().compareToIgnoreCase(o2.getName());
                if (flag != 0) {
                    return flag;
                }
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
        return result;
    }


    public boolean update(Product p) {
        for (Product item : products) {
            if (item.getId() == p.getId()) {
                item.setName(p.getName());
                item.setValue(p.getValue());
                item.setLabel(p.getLabel());
                item.setDescription(p.getDescription());
                saveToFile();
                return true;
            }
        }
        return false;
    }


    // File I/O


    public void saveToFile() {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_PATH)))) {
            dos.writeInt(products.size());
            for (Product p : products) {
                dos.writeInt(p.getId());
                dos.writeUTF(p.getName());
                dos.writeDouble(p.getValue());
                dos.writeUTF(p.getLabel() == null ? "" : p.getLabel());
                dos.writeUTF(p.getDescription() == null ? "" : p.getDescription());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_PATH)))) {

            int count = dis.readInt();
            products.clear();
            for (int i = 0; i < count; i++) {
                int id = dis.readInt();
                String name = dis.readUTF();
                double value = dis.readDouble();
                String label = dis.readUTF();
                String description = dis.readUTF();
                products.add(new Product(id, name, value, label, description));
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

