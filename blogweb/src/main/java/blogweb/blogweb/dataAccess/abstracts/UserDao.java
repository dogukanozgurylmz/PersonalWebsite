package blogweb.blogweb.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import blogweb.blogweb.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findById(int id);
	
	boolean existsByEmailAndPassword(String email, String password);

}
