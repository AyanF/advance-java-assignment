package Servlet;

import java.io.IOException;

import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LogicalCode;
import DAO.SendEmail;
import DTO.Party;
import DTO.UserLogin;

/**
 * Servlet implementation class AddUser
 */
@WebServlet(name = "AddUser", description = "Registration ", urlPatterns = "/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LogicalCode logicalCode = new LogicalCode();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String city = request.getParameter("city1");
		String zip = request.getParameter("zip");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String phone  = request.getParameter("phone");
		
		String userLogin = request.getParameter("userLoginId");
		String passUn = request.getParameter("password");
		
		String pass = logicalCode.passwordEncryption(passUn);
		
		int partyId=0;
		
		Party partyObj = new Party();
		partyObj.setFirstName(firstName);
		partyObj.setLastName(lastName);
		partyObj.setAddress(address);
		partyObj.setCity(city);
		partyObj.setZip(zip);
		partyObj.setState(state);
		partyObj.setCountry(country);
		partyObj.setPhone(phone);
		
		//create instance object of the SendEmail Class
        SendEmail sm = new SendEmail();
   		//get the 6-digit code
        String code = sm.getRandom();
		
		UserLogin userlogin = new UserLogin();
		userlogin.setPartyId(partyId);
		userlogin.setUserLoginId(userLogin);
		userlogin.setPassword(pass);
		userlogin.setCode(code);
        
        //call the send email method
        boolean test = sm.sendEmail(userlogin);
        
   		//check if the email send successfully
        if(test){
            HttpSession session  = request.getSession();
            session.setAttribute("authcode", userlogin);
            //response.sendRedirect("verify.jsp");
        }else{
   		 // out.println("Failed to send verification email");
   	   }
		
		try {
			logicalCode.insertUser(partyObj, userlogin);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/Verify.jsp");
		dispatcher.forward(request, response);
	}

}
