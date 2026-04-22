package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import relationaldbs.model.Product;

public class ProductDaoImpl implements ProductDao {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    @Override
    public boolean insert(Product product) {
        String sql = "INSERT INTO products(name, description, price, category, stock, subCategory, rating) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getCategory());
            ps.setInt(5, product.getStock());
            ps.setString(6, product.getSubCategory());
            ps.setInt(7, product.getRating());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE products SET name = ?, description = ?, price = ?, category = ?, stock = ?, subCategory = ?, rating = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getCategory());
            ps.setInt(5, product.getStock());
            ps.setString(6, product.getSubCategory());
            ps.setInt(7, product.getRating());
            ps.setLong(8, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product find(long id) {
        String sql = "SELECT * FROM products WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            var rs = ps.executeQuery();
            if (rs.next()) {
                Product product = new Product(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getInt("stock"),
                    rs.getString("subCategory"),
                    rs.getInt("rating")
                );
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        String sql = "SELECT * FROM products WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            var rs = ps.executeQuery();
            if (rs.next()) {
                Product product = new Product(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getInt("stock"),
                    rs.getString("subCategory"),
                    rs.getInt("rating")
                );
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        List<Product> products = new java.util.ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getInt("stock"),
                    rs.getString("subCategory"),
                    rs.getInt("rating")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Método main para insertar un producto de ejemplo
    public static void main(String[] args) {
        ProductDao dao = new ProductDaoImpl();

        // Crear un producto de ejemplo
        Product product = new Product(
            0,                         // id (0 porque la base de datos lo asignará)
            "Laptop Gamer",
            "Laptop de alto rendimiento para gaming",
            1299.99,
            "Electronics",
            10,
            "Computers",
            5
        );

        boolean inserted = dao.insert(product);
        if (inserted) {
            System.out.println("Producto insertado correctamente.");
        } else {
            System.out.println("Error al insertar producto.");
        }
    }
}