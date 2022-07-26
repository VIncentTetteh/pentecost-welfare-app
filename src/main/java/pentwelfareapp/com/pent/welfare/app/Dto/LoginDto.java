package pentwelfareapp.com.pent.welfare.app.Dto;

import lombok.Data;

@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
