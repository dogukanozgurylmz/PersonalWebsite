package blogweb.blogweb.business.abstracts;

import java.util.List;

import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.entities.concretes.User;

public interface UserService {

	Result add(User user);
	
	Result update(User user);
	
	Result delete(int id);
	
	DataResult<List<User>> findAll();
	
	DataResult<User> findById(int id);
	
}
