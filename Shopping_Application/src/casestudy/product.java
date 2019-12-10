package casestudy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class product {
	ConnectionManager con=new ConnectionManager();
	public void addproduct() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("PRODUCT ID");
		int id=s.nextInt();
		System.out.println("ENTER NAME OF PRODUCT");
		String name=s.next();
		System.out.println("PRODUCT QUANTITY");
		int quantity=s.nextInt();
		System.out.println("PRODUCT PRICE");
		int price=s.nextInt();
		PreparedStatement pr=(PreparedStatement) con.getConnection().prepareStatement("insert into addproduct(Productid,ProductName,Minsellquantity,Price) values(?,?,?,?)");
		pr.setInt(1,id);
		pr.setString(2,name);
		pr.setInt(3,quantity);
		pr.setInt(4,price);
		pr.executeUpdate();
		con.getConnection().close();
		System.out.println("data added successfully");
		}
	public void displayproduct() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int i=1;
		java.sql.Statement s1=con.getConnection().createStatement();
		ResultSet r=s1.executeQuery("select * from addproduct");
		System.out.println("*******PRODUCT DETAILS********");
		while(r.next())
		{
			System.out.printf("*******PRODUCT DETAILS %d********",i);
			System.out.println("ID "+r.getInt(1));
			System.out.println("NAME "+r.getString(2));
			System.out.println("QUANTITY "+r.getInt(3));
			System.out.println("PRICE "+r.getInt(4));
			i++;
		}
	}
	public void removeproduct() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("PRODUCT ID OF PRODUCT YOU WANT TO DELETE");
		int id=s.nextInt();
		PreparedStatement pr=(PreparedStatement) con.getConnection().prepareStatement("delete from addproduct where ID=?");
		pr.setInt(1,id);
		pr.executeUpdate();
		con.getConnection().close();
		System.out.println("data deleted successfully");
	}
		
	}


