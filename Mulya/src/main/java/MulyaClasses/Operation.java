//package MulyaClasses;
//
//import java.util.Scanner;
//
//import com.entities.Mulya.*;
//
//public class Operation implements Main {
//	Expense ex= new Expense();
//	Scanner sc= new Scanner(System.in);
//	public Expense addExpense() {
//		System.out.print("Enter description : \r");
//		String desc= sc.next();
//		ex.setDescription(desc);
//		System.out.print("Enter your ExpenseAmount : \r");
//		double ea= sc.nextDouble();
//		System.out.print("Enter Date of Expense : \r");
//		String date= sc.next();
//		ex.setDate(date);
//		System.out.print("Enter your user Id : ");
//		UserDetails uId;
//		ex.setuId(uId); // Associate the expense with the user
//		//Constructor
////		System.out.println("Adding Data...............");
//		return ex;
//	};
//	public Expense Reterive() {
//		String newUser = sc.next();
//		
//		UserDetails user = session.get(UserDetails.class, newUser.getUserID());
//		System.out.println("Expenses for user " + user.getUsername() + ":");
//		for (Expense expense : user.getExpenses()) {
//			System.out.println("Amount: " + expense.getAmount() + ", Category: " + expense.getCategory() +
//					", Description: " + expense.getDescription() + ", Date: " + expense.getDate());
//		}
//	}
////	};
////	public void deleteExpense() {
////	};
////}
