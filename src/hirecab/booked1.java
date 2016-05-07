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




/**
 * Servlet implementation class booked1
 */
@WebServlet("/booked1")
public class booked1 extends HttpServlet {
	public void init() throws ServletException {
		super.init();
		Beans.connect();
	}
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String uid=randomnum.nextSessionId();
		String name=request.getParameter("tb1");
		String email=request.getParameter("email");
		String number=request.getParameter("tb2");
		String date=request.getParameter("date");
		String thr=request.getParameter("hr");
		String tmin=request.getParameter("min");
		String pick=request.getParameter("pick");
		String drop=request.getParameter("drop");
		String time=(thr+":"+tmin);
		String address=request.getParameter("textarea");
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
    	String t=sd.format(cal.getTime());
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
								+ "<div id="+"div1"+"></div>"
								+ "<a id="+"feedback"+"href="+"feedback.html"+"><img id="+"feed"+"src="+"images/feedback.png"+"/></a>"
								+ "<a id="+"heading"+"href="+"index.html"+"onmouseout="+"myFunction2('heading')"+"><h1 onmouseout="+"myFunction2('heading')"+">Hire-a-cab</h1> </a>"
								+ "");
		String query="select * from driver where booked_status='Not Booked'";
		Beans.dataRet(query);
		ResultSet dr=Beans.getRs();
		try
		{
			if(pick.equals(drop))
			{
				out.println("<script> { alert('Pick up location and drop location cannot be same')");
				out.println("location.href='bookmumbai.jsp' } </script>");
			}
			
			
			else if(dr.first())
				{
					Beans.doTask("insert into `bookings`"
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
					//ob.setCId(cid);
					Beans.registration(ob);
				
					
					final String username = "hirecab24@gmail.com";
					final String password = "webteklabs";
					
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
						Beans.dataRet("select * from `bookings` where `booking_id`='"+uid+"'");
						ResultSet booked=Beans.getRs();
						message.setFrom(new InternetAddress("hirecab24@gmail.com"));
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
							+ "\n\n Thank You for booking with us.");
						
						}
						Transport.send(message);
			 
						System.out.println("Done");
			 
					} catch (MessagingException | SQLException e) {
						throw new RuntimeException(e);
					}

					
					
					
				out.println("<br><br><h3 align='center'>Your Booking Details</h3><br><br>");
				out.println("<p>The booking ID for '"+name+"' is : '"+uid+"'.A text message will be sent to '"+number+"' shortly. "
						+ "For more details about the booking kindly check your email at '"+email+"'</p>");
				out.println("<br><br><h2 id='booking'>Thank You For Booking With us</h2><br><br>");
				out.println("<hr><br><br><div id='footer'><p> <a href='#'>contact us</a> | <a href='#'>report error</a> | <a href='#'>Advertise with us</a></p></div>");
		            out.println("<footer>&reg;All rights reserved!</footer>");
				out.println("</body></html>");
				
				}
			else
			{
				out.println("<script> { alert('Sorry,All the drivers seem to be busy right now.Please try again later.')");
				out.println("location.href='index.html' } </script>");
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
	/*	PrintWriter out=response.getWriter();
		String uid=randomnum.nextSessionId();
		String name=request.getParameter("tb1");
		String email=request.getParameter("email");
		String number=request.getParameter("tb2");
		String date=request.getParameter("date");
		String thr=request.getParameter("hr");
		String tmin=request.getParameter("min");
		String pick=request.getParameter("pick");
		String drop=request.getParameter("drop");
		String time=(thr+":"+tmin);
		String address=request.getParameter("textarea");
		
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
		
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='design1.css'>");
		out.println("<h1>Hire-a-cab</h1>");
		out.println("</head><body>");
		try
		{
			if(pick.equals(drop))
			{
				out.println("<script> { alert('Pick up location and drop location cannot be same')");
				out.println("location.href='bookmumbai.jsp' } </script>");
			}
			else
			{
			/*String adddb="insert into `customer`"
					+ "(`cust_id`,`cust_name`,`cust_num`,`cust_mail`,`date`,`time`,`pick`,`dropp`,`address`"
					+ "VALUES("+uid+","+name+","+number+","+email+","+date+","+time+","+pick+","+drop+","+address+")";
			Beans.doTask(adddb);
			
				customer ob=new customer();
				ob.setAddress(address);
				ob.setDate(date);
				ob.setDrop(drop);
				ob.setEmail(email);
				ob.setName(name);
				ob.setNumber(number);
				ob.setPick(pick);
				ob.setTime(time);
				ob.setId(uid);
				Beans.registration(ob);
			out.println("<br><br><h3 align='center'>Your Booking Details</h3><br><br>");
			out.println("<p>The booking ID for '"+name+"' is : '"+uid+"'.A text message will be sent to '"+number+"' shortly. "
					+ "For more details about the booking kindly check your email at '"+email+"'</p>");
			out.println("<br><br><h2 id='booking'>Thank You For Booking With us</h2><br><br>");
			out.println("<hr><br><br><div id='footer'><p> <a href='#'>contact us</a> | <a href='#'>report error</a> | <a href='#'>Advertise with us</a></p></div>");
	            out.println("<footer>&reg;All rights reserved!</footer>");
			out.println("</body></html>");
			}
			}
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}
*/
}
}

