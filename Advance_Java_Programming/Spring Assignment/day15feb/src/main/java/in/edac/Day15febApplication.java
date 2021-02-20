package in.edac;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Day15febApplication implements CommandLineRunner   {

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Day15febApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		//update();
		//create();
		//findAndUpdate();
		//delete();
		//findAllDemo();
		 queryDemo();
	}
	
	public void queryDemo() {
//		List<User> list = userRepository.findByUsername("mumbai");
//		list.stream().map(User::getUsername).forEach(System.out::println);
		
//		User user = userRepository.findByUsernameAndPassword("pratu","jmule");
//	    System.out.println(user.getUsername());
		
		List<User> list = userRepository.findByUsernameOrPassword("pratu","asjij");
		list.stream().map(User::getEmail).forEach(System.out::println);
	}
	
	public void findAllDemo() {
		List<User> list =  userRepository.findAll();
	
		list.stream().map(User::getUsername).forEach(System.out::println);
	}
	
	public void delete() {
		userRepository.deleteById(1);
	}
	
	public void findAndUpdate() {
		User user = userRepository.findById(2).get();
		user.setUsername("mumbai");
		
		userRepository.save(user);
	}
	
	
	public void update() {
		User user = new User();
		user.setId(2);
		user.setUsername("pratima");
		userRepository.save(user);
	}
	
	public void create() {
		User user = new User("pratu","jmule","dahg","54");
		userRepository.save(user);
	}
	
	


	
}
