package pentwelfareapp.com.pent.welfare.app.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import pentwelfareapp.com.pent.welfare.app.Entities.Member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class MemberDto {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rolesDate;

    private List<ContributionDto> contributionDtos = new ArrayList<>();

    public static MemberDto from(Member member){
        MemberDto  memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setAddress(member.getAddress());
        memberDto.setName(member.getName());
        memberDto.setRolesDate(member.getRolesDate());
        memberDto.setPhoneNumber(member.getPhoneNumber());
        memberDto.setContributionDtos(member.getContributions().stream().map(ContributionDto::from)
                .collect(Collectors.toList()));
        return memberDto;

    }
}
