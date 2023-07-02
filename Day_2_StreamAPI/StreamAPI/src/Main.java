import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductService service = new ProductService();

        System.out.println("==============================================");

        // hey service, add the products..

        service.addProduct(new Product("Type C", "Cable", "Black Drawer", 2024));
        service.addProduct(new Product("Mac Studio", "Computer", "White Table", 2025));
        service.addProduct(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));
        service.addProduct(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
        service.addProduct(new Product("Asus Rog", "Laptop", "Black Table", 2021));
        service.addProduct(new Product("Macbook pro", "Laptop", "Brown Drawer", 2022));
        service.addProduct(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
        service.addProduct(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
        service.addProduct(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));
        service.addProduct(new Product("Hdmi cable", "Cable", "Black Drawer", 2024));
        service.addProduct(new Product("Java Black Book", "Cable", "Shelf", 2024));
        service.addProduct(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
        service.addProduct(new Product("Apple Mouse", "Mouse", "White Table", 2022));
        service.addProduct(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
        service.addProduct(new Product("BlackBeast", "Computer", "White Table", 2020));

        List<Product> products = service.getAllProducts();
        for(Product p : products){
            System.out.println(p);
        }
        System.out.println("==============================================");

        System.out.println("a Particular product - Logi Mouse");

        Product p = service.getProduct("Logi Mouse");
        System.out.println(p);

        System.out.println("==============================================");
        System.out.println("a Particular text - black");

        List<Product> prods = service.getProductWithText("black");
        for(Product product : prods){
            System.out.println(product);
        }
        System.out.println("==============================================");
        //Assignment 1 : Search by Place
        System.out.println("Assignment 1 : Search by Place - Black Drawer");
        displayProductByPlace(service);
        System.out.println("==============================================");
        //Assignment 2 : out of warranty product
        System.out.println("Assignment 2 : out of warranty product < 2023");
        displayOutOfWarrantyProduct(service);


    }

    public static void displayProductByPlace(ProductService service){
        System.out.println("A Particular product By Place");
        Product p = service.getProductByPlace("Black Drawer");
        if(p == null){
            System.out.println("No data found");
        }else{
            System.out.println(p);
        }
    }
    public static void displayOutOfWarrantyProduct(ProductService service){
        System.out.println("Out of warranty products");
        int currentYear = 2023;
        List<Product> productList = new ArrayList<>();
        //Assignment 3 : Using stream
        List<Product> listP = service.getOutOfWarrantyProduct(currentYear);
        if(listP.size() > 0)
            System.out.println(listP);
        else
            System.out.println("No data found");
    }
}
