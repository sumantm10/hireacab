package hirecab;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

/**
 * Servlet implementation class feedback
 */
@WebServlet("/feedback")
public class feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		try
		{
		final String username = "kiitshuttleservice@gmail.com";
		final String password = "kiitshuttle2015";
		String rating = request.getParameter("star");
		String email=request.getParameter("email");
		String name=request.getParameter("tb1");
		String num=request.getParameter("tb2");
		String msg=request.getParameter("textarea");
		String bookid=request.getParameter("tb3");
		Beans.connect();
		String query3 = "INSERT INTO `feedback`"
        		+ "(`name`,`number`,`email`,`booking_id`,`driver_rating`,`feedback`)"
        		+ "VALUES('"+name+"','"+num+"','"+email+"','"+bookid+"','"+rating+"','"+msg+"')";
		Beans.doTask(query3);
		String query = "select driver_number from driver_bookings where booking_id like '"+bookid+"'";
		Beans.dataRet(query);
		ResultSet data = Beans.getRs();
		try {
			data.next();
			String dnum;
			dnum = data.getString(1);
		
		String query1 = "select rating,num_rates from driver where driver_num like '"+dnum+"'";
		Beans.dataRet(query1);
		ResultSet data1 = Beans.getRs();
		data1.next();
		String ratee = data1.getString(1);
		String rates = data1.getString(2);
		int rate = Integer.parseInt(ratee);
		int rating1 = Integer.parseInt(rating);
		int rates1 = Integer.parseInt(rates);
		int newrate = (rate*rates1+rating1)/(rates1+1);
		rates1++;
		String query2 = "update driver set rating = '"+newrate+"',num_rates = '"+rates1+"' where driver_num like '"+dnum+"'";
		Beans.doTask(query2);
		System.out.println(newrate);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kiitshuttleservice@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(username));
			message.setSubject("Feedback from '"+email+"' '"+name+"','"+num+"','"+bookid+"'");
			message.setText("'"+msg+"'");
			
 
			Transport.send(message);
 
			System.out.println("Done");
			out.println("<html><body>");
			out.println("<link rel='stylesheet' type='text/css' href='design1.css'>");
			out.println("<script> { alert('Your feedback is successfully submitted.Thank You for your time')");
			out.println("location.href='index.jsp' } </script>");
			out.println("</body></html>");
		
			 
			Message message2 = new MimeMessage(session);
			message2.setFrom(new InternetAddress("kiitshuttleservice@gmail.com"));
			message2.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message2.setSubject("Thank You for your feedback");
			message2.setText("You feedback for the booking ID '"+bookid+"' was : \n '"+msg+"' \n\n\n"
					+"We will work on it in the best way possible.\n\n"
					+ "We value your opinions and suggestions alot! Keep sending 'em !\n\n\n\n"
					+ "Regards,\nTeam Kiit Shuttle Service");
 
			Transport.send(message2);
 
			System.out.println("Done");
			
			
		}
	catch (Exception e2) {
			throw new RuntimeException(e2);
		}
		
	
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
