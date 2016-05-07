package hirecab;

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
 * Servlet implementation class bookeddelhi
 */
@WebServlet("/bookeddelhi")
public class bookeddelhi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookeddelhi() {
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
		String uid=randomnum.nextSessionId();
		String cid=(String) request.getSession().getAttribute("custid");
		String name=request.getParameter("tb1");
		String email=request.getParameter("email");
		String number=request.getParameter("tb2");
		String date=request.getParameter("date");
		String thr=request.getParameter("hr");
		String tmin=request.getParameter("min");
		String pick=request.getParameter("pick");
		String drop=request.getParameter("drop");
		String time=(thr+":"+tmin);
		Date d1 = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d1);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		int seconds = calendar.get(Calendar.SECOND);
		System.out.println(hours);
		System.out.println(minutes);
		String address=request.getParameter("textarea");
		try
		{
			String hrss = time.substring(0, 2);
			String minss = time.substring(3,5);
			int hrsint = Integer.parseInt(hrss);
			int minsint = Integer.parseInt(minss);
			if(date.equals("Today"))
			{
				if(hrsint<hours || (hrsint==hours && minsint < minutes))
				{
					out.println("<script> { alert('Enter valid time')");
					out.println("location.href='bookdelhi.jsp' } </script>");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Calendar d = Calendar.getInstance();
			c.add(Calendar.DATE, 1);
			String currdt= sdf.format(d.getTime());
			String nextdt = sdf.format(c.getTime());
			if(date.equals("Today"))
			{
				date=currdt;
			}
			else if(date.equals("Tomorrow"))
			{
				date=nextdt;
			}
				
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		System.out.println(uid+name+email+number+date+time+pick+drop+address);
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='design1.css'>");
		out.println("<script> function myFunction2(id)"
				+ "{"
				+ "document.getElementById(id).style.transition = "+"0.5s"+";"
						+ "	document.getElementById(id).style.WebkitTransition = "+"0.5s"+";}"
								+ "</script>"
								+ "</head><body>"
								+ "<div id='div1'></div>"
								+ "<a id='feedback' href='feedback.jsp'><img id='feed' src='images/feedback.png'/></a>"
								+ "<a id='heading' href='index.jsp' onmouseout='myFunction2('heading')'><h1 onmouseout='myFunction2('heading')'>KIIT Shuttle Service</h1> </a>"
								+ "");
		String query="select * from driver where booked_status='Not Booked'";
		Beans.dataRet(query);
		ResultSet dr=Beans.getRs();
		try
		{
			if(pick.equals(drop))
			{
				out.println("<script> { alert('Pick up location and drop location cannot be same')");
				out.println("location.href='bookdelhi.jsp' } </script>");
			}
			
			else if(dr.first())
				{
				Beans.doTask("insert into `driver_bookings`"
						+ "(`booking_id`,`driver_name`,`driver_number`,`driver_mail`,`time`)"
						+ "VALUES('"+uid+"','"+dr.getString(1)+"','"+dr.getString(2)+"','"+dr.getString(3)+"','"+time+"')");
					Beans.doTask("update `driver` set `booked_status`='booked' where `license_num`='"+dr.getString(5)+"'");
					customer ob=new customer();
					ob.setAddress(address);
					ob.setDate(date);
					ob.setDrop(drop);
					ob.setEmail(email);
					ob.setName(name);
					ob.setNumber(number);
					ob.setPick(pick);
					ob.setTime(time);
					ob.setBId(uid);
					ob.setCId(cid);
					Beans.registration(ob);
				
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
						Beans.dataRet("select * from `driver_bookings` where `booking_id`='"+uid+"'");
						ResultSet booked1=Beans.getRs();
						booked1.next();
						//URL url = new URL("http://crunchify.com/");
						String msg = "KIIT Shuttle Service booking details:\n"
								+ "Booking ID : '"+uid+"'\n"
										+ "Driver Name : '"+booked1.getString(2)+"'\n"
										+ "Driver Number : '"+booked1.getString(3)+"'\n"
+ "\n\n Thank You for booking with us.";
						URL url = new URL("http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=sagascious.sumant@gmail.com:qwerty&senderID=TEST%20SMS&receipientno="+number+"&dcs=0&msgtxt="+URLEncoder.encode(msg,"UTF-8")+"&state=4");

						BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
						String strTemp = "";
						while (null != (strTemp = br.readLine())) {
							System.out.println(strTemp);
							System.out.println("Message Done");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
			 
					try {
						Beans.dataRet("select * from `driver_bookings` where `booking_id`='"+uid+"'");
						ResultSet booked=Beans.getRs();
						Message message = new MimeMessage(session);
						
						message.setFrom(new InternetAddress("kiitshuttleservice@gmail.com"));
						message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(email));
						message.setSubject("Booking Details");
						while(booked.next())
						{
						message.setText("Your Booking Details are : \n"
								+ "Booking ID : '"+uid+"' \n"
							+ "Date of Journey : '"+date+"' \n"
									+ "Time of Journey : '"+time+"' \n"
											+ "Pick up Address : '"+address+"' \n"
													+ "Drop Location : '"+drop+"' \n"
															+ "Driver Name : '"+booked.getString(2)+"' \n"
																	+ "Driver Number : '"+booked.getString(3)+"' \n"
							+ "\n\n Thank You for booking with us."
							+ "We Hope you have a nice ride.\n\n\n"
							+ "Regards,\n"
							+ "Team Kiit Shuttle Service");
						
						}
						Transport.send(message);
			 
						System.out.println("Done");
			 
					} catch (MessagingException | SQLException e) {
						throw new RuntimeException(e);
					}
					
					
				out.println("<br><br><h3 align='center'>Your Booking Details</h3><br><br>");
				out.println("<p>The booking ID for '"+name+"' is : '"+uid+"'.A text message will be sent to '"+number+"' shortly. "
						+ "For more details about the booking kindly check your email at '"+email+"'</p>");
				out.println("<br><br><h2 id='booking'>Thank You For Booking With us</h2><br><br><br><br><br><br>");
				out.println("<hr><br><br><div id='footer'><p> <a href='contactus.jsp'>contact us</a> | <a href='#'>report error</a> | <a href='#'>Advertise with us</a></p></div>");
		            out.println("<footer>&reg;All rights reserved!</footer>");
				out.println("</body></html>");
				
				}
			else
			{
				out.println("<script> { alert('Sorry,All the drivers seem to be busy right now.Please try again later.')");
				out.println("location.href='index.jsp' } </script>");
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
	/*	final String username = "hirecab24@gmail.com";
		final String password = "webteklabs";
		String number=request.getParameter("tb2");
		String date=request.getParameter("date");
		String thr=request.getParameter("hr");
		String tmin=request.getParameter("min");
		String pick=request.getParameter("pick");
		String drop=request.getParameter("drop");
		String time=(thr+":"+tmin);
		String address=request.getParameter("textarea");
		String email=request.getParameter("email");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Beans.dataRet("select * from `bookings` where `booking_id`='"+id+"'");
		ResultSet booked=Beans.getRs();
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("hireacab@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Booking Details");
			message.setText("Your Booking Details are : \n"
				+ "Date of Journey : '"+date+"' \n"
						+ "Time of Journey : '"+time+"' \n"
								+ "Pick up Address : '"+address+"' \n"
										+ "Drop Location : '"+drop+"' \n"
												+ "Driver Name : '"+booked.getString(2)+"' \n"
														+ "Driver Number : '"+booked.getString(3)+"' \n"
				+ "\n\n Thank You for booking with us.");
			
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException | SQLException e) {
			throw new RuntimeException(e);
		}
*/
	}

}
