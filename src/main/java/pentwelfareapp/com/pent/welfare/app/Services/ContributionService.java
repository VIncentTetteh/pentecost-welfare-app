package pentwelfareapp.com.pent.welfare.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pentwelfareapp.com.pent.welfare.app.Entities.Contribution;
import pentwelfareapp.com.pent.welfare.app.Exceptions.ContributionNotFoundException;
import pentwelfareapp.com.pent.welfare.app.Repositories.ContributionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContributionService {

    private final ContributionRepository contributionRepository;

    @Autowired
    public ContributionService(ContributionRepository contributionRepository) {
        this.contributionRepository = contributionRepository;
    }

    public Contribution addContribution(Contribution contribution){
        return contributionRepository.save(contribution);
    }

    public List<Contribution> getContributions(){
        return contributionRepository.findAll();
    }
    public Contribution getContribution(Long id) throws ContributionNotFoundException {
        return contributionRepository.findById(id).orElseThrow(() ->
                new ContributionNotFoundException("Contribution with id " + id + " not found"));
    }

    public List<Contribution> getContributionByType(String contributionType){
        return contributionRepository.findContributionByContributionType(contributionType);
    }

    public Contribution deleteContribution(Long id) throws ContributionNotFoundException {
        Contribution contribution = getContribution(id);
        contributionRepository.delete(contribution);
        return contribution;
    }

    @Transactional
    public Contribution editContribution(Long id, Contribution contribution) throws ContributionNotFoundException {
        Contribution contributionToEdit = getContribution(id);
        contributionToEdit.setContributionDate(contribution.getContributionDate());
        contributionToEdit.setAmount(contribution.getAmount());
        contributionToEdit.setContributionType(contribution.getContributionType());
        return contributionToEdit;
    }
}
