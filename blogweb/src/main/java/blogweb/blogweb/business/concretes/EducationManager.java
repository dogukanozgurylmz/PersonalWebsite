package blogweb.blogweb.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import blogweb.blogweb.business.abstracts.EducationService;
import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.ErrorDataResult;
import blogweb.blogweb.core.utilities.results.ErrorResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.core.utilities.results.SuccessDataResult;
import blogweb.blogweb.core.utilities.results.SuccessResult;
import blogweb.blogweb.dataAccess.abstracts.EducationDao;
import blogweb.blogweb.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private final EducationDao educationDao;
	
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		
		this.educationDao.save(education);
		return new SuccessResult("Eğitim bilgileri eklendi");
	}

	@Override
	public Result update(Education education) {
		
		this.educationDao.save(education);
		return new SuccessResult("Eğitim bilgileri güncellendi");
		
	}

	@Override
	public Result delete(int id) {
		
		var result = this.educationDao.findById(id);
		if (result.equals(null)) {
			return new ErrorResult("Id bulunamadı");
		}
		this.educationDao.deleteById(id);
		return new SuccessResult("Eğitim bilgileri silindi");
		
	}

	@Override
	public DataResult<List<Education>> findAll() {

		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Eğitim bilgileri listelendi");
		
	}

	@Override
	public DataResult<Education> findById(int id) {
		
		var result = this.educationDao.findById(id);
		if (result.equals(null)) {
			return new ErrorDataResult<Education>("Id bulunamadı");
		}
		return new SuccessDataResult<Education>(this.educationDao.findById(id),"Eğitim bilgisi getirildi");
		
	}
	
	//İŞ KODLARI - BAŞLANGIÇ
	
	/*
	 * private boolean realDate(String date) {
	 * 
	 * String regex =
	 * "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$"; Pattern
	 * pattern = Pattern.compile(regex); Matcher matcher = pattern.matcher(date); if
	 * (!matcher.matches()) { return false; } return true;
	 * 
	 * }
	 */
	
	//İŞ KODLARI - BİTİŞ

}
