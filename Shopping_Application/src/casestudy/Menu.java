package casestudy;
import java.sql.SQLException;
import java.util.Scanner;
public class Menu {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
Menu m=new Menu();
m.login();
	}
	void login() throws ClassNotFoundException, SQLException
	{
		Scanner s=new Scanner(System.in);
		System.out.println("1.ADMIN LOGIN\n2.AGENT LOGIN\n3.EXIT\nENTER YOUR CHOICE");
		int n=s.nextInt();
		if(n==1)
		{
		Admin ad=new Admin();
		ad.admin1();
		}
		else if(n==2)
		{
			Agent ag=new Agent();
			ag.agent();
		}
		else 
		{
			System.out.println("PROCESS COMPLETE");
			System.exit(0);
		}
		
		
	}

}
