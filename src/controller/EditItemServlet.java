package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListPet;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListPetHelper dao = new ListPetHelper();

		String petType = request.getParameter("petType");
		String petName = request.getParameter("petName");
		String petOwner = request.getParameter("petOwner");
		Integer tempId = Integer.parseInt(request.getParameter("id"));

		ListPet itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setType(petType);
		itemToUpdate.setName(petName);
		itemToUpdate.setOwner(petOwner);

		dao.updateItem(itemToUpdate); 
		 
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

}
