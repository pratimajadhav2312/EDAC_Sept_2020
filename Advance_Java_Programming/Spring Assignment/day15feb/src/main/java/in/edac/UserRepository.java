package in.edac;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByUsername(String username);
	
	User findByUsernameAndPassword(String username,String password);

	List<User> findByUsernameOrPassword(String username,String password);
}
