package pentwelfareapp.com.pent.welfare.app.Exceptions;

import java.text.MessageFormat;

public class ContributionNotFoundException extends RuntimeException{
    public ContributionNotFoundException(Long id){
        super(MessageFormat.format("Could not find contribution with id: {0}",id));
    }
}
