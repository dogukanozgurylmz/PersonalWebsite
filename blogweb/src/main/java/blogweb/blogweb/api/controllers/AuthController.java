package blogweb.blogweb.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blogweb.blogweb.business.abstracts.AuthService;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.entities.concretes.User;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
	
	private final AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public Result register(@RequestBody User user) {
		return this.authService.register(user);
	}
	
	@PostMapping("/login")
	public Result login(@RequestParam String email, @RequestParam String password) {
		return this.authService.login(email, password);
	}

}
