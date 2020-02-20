package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListPet;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String petType = request.getParameter("petType");
		String petName = request.getParameter("petName");
		String petOwner = request.getParameter("petOwner");

		if (petType.isEmpty() || petName.isEmpty() || petOwner.isEmpty() || petType == null || petName == null
				|| petOwner == null) {

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		} else {

			ListPet li = new ListPet(petType, petName, petOwner);
			ListPetHelper dao = new ListPetHelper();

			dao.insertItem(li);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);

		}
	}

}
