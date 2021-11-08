package blogweb.blogweb.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import blogweb.blogweb.business.abstracts.UserService;
import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.ErrorDataResult;
import blogweb.blogweb.core.utilities.results.ErrorResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.core.utilities.results.SuccessDataResult;
import blogweb.blogweb.core.utilities.results.SuccessResult;
import blogweb.blogweb.dataAccess.abstracts.UserDao;
import blogweb.blogweb.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private final UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {

		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");

	}

	@Override
	public Result delete(int id) {

		if (this.userDao.findById(id).equals(null)) {
			return new ErrorResult("Id bulunamadı");
		}
		this.userDao.deleteById(id);
		return new SuccessResult("Kullanıcı silindi");

	}

	@Override
	public DataResult<List<User>> findAll() {

		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Kullanıcılar listelendi");

	}

	@Override
	public DataResult<User> findById(int id) {

		if (this.userDao.findById(id).equals(null)) {
			return new ErrorDataResult<User>("Id bulunamadı");
		}
		return new SuccessDataResult<User>(this.userDao.findById(id), "Kullanıcı getirildi");

	}

	@Override
	public boolean existsByEmailAndPassword(String email, String password) {
		return this.userDao.existsByEmailAndPassword(email, password);
	}

	// İŞ KODLARI - BAŞLANGIÇ

	/*
	 * private boolean realEmail(String email) {
	 * 
	 * String regex =
	 * "[a-z0-9!#$%&\\'*+/=?^_\\'{|}~-]+(?:.[a-z0-9!#$%&\\'*+/=?^_\\'{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
	 * Pattern pattern = Pattern.compile(regex); Matcher matcher =
	 * pattern.matcher(email); if (!matcher.matches()) { return false; } return
	 * true;
	 * 
	 * }
	 */

	// İŞ KODLARI - BİTİŞ

}
