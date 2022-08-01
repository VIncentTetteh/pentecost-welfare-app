package pentwelfareapp.com.pent.welfare.app.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pentwelfareapp.com.pent.welfare.app.Entities.Error;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(ContributionAlreadyAssignException.class)
    public ResponseEntity<Error> handleException(ContributionAlreadyAssignException e) {
        Error error = new Error(HttpStatus.CONFLICT, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @ExceptionHandler(ContributionNotFoundException.class)
    public ResponseEntity<Error> handleException2(ContributionNotFoundException e) {
        Error error = new Error(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<Error> handleException3(MemberNotFoundException e) {
        Error error = new Error(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getHttpStatus());
    }
}
