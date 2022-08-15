package tr.com.atez.staj.db.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tr.com.atez.staj.db.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcUserService implements UserService {

	@Override
	public List<User> listUsers() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/staj-db", "staj", "1234");

			ResultSet resultSet = conn.prepareStatement("select * from users").executeQuery();

			List<User> result = new ArrayList<>();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString("name");
				String department = resultSet.getString(3);
				double salary = resultSet.getDouble(4);

				User user = new User(id, name, department, salary);
				result.add(user);
			}

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findUserByName(String name) {
		return null;
	}

	@Override
	public User findUserByNameWithSalaryGreaterThan(String name, Double salary) {
		return null;
	}

}
