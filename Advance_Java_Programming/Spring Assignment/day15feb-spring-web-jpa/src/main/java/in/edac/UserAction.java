package in.edac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserAction {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/register")
	public String register(String username,String password,String email,String mobile) {
		
		User user = new User(username,password,email,mobile);
		userRepository.save(user);
		
		return username;
	}
}
