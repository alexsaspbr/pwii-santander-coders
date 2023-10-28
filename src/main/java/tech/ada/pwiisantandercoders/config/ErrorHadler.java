package tech.ada.pwiisantandercoders.config;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;

@ControllerAdvice
public class ErrorHadler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationHandler(MethodArgumentNotValidException exception) {

        LinkedHashMap<String, String> erros = new LinkedHashMap<>();
        exception.getBindingResult().getAllErrors().forEach((ObjectError erro) -> {
            String field = ((FieldError) erro).getField();
            String message = erro.getDefaultMessage();
            erros.put(field, message);
        });

        return ResponseEntity.badRequest().body(erros);

    }

}
