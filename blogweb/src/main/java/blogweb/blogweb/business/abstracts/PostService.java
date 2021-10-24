package blogweb.blogweb.business.abstracts;

import java.util.List;

import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.entities.concretes.Post;

public interface PostService {

	Result add(Post post);
	
	Result update(Post post);
	
	Result delete(int id);
	
	DataResult<List<Post>> findAll();
	
	DataResult<Post> findById(int id);
	
}
