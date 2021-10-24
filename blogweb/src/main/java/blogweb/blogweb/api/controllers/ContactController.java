package blogweb.blogweb.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blogweb.blogweb.business.abstracts.ContactService;
import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.entities.concretes.Contact;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {

	private final ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Contact contact) {
		return this.contactService.add(contact);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Contact contact) {
		return this.contactService.update(contact);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.contactService.delete(id);
	}
	
	@GetMapping("/findAll")
	public DataResult<List<Contact>> findAll(){
		return this.contactService.findAll();
	}
	
	@GetMapping("/findById")
	public DataResult<Contact> findById(@RequestParam int id){
		return this.contactService.findById(id);
	}
	
}
