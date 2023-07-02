import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    List<Product> products = new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        for (Product p: products){
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(str) || type.contains(str) || place.contains(str))
                prods.add(p);
        }
        return prods;

    }

    /** This method will search the product according to given exact key word as place.
     Also, it will handle the lowercase scenarios of place name.    **/
    public Product getProductByPlace(String place){
        return products.stream()
                .filter(p -> (p.getPlace().toLowerCase().equals(place.toLowerCase())))
                .findFirst()
                .orElse(null);
    }

    /** This method will return type as List, but we are using stream to filter out of warranty products.
     And converting Stream to List using collect(Collectors.toList()).    **/
    public List<Product> getOutOfWarrantyProduct(int currentYear) {
        return products.stream()
                .filter(p -> (p.getWarranty() < currentYear))
                .collect(Collectors.toList());

    }
}
