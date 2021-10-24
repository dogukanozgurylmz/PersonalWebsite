package blogweb.blogweb.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blogweb.blogweb.business.abstracts.PostService;
import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.entities.concretes.Post;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin
public class PostController {

	private final PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Post post) {
		return this.postService.add(post);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Post post) {
		return this.postService.update(post);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.postService.delete(id);
	}
	
	@GetMapping("/findAll")
	public DataResult<List<Post>> findAll() {
		return this.postService.findAll();
	}
	
	@GetMapping("/findById")
	public DataResult<Post> findById(@RequestParam int id) {
		return this.postService.findById(id);
	}
	
}
