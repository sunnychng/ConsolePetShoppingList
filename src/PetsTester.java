import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.PetsDetailsHelper;
import controller.PetsSitterHelper;
import model.ListPet;
import model.PetsDetails;
import model.PetsSitter;

public class PetsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PetsSitter john = new PetsSitter("John");
		
		PetsSitterHelper psh = new PetsSitterHelper();
		
		ListPet dog = new ListPet("Dog", "Rover", "Smith");
		ListPet hamster = new ListPet("Hamster", "Pokey", "King");
		
		List<ListPet> johnsPets = new ArrayList<ListPet>();
		johnsPets.add(dog);
		johnsPets.add(hamster);
		
		//psh.insertPetsSitter(john);
		
		//List<PetsSitter> allPetsSitter = psh.showAllPetsSitter();
		//for (PetsSitter a: allPetsSitter) {
		//	System.out.println(a.toString());
		//}
		
		PetsDetailsHelper pdh = new PetsDetailsHelper();
		PetsDetails johnList = new PetsDetails("John", "15152226666", LocalDate.now(), john);
		johnList.setListOfPets(johnsPets);
		
		pdh.insertNewPetsDetails(johnList);
		
		List<PetsDetails> allPets = pdh.getPets();
		for (PetsDetails a : allPets) {
			System.out.println(a.toString());
		}
	}

}
