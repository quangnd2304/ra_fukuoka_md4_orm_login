package ra.repository;

import ra.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    boolean create(Product product);
}
