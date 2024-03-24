package by.kochyk.KoronaTestTask.service;

import by.kochyk.KoronaTestTask.domain.Product;
import by.kochyk.KoronaTestTask.domain.exception.ProductException;
import by.kochyk.KoronaTestTask.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductException("Invalid product ID"));
    }
}
