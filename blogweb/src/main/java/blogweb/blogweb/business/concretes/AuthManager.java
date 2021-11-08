package blogweb.blogweb.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import blogweb.blogweb.business.abstracts.AuthService;
import blogweb.blogweb.business.abstracts.UserService;
import blogweb.blogweb.core.utilities.results.ErrorResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.core.utilities.results.SuccessResult;
import blogweb.blogweb.entities.concretes.User;

@Service
public class AuthManager implements AuthService {
	
	private final UserService userService;

	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public Result register(User user) {
		
		var resultEmail = this.realEmail(user.getEmail());
		var resultPassword = this.passwordRules(user.getPassword());
		if (!resultEmail) {
			return new ErrorResult("Geçerli bir e-posta adresi giriniz");
		}
		if (!resultPassword) {
			return new ErrorResult("Şifre"
					+ " En az 8 karakter olmalı"
					+ " En az bir rakam içermeli"
					+ " En az bir küçük harf ve bir büyük harf içermeli"
					+ " Bir dizi özel karakter ( @#%$^vb.) n en az bir karakter içermeli"
					+ " Boşluk, sekme vb. içermez.");
		}
		this.userService.add(user);
		return new SuccessResult("Kayıt olundu");
		
	}

	@Override
	public Result login(String email, String password) {
		
		if (!this.userService.existsByEmailAndPassword(email, password)) {
			return new ErrorResult("E-posta veya şifre hatalı");
		}
		return new SuccessResult("Giriş yapıldı");
	}

	// İŞ KODLARI - BAŞLANGIÇ

	private boolean realEmail(String email) {

		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			return false;
		}
		return true;

	}
	
	private boolean passwordRules(String password) {
		
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.,?@#$%^&-+=()])(?=\\S+$).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if (!matcher.matches()) {
			return false;
		}
		return true;
		
	}

	// İŞ KODLARI - BİTİŞ

}
