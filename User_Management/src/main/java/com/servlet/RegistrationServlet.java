package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Users;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public RegistrationServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		out.print("Working...");
		
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = hashValue(request.getParameter("pass"));
		String umobile = request.getParameter("contact");
		
		RequestDispatcher dispatcher = null;
		Connection connection = null;
		
		// Sysout variables
		PrintWriter out = response.getWriter();
		out.print(uname);
		out.print(uemail);
		out.print(upwd);
		out.print(umobile);
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "");
//			PreparedStatement pst = connection.prepareStatement("insert into users (uname, upwd, uemail, umobile) values (?, ?, ?, ?)");
//			pst.setString(1, uname);
//			pst.setString(2, upwd);
//			pst.setString(3, uemail);
//			pst.setString(4, umobile);
//			
//			int rowCount = pst.executeUpdate();
//			dispatcher = request.getRequestDispatcher("registration.jsp");
//			
//			if (rowCount > 0) {
//				request.setAttribute("status", "success");
//			} else {
//				request.setAttribute("status", "failed");
//			}
//			
//			dispatcher.forward(request, response);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
		// Using hibernate
		// Load configuration
		com.db.Connection config = new com.db.Connection();
		Configuration configuration = config.getConfig();
		
		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
			Session session = sessionFactory.openSession();
			
			// With Hibernate
			Users user = new Users();
			
			user.setUname(uname);
			user.setUemail(uemail);
			user.setUpwd(upwd);
			user.setUmobile(umobile);
			
			session.persist(user);
			session.beginTransaction().commit();
			
			// Redirect to login page
			request.setAttribute("status", "success");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("status", "failed");
		    dispatcher = request.getRequestDispatcher("registration.jsp");
		    dispatcher.forward(request, response);
		}
	}
	
	private static String hashValue(String text) {
		String hashValue = "";
		try {
			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(text.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			hashValue = no.toString();
			while (hashValue.length() < 32) {
				hashValue = "0" + hashValue;
			}
			return hashValue;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hashValue;
	}

}
