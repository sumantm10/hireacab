package hirecab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Otpv2
 */
@WebServlet("/Otpv2")
public class Otpv2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Otpv2() {
        super();
        // TODO Auto-generated constructor stub
    }
    String id=randomnum.nextSessionId();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();

		System.out.println("abcd");
		
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
		
		String time=(hour+":"+min);
		Random random = new Random();
		int value = random.nextInt(10000);
		String otp = value+"";
		System.out.println(otp);
		System.out.println(pass+pass1);
		try {
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
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
		String msg = "Hello "+name+"\n Welcome to KIIT Shuttle Service."
					+ "\nYour OTP is : "+otp+"\nKindly don't share your OTP with anybody."
					
					
					+ "\n\nThank You.";
			//URL url = new URL("http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=sagascious.sumant@gmail.com:qwerty&senderID=TEST%20SMS&receipientno="+number+"&dcs=0&msgtxt="+URLEncoder.encode(msg,"UTF-8")+"&state=4");
			URL url = new URL("http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=akash223106@gmail.com:akash1234&senderID=TEST%20SMS&receipientno="+number+"&dcs=0&msgtxt="+URLEncoder.encode(msg,"UTF-8")+"&state=4");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String strTemp = "";
			while (null != (strTemp = br.readLine())) {
				System.out.println(strTemp);
				System.out.println("Message Done");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		request.setAttribute("time", time);
		request.setAttribute("pass", pass);
		request.setAttribute("roll", roll);
		request.setAttribute("date", date);
		request.setAttribute("number", number);
		request.setAttribute("email", email);
		request.setAttribute("name", name);
		request.setAttribute("uid", uid);
		request.setAttribute("otp", otp);
		RequestDispatcher dispatcher = request.getRequestDispatcher("otpverify.jsp");
		dispatcher.forward(request, response);
		
}
	}


