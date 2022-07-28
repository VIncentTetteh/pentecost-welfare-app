package pentwelfareapp.com.pent.welfare.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pentwelfareapp.com.pent.welfare.app.Entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
}
