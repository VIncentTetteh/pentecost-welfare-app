package pentwelfareapp.com.pent.welfare.app.Exceptions;

import java.text.MessageFormat;

public class MemberNotFoundException extends Exception{
    public MemberNotFoundException(String error){
        super(error);
    }
}
