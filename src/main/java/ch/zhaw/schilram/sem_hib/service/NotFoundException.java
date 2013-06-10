package ch.zhaw.schilram.sem_hib.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author schilram
 */
@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "This object cannot be found")
public class NotFoundException extends RuntimeException {

}
