package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LogicalCode;
import DTO.Party;
import DTO.UserLogin;

/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LogicalCode logicalCode = new LogicalCode();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUser() {
        super();

    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Party partyObj = logicalCode.searchUser(firstName,lastName);
		String fname = partyObj.getFirstName();
		String lname = partyObj.getLastName();
		String address= partyObj.getAddress();
		String city = partyObj.getCity();
		String phone = partyObj.getPhone();
	
	        request.setAttribute("fname", fname); 
	        request.setAttribute("lname", lname); 
	        request.setAttribute("addres", address); 
	        request.setAttribute("city", city);
	        request.setAttribute("phone", phone);
	        request.getRequestDispatcher("views/Dashboard.jsp").forward(request, response);
	    
		/*
		 * out.
		 * print("<table><tr><th>First Name</th><th>Last Name</th><th>Phone</th><th>City</th></tr>"
		 * ); out.print("<tr><td>"); out.print(partyObj.getFirstName());
		 * out.print("</td>"); out.print("<td>"); out.print(partyObj.getLastName());
		 * out.print("</td>"); out.print("<td>"); out.print(partyObj.getPhone());
		 * out.print("</td>"); out.print("<td>"); out.print(partyObj.getCity());
		 * out.print("</td>"); out.print("</tr>"); out.print("</table>");
		 */
		//System.out.println("Successful");
	}

}
