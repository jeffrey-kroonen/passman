package nl.agilicy.passman.exception.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "bad request")
public class BadRequestException extends RuntimeException {
    //
}
