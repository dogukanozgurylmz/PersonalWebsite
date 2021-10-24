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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "İsim boş olamaz")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Soyisim boş olamaz")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "E-posta boş olamaz")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "Şifre boş olamaz")
	@Column(name = "password")
	private String password;
	
}
