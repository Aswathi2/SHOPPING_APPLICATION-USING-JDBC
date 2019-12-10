package casestudy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Agent {
	Scanner s=new Scanner(System.in);
	ConnectionManager con=new ConnectionManager();
	void agent() throws ClassNotFoundException, SQLException {
	
		int flag=0;
	do {
		System.out.println("ENTER NAME");
		String name=s.next();
		System.out.println("ENTER PASSWORD");
		String pw=s.next();
		java.sql.Statement s1=con.getConnection().createStatement();
		ResultSet r=s1.executeQuery("select * from agentlogin");
		while(r.next())
		{
			String name1=r.getString(1);
			String pw1=r.getString(2);
			if(name1.equals(name)&&pw1.equals(pw)) {
				flag=1;
				System.out.println("Successfully verified");
		}}
		if(flag==1)
		{
			int ok=0;
			do {
				
			ok=0;
		System.out.println("1.Buy sell\n2.display product\n3.Home page\nenter your choice");
		int n=s.nextInt();
		if(n==1)
		{
			System.out.println("ENTER ID");
			int id=s.nextInt();
			System.out.println("ENTER QUANTITY");
			int quantity=s.nextInt();
			java.sql.Statement s11=con.getConnection().createStatement();
			ResultSet r11=s11.executeQuery("select * from addproduct");
			int q=0,qa=0;
			while(r11.next())
			{
				
				if(r11.getInt(1)==id) {
					q=r11.getInt(4);
					qa=r11.getInt(3);
					break;
			}}
			if(q<quantity) {
				ok=1;
			
				System.out.println("There is no enough product");
				}
			else
			{
			int total=q*quantity;
			System.out.printf("total cost is %d",total);
			System.out.println("\nenter 1 for confirm booking");
			int n1=s.nextInt();
			if(n1==1)
			{
				ok=1;
				System.out.println("BOOKED\n");
				System.out.println("THANK YOU\n");
				int t=qa-quantity;
			PreparedStatement pr=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set minsellquantity=? where Productid=?");
			pr.setInt(1,t);
			pr.setInt(2,id);
			pr.executeUpdate();
			con.getConnection().close();
			}
			else {
				
			ok=1;
				break;
		}
			}}
		else if(n==2)
		{
			int i=1;
			java.sql.Statement s11=con.getConnection().createStatement();
			ResultSet r1=s11.executeQuery("select * from addproduct");
			
			while(r1.next())
			{
				System.out.println("~~~~~**********~~~~~~");
				System.out.printf("~~~~~PRODUCT DETAILS %d~~~~~\n",i);
				System.out.println("PRODUCT ID->"+r1.getInt(1));
				System.out.println("NAME OF PRODUCT->"+r1.getString(2));
				System.out.println("QUANTITY OF PRODUCT->"+r1.getInt(3));
				System.out.println("PRICE OF PRODUCT->"+r1.getInt(4));
				i++;
				ok=1;
				System.out.println("~~~~*****~~~~\n");
			}}
			else 
			{
			System.out.println("AGENT ACCOUNT LOGOUT");
			Menu m=new Menu();
			m.login();
			}
			}while(ok==1);
		}
		else
			System.out.println("invalid username and password");
	
		}while(flag==0);
	
	
	}}
	
