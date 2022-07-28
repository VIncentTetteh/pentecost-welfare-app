package pentwelfareapp.com.pent.welfare.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pentwelfareapp.com.pent.welfare.app.Entities.Contribution;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution,Long> {
}
