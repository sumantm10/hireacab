package hirecab;
import java.sql.*;

import hirecab.Users;
public class Beans {
	public Beans() {
		// TODO Auto-generated constructor stub
	}
	

	static private Connection con=null;
	static private ResultSet rs;


public static ResultSet getRs() {
		return rs;
	}
	public static void setRs(ResultSet rs) {
		Beans.rs = rs;
	}
static public	void connect()
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Loaded driver");
        //con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/demo","root","java");
        //con = DriverManager.getConnection("jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com/satya1989", "satyadb","java");
        con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","1234");
        // PreparedStatement pstm=con.prepareStatement("select* from student where loginId=? ans password=?");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
/*-----------------------------------------*/
public static  boolean registration1(Users ob)
{
	
	try {
		String	query="INSERT INTO `userscab`"
        		+ "(`user_id`,`user_name`,`user_roll`,`user_num`,`user_mail`,`date`,`time`,`password`)"
        		+ "VALUES('"+ob.getId()+"','"+ob.getName()+"','"+ob.getRoll()+"','"+ob.getNumber()+"','"+ob.getEmail()+"','"+ob.getDate()+"','"+ob.getTime()+"','"+ob.getPassword()+"')";
	if(con.isClosed())
		{
			connect();
			
		PreparedStatement pst=con.prepareStatement(query);
		pst.executeUpdate();
		}
		else
		{
			PreparedStatement pst=con.prepareStatement(query);
			pst.executeUpdate();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
	
}
public static  boolean registration(customer ob)
{
	
	try {
		String	query="INSERT INTO `cust_bookings`"
        		+ "(`cust_id`,`booking_id`,`cust_name`,`cust_num`,`cust_mail`,`date`,`time`,`pick`,`dropp`,`address`)"
        		+ "VALUES('"+ob.getCId()+"','"+ob.getBId()+"','"+ob.getName()+"','"+ob.getNumber()+"','"+ob.getEmail()+"','"+ob.getDate()+"','"+ob.getTime()+"','"+ob.getPick()+"','"+ob.getDrop()+"','"+ob.getAddress()+"')";
        

		if(con.isClosed())
		{
			connect();
			
		PreparedStatement pst=con.prepareStatement(query);
		pst.executeUpdate();
		}
		else
		{
			PreparedStatement pst=con.prepareStatement(query);
			pst.executeUpdate();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
	
}
/*======================================*/
public static  boolean doTask(String query)
{
	try {

		if(con.isClosed())
		{
			connect();
		PreparedStatement pst=con.prepareStatement(query);
		pst.executeUpdate();
		}
		else
		{
			PreparedStatement pst=con.prepareStatement(query);
			pst.executeUpdate();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
	
}
public static void  dataRet(String query) {
	
	try{
	if(con.isClosed())
	{
		connect();
		Statement smt=con.createStatement();
		rs=smt.executeQuery(query);
	}
	else
	{
		Statement smt=con.createStatement();
		rs=smt.executeQuery(query);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
