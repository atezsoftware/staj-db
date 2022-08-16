package tr.com.atez.staj.db.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.atez.staj.db.model.User;
import tr.com.atez.staj.db.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	final UserRepository userRepository;

	@Override
	public List<User> listUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByName(String name) {
		return userRepository.findUserByName(name);
	}

	@Override
	public User findUserByNameWithSalaryGreaterThan(String name, Double salary) {
		return userRepository.findUserByNameWithSalaryGreaterThan(name, salary);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

}
