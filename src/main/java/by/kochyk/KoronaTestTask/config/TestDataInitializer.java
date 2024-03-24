package by.kochyk.KoronaTestTask.config;

import by.kochyk.KoronaTestTask.domain.Product;
import by.kochyk.KoronaTestTask.domain.User;
import by.kochyk.KoronaTestTask.domain.dto.ReviewDTO;
import by.kochyk.KoronaTestTask.service.ProductService;
import by.kochyk.KoronaTestTask.service.ReviewService;
import by.kochyk.KoronaTestTask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final ReviewService reviewService;
    private final ProductService productService;

    @Override
    public void run(String... args) {
        User user1 = new User();
        user1.setUsername("Andrei");
        user1.setEmail("andrei@example.com");
        userService.createUser(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setEmail("user2@example.com");
        userService.createUser(user2);

        Product product1 = new Product();
        product1.setName("Iphone 15");
        product1.setPrice(2100.50);
        productService.createProduct(product1);

        Product product2 = new Product();
        product2.setName("Samsung Galaxy S25");
        product2.setPrice(3100.50);
        productService.createProduct(product2);

        Product product3 = new Product();
        product3.setName("Nokia 5250");
        product3.setPrice(100.0);
        productService.createProduct(product3);


        ReviewDTO reviewDTO1 = new ReviewDTO();
        reviewDTO1.setContent("Bad product");
        reviewDTO1.setRating(1);
        reviewService.createReview(user1.getId(), product1.getId(), reviewDTO1);

        ReviewDTO reviewDTO2 = new ReviewDTO();
        reviewDTO2.setContent("Good product");
        reviewDTO2.setRating(4);
        reviewService.createReview(user2.getId(), product2.getId(), reviewDTO2);


        ReviewDTO reviewDTO3 = new ReviewDTO();
        reviewDTO3.setContent("Very good product");
        reviewDTO3.setRating(5);
        reviewService.createReview(user2.getId(), product3.getId(), reviewDTO3);
    }
}