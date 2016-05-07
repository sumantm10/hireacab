package hirecab;

import hirecab.randomnum;
import hirecab.Beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
 * Servlet implementation class Input
 */
@WebServlet("/Input")
public class Input extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	
    public Input() {
    	super();
        // TODO Auto-generated constructor stub
    }
    String id=randomnum.nextSessionId();
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String uid=id;
		Beans.connect();
		Date dt = new Date();
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String number=request.getParameter("number");
		String date = dt.toString();
		String pass=request.getParameter("pass");
		String pass1=request.getParameter("pass1");
		String time=(hour+":"+min);
		System.out.print(pass);
		try {
		if(!(pass.equals(pass1)))
		{
			
			out.println("<script> { alert('Passwords do not match')");
			out.println("location.href='first.jsp' } </script>"); 
			System.out.print("checking");
		}
		}
		catch(Exception e1)
		{
			e1.getStackTrace();
			
		}
		
		try {
		String query = "SELECT COUNT(*) AS rowcount FROM userscab WHERE user_mail like '"+email+"'";
		Beans.dataRet(query);
		ResultSet dr=Beans.getRs();
		
			dr.next();
			int count = dr.getInt("rowcount");
			System.out.println(count);
			if(count>0)
			{
				out.println("<script> { alert('Email ID Already Registered!!')");
				out.println("location.href='first.jsp' } </script>"); 
			}
			else
		{
			Users ob = new Users();
			ob.setName(name);
			ob.setDate(date);
			ob.setEmail(email);
			ob.setId(uid);
			ob.setNumber(number);
			ob.setPassword(pass);
			ob.setTime(time);
			Beans.connect();
			Beans.registration1(ob);
			out.println("<script> { alert('Thanks for registering with us!!')");
			out.println("location.href='first.jsp' } </script>"); 
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		
		
		
		
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String uid=id;
		Beans.connect();
		Date dt = new Date();
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String number=request.getParameter("number");
		String date = dt.toString();
		String roll=request.getParameter("roll");
		String pass=request.getParameter("pass");
		String pass1=request.getParameter("pass1");
		String otpp = request.getParameter("otp");
		String otpt = request.getParameter("otpt");
		String time=(hour+":"+min);
		System.out.print(pass);
		/*try {
		if(!(pass.equals(pass1)))
		{
			
			out.println("<script> { alert('Passwords does not match')");
			out.println("location.href='first.jsp' } </script>"); 
			System.out.print("checking");
		}
		}
		catch(Exception e1)
		{
			e1.getStackTrace();
			
		}
		try {
			String query = "SELECT COUNT(*) AS rowcount FROM userscab WHERE user_roll like '"+roll+"'";
			String query2 = "SELECT COUNT(*) AS rowcount2 FROM userscab WHERE user_mail like '"+email+"'";
			Beans.dataRet(query);
			ResultSet dr=Beans.getRs();
				dr.next();
				int count = dr.getInt("rowcount");
				System.out.println(count);
				Beans.dataRet(query2);
				ResultSet dr2=Beans.getRs();
				dr2.next();
				int count2 = dr2.getInt("rowcount2");
				System.out.println(count2);
				if(count>0)
				{
					out.println("<script> { alert('Roll Number Already Registered!!')");
					out.println("location.href='first.jsp' } </script>"); 
				}
				else if(count2>0)
				{
					out.println("<script> { alert('Email ID Already Registered!!')");
					out.println("location.href='first.jsp' } </script>"); 
				}
				else
			{
			*/	
		try{
			if(otpp.equals(otpt))
					{
						String msg = "Hello "+name+"\n Welcome to KIIT Shuttle Service."
								+ "\nWe are here to help you book cabs around KIIT Campus."
								+ "\n\nFor more details check your mail."
								+ "\nThank You.";
						//URL url = new URL("http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=sagascious.sumant@gmail.com:qwerty&senderID=TEST%20SMS&receipientno="+number+"&dcs=0&msgtxt="+URLEncoder.encode(msg,"UTF-8")+"&state=4");
						URL url = new URL("http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=akash223106@gmail.com:akash1234&senderID=TEST%20SMS&receipientno="+number+"&dcs=0&msgtxt="+URLEncoder.encode(msg,"UTF-8")+"&state=4");

						BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
						String strTemp = "";
						while (null != (strTemp = br.readLine())) {
							System.out.println(strTemp);
							System.out.println("Message Done");
						}
			
		
				Users ob = new Users();
				ob.setName(name);
				ob.setDate(date);
				ob.setEmail(email);
				ob.setId(uid);
				ob.setRoll(roll);
				ob.setNumber(number);
				ob.setPassword(pass);
				ob.setTime(time);
				Beans.connect();
				Beans.registration1(ob);
				
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
		 
					Message message = new MimeMessage(session);
					
					message.setFrom(new InternetAddress("kiitshuttleservice@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(email));
					message.setSubject("Welcome To KIIT Shuttle Service");
					Beans.connect();
				String query1="select * from users where user_mail like'"+email+"'";
				
				Beans.dataRet(query1);
				ResultSet data = Beans.getRs();
				data.next();
				String msg1 = " Hello "+name+","
						+ "\n Welcome to KIIT Shuttle Service.\n"
						+ "\n\n Now You can book cabs anytime and from anywhere in the KIIT campus.  \n"
						+ "\n\n For any further assisstance, feel free to contact us. "
						
						+ "\n\n Thank You!!"
						+ "\n\n\n\n Warm Regards,"
						+ "\n\n KIIT Shuttle Service Team";
			
							message.setText(msg1);
					Transport.send(message);
		 
					out.println("<script> { alert('Thank You for registering with us. Kindly check your mail for further details.')");
					out.println("location.href='first.jsp' } </script>"); 
					
					System.out.println("Done");
					
		 
				}
		else
		{
			out.println("<script> { alert('OTP does not match')} </script>");
			//out.println("location.href='otpverify.jsp' } </script>"); 
		}
			}
			catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
				
			
		
			
			
	}


