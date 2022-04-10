package Servlet;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LogicalCode;
import DTO.Party;

/**
 * Servlet implementation class DisplayAll
 */
@WebServlet("/DisplayAll")
public class DisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       LogicalCode logicalCode = new LogicalCode();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAll() {
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
		 List<Party> partyList= logicalCode.displayAllUsers();
		 PrintWriter out = response.getWriter();
		 System.out.println(partyList.size());
		 HttpSession session= request.getSession();
		 out.println("<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
		 		+ "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n"
		 		+ "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n"
		 		+ "<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n"
		 		+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script></head>"
		 		+ "<body style=\"background-image: url('data.jpg');\">");
		 out.print("<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\n"
		 		+ "  <a class=\"navbar-brand\" href=\"#\">"+session.getAttribute("USERID")+"</a>  \n"
		 		+ "  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
		 		+ "    <span class=\"navbar-toggler-icon\"></span>\n"
		 		+ "  </button>\n"
		 		+ "  <div class=\"collapse navbar-collapse\" id=\"navbarText\">\n"
		 		+ "    <ul class=\"navbar-nav mr-auto\">\n"
		 		+ "      <li class=\"nav-item\">\n"
		 		+ "        <a class=\"nav-link\" href=\"views/Dashboard.jsp\">Search</a>\n"
		 		+ "      </li>\n"
		 		+ "    </ul>\n"
		 		+ "    <span class=\"navbar-text\">\n"
		 		+ "      Navbar text with an inline element\n"
		 		+ "    </span>\n"
		 		+ "  </div>\n"
		 		+ "</nav>");
		 out.print("<div class='mt-5 ml-5 mr-5' ");
		 out.println("<div class='table-responsive-sm'>");
		 out.print("<table class='table table-striped' ><thead class='thead-dark'><tr><th>First Name</th><th>Last Name</th><th>Phone</th><th>Address</th><th>Zip</th><th>City</th><th>State</th><th>Country</th><th>Edit</th><th>Delete</th></tr></thead>");
		 out.print("<div class='form-group'>");	
		 
		 
		 for(Party partyObj: partyList)
		 {
			 	out.print("<form action="+request.getContextPath()+"/EditUser"+" method='post'>");
			 	out.print("<tr><td>");
			 	out.print("<input type='hidden' name='partyId' value="+partyObj.getPartyId()+">");
			 	out.print("<input class='form-control' type='text' name='firstName' value="+partyObj.getFirstName()+">");
				out.print("</td>");
				out.print("<td>");
				out.print("<input class='form-control' type='text' name='lastName' value="+partyObj.getLastName()+">");
				out.print("</td>");
				out.print("<td>");
				out.print("<input class='form-control' type='text' name='phone' value="+partyObj.getPhone()+">");
				out.print("</td>");
				out.print("<td>");
				out.print("<input class='form-control' type='text' name='address' value="+partyObj.getAddress()+">");
				out.print("</td>");
				out.print("<td>");
				out.print("<input class='form-control' type='text' name='zip' value="+partyObj.getZip()+">");
				out.print("</td>");
				out.print("<td>");
				out.print("<input class='form-control' type='text' name='city' value="+partyObj.getCity()+">");
				out.print("</td>");
				out.print("<td>");
				out.print("<input class='form-control' type='text' name='state' value="+partyObj.getState()+">");
				out.print("</td>");
				out.print("<td>");
				out.print("<input class='form-control' type='text' name='country' value="+partyObj.getCountry()+">");
				out.print("</td>");
				out.print("<td><input class='form-control' type='submit' name='Edit' value='Edit'></td>");
				out.print("<td><input class='form-control' type='submit' name='Delete' value='Delete'></td>");
				out.print("</tr>");
				out.print("</form>");
		 }
		 out.print("</div>");
		 out.print("</table>");
		 String edited = (String) request.getAttribute("EDIT");
		 String deleted= (String) request.getAttribute("DELETE");
		 if(edited.equalsIgnoreCase("edited")) {
			 System.out.println(edited);
		 out.print("<script type='text/javascript'>alert(' User Edited');</script>");
		 }
		 if(deleted.equalsIgnoreCase("deleted")) {
			 System.out.println(deleted);
		 out.print("<script type='text/javascript'>alert(' User Deleted');</script>");
		 }
		 out.print("<div><a href="+request.getContextPath()+"/DestroySession"+"><button class='btn btn-primary'>"+"Log Out"+"</button></a></div>");
		 out.print("</div>");
		 
		 out.print("</div>");
		 
		 out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		/*
		 * List<Party> partyList= logicalCode.displayAllUsers(); PrintWriter out =
		 * response.getWriter(); for(Party partyObj: partyList) { out.
		 * print("<table><tr><th>First Name</th><th>Last Name</th><th>Phone</th><th>City</th></tr>"
		 * ); out.print("<tr><td>"); out.print(partyObj.getFirstName());
		 * out.print("</td>"); out.print("<td>"); out.print(partyObj.getLastName());
		 * out.print("</td>"); out.print("<td>"); out.print(partyObj.getPhone());
		 * out.print("</td>"); out.print("<td>"); out.print(partyObj.getCity());
		 * out.print("</td>"); out.print("</tr>"); } out.print("</table>");
		 */
		
	}

}
