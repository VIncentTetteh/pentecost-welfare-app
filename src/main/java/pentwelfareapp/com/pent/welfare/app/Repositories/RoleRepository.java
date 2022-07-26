package pentwelfareapp.com.pent.welfare.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pentwelfareapp.com.pent.welfare.app.Entities.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
