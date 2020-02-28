package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pets_owner")
public class PetsDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OWNER_ID")
	private int id;
	@Column(name="OWNER_NAME")
	private String ownerName;
	@Column(name="OWNER_PHONE")
	private String ownerPhone;
	@Column(name="TRIP_DATE")
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST )
	@JoinColumn(name="PETS_SITTER_ID")
	private PetsSitter petsSitter;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable (
				name="pets_on_list",
				joinColumns= {@JoinColumn(name="OWNER_ID", referencedColumnName="OWNER_ID")},
				inverseJoinColumns= {@JoinColumn(name="PETS_ID", referencedColumnName="ID", unique=true)}
		)
	private List<ListPet> listOfPets;

	public PetsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetsDetails(int id, String ownerName, String ownerPhone, LocalDate tripDate, PetsSitter petsSitter,
			List<ListPet> listOfPets) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.tripDate = tripDate;
		this.petsSitter = petsSitter;
		this.listOfPets = listOfPets;
	}
	
	public PetsDetails(String ownerName, String ownerPhone, LocalDate tripDate, PetsSitter petsSitter,
			List<ListPet> listOfPets) {
		super();
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.tripDate = tripDate;
		this.petsSitter = petsSitter;
		this.listOfPets = listOfPets;
	}
	
	public PetsDetails(String ownerName, String ownerPhone, LocalDate tripDate, PetsSitter petsSitter) {
		super();
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.tripDate = tripDate;
		this.petsSitter = petsSitter;
	}

	public int getId() {
		return id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public PetsSitter getPetsSitter() {
		return petsSitter;
	}

	public List<ListPet> getListOfPets() {
		return listOfPets;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public void setPetsSitter(PetsSitter petsSitter) {
		this.petsSitter = petsSitter;
	}

	public void setListOfPets(List<ListPet> listOfPets) {
		this.listOfPets = listOfPets;
	}

	@Override
	public String toString() {
		return "PetsDetails [id=" + id + ", ownerName=" + ownerName + ", ownerPhone=" + ownerPhone + ", tripDate="
				+ tripDate + ", petsSitter=" + petsSitter + ", listOfPets=" + listOfPets + "]";
	}

}
