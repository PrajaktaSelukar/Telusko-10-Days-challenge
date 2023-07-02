import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection conn = null;

    public ProductDB() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teluskoProduct", "postgres", "prajaktaselukar");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(Product p) {
        String query = "insert into product (name, type, place, warranty) values (String, String, String, Integer)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getName());
            st.setString(2, p.getType());
            st.setString(3, p.getPlace());
            st.setInt(4, p.getWarranty());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet res = st.executeQuery();
            while(res.next()){
                Product p = new Product();
                p.setName(res.getString(1));
                p.setType(res.getString(2));
                p.setPlace(res.getString(3));
                p.setWarranty(res.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getProduct(String name) {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product where name = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, name);
            ResultSet res = st.executeQuery();
            while(res.next()){
                Product p = new Product();
                p.setName(res.getString(1));
                p.setType(res.getString(2));
                p.setPlace(res.getString(3));
                p.setWarranty(res.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }


    public List<Product> getProductWithText(String searchText) {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product where concat(name, type, place) ILIKE ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, "%" + searchText + "%");
            ResultSet res = st.executeQuery();
            while(res.next()){
                Product p = new Product();
                p.setName(res.getString(1));
                p.setType(res.getString(2));
                p.setPlace(res.getString(3));
                p.setWarranty(res.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getProductByPlace(String place) {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product where place = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, place);
            ResultSet res = st.executeQuery();
            while(res.next()){
                Product p = new Product();
                p.setName(res.getString(1));
                p.setType(res.getString(2));
                p.setPlace(res.getString(3));
                p.setWarranty(res.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getOutOfWarrantyProduct(Integer year) {
        List<Product> products = new ArrayList<>();
        String query = "select name, type, place, warranty from product where warranty <  ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, year);
            ResultSet res = st.executeQuery();
            while(res.next()){
                Product p = new Product();
                p.setName(res.getString(1));
                p.setType(res.getString(2));
                p.setPlace(res.getString(3));
                p.setWarranty(res.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
