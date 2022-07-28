package pentwelfareapp.com.pent.welfare.app.Exceptions;

import java.text.MessageFormat;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(Long id){
        super(MessageFormat.format("Member not found with id: {0}",id));
    }
}
