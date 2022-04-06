package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UserLogin;
import DAO.LogicalCode;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 LogicalCode logicalCode= new LogicalCode();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("POSTCALLED");
		PrintWriter out = response.getWriter();
		String userLogin = request.getParameter("userLoginId");
		String passUn = request.getParameter("password");
		String pass = logicalCode.passwordEncryption(passUn);
		String save = request.getParameter("remember-me");
		
		UserLogin userlogin = new UserLogin();
		userlogin.setUserLoginId(userLogin);
		userlogin.setPassword(pass);
		
		try {
			if(logicalCode.loginUser(userlogin)) {
				HttpSession session=request.getSession();  
                session.setAttribute("USERID",userLogin);
				if(save!=null)
				{
					Cookie ck = new Cookie("CustomerRegistration",userLogin);
                    response.addCookie(ck);
                    ck.setMaxAge(10000);
				}
				response.sendRedirect("views/Dashboard.jsp");
			}
			else {
				
				//User not found 
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
