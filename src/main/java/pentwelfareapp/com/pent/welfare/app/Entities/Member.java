package pentwelfareapp.com.pent.welfare.app.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pentwelfareapp.com.pent.welfare.app.Dto.MemberDto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rolesDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private List<Contribution> contributions;

    public void addContribution(Contribution contribution){
        contributions.add(contribution);
    }

    public void removeContribution(Contribution contribution){
        contributions.remove(contribution);
    }

    public static Member from(MemberDto memberDto){
        Member member = new Member();
        member.setAddress(memberDto.getAddress());
        member.setName(memberDto.getName());
        member.setRolesDate(memberDto.getRolesDate());
        member.setPhoneNumber(memberDto.getPhoneNumber());
        return member;
    }
}
