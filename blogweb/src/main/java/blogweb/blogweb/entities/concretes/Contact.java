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
@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Telefon numarası boş olamaz")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@NotBlank(message = "E-posta boş olamaz")
	@Column(name = "email")
	private String email;
	
	@Column(name = "instagram")
	private String instagram;
	
	@Column(name = "facebook")
	private String facebook;
	
	@Column(name = "twitter")
	private String twitter;
	
}
