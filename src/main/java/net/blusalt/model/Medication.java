package net.blusalt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Medication {

	

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 @NotBlank
	 @Pattern(regexp = "[A-Za-z0-9-_]+")
	 private String name;
	 
	 private int weight;
	 
	 @Pattern(regexp = "[A-Z0-9_]+")
	 private String code;
	 
	 private String image;
	
}
