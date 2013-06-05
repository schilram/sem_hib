package ch.zhaw.schilram.sem_hib.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author rschilling
 */
@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED, reason = "This object is in use and cannot be deleted.")
public class ObjectInUseException extends RuntimeException {

}
