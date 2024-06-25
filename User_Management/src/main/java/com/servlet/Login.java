package com.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Users;
import com.mysql.cj.Query;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Users user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
//    public Login() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;

		String uname = request.getParameter("username");
		String upwd = hashValue(request.getParameter("password"));
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "");
//			PreparedStatement pst = connection.prepareStatement("select * from users where uemail = ? and upwd = ?");
//			pst.setString(1, uemail);
//			pst.setString(2, upwd);
//
//			ResultSet rs = pst.executeQuery();
//
//			if (rs.next()) {
//				session.setAttribute("name", rs.getString("uname"));
//				dispatcher = request.getRequestDispatcher("index.jsp");
//			} else {
//				request.setAttribute("status", "failed");
//				dispatcher = request.getRequestDispatcher("login.jsp");
//			}
//
//			dispatcher.forward(request, response);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		// Use hibernate
		boolean isValiduser = validateUser(uname, upwd);
		if (isValiduser) {
			session.setAttribute("name", uname);
			session.setAttribute("pwd", request.getParameter("password"));
			session.setAttribute("email", user.getUemail());
			session.setAttribute("mobile", user.getUmobile());
			dispatcher = request.getRequestDispatcher("index.jsp");
		} else {
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("login.jsp");
		}
		dispatcher.forward(request, response);

	}
	
	private boolean validateUser(String uname, String upwd) {
		boolean isValid = false;

		com.db.Connection config = new com.db.Connection();
		Configuration configuration = config.getConfig();

		try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
			Session session = sessionFactory.openSession();

			String hql = "FROM Users where uname = :uname AND upwd = :upwd";
			org.hibernate.query.Query<Users> query = session.createQuery(hql, Users.class);
			query.setParameter("uname", uname);
			query.setParameter("upwd", upwd);

			user = query.uniqueResult();
			if (user != null) {
				isValid = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isValid;
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
