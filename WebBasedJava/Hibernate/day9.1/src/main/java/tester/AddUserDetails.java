package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.*;

public class AddUserDetails {

	public static void main(String[] args) {
		//bootstrapping hib frmwork
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in))
		{
			System.out.println();
			
			System.out.println("hibernate up n running! "+sf);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
