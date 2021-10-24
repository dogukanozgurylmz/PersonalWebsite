package blogweb.blogweb.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import blogweb.blogweb.entities.concretes.About;

public interface AboutDao extends JpaRepository<About, Integer> {

	About findById(int id);
	
}
