package blogweb.blogweb.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

	private int id;
	
	private String phoneNumber;
	
	private String email;
	
	private String instagram;
	
	private String facebook;
	
	private String twitter;
	
	private String github;
	
	private String linkedin;
	
}
