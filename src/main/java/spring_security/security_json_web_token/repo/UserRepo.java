package spring_security.security_json_web_token.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_security.security_json_web_token.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
