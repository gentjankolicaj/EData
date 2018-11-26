package edata.api.v1.advice;

import edata.exception.api.request.CountryBadRequestException;
import edata.exception.api.uri.CountryBadUriException;
import edata.exception.resource.CountryNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CountryRestAdvice {

    @ExceptionHandler(CountryBadRequestException.class)
    public ResponseEntity<Object> badRequest(CountryBadRequestException exception){
        String message=exception.getMessage();
        return new ResponseEntity<Object>(message,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CountryBadUriException.class)
    public ResponseEntity<Object> badUri(CountryBadUriException exception){
        String message=exception.getMessage();
        return new ResponseEntity<Object>(message,new HttpHeaders(),  HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<Object>  notFound(CountryNotFoundException exception){
        String message=exception.getMessage();
        return new ResponseEntity<>(message,new HttpHeaders(), HttpStatus.NOT_FOUND);

    }
}
