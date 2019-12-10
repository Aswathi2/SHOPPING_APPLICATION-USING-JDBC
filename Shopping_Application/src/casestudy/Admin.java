package casestudy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Admin {
	ConnectionManager con=new ConnectionManager();
	Scanner s=new Scanner(System.in);
	void admin1() throws ClassNotFoundException, SQLException
	{
		int f=0,up=0;
	do {
		System.out.println("ENTER NAME");
		String name=s.next();
		System.out.println("ENTER PASSWORD");
		String pw=s.next();
		java.sql.Statement s1=con.getConnection().createStatement();
		ResultSet r=s1.executeQuery("select * from adminlogin");
		int flag=0;
		while(r.next())
		{
			String name1=r.getString(1);
			String pw1=r.getString(2);
			if(name1.equals(name)&&pw1.equals(pw)) {
				flag=1;
				System.out.println("Successfully verified");}
		}
		if(flag==1)
		{
			
			int ok=0;
			do {
				
			ok=0;
		System.out.println("1.add product\n2.display\n3.remove\n4.update\n5.exit\nenter your choice");
		int n=s.nextInt();
		if(n==1)
		{
				// TODO Auto-generated method stub
				Scanner s=new Scanner(System.in);
				System.out.println("PRODUCT ID");
				int id=s.nextInt();
				System.out.println("ENTER NAME OF PRODUCT");
				String name2=s.next();
				System.out.println("PRODUCT QUANTITY");
				int quantity=s.nextInt();
				System.out.println("PRODUCT PRICE");
				int price=s.nextInt();
				PreparedStatement pr=(PreparedStatement) con.getConnection().prepareStatement("insert into addproduct(Productid,ProductName,Minsellquantity,Price) values(?,?,?,?)");
				pr.setInt(1,id);
				pr.setString(2,name2);
				pr.setInt(3,quantity);
				pr.setInt(4,price);
				pr.executeUpdate();
				con.getConnection().close();
				System.out.println("data added successfully");
				ok=1;
				}
		else if(n==2)
		{
			int i=1;
			java.sql.Statement s11=con.getConnection().createStatement();
			ResultSet r1=s11.executeQuery("select * from addproduct");
			System.out.println("*******PRODUCT DETAILS********");
			while(r1.next())
			{
				System.out.println("########**********#######");
				System.out.printf("*******PRODUCT DETAILS %d********\n",i);
				System.out.println("PRODUCT ID->"+r1.getInt(1));
				System.out.println("NAME OF PRODUCT->"+r1.getString(2));
				System.out.println("QUANTITY OF PRODUCT->"+r1.getInt(3));
				System.out.println("PRICE OF PRODUCT->"+r1.getInt(4));
				i++;
				ok=1;
				System.out.println("########**********#######\n");
			}
		}
		else if(n==3)
		{
			int i=1;
			java.sql.Statement s11=con.getConnection().createStatement();
			ResultSet r1=s11.executeQuery("select * from addproduct");
			
			while(r1.next())
			{
				System.out.println("########**********#######");
				System.out.printf("***PRODUCT DETAILS %d***\n",i);
				System.out.println("PRODUCT ID->"+r1.getInt(1));
				System.out.println("NAME OF PRODUCT->"+r1.getString(2));
				i++;
				ok=1;
				System.out.println("########**********#######\n");
			}
			System.out.println("PRODUCT ID OF PRODUCT YOU WANT TO DELETE");
			int id=s.nextInt();
			PreparedStatement pr=(PreparedStatement) con.getConnection().prepareStatement("delete from addproduct where Productid=?");
			pr.setInt(1,id);
			pr.executeUpdate();
			con.getConnection().close();
			System.out.println("data deleted successfully");
			ok=1;
		}
		else if(n==4)
		{
		
				int i=1;
				java.sql.Statement s11=con.getConnection().createStatement();
				ResultSet r1=s11.executeQuery("select * from addproduct");
				while(r1.next())
				{
					System.out.println("########**********#######");
					System.out.printf("*******PRODUCT DETAILS %d********\n",i);
					System.out.println("PRODUCT ID->"+r1.getInt(1));
					System.out.println("NAME OF PRODUCT->"+r1.getString(2));
					i++;
					ok=1;
					System.out.println("########**********#######\n");
				}
					
				System.out.println("enter the id");
				int id1=s.nextInt();
				System.out.println("1.Name(2)\n2.Minsellquantity(3)\n3.price(4)\n enter number of fields you want to update");
				  int c=s.nextInt();
				  System.out.println("enter the fields");
				 int a[]=new int[c];
				  int j=0;
				  up=0;
				  for(j=0;j<c;j++)
				 {
				a[j]=s.nextInt();
				  }
				  for(j=0;j<c;j++)
				  {
					 
				  if(a[j]==2)
				 {
				  System.out.println("enter the new name");
					String name1=s.next();
					
				  ResultSet r11=s11.executeQuery("select * from addproduct");
					int q=0,na=0;
					while(r11.next())
					{
						
						if(r11.getInt(1)==id1) {
						na=1;
						break;
					}
					}
					if(na==1)
					{
					PreparedStatement p1r=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set ProductName=? where Productid=?");
					p1r.setString(1,name1);
					p1r.setInt(2,id1);
					up=1;
					p1r.executeUpdate();
					
					}
					else
					System.out.println("Not present");
					}
					if(a[j]==4)
				  {
				  System.out.println("enter the new price");
					int price=s.nextInt();
				 ResultSet r11=s11.executeQuery("select * from addproduct");
					int p=1;
					while(r11.next())
					{
						
						if(r11.getInt(1)==id1) {
						p=1;
						break;
					}
					}
					if(p==1)
					{
					PreparedStatement p1r=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set Price=? where Productid=?");
					p1r.setInt(1,price);
					p1r.setInt(2,id1);
					p1r.executeUpdate();
					}
					else
					System.out.println("Not present");
					}
					if(a[j]==3)
					{
				int total=0;
					System.out.println("enter the new quantity");
					int qnt=s.nextInt();
					ResultSet r11=s11.executeQuery("select * from addproduct");
					int q=0;
					while(r11.next())
					{
						
						if(r11.getInt(1)==id1) {
							q=r11.getInt(3);
							break;
					}}
					if(up==1) {
						q=0;
						total=qnt+q;
						
						
						PreparedStatement p1r=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set minsellquantity=? where Productid=?");
						p1r.setInt(1,total);
						p1r.setInt(2,id1);
						p1r.executeUpdate();
						}
					else {
					total=qnt+q;
					
					
					PreparedStatement p1r=(PreparedStatement) con.getConnection().prepareStatement("update addproduct set minsellquantity=? where Productid=?");
					p1r.setInt(1,total);
					p1r.setInt(2,id1);
					p1r.executeUpdate();
					}
					con.getConnection().close();
					
					System.out.println("Updated successfully");
					ok=1;
					}}}	
		
		else
		{
			Menu m=new Menu();
			m.login();
		}
			}while(ok==1);
		}
		else {
			System.out.println("Invalid username &password");
			f=1;
			}
	}while(f==1);
	
	}}

