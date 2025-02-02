 package com.jsp.servlet.cardb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//using this anotiation  we can not write a logic web.xml
@WebServlet("/add-car")
public class AddCarServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//All are string type so first you convort the int type if required
		int carID=Integer.parseInt(req.getParameter("carID"));
		String carModel=req.getParameter("carModel");
		String carBrand=req.getParameter("carBrand");
		String carColour=req.getParameter("carColour");
		int carPrice=Integer.parseInt(req.getParameter("carPrice"));


		//JDBC Logic
		Connection conn=null;



		try {
			//Step 1:-Load And Register
			Class.forName("com.mysql.jdbc.Driver");

			//Step 2:-Connection
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=Akash@2002");

			//Step 3:-Create Statement	
			PreparedStatement pStatement=conn.prepareStatement("INSERT INTO car VALUES(?,?,?,?,?)");

			//Step 4:-Executed The  Query
			pStatement.setInt(1, carID);
			pStatement.setString(2, carModel);
			pStatement.setString(3, carBrand);
			pStatement.setString(4, carColour);
			pStatement.setInt(5, carPrice);

			pStatement.execute();

			//Step 5:-Process The Result but in case i return the index.jsp
			resp.sendRedirect("index.jsp");






		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		//Step:-6

		finally {
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}




	}

}
