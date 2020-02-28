package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListPet;
import model.PetsDetails;
import model.PetsSitter;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListPetHelper lih = new ListPetHelper();
		String ownerName = request.getParameter("ownerName");
		String ownerPhone = request.getParameter("ownerPhone");
		System.out.println("Owner Name: " + ownerName);
		System.out.println("Owner Phone: " + ownerPhone);

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String petSitterName = request.getParameter("petSitterName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		String[] selectedPets = request.getParameterValues("allItemsToAdd");
		List<ListPet> selectedPetsInList = new ArrayList<ListPet>();
		if (selectedPets != null && selectedPets.length > 0) {
			for (int i = 0; i < selectedPets.length; i++) {
				System.out.println(selectedPets[i]);
				ListPet c = lih.searchForItemById(Integer.parseInt(selectedPets[i]));
				selectedPetsInList.add(c);

			}
		}
		
		PetsSitter petSitter = new PetsSitter(petSitterName);
		PetsDetails pld = new PetsDetails(ownerName, ownerPhone, ld, petSitter);
		pld.setListOfPets(selectedPetsInList);
		PetsDetailsHelper plh = new PetsDetailsHelper();
		plh.insertNewPetsDetails(pld);

		System.out.println("Success!");
		System.out.println(pld.toString());

		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
