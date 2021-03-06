package pl.codesphere.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;

import pl.codesphere.spring.boot.domain.User;

public interface UserRepository extends CrudRepository<User, Integer>  {

}