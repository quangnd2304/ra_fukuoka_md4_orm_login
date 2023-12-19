package ra.service;

import ra.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean create(Product product);
}
