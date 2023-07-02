import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductService {

    List<Product> products = new ArrayList<>();
    ProductDB db = new ProductDB();

    public void addProduct(Product p){
        db.save(p);
    }

    public List<Product> getAllProducts(){
        return db.getAll();
    }

    public List<Product> getProduct(String name){
        return db.getProduct(name.toLowerCase());
    }

    public List<Product> getProductWithText(String text) {
        return db.getProductWithText(text.toLowerCase());
    }

    /** This method will search the product according to given exact key word as place.
     Also, it will handle the lowercase scenarios of place name.    **/
    public List<Product> getProductByPlace(String place){
        return db.getProductByPlace(place);
    }

    /** This method will return type as List, but we are using stream to filter out of warranty products.
     And converting Stream to List using collect(Collectors.toList()).    **/
    public List<Product> getOutOfWarrantyProduct(int currentYear) {
        return db.getOutOfWarrantyProduct(currentYear);
    }
}
