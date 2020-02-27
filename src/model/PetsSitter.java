package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pets_sitter")
public class PetsSitter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PETS_SITTER_ID")
	private int id;
	@Column(name="PETS_SITTER_NAME")
	private String petsSitterName;
	
	public PetsSitter() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public PetsSitter(int id, String petsSitterName) {
		super();
		this.id = id;
		this.petsSitterName = petsSitterName;
	}

	public PetsSitter(String petsSitterName) {
		super();
		this.petsSitterName = petsSitterName;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPetsSitterName() {
		return petsSitterName;
	}
	
	public void setPetsSitterName(String petsSitterName) {
		this.petsSitterName = petsSitterName;
	}
	
	@Override
	public String toString() {
		return "PetsSitter [id=" + id + ", petsSitterName=" + petsSitterName + "]";
	}

}
