package topic17.view;



import topic17.controller.ProductController;
import topic17.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {

    private ProductController productController = new ProductController();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    productController.add(inputProduct());
                    break;

                case 2:
                    productController.update(inputProduct());
                    break;

                case 3:
                    System.out.print("ID delete: ");
                    productController.delete(Integer.parseInt(sc.nextLine()));
                    break;

                case 4:
                    display(productController.getAll());
                    break;

                case 5:
                    System.out.print("Keyword: ");
                    display(productController.search(sc.nextLine()));
                    break;

                case 6:

                    display(productController.sortByValue());
                    break;
                case 7:
                    display(productController.sortByName());
                    break;
                case 8:
                    System.out.print("");
                    System.out.print("Vui lòng nhập id: ");
                    Product p = productController.getById(Integer.parseInt(sc.nextLine()));
                    System.out.println(p);
                    break;


                case 0:
                    return;
            }
        }
    }

    private int menu() {
        System.out.println("\n1.Add 2.Update 3.Delete 4.Show 5.Search 6.Sort by value 7. sort by name 8. find by id   0.Exit");
        System.out.print("Choose: ");
        return Integer.parseInt(sc.nextLine());
    }

    private Product inputProduct() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Value: ");
        double value = Double.parseDouble(sc.nextLine());

        System.out.print("label: ");
        String label =  sc.nextLine();

        System.out.print("description: ");
        String description =  sc.nextLine();

        return new Product(id, name, value,label,description);
    }

    private void display(List<Product> list) {
        for (Product p : list) {
            System.out.println("ID: "+ p.getId()+" " +"Name: " + p.getName()+" " + "Value: " + p.getValue()+" " + "label: " + p.getLabel()+ " " + "desciption: " + p.getDescription()) ;
        }
    }
}