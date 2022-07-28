package pentwelfareapp.com.pent.welfare.app.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import pentwelfareapp.com.pent.welfare.app.Entities.Member;

import java.util.Date;

@Data
public class PlainMemberDto {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date rolesDate;

    public static PlainMemberDto from(Member member){
        PlainMemberDto plainMemberDto = new PlainMemberDto();
        plainMemberDto.setId(member.getId());
        plainMemberDto.setName(member.getName());
        plainMemberDto.setAddress(member.getAddress());
        plainMemberDto.setPhoneNumber(member.getPhoneNumber());
        plainMemberDto.setRolesDate(member.getRolesDate());
        return plainMemberDto;
    }

}
