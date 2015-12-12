package pl.codesphere.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import pl.codesphere.spring.boot.domain.User;
import pl.codesphere.spring.boot.repository.UserRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		User admin = new User();
		admin.setId(1);
		admin.setLogin("admin");
		admin.setPassword("admin");
		userRepository.save(admin);

		User user = new User();
		user.setId(2);
		user.setLogin("user");
		user.setPassword("user");
		userRepository.save(user);

		User guest = new User();
		guest.setId(3);
		guest.setLogin("guest");
		guest.setPassword("guest");
		userRepository.save(guest);
	}
}
