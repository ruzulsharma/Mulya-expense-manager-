package MulyaClasses;

import java.util.Scanner;

import com.entities.Mulya.*;

public class Operation implements Main {
	Expense ex= new Expense();
	public Expense addExpense() {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter description : \r");
		String desc= sc.next();
		ex.setDescription(desc);
		System.out.print("Enter your ExpenseAmount : \r");
		double ea= sc.nextDouble();
		System.out.print("Enter Date of Expense : \r");
		String date= sc.next();
		ex.setDate(date);
		System.out.print("Enter your user Id : ");
		UserDetails uId;
		ex.setuId(uId); // Associate the expense with the user
		//Constructor
//		System.out.println("Adding Data...............");
		return ex;
	};
	public Expense Reterive() {
		return ex;
	};
	public void deleteExpense() {
	};
}
