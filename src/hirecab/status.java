package hirecab;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class status
 */
@WebServlet("/status")
public class status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public status() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String id = request.getParameter("id");
		System.out.println(id);

	String query="SELECT * FROM cust_bookings WHERE booking_id='"+id+"'";
		Beans.dataRet(query);
		ResultSet r=Beans.getRs();
		try {
			int i=1;
			while(r.next())
			{
			System.out.println(r.getString(i));
			}
			} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='design1.css'></head>");
		out.println("<body><br><br><h3> Your Booking Details are : </h3>");
		try {
			out.println("<p>Name  '"+r.getString(1).toString()+"' </p>");
			out.println("<p>Date  '"+r.getString(1).toString()+"' </p>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</body></html>");
*/
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
