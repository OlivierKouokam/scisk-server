package com.scisk.sciskbackend.config;

import com.scisk.sciskbackend.responses.OperationResponseModel;
import com.scisk.sciskbackend.responses.SimpleObjectResponseModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j2
@ControllerAdvice
public class ValidationException extends ResponseEntityExceptionHandler {

    public static final String LIST_JOIN_DELIMITER = ",";
    public static final String FIELD_ERROR_SEPARATOR = ": ";
    private static final String ERRORS_FOR_PATH = "errors {} for path {}";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        Map<String, String> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        fieldError -> fieldError.getDefaultMessage() == null ? "" : fieldError.getDefaultMessage()
                        )
                );
        return getExceptionResponseEntity(ex, HttpStatus.BAD_REQUEST, request, validationErrors);
    }

    /**
     * Build a detailed information about the ex in the response
     */
    private ResponseEntity<Object> getExceptionResponseEntity(final Exception ex,
                                                              final HttpStatus status,
                                                              final WebRequest request,
                                                              final Map<String, String> errors) {
        OperationResponseModel response = new SimpleObjectResponseModel("validation.error", errors);
        final String path = request.getDescription(false);
        final String errorsMessage =
                !errors.isEmpty() ?
                        errors.entrySet().stream()
                                .map(entrySet -> entrySet.getKey() + FIELD_ERROR_SEPARATOR + entrySet.getValue())
                                .collect(Collectors.joining(LIST_JOIN_DELIMITER))
                        : status.getReasonPhrase();
        log.error(ERRORS_FOR_PATH, errorsMessage, path);

        return ResponseEntity.status(status).body(response);
    }
}
