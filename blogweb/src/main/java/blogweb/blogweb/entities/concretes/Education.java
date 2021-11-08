package blogweb.blogweb.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "educations")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Okul adı boş olamaz")
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "section")
	private String section;
	
	@NotBlank(message = "Başlangıç tarihi boş olamaz")
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "end_date")
	private String endedDate;
	
}
