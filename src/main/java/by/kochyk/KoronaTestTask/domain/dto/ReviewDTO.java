package by.kochyk.KoronaTestTask.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
public class ReviewDTO {

    @NotNull(message = "content must be not null.")
    @Length(
            min = 5,
            max = 255,
            message = "The length of the content should be between 5 and 255 characters!!!"
    )
    @Schema(description = "Тело отзыва", example = "Крутой товар, рекомендую")
    private String content;

    @Range(min = 1, max = 5)
    @Schema(description = "Оценка товара", example = "4")
    private int rating;
}
