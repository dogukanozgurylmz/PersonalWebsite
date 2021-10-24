package blogweb.blogweb.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import blogweb.blogweb.entities.concretes.Post;

public interface PostDao extends JpaRepository<Post, Integer> {

}
