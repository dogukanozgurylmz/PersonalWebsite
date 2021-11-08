package blogweb.blogweb.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private int id;
	
	private String headline;
	
	private String postContent;
	
	private String addedDate;
	
}
