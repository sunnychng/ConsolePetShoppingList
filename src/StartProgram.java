
import java.util.List;
import java.util.Scanner;

import controller.ListPetHelper;
import model.ListPet;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static ListPetHelper lih = new ListPetHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter pet type: ");
		String type = in.nextLine();
		System.out.print("Enter pet name: ");
		String name = in.nextLine();
		System.out.print("Enter pet owner name: ");
		String owner = in.nextLine();
		ListPet toAdd = new ListPet(type, name, owner);
		lih.insertItem(toAdd);

	}
	

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the pet type to delete: ");
		String type = in.nextLine();
		System.out.print("Enter the pet name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the pet owner to delete: ");
		String owner = in.nextLine();
		ListPet toDelete = new ListPet(type, name, owner);
		lih.deleteItem(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by pet type");
		System.out.println("2 : Search by pet name");
		System.out.println("3 : Search by pet owner");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ListPet> foundPet = null;
		if (searchBy == 1) {
			System.out.print("Enter the pet type: ");
			String petType = in.nextLine();
			foundPet = lih.searchForPetByType(petType);

		} else if (searchBy == 2) {
			System.out.print("Enter the pet name: ");
			String petName = in.nextLine();
			foundPet = lih.searchForPetByName(petName);
		} else {
			System.out.print("Enter the pet owner name: ");
			String ownerName = in.nextLine();
			foundPet = lih.searchForPetByOwner(ownerName);
		}
		
		if (!foundPet.isEmpty()) {
			System.out.println("Found Results.");
			for (ListPet l : foundPet) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ListPet toEdit = lih.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + ", " + toEdit.getOwner() + " from " + toEdit.getType());
			System.out.println("1 : Update Pet Type");
			System.out.println("2 : Update Pet Name");
			System.out.println("3 : Update Owner Name");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Type: ");
				String newType = in.nextLine();
				toEdit.setType(newType);
			} else if (update == 2) {
				System.out.print("New Pet Name: ");
				String newPetName = in.nextLine();
				toEdit.setName(newPetName);
			} else {
				System.out.print("New Pet Owner: ");
				String newOwner = in.nextLine();
				toEdit.setOwner(newOwner);
			}

			lih.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome pet shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a pet");
			System.out.println("*  2 -- Edit a pet");
			System.out.println("*  3 -- Delete a pet");
			System.out.println("*  4 -- View the pet list");
			System.out.println("*  5 -- Exit the pet list program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<ListPet> allItems = lih.showAllItems();
		System.out.println("ID\t"+ "Type\t" + "Name\t" + "Owner");
		System.out.println("------------------------------------");
		for (ListPet singleItem : allItems) {
			System.out.println(singleItem.returnItemDetails());
		}
		System.out.println();
	}

}
