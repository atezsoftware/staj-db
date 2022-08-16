package tr.com.atez.staj.db.service;


import tr.com.atez.staj.db.model.User;

import java.util.List;

public interface UserService {

	/**
	 * returns all users
	 * @return user list
	 */
	List<User> listUsers();

	User findUserByName(String name);

	User findUserByNameWithSalaryGreaterThan(String name, Double salary);

	User createUser(User user);
}
