package pentwelfareapp.com.pent.welfare.app.Exceptions;

import java.text.MessageFormat;

public class ContributionAlreadyAssignException extends RuntimeException{

    public ContributionAlreadyAssignException(final Long contributionId, final Long memberId){
        super(MessageFormat.format("contribution: {0} is already assigned to member: {1}", contributionId,
                memberId));
    }
}
