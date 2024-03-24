package by.kochyk.KoronaTestTask.controller;

import by.kochyk.KoronaTestTask.domain.exception.ExceptionBody;
import by.kochyk.KoronaTestTask.domain.exception.ProductException;
import by.kochyk.KoronaTestTask.domain.exception.ReviewException;
import by.kochyk.KoronaTestTask.domain.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(UserException.class)
    public ExceptionBody handleUserException(final UserException e) {
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(ReviewException.class)
    public ExceptionBody handleReviewException(final ReviewException e) {
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(ProductException.class)
    public ExceptionBody handleProductException(final ProductException e) {
        return new ExceptionBody(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleMethodArgumentNotValid(
            final MethodArgumentNotValidException e) {
        ExceptionBody exceptionBody = new ExceptionBody("Validation failed.");
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        exceptionBody.setErrors(errors.stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage)));
        return exceptionBody;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleException(final Exception e) {
        return new ExceptionBody("Internal error.");
    }
}
