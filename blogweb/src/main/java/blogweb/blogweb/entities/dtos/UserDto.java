package blogweb.blogweb.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;

}
