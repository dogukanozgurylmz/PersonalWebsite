package blogweb.blogweb.business.abstracts;

import java.util.List;

import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.entities.concretes.Education;

public interface EducationService {

	Result add(Education education);
	
	Result update(Education education);
	
	Result delete(int id);
	
	DataResult<List<Education>> findAll();
	
	DataResult<Education> findByAll(int id);
	
}
