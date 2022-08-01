package pentwelfareapp.com.pent.welfare.app.Exceptions;

import java.text.MessageFormat;

public class ContributionAlreadyAssignException extends Exception{

    public ContributionAlreadyAssignException(String error){
        super(error);
    }
}
