package pentwelfareapp.com.pent.welfare.app.Dto;

import lombok.Data;
import pentwelfareapp.com.pent.welfare.app.Entities.Contribution;

import java.util.Date;
import java.util.Objects;

@Data
public class ContributionDto {
    private Long id;
    private float amount;
    private String contributionType;
    private Date contributionDate;
    private String comment;
    private PlainMemberDto plainMemberDto;

    public static ContributionDto from(Contribution contribution){
        ContributionDto contributionDto = new ContributionDto();
        contributionDto.setId(contribution.getId());
        contributionDto.setAmount(contribution.getAmount());
        contributionDto.setContributionDate(contribution.getContributionDate());
        contributionDto.setComment(contribution.getComment());
        contributionDto.setContributionType(contribution.getContributionType());
        if(Objects.nonNull(contribution.getMember())){
            contributionDto.setPlainMemberDto(PlainMemberDto.from(contribution.getMember()));
        }
        return contributionDto;
    }
}
