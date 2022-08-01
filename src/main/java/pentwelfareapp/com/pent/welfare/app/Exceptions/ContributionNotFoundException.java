package pentwelfareapp.com.pent.welfare.app.Exceptions;

import java.text.MessageFormat;

public class ContributionNotFoundException extends Exception{
    public ContributionNotFoundException(String error){
        super(error);
    }
}
