package blogweb.blogweb.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blogweb.blogweb.business.abstracts.EducationService;
import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationController {

	private final EducationService educationService;

	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		return this.educationService.add(education);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Education education) {
		return this.educationService.update(education);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.educationService.delete(id);
	}
	
	@GetMapping("/findAll")
	public DataResult<List<Education>> findAll() {
		return this.educationService.findAll();
	}
	
	@GetMapping("/findById")
	public DataResult<Education> findById(@RequestParam int id){
		return this.educationService.findById(id);
	}
	
}
