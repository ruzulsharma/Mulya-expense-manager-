package com.entities.Mulya;

import java.util.*;
import org.hibernate.*;
import org.hibernate.query.Query;

public class Mulya {

    // Main method to start the program
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            System.out.println("------------------------Welcome to Expense Manager---------------");
            Menus menu = new Menus();
            menu.mainmenu(); // Display the main menu
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt(); // Get user input for main menu option
            while (ch != 0) {
                transaction = session.beginTransaction();
                if (ch == 1) {
                    // Option 1: Registration and adding income
                    performRegistration(session, sc);
                } else if (ch == 2) {
                    // Option 2: Log in and show expenses
                    showExpenses(session, sc);
                } else if (ch == 3) {
                    // Option 3: Exit
                    System.out.println("--------------Thank you for being here---------------");
                    break;
                } else {
                    // Invalid Choice
                    System.out.println("Invalid choice. Please try again.");
                }

                transaction.commit();
                menu.mainmenu(); // Display the main menu again
                ch = sc.nextInt(); // Get user input for main menu option
            }

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

    // Method to perform user registration and adding income
    public static void performRegistration(Session session, Scanner sc) {
        // Registration logic here
        Registeration reg = new Registeration();
        System.out.println("----------Registration---------");
        System.out.print("Enter Registration Name: ");
        String Regname = sc.next();
        reg.setRegisterationname(Regname);
        System.out.print("Enter Password: ");
        String pass = sc.next();
        reg.setPassword(pass);
        session.save(reg); // Save registration details
        System.out.println("---------------------Registration Successful!-----------------");
        // Taking User Details
        UserDetails ud = new UserDetails();
        System.out.println("Create User Id: ");
        String userId = sc.next();
        ud.setUserId(userId);
        System.out.print("Enter Your Name: ");
        String name = sc.next();
        ud.setUsername(name);
        System.out.print("Enter your E-mail (xyz@gmail.com): ");
        String email = sc.next();
        ud.setEmail(email);
        System.out.print("Enter Your Mobile No.: ");
        String mob_no = sc.next();
        ud.setMob_no(mob_no);
        session.save(ud); // Save user details

        System.out.println("-----------------------Details Saved-------------------");

        // Adding Income
        System.out.println("----------Income Details--------");
        Income income = new Income();
        System.out.print("Enter Income: ");
        double sal = sc.nextDouble();
        income.setAmount(sal);
        System.out.print("Enter Income Description: ");
        String desc = sc.next();
        income.setDescription(desc);
        income.setUser(ud);

        Date incdate= new Date();
        System.out.println("Enter day of Income: ");
        int day= sc.nextInt();
        incdate.setDay(day);
        
        System.out.println("Enter month of Income: ");
        int mon= sc.nextInt();
        incdate.setMonth(mon);
        
        System.out.println("Enter year of Income: ");
        int year= sc.nextInt();
        incdate.setYear(year);
        
        session.save(income); // Save income details

        System.out.println("------------User Details and Income saved successfully------------");
    }

    // Method to prompt user for login and show expenses
    public static void showExpenses(Session session, Scanner sc) {
        System.out.print("Enter your UserId: \r");
        String usrid= sc.next();
        UserDetails userId = new UserDetails();
        userId.setUserId(usrid);
        		
        System.out.print("Enter your Password: \r");
        String password = sc.next();
        
        boolean isAuthenticated = authenticateUser(session, userId, password);
        
        if (isAuthenticated) {
            showOptionsMenu(session, sc, userId);
        } else {
            System.out.println("Invalid UserId or Password. Please try again.");
        }
    }

    // Method to authenticate user based on UserId and Password
    public static boolean authenticateUser(Session session, UserDetails userId, String password) {
        try {
            Query<Registeration> query = session.createQuery("FROM Registeration WHERE registerationname = :userId AND password = :password", Registeration.class);
            query.setParameter("userId", userId);
            query.setParameter("password", password);
            List<Registeration> result = query.getResultList();
            return !result.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to display options for viewing, deleting expenses, or logging out
    public static void showOptionsMenu(Session session, Scanner sc, UserDetails userId) {
        Menus menu = new Menus();
        int choice=0;
        while (choice != 4) { // Continue until user chooses to log out

            choice = sc.nextInt(); // Get user input for options menu

            switch (choice) {
                case 1:
                    addExpense(session, sc, userId); // Add expense
                    break;
                case 2:
                    retrieveExpenses(session, userId); // Retrieve expenses
                    break;
                case 3:
                    deleteExpenses(session, sc, userId); // Delete expenses
                    break;
//                case 4:
//                    addIncome(session, sc, userId); // Add income
//                    break;
                case 4:
                    System.out.println("-----------------Logged Out Successfully-------------------");
                    break; // Logout
                default:
                    System.out.println("Invalid Choice");
            }
            
        }};
        
        
    


    public static void addExpense(Session session, Scanner sc,  UserDetails userId) {
        try {
            // Create a new Expense object
            Expense expense = new Expense();

            // Set the user for the expense
            expense.setuId(userId);

            // Read expense details from the user
            System.out.print("Enter Expense Amount: ");
            double amount = sc.nextDouble();
            expense.setExpenseAmount(amount);

            System.out.print("Enter Expense Description: ");
            String description = sc.next();
            expense.setDescription(description);

            System.out.println("Enter the Date of Expense (DD MM YYYY): ");
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            Date expenseDate = new Date(day, month, year);
            expense.setDate(expenseDate);

            // Save the expense object to the database
            session.save(expense);

            System.out.println("Expense added successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add expense: " + e.getMessage());
        }
    }

 // Method to retrieve expenses for a given user
    public static void retrieveExpenses(Session session, UserDetails userId) {
        try {
            // Query to retrieve expenses for the given userId
            Query<Expense> query = session.createQuery("FROM Expense WHERE uId_userId = :userId", Expense.class);
            query.setParameter("userId", userId);
            List<Expense> expenses = query.getResultList();

            if (expenses.isEmpty()) {
                System.out.println("No expenses found for the user with userId: " + userId);
            } else {
                System.out.println("Expenses for the user with userId: " + userId);
                for (Expense expense : expenses) {
                    System.out.println("Expense Id: " + expense.getExpenseId());
                    System.out.println("Expense Amount: " + expense.getExpenseAmount());
                    System.out.println("Expense Description: " + expense.getDescription());
                    System.out.println("Expense Date: " + expense.getDate().getFormattedDate());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to delete expenses for a given user
    public static void deleteExpenses(Session session, Scanner sc, UserDetails userId) {
        System.out.print("Enter Expense Id to delete: ");
        int expenseId = sc.nextInt();
        try {
            Transaction transaction = session.beginTransaction();
            Expense expense = session.get(Expense.class, expenseId);
            UserDetails expenseUserId = expense.getuId();
            UserDetails userDetails = session.load(UserDetails.class,userId.getUserId());
            if (userDetails != null && userDetails.getUserId().equals(userId)) {
                session.delete(expense);
                transaction.commit();
                System.out.println("Expense with ID " + expenseId + " deleted successfully.");
            } else {
                System.out.println("Expense not found or you do not have permission to delete it.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}