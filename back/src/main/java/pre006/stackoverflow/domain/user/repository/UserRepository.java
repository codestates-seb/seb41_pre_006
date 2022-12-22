package pre006.stackoverflow.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pre006.stackoverflow.domain.user.entity.User;

import javax.annotation.PostConstruct;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
