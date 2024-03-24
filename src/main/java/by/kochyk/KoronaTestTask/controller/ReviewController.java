package by.kochyk.KoronaTestTask.controller;

import by.kochyk.KoronaTestTask.domain.Review;
import by.kochyk.KoronaTestTask.domain.dto.ReviewDTO;
import by.kochyk.KoronaTestTask.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Review Controller")
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @Operation(summary = "Получить все отзывы")
    @GetMapping
    public List<Review> getReview() {
        return reviewService.getReviews();
    }

    @Operation(summary = "Добавление отзыва")
    @PostMapping
    public Review createReview(@RequestParam Long userId,
                               @RequestParam Long productId,
                               @Valid @RequestBody ReviewDTO reviewDTO) {
        return reviewService.createReview(userId, productId, reviewDTO);
    }

    @Operation(summary = "Редактирование отзыва")
    @PutMapping("/{reviewId}")
    public Review updateReview(@PathVariable Long reviewId, @Valid  @RequestBody ReviewDTO reviewDTO) {
        return reviewService.updateReview(reviewId, reviewDTO);
    }

    @Operation(summary = "Получение всех отзывов для конкретного пользователя")
    @GetMapping("/user/{userId}")
    public List<Review> getUserReviews(@PathVariable Long userId) {
        return reviewService.getUserReviews(userId);
    }

    @Operation(summary = "Получение всех отзывов для конкретного товара")
    @GetMapping("/product/{productId}")
    public List<Review> getProductReviews(@PathVariable Long productId) {
        return reviewService.getProductReviews(productId);
    }

}
