package pentwelfareapp.com.pent.welfare.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pentwelfareapp.com.pent.welfare.app.Entities.Contribution;
import pentwelfareapp.com.pent.welfare.app.Entities.Member;
import pentwelfareapp.com.pent.welfare.app.Exceptions.ContributionAlreadyAssignException;
import pentwelfareapp.com.pent.welfare.app.Exceptions.ContributionNotFoundException;
import pentwelfareapp.com.pent.welfare.app.Exceptions.MemberNotFoundException;
import pentwelfareapp.com.pent.welfare.app.Repositories.ContributionRepository;
import pentwelfareapp.com.pent.welfare.app.Repositories.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    private ContributionService contributionService;

    @Autowired
    public MemberService(MemberRepository memberRepository, ContributionService contributionService) {
        this.memberRepository = memberRepository;
        this.contributionService = contributionService;
    }

    public Member addMember(Member member){
        return memberRepository.save(member);
    }

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    public Member getMember(Long id) throws MemberNotFoundException {
        return memberRepository.findById(id).orElseThrow( () ->
                new MemberNotFoundException("Member with ID :" + id + "not found"));
    }

    public Member deleteMember(Long id) throws MemberNotFoundException {
        Member member = getMember(id);
        memberRepository.delete(member);
        return member;
    }

    @Transactional
    public Member editMember(Long id,Member member) throws MemberNotFoundException {
        Member memberToEdit = getMember(id);
        memberToEdit.setName(member.getName());
        memberToEdit.setAddress(member.getAddress());
        memberToEdit.setPhoneNumber(member.getPhoneNumber());
        memberToEdit.setRolesDate(member.getRolesDate());
        return memberToEdit;
    }

    @Transactional
    public Member addContributionToMember(Long memberId, Long contributionId) throws ContributionAlreadyAssignException, MemberNotFoundException, ContributionNotFoundException {
        Member member = getMember(memberId);
        Contribution contribution = contributionService.getContribution(contributionId);
        if(Objects.nonNull(contribution.getMember())){
            throw new ContributionAlreadyAssignException("contribution with id contributionId,"+ contributionId +
                    " is already assigned to member:"+ contribution.getMember().getId() );
        }
        member.addContribution(contribution);
        contribution.setMember(member);
        return member;

    }

    @Transactional
    public Member removeContributionFromMember(Long memberId,Long contributionId) throws MemberNotFoundException, ContributionNotFoundException {
        Member member = getMember(memberId);
        Contribution contribution = contributionService.getContribution(contributionId);
        member.removeContribution(contribution);
        return member;
    }
}
