package pl.codesphere.spring.boot.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.codesphere.spring.boot.config.Application;
import pl.codesphere.spring.boot.domain.User;
import pl.codesphere.spring.boot.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void saveUserTest() {
		User user = new User();
		user.setId(1);
		user.setLogin("es_jakubowski");
		user.setPassword("P@ssw0rd");

		assertNull(user.getId());
		userRepository.save(user);
		assertNotNull(user.getId());

		User findUser = userRepository.findOne(user.getId());
		assertNotNull(findUser);
		assertEquals(user.getId(), findUser.getId());
		assertEquals(user.getLogin(), findUser.getLogin());
		assertEquals(user.getPassword(), findUser.getPassword());

		findUser.setPassword("Pa$$word");
		userRepository.save(findUser);

		User findUpdatedUser = userRepository.findOne(findUser.getId());
		assertEquals(findUser.getPassword(), findUpdatedUser.getPassword());

		long userCount = userRepository.count();
		assertEquals(userCount, 1);

		Iterable<User> users = userRepository.findAll();
		int count = 0;
		for (User u : users)
			count++;
		assertEquals(count, 1);
	}
}
