package blogweb.blogweb.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {

	private int id;
	
	private String schoolName;
	
	private String grade;
	
	private String section;
	
	private String StartDate;
	
	private String endedDate;
	
}
