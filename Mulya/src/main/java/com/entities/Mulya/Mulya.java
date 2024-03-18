package com.entities.Mulya;

import MulyaClasses.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Mulya {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {

			// Create and Persist a Registeration
//	            Registeration reg = new Registeration();
//	            reg.setRegisterationname("exampleUser");
//	            reg.setPassword("password");
//	            
//	            session.save(reg);
//	            // Create and persist a user
//	            UserDetails user = new UserDetails();
//	            user.setUsername("exampleUser");
//	            user.setMob_no("password");
//	            user.setEmail("user@example.com");
//
//	            session.save(user);
//
//	            // Create and persist an expense
//	            Expense expense = new Expense();
//	            expense.setAmount(100.50); // Set the amount of the expense
//	            expense.setDescription("Dinner with friends"); // Set the description
//	            expense.setDate(new Date()); // Set the date of the expense
//	            expense.setRegId(reg); // Associate the expense with the user
//
//	            session.save(expense);
//
//	            // Create and persist a category
//	            Category category = new Category();
//	            category.setCategoryName("Food"); // Set the category name
//	            category.setDescription("Expenses related to food items"); // Set the description
//
//	            session.save(category);
//
//	            // Create and persist a payment method
//	            PaymentMethod paymentMethod = new PaymentMethod();
//	            paymentMethod.setPaymentMethodName("Credit Card"); // Set the payment method name
//	            paymentMethod.setDescription("Payment made using a credit card"); // Set the description
//
//	            session.save(paymentMethod);

			System.out.println("------------------------Welcome to Expense Manager---------------");
			Menus m = new Menus();
			m.mainmenu();
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();

			while (ch != 3) {
				transaction = session.beginTransaction();
				if (ch == 1) {
					// Perform action for option 1
					Registeration reg = new Registeration();
					System.out.println("----------Registeration---------");
					System.out.print("Enter RegisterationName :");
					String name = sc.next();
					reg.setRegisterationname(name);
					System.out.print("Enter Password : ");
					String pass = sc.next();
					reg.setPassword(pass);
					System.out.println("Registration successful!");
					// Assuming 'session' is your Hibernate session, you should save the entity here
					session.save(reg);
					break;
				}
				// Log in work
				else if (ch == 2) {
					System.out.println("-----------Log in-------------");
					UserDetails ud = new UserDetails();
					System.out.print("Enter Your Name : ");
					String name = sc.next();
					ud.setUsername(name);
					System.out.print("Enter your E-mail (xyz@gmail.com) ");
					String email = sc.next();
					ud.setEmail(email);
					System.out.print("Enter Tour Mobile No. : ");
					String mob_no = sc.next();
					ud.setMob_no(mob_no);
					System.out.print("Enter Income");
					double sal = sc.nextDouble();
					ud.setSalary(sal);
					System.out.print(" Deatails Saved");
					System.out.println("------------------------------------");
					
					System.out.println();
					System.out.println();
					System.out.println();
					
//	                	
				} else if (ch == 3) {
					System.out.println("--------------Thank you for being here---------------");
					break;
				}
				// Invalid Choice
				else {
					// Handle invalid input
					System.out.println("Invalid choice. Please try again.");
				}

				m.mainmenu();
				ch = sc.nextInt();
			}

			transaction.commit();
			System.out.println("Entities saved successfully.");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.shutdown();
		}
	}
}

//System.out.println("Enter your Registered Username : ");
////String regname =sc.next();
//// Perform action for option 2
//System.out.println("Option 2 selected.");
