package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.LogicalCode;
import DTO.Party;
/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 LogicalCode logicalCode = new LogicalCode();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
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
		
		String Edit= request.getParameter("Edit");
		String Delete= request.getParameter("Delete");
		
		int partyId = Integer.parseInt(request.getParameter("partyId"));
		 if(Edit!=null)
		 {
			 String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String phone = request.getParameter("phone");
				String city = request.getParameter("city");
				String address = request.getParameter("address");
				String zip = request.getParameter("zip");
				String state = request.getParameter("state");
				String country = request.getParameter("country");
				Party partyObj = new Party(partyId,firstName,lastName,address,city,zip,state,country,phone);
				
				try {
					logicalCode.updateUser(partyObj);
					request.setAttribute("EDIT","edited");
					request.getRequestDispatcher("/DisplayAll").forward(request, response);
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 if(Delete!=null)
		 {
			 try {
				 	logicalCode.deleteUser(partyId);
				 	request.setAttribute("DELETE","deleted");
					request.getRequestDispatcher("/DisplayAll").forward(request, response);
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		
	
		
		
	}
}
