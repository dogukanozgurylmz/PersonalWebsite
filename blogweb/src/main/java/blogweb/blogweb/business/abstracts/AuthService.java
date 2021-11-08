package blogweb.blogweb.business.abstracts;

import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.entities.concretes.User;

public interface AuthService {

	Result register(User user);
	
	Result login(String email, String password);
	
}
