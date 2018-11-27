package edata.api.v1.advice;

import edata.exception.resource.IdNullException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GeneralRestAdvice {

    @ExceptionHandler(IdNullException.class)
    public ResponseEntity<Object> badId(IdNullException exception){
        String message=exception.getMessage();
        log.warn(message);
        return new ResponseEntity<Object>(message,new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }
}
