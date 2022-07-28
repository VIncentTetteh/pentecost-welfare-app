package pentwelfareapp.com.pent.welfare.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pentwelfareapp.com.pent.welfare.app.Dto.ContributionDto;
import pentwelfareapp.com.pent.welfare.app.Entities.Contribution;
import pentwelfareapp.com.pent.welfare.app.Services.ContributionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/contribution")
public class ContributionController {
    private final ContributionService contributionService;

    @Autowired
    public ContributionController(ContributionService contributionService) {
        this.contributionService = contributionService;
    }

    @PostMapping
    public ResponseEntity<ContributionDto> addContribution(@RequestBody final ContributionDto contributionDto){
        Contribution contribution = contributionService.addContribution(Contribution.from(contributionDto));
        return new ResponseEntity<>(ContributionDto.from(contribution), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ContributionDto>> getContributions(){
        List<Contribution> contributions = contributionService.getContributions();
        List<ContributionDto> contributionDtos = contributions.stream().map(ContributionDto::from)
                .collect(Collectors.toList());
        return new ResponseEntity<>(contributionDtos,HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ContributionDto> getContribution(@PathVariable final Long id){
        Contribution contribution = contributionService.getContribution(id);
        return new ResponseEntity<>(ContributionDto.from(contribution),HttpStatus.OK);
    }

    @DeleteMapping(value ="{id}")
    public ResponseEntity<ContributionDto> deleteContribution(@PathVariable final Long id){
        Contribution contribution = contributionService.deleteContribution(id);
        return new ResponseEntity<>(ContributionDto.from(contribution),HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ContributionDto> editContribution(@PathVariable final Long id,
                                                            @RequestBody ContributionDto contributionDto){
        Contribution editedContribution = contributionService
                .editContribution(id, Contribution.from(contributionDto));
        return new ResponseEntity<>(ContributionDto.from(editedContribution),HttpStatus.OK);
    }



}
