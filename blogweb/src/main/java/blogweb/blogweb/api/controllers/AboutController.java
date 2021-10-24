package blogweb.blogweb.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blogweb.blogweb.business.abstracts.AboutService;
import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.ErrorResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.core.utilities.results.SuccessResult;
import blogweb.blogweb.entities.concretes.About;

@RestController
@RequestMapping("/api/about")
@CrossOrigin
public class AboutController {

	private final AboutService aboutService;

	public AboutController(AboutService aboutService) {
		super();
		this.aboutService = aboutService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody About about) {
		return this.aboutService.add(about);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody About about) {
		return this.aboutService.update(about);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.aboutService.delete(id);
	}
	
	@GetMapping("/findAll")
	public DataResult<List<About>> findAll(){
		return this.aboutService.findAll();
	}
	
	@GetMapping("/findById")
	public DataResult<About> findById(int id){
		return this.aboutService.findById(id);
	}

}
