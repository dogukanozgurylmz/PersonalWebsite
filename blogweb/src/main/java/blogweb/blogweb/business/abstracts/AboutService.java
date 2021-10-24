package blogweb.blogweb.business.abstracts;

import java.util.List;

import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.entities.concretes.About;

public interface AboutService {

	Result add(About about);
	
	Result update(About about);
	
	Result delete(int id);
	
	DataResult<List<About>> findAll();
	
	DataResult<About> findById(int id);
	
}
