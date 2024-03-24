package by.kochyk.KoronaTestTask.service;

import by.kochyk.KoronaTestTask.domain.Product;
import by.kochyk.KoronaTestTask.domain.Review;
import by.kochyk.KoronaTestTask.domain.User;
import by.kochyk.KoronaTestTask.domain.dto.ReviewDTO;
import by.kochyk.KoronaTestTask.domain.exception.ReviewException;
import by.kochyk.KoronaTestTask.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public Review createReview(Long userId, Long productId, ReviewDTO reviewDTO) {
        User user = userService.getUserById(userId);
        Product product = productService.getProductById(productId);

        if (existsByUserIdAndProductId(userId, productId)) {
            throw new ReviewException("This user already has a review on this product");
        }

        Review review = Review.builder()
                .user(user)
                .product(product)
                .content(reviewDTO.getContent())
                .rating(reviewDTO.getRating())
                .dateTimeReview(LocalDateTime.now())
                .build();
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long reviewId, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewException("Invalid review ID"));

        review.setRating(reviewDTO.getRating());
        review.setContent(reviewDTO.getContent());
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getUserReviews(Long userId) {
        userService.getUserById(userId);
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public List<Review> getProductReviews(Long productId) {
        productService.getProductById(productId);
        return reviewRepository.findByProductId(productId);
    }

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean existsByUserIdAndProductId(Long userId, Long productId) {
        return reviewRepository.existsByUserIdAndProductId(userId, productId);
    }

}
