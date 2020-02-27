// final annotated ListPet POJO
package model;

import javax.persistence.CascadeType;

/*All these import statements came in by clicking the red X and using
*  Import option from the javax.persistence package
*/

/*
 * If you are asked to create a class, interface, constant, etc, you 
 * made a spelling or capitalization error!!
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pets")
public class ListPet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TYPE")
	private String type;
	@Column(name="NAME")
	private String name;
	@Column(name="OWNER")
	private String owner;
	
	// Default, no arg constructor
	public ListPet() {
		super();
	}
	
	public ListPet(String type, String name, String owner) {
		super();
		this.type = type;
		this.name = name;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	// Print method
	public String returnItemDetails() {
		return id + "\t" + type + "\t" + name + "\t" + owner;
	}
	

}
