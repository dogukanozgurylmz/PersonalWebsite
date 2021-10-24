package blogweb.blogweb.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import blogweb.blogweb.business.abstracts.AboutService;
import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.ErrorDataResult;
import blogweb.blogweb.core.utilities.results.ErrorResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.core.utilities.results.SuccessDataResult;
import blogweb.blogweb.core.utilities.results.SuccessResult;
import blogweb.blogweb.dataAccess.abstracts.AboutDao;
import blogweb.blogweb.entities.concretes.About;

@Service
public class AboutManager implements AboutService {
	
	private final AboutDao aboutDao;
	
	public AboutManager(AboutDao aboutDao) {
		this.aboutDao=aboutDao;
	}

	@Override
	public Result add(About about) {
		
		var result = aboutContentWordLimit(about.getAboutContent().length());
		if (!result) {
			return new ErrorResult("Hakkında içeriği 5000 karakterden uzun olamaz.");
		}
		this.aboutDao.save(about);
		return new SuccessResult("Hakkında içerik ekleme başarılı.");
		
	}

	@Override
	public Result update(About about) {
		
		var result = aboutContentWordLimit(about.getAboutContent().length());
		if (!result) {
			return new ErrorResult("Hakkında içeriği 5000 karakterden uzun olamaz.");
		}
		this.aboutDao.save(about);
		return new SuccessResult("Hakkında içerik güncelleme başarılı.");
		
	}

	@Override
	public Result delete(int id) {
		
		if (this.aboutDao.findById(id).equals(null)) {
			return new ErrorResult("Id bulunamadı");
		}
		this.aboutDao.deleteById(id);;
		return new SuccessResult("Hakkında içeriği silindi");
		
	}

	@Override
	public DataResult<List<About>> findAll() {

		return new SuccessDataResult<List<About>>(this.aboutDao.findAll(), "Hakkında listelendi");
		
	}
	
	@Override
	public DataResult<About> findById(int id) {
		
		if (this.aboutDao.findById(id).equals(null)) {
			return new ErrorDataResult<About>("Id bulunamadı");
		}
		return new SuccessDataResult<About>(this.aboutDao.findById(id),"Id getirildi");
		
	}
	
	//İŞ KODLARI - BAŞLANGIÇ
	
	private boolean aboutContentWordLimit(int content) {
		if (content>5000) {
			return false;
		}
		return true;
	}
	
	//İŞ KODLARI - BİTİŞ
	
}
