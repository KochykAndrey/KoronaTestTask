package by.kochyk.KoronaTestTask.service;

import by.kochyk.KoronaTestTask.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProduct();

    Product createProduct(Product product);

    Product getProductById(Long productId);

}
