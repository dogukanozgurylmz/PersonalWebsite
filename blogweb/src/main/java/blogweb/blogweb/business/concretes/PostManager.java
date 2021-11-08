package blogweb.blogweb.business.concretes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import blogweb.blogweb.business.abstracts.PostService;
import blogweb.blogweb.core.utilities.results.DataResult;
import blogweb.blogweb.core.utilities.results.ErrorDataResult;
import blogweb.blogweb.core.utilities.results.ErrorResult;
import blogweb.blogweb.core.utilities.results.Result;
import blogweb.blogweb.core.utilities.results.SuccessDataResult;
import blogweb.blogweb.core.utilities.results.SuccessResult;
import blogweb.blogweb.dataAccess.abstracts.PostDao;
import blogweb.blogweb.entities.concretes.Post;

@Service
public class PostManager implements PostService {

	private final PostDao postDao;

	public PostManager(PostDao postDao) {
		super();
		this.postDao = postDao;
	}

	@Override
	public Result add(Post post) {
		
		SimpleDateFormat sekil = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
		
		var resultHeadline = this.postHeadlineWordLimit(post.getHeadline().length());
		var resultPostContent = this.postContentWordLimit(post.getPostContent().length());
		if (!resultHeadline) {
			return new ErrorResult("Başlık 150 karakterden fazla olamaz");
		}
		if (!resultPostContent) {
			return new ErrorResult("İçerik 5000 karakterden fazla olamaz");
		}
		post.setAddedDate(sekil.format(date));
		this.postDao.save(post);
		return new SuccessResult("Gönderi eklendi");
		
	}

	@Override
	public Result update(Post post) {
		
		var resultHeadline = this.postHeadlineWordLimit(post.getHeadline().length());
		var resultPostContent = this.postContentWordLimit(post.getPostContent().length());
		if (!resultHeadline) {
			return new ErrorResult("Başlık 150 karakterden fazla olamaz");
		}
		if (!resultPostContent) {
			return new ErrorResult("İçerik 5000 karakterden fazla olamaz");
		}
		this.postDao.save(post);
		return new SuccessResult("Gönderi güncellendi");
		
	}

	@Override
	public Result delete(int id) {
		
		var result = this.postDao.findById(id);
		if (result.equals(null)) {
			return new ErrorResult("Id bulunamadı");
		}
		this.postDao.deleteById(id);
		return new SuccessResult("Gönderi silindi");
		
	}

	@Override
	public DataResult<List<Post>> findAll() {
		
		return new SuccessDataResult<List<Post>>(this.postDao.findAll(), "Gönderiler listelendi");
		
	}

	@Override
	public DataResult<Post> findById(int id) {
		
		var result = this.postDao.findById(id);
		if (result.equals(null)) {
			return new ErrorDataResult<Post>("Id bulunamadı");
		}
		return new SuccessDataResult<Post>(this.postDao.findById(id), "Seçili gönderi getirildi");
		
	}
	
	//İŞ KODLARI - BAŞLANGIÇ
	
	private boolean postHeadlineWordLimit(int limit) {
		
		if (limit>150) {
			return false;
		}
		return true;
		
	}
	
	private boolean postContentWordLimit(int limit) {
		
		if (limit>5000) {
			return false;
		}
		return true;
		
	}
	
	//İŞ KODLARI = BİTİŞ
	
}
