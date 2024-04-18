package com.ms.user.exception;

import com.ms.user.configs.ExceptionConfigs;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class HandleException {

    private final ExceptionConfigs exceptionConfigs;

   // public HandleException(ExceptionConfigs exceptionConfigs) {
      //  this.exceptionConfigs = exceptionConfigs;
    //}

    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<Object> handleMyException(MyHandleException ex){
        log.error(
                "{}{}",
                exceptionConfigs.getTypeException(ExceptionConfigs.BUSINESS),
                ex.getMessage(),ex
        );
        return ResponseEntity
                .badRequest()
                .body(String.format(
                        """
                       %s  : %s
                       """,exceptionConfigs.getTypeException(ExceptionConfigs.BUSINESS),ex.getMessage()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){
        log.error(
                "{}{}",
                exceptionConfigs.getTypeException(ExceptionConfigs.SYSTEM),
                ex.getMessage(),ex
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionConfigs.getTypeException(ExceptionConfigs.SYSTEM) + ":" + ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List> handleValidationException(MethodArgumentNotValidException ex){
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.add(error.getObjectName()+ ":" +error.getField() + ": "+ error.getDefaultMessage());
        }

        log.error(
                exceptionConfigs.getTypeException(ExceptionConfigs.SYSTEM)+"error info : \n{}" ,
                errors
        );
        return ResponseEntity.badRequest().body(errors);
    }

}
