package com.jsp.servlet.cardb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find-car-by-id")
public class FindCarByIdServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId=Integer.parseInt(req.getParameter("carId"));
		Connection conn=null;
		try {			
			Class.forName("com.mysql.jdbc.Driver");

			//Step 2:-Connection
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=Akash@2002");
			
			

			//Step 3:-Create Statement 	
			PreparedStatement pStatement=conn.prepareStatement("SELECT * FROM  car WHERE carId= ?");
			pStatement.setInt(1, carId);

			
			//Step 4:-executeQuery
			ResultSet rs=pStatement.executeQuery();
			
			
			
			req.setAttribute("carObject", rs);	//what
			//carry the data
			RequestDispatcher rd=req.getRequestDispatcher("Upadatecar.jsp");	//where
			rd.forward(req, resp); //Transfer
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		//Step 6:-Close
				finally {

					if(conn!=null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				
	 }
	
	
	



}
