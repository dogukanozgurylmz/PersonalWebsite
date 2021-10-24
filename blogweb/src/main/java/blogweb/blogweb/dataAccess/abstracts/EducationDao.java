package blogweb.blogweb.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import blogweb.blogweb.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

	Education findById(int id);
	
}
