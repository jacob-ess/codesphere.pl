package pl.codesphere.spring.boot.service;

import pl.codesphere.spring.boot.domain.User;

public interface UserService {

	Iterable<User> findAll();

	User findOne(Integer id);

	User save(User user);

	void delete(Integer id);
}