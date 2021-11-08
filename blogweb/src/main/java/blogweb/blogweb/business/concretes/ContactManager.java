package blogweb.blogweb.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import blogweb.blogweb.business.abstracts.ContactService;
import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.ErrorDataResult;
import blogweb.blogweb.core.utilities.results.ErrorResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.core.utilities.results.SuccessDataResult;
import blogweb.blogweb.core.utilities.results.SuccessResult;
import blogweb.blogweb.dataAccess.abstracts.ContactDao;
import blogweb.blogweb.entities.concretes.Contact;

@Service
public class ContactManager implements ContactService {

	private final ContactDao contactDao;

	public ContactManager(ContactDao contactDao) {
		super();
		this.contactDao = contactDao;
	}

	@Override
	public Result add(Contact contact) {
		
		var resultEmail = this.realEmail(contact.getEmail());
		var resultPhone = this.realPhoneNumber(contact.getPhoneNumber());
		if (!resultEmail) {
			return new ErrorResult("Geçerli bir e-posta adresi giriniz");
		}
		if (!resultPhone) {
			return new ErrorResult("Telefon numarasını başında 0 olmadan giriniz");
		}
		this.contactDao.save(contact);
		return new SuccessResult("İletişim bilgileri eklendi");

	}

	@Override
	public Result update(Contact contact) {

		var resultEmail = this.realEmail(contact.getEmail());
		var resultPhone = this.realPhoneNumber(contact.getPhoneNumber());
		if (!resultEmail) {
			return new ErrorResult("Geçerli e-posta adresi giriniz");
		}
		if (!resultPhone) {
			return new ErrorResult("Telefon numarasını başında 0 olmadan giriniz");
		}
		this.contactDao.save(contact);
		return new SuccessResult("İletişim bilgileri güncellendi");
		
	}

	@Override
	public Result delete(int id) {
		
		if (this.contactDao.findById(id).equals(null)) {
			return new ErrorResult("Id bulunamadı");
		}
		this.contactDao.deleteById(id);
		return new SuccessResult("İletişişm bilgileri silindi");
		
	}

	@Override
	public DataResult<List<Contact>> findAll() {
		
		return new SuccessDataResult<List<Contact>>(this.contactDao.findAll(), "İletişim bilgileri listelendi");
		
	}

	@Override
	public DataResult<Contact> findById(int id) {
		
		if (this.contactDao.findById(id).equals(null)) {
			return new ErrorDataResult<Contact>("Id bulunumadı");
		}
		return new SuccessDataResult<Contact>(this.contactDao.findById(id), "İletişim bilgisi getirildi.");
		
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

	private boolean realPhoneNumber(String phoneNumber) {
		
		String regex = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		if (!matcher.matches()) {
			return false;
		}
		return true;
		
	}

	// İŞ KODLARI - BİTİŞ

}
