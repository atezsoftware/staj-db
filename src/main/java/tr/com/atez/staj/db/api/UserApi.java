package tr.com.atez.staj.db.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tr.com.atez.staj.db.model.User;
import tr.com.atez.staj.db.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApi {

	@Autowired
	@Qualifier("userServiceImpl")
	UserService userService;

	@GetMapping
	public List<User> listUsers() {
		return userService.listUsers();
	}

	@GetMapping("/{name}")
	public User findUserByName(@PathVariable("name") String name) {
		return userService.findUserByName(name);
	}

	@GetMapping("/salary/{name}")
	public User findUserByNameAndSalary(@PathVariable("name") String name, @RequestParam("salary") Double salary) {
		return userService.findUserByNameWithSalaryGreaterThan(name, salary);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

}
