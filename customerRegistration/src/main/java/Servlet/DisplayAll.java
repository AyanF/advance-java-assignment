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
		 for(Party partyObj: partyList)
		 {
			 	
			 	out.print("<table><tr><th>First Name</th><th>Last Name</th><th>Phone</th><th>City</th></tr>");
			 	out.print("<form action="+request.getContextPath()+"/EditUser"+" method='post'>");
				out.print("<tr><td id='fName'>");
				out.print(partyObj.getFirstName());
				out.print("</td>");
				out.print("<td>");
				out.print("<input type='text' name='LastName'>"+partyObj.getLastName());
				out.print("</td>");
				out.print("<td>");
				out.print("<input type='text' name='phone'>"+partyObj.getPhone());
				out.print("</td>");
				out.print("<td>");
				out.print("<input type='text' name='city'>"+partyObj.getCity());
				out.print("</td>");
				//out.print("<td><a href="+"views/EditUser.jsp"+"><button type="+"submit"+" >Edit</button></a></td>");
				out.print("<td><input type='submit' value='Edit'></td>");
				out.print("<td><input type='submit' value='Delete'></td>");
				out.print("</tr>");
				out.print("</form>");
		 }
		 out.print("</table>");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 List<Party> partyList= logicalCode.displayAllUsers();
		 PrintWriter out = response.getWriter();
		 for(Party partyObj: partyList)
		 {
			 	out.print("<table><tr><th>First Name</th><th>Last Name</th><th>Phone</th><th>City</th></tr>");
				out.print("<tr><td>");
				out.print(partyObj.getFirstName());
				out.print("</td>");
				out.print("<td>");
				out.print(partyObj.getLastName());
				out.print("</td>");
				out.print("<td>");
				out.print(partyObj.getPhone());
				out.print("</td>");
				out.print("<td>");
				out.print(partyObj.getCity());
				out.print("</td>");
				out.print("</tr>");
		 }
		 out.print("</table>");
		
	}

}
