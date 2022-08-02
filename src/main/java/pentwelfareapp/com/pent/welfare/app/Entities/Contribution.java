package pentwelfareapp.com.pent.welfare.app.Entities;

import lombok.Data;
import pentwelfareapp.com.pent.welfare.app.Dto.ContributionDto;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "contribution")
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float amount;
    private String contributionType;
    private Date contributionDate;
    private String comment;
    @ManyToOne
    private Member member;

    public static Contribution from(ContributionDto contributionDto){
        Contribution contribution = new Contribution();
        contribution.setAmount(contributionDto.getAmount());
        contribution.setContributionType(contributionDto.getContributionType());
        contribution.setComment(contributionDto.getComment());
        contribution.setContributionDate(contributionDto.getContributionDate());
        return contribution;
    }
}
