package pentwelfareapp.com.pent.welfare.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pentwelfareapp.com.pent.welfare.app.Dto.ContributionDto;
import pentwelfareapp.com.pent.welfare.app.Dto.MemberDto;
import pentwelfareapp.com.pent.welfare.app.Entities.Contribution;
import pentwelfareapp.com.pent.welfare.app.Entities.Member;
import pentwelfareapp.com.pent.welfare.app.Services.MemberService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberDto> addMember(@RequestBody final MemberDto memberDto){
        Member member = memberService.addMember(Member.from(memberDto));
        return new ResponseEntity<>(MemberDto.from(member), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getMembers(){
        List<Member> members = memberService.getMembers();
        List<MemberDto> memberDtos = members.stream().map(MemberDto::from)
                .collect(Collectors.toList());
        return new ResponseEntity<>(memberDtos,HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<MemberDto> getMember(@PathVariable final Long id){
        Member member = memberService.getMember(id);
        return new ResponseEntity<>(MemberDto.from(member),HttpStatus.OK);
    }

    @DeleteMapping(value ="{id}")
    public ResponseEntity<MemberDto> deleteMember(@PathVariable final Long id){
        Member member = memberService.deleteMember(id);
        return new ResponseEntity<>(MemberDto.from(member),HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<MemberDto> editMember(@PathVariable final Long id,
                                                            @RequestBody MemberDto memberDto){
        Member editedMember = memberService
                .editMember(id, Member.from(memberDto));
        return new ResponseEntity<>(MemberDto.from(editedMember),HttpStatus.OK);
    }

    @PostMapping(value = "{memberId}/contributions/{contributionId}/add")
    public ResponseEntity<MemberDto> addContributionToMember(@PathVariable final Long memberId,
                                                             @PathVariable final Long contributionId){
        Member member = memberService.addContributionToMember(memberId,contributionId);
        return new ResponseEntity<>(MemberDto.from(member), HttpStatus.OK);
    }

    @DeleteMapping(value = "{memberId}/contributions/{contributionId}/remove")
    public ResponseEntity<MemberDto> removeContributionFromMember(@PathVariable final Long memberId,
                                                             @PathVariable final Long contributionId){
        Member member = memberService.removeContributionFromMember(memberId,contributionId);
        return new ResponseEntity<>(MemberDto.from(member), HttpStatus.OK);
    }
}
