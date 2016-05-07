package hirecab;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class contactaction
 */
@WebServlet("/contactaction")
public class contactaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		final String username = "kiitshuttleservice@gmail.com";
		final String password = "kiitshuttle2015";
		String email=request.getParameter("email");
		String name=request.getParameter("tb1");
		String num=request.getParameter("tb2");
		String msg=request.getParameter("textarea");
 
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
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kiitshuttleservice@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(username));
			message.setSubject("Query from '"+email+"' '"+name+"','"+num+"'");
			message.setText("'"+msg+"'");
			
 
			Transport.send(message);
 
			System.out.println("Done");
			out.println("<html><body>");
			out.println("<link rel='stylesheet' type='text/css' href='design1.css'>");
			out.println("<script> { alert('Your query is successfully recorded. We will answer it shortly. Thank You')");
			out.println("location.href='index.jsp' } </script>");
			out.println("</body></html>");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		try {
			 
			Message message2 = new MimeMessage(session);
			message2.setFrom(new InternetAddress("kiitshuttleservice@gmail.com"));
			message2.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message2.setSubject("Thank You for your query");
			message2.setText("You query was : \n '"+msg+"' \n\n\n"
					+"We will give you an answer to it as soon as possible.\n"
					+ "Thank You \n\n\n"
					+ "Regards,\nTeam Kiit Shuttle Service");
 
			Transport.send(message2);
 
			System.out.println("Done");
			/*out.println("<html><body>");
			out.println("<link rel='stylesheet' type='text/css' href='design1.css'>");
			out.println("<script> { alert('You feedback is successfully submitted.Thank You for your time'); } </script>");
			out.println("</body></html>");*/
		} catch (MessagingException e2) {
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
