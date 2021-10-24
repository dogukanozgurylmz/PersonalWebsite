package blogweb.blogweb.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import blogweb.blogweb.entities.concretes.Contact;

public interface ContactDao extends JpaRepository<Contact, Integer> {

	Contact findById(int id);
	
}
