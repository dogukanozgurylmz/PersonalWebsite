package blogweb.blogweb.business.abstracts;

import java.util.List;

import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.entities.concretes.Contact;

public interface ContactService {

	Result add(Contact contact);
	
	Result update(Contact contact);
	
	Result delete(int id);
	
	DataResult<List<Contact>> findAll();
	
	DataResult<Contact> findById(int id);
	
}
