package application;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BudgetTracker {
    private static Map<String, user> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSampleData();
        
        System.out.println("+----------------------------------+");
		System.out.printf("| %-33s|","WELCOME TO BUDGET TRACKER APP");
		System.out.println("\n+----------------------------------+");
		System.out.println("Developed by Sahana Tattimani");
		System.out.println("\nPLEASE ENTER LOGIN CREDENTIALS TO CONTINUE");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        user loggedInUser = loginUser(username, password);

        if (loggedInUser != null) {
            System.out.println("Welcome, " + loggedInUser.getUsername() + "!");
            handleUserActions(loggedInUser);
            
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    private static void initializeSampleData() {
        // Create pre-defined login credentials
        users.put("Sahana", new user("Sahana", "123sahana"));
    }

    private static user loginUser(String username, String password) {
        user user = users.get(username);
        if (user != null && user.authenticate(password)) {
            return user;
        }
        return null;
    }

    // Prompt user to choose an option
    private static void handleUserActions(user user) {
        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Set monthly budget");
            System.out.println("2. Record an expense");
            System.out.println("3. Budgetry Logs");
            System.out.println("4. Change Password");
            System.out.println("5. Exit");
           

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    setMonthlyBudget();
                    break;
                case 2:
                    recordAnExpense();
                    break;
                case 3:
                	budgetryLogs(user);
                    break;
                case 4:
                	changePassword(user);
                	break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    
	// Functions to be performed when option 1 is selected, to set monthly budget
    private static void setMonthlyBudget() {
        new SimpleDateFormat("yyyy-MM");
    
        try {
            System.out.print("Enter the monthly budget for every month:$");
            scanner.nextDouble();
            System.out.println("Your monthly budget has been updated successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Enter the amount.");
        }
    }

   // Functions to be performed when option 2 is selected, to record and expense
    @SuppressWarnings({ "unused", "unused" })
	private static void recordAnExpense() {
    	while (true) {
            System.out.println("\nChoose an expense category:");
            System.out.println("1. Clothes");
            System.out.println("2. Electricity Bill");
            System.out.println("3. Exam Fees");
            System.out.println("4. Food");
            System.out.println("5. Fuel");
            System.out.println("6. House Rent");
            System.out.println("7. Travelling");
            System.out.println("8. Other");
            System.out.println("9. Exit");
    	           
            int choice = scanner.nextInt();
    	            scanner.nextLine(); 

    	            switch (choice) {
    	                case 1:
    	                	System.out.println("1. Clothes");
    	                    break;
    	                case 2:
    	                	System.out.println("2. Electricity Bill");
    	                    break;
    	                case 3:
    	                    System.out.println("3. Exam Fees");
    	                    break;
    	                case 4:
    	                	System.out.println("4. Food");
    	                    break;
    	                case 5:
    	                	System.out.println("5. Fuel");
    	                    break;
    	                case 6:
    	                	System.out.println("6. House Rent");
    	                    break;
    	                case 7:
    	                	System.out.println("7. Travelling");
    	                	break;
    	                case 8:
    	                	System.out.println("8. Other");
    	                	break;
    	                case 9:
    	                	return;
    	                default:
    	                    System.out.println("Invalid choice. Try again.");
    	            }
    	           try {
    	            System.out.print("Enter expense amount:$");
    	            scanner.nextDouble();
    	            System.out.println("Expenses recorded successfully");
    	            Scanner scanner = new Scanner(System.in); 
    	           } catch (Exception e) {
    	               System.out.println("Invalid input. Enter the amount.");
    	           }
    	       }
    	            
    }
    // Functions to be performed when option 3 is selected, to store budgetary logs
    public static void budgetryLogs(user user) {
    	        System.out.println("Select the budget log you want to display");
    	    	while (true) {
    	            System.out.println("1. Date-Wise log");
    	            System.out.println("2. Month-Wise log");
    	            System.out.println("3. Total budget");
    	            System.out.println("4. Delete budgetry log");
    	            System.out.println("5. Exit");
    	    	           
    	            int choice = scanner.nextInt();
    	    	    scanner.nextLine(); 
    	    	    
    	    	        switch (choice) {
    	    	            case 1:
    	    	               dateWiseLog(user);
    	    	               break;
    	    	            case 2:
     	    	               monthWiseLog(user);     	    	               
     	    	               break;
    	    	            case 3:
     	    	              totalBudget(user);
     	    	               break;
    	    	            case 4:
     	    	              deleteLog(user);
     	    	               break;
    	    	            case 5:
    	    	            	return;
    	    	        }
    	    	}
    }  
    	    	// Function to Date wise log
    	    	private static void dateWiseLog(user user) {
    	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	            System.out.print("Enter the date (yyyy-MM-dd) for which you want to display the budgetry logs ");
    	            String input = scanner.nextLine();

    	            try {
    	                Date date = dateFormat.parse(input);
    	                Expense expense = user.getExpenseByDate(date);

    	                if(expense != null) {
    	                    System.out.println("Budget entry for " + dateFormat.format(date) + ": $" + ((Expense) expense).getAmount());
    	                } else {
    	                    System.out.println("No budget entry found for " + dateFormat.format(date));
    	                }
    	            } catch (Exception e) {
    	                System.out.println("Invalid input. Please use the yyyy-MM-dd format for the date.");
    	            }    	    	
    	        }
                
                // Function to Month wise log
                public static void monthWiseLog(user user) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
                System.out.print("Enter the month and year (yyyy-MM): ");
                String input = scanner.nextLine();

                try {
                    Date date = dateFormat.parse(input);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);

                    List<Expense> entries = user.getBudgetEntriesByMonth(year, month);

                    if (!entries.isEmpty()) {
                        System.out.println("Budget entries for " + dateFormat.format(date) + ":");
                        for (Expense entry : entries) {
                            System.out.println("Date: " + dateFormat.format(entry.getDate()) + ", Amount: $" + entry.getAmount());
                        }
                    } else {
                        System.out.println("No budget entries found for " + dateFormat.format(date));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please use the yyyy-MM format for the date.");
                }
            }
            // Function to calculate total budget
            private static void totalBudget(user user) {
                double totalBudget = user.calculateTotalBudget();
                System.out.println("Total Budget: $" + totalBudget);
            }
           
            // 	Function to delete the budgetary log
            private static void deleteLog(user user) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
                System.out.print("Enter the month and year (yyyy-MM) to delete budget entries: ");
                String input = scanner.nextLine();

                try {
                    Date date = dateFormat.parse(input);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);

                    user.deleteBudgetEntriesByMonth(year, month);
                    System.out.println("Budget entries for " + dateFormat.format(date) + " deleted successfully.");
                } catch (Exception e) {
                    System.out.println("Invalid input. Please use the yyyy-MM format for the date.");
                }
            }
            
            // Functions to be performed when option 4 is selected
            private static void changePassword(user user) {
            	    System.out.print("Enter your current password: ");
            	    String currentPassword = scanner.nextLine();

            	    if (!user.authenticate(currentPassword)) {
            	        System.out.println("Incorrect current password. Password change failed.");
            	        return;
            	    }

            	    System.out.print("Enter your new password: ");
            	    String newPassword = scanner.nextLine();

            	    // Update the password
            	    user.changePassword(newPassword);
     	           scanner.close();
            	}
            
        		
        	}



    

   