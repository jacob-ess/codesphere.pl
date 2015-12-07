package pl.codesphere.spring.boot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.codesphere.spring.boot.domain.User;
import pl.codesphere.spring.boot.service.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST)
	public void create(@RequestBody User user) {
		userRepository.save(user);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public User find(@PathVariable("id") long id) {
		return userRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public User update(@PathVariable("id") long id, @RequestBody User user) {
		user.setId(id);
		return userRepository.save(user);
	}

	@RequestMapping(value = " {id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") long id) {
		userRepository.delete(id);
	}

}