package com.jsp.servlet.cardb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dlt-car-by-id")
public class DeleteCarServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		int carId=Integer.parseInt(req.getParameter("carId"));
		try {
			Class.forName("com.mysql.jdbc.Driver");

			//Step 2:-Connection
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=Akash@2002");
			

			//Step 3:-Create Statement
			PreparedStatement pst = conn.prepareStatement("DELETE FROM  car WHERE carId=?");
			pst.setInt(1, carId);


			//Step 4:-executeQueery
//			int rowsDeleted = pst.executeUpdate();
			
			pst.execute();
			
			resp.sendRedirect("display-all-cars");
			
			
//			
//			req.setAttribute("carList", rowsDeleted);	//what
//			//carry the data
//			RequestDispatcher rd=req.getRequestDispatcher("DisplayAllcar.jsp");	//where
//			rd.forward(req, resp); //Transfer
			
			//only print
//			PrintWriter pw = resp.getWriter();
//			if(rowsDeleted>0)
//				pw.print("<h1> "+rowsDeleted+" data deleted SucessFull !! </h1>");
//			else
//				pw.print("<h1>data not inserted !!</h1>");
			
			
			
			
			
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
