package tr.com.atez.staj.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tr.com.atez.staj.db.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByName(String name);

	@Query("select u from User u where u.name=:name and u.salary > :salary")
	User findUserByNameWithSalaryGreaterThan(@Param("name") String name, @Param("salary") Double salary);

}
