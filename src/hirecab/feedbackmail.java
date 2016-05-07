package hirecab;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import hirecab.Beans;

/**
 * Servlet implementation class feedbackmail
 */
@WebServlet("/feedbackmail")
public class feedbackmail extends HttpServlet {
	public void init() throws ServletException {
		super.init();
		Beans.connect();
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feedbackmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//response.setContentType("text/html");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Calendar d = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		String currdt= sdf.format(d.getTime());
		String prevdt = sdf.format(c.getTime());
		System.out.println(currdt);
		System.out.println(prevdt);
		String qr="select cust_mail from cust_bookings WHERE date='"+prevdt+"'";
		Beans.dataRet(qr);
		ResultSet rs=Beans.getRs();
		
		final String username = "kiitshuttleservice@gmail.com";
		final String password = "kiitshuttle2015";
 
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
		
		try {
			int i=1;
			while(rs.next())
			{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kiitshuttleservice@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(rs.getString(i)));
			System.out.println(rs.getString(i));
			message.setSubject("Did u enjoy the ride?");
			message.setText("Please spare out some of your precious time and  provide us your valuable feedback.\n Please click on the link below :"
				+ "\n\n http://localhost:8880/Hireacab/feedback.html "
				+ "\n\n\n We appreciate you co=operation."
				+ "\n\n Thank You!!\n\n"
				+ "Regards,\nTeam Kiit Shuttle Service");
 
			Transport.send(message);
 
			System.out.println("Done");
			}
		} catch (MessagingException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
