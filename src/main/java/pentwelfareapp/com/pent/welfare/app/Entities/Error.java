package pentwelfareapp.com.pent.welfare.app.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Error {
    private HttpStatus httpStatus;
    private String message;
}
