package by.kochyk.KoronaTestTask.service;

import by.kochyk.KoronaTestTask.domain.Review;
import by.kochyk.KoronaTestTask.domain.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    Review createReview(Long userId, Long productId, ReviewDTO reviewDTO);

    Review updateReview(Long reviewId, ReviewDTO reviewDTO);

    List<Review> getUserReviews(Long userId);

    List<Review> getProductReviews(Long productId);

    List<Review> getReviews();

    boolean existsByUserIdAndProductId(Long userId, Long productId);

}
