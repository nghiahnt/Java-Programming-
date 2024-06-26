package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.db.Connection;
import com.entity.Users;

/**
 * Servlet implementation class ExportExcel
 */
public class ExportExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Users> listUsers;
    /**
     * Default constructor. 
     */
//    public ExportExcel() {
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Users.class);
        List<Users> listUsers;

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            // Get all users
            Query<Users> query = session.createQuery("FROM Users", Users.class);
            listUsers = query.list();

            // Set response content type and header
            response.setContentType("text/plain");
            response.setHeader("Content-Disposition", "attachment; filename=users.txt");

            // Write data to TXT file
            PrintWriter out = response.getWriter();
            out.println("ID\tName\tPassword\tEmail\tMobile");

            for (Users user : listUsers) {
                out.println(user.getId() + "\t" + user.getUname() + "\t" + user.getUpwd() + "\t" + user.getUemail() + "\t" + user.getUmobile());
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
