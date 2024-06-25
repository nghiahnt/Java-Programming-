package com.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.db.Connection;
import com.entity.Users;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public UpdateUser() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String uemail = request.getParameter("uemail");
		String umobile = request.getParameter("umobile");
		
//		System.out.println(uname);
//		System.out.println(upwd);
//		System.out.println(uemail);
//		System.out.println(umobile);
		
		Users user = new com.servlet.GetUserServlet().getUserByUname(uname);
		
		if (user != null) {
			user.setUpwd(hashValue(upwd));
			user.setUemail(uemail);
			user.setUmobile(umobile);
			
			Configuration configuration = new Connection().getConfig();
			try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
				Session session = sessionFactory.openSession();
				
				session.merge(user);
				session.beginTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
                request.setAttribute("status", "failed");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
			}
			
			request.setAttribute("status", "success");
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
