package application;

import java.util.*;

public class user {
	    private String username;
	    private String password;
	    public static Map<Date, Expense> budgetEntries = new HashMap<>();
	    
	    public user(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public boolean authenticate(String inputPassword) {
	        return password.equals(inputPassword);
	    }

	    public void addExpense(Date date, double amount) {
	        budgetEntries.put(date, new Expense(date, amount));
	    }

	    // Budget entries by date
	    public Expense getExpenseByDate(Date date) {
	        return budgetEntries.get(date);
	    }
	    
	    // budget entries by month
	    public List<Expense> getBudgetEntriesByMonth(int year, int month) {
	        List<Expense> entries = new ArrayList<>();
	        Calendar calendar = Calendar.getInstance();
	        for (Expense entry : budgetEntries.values()) {
	            calendar.setTime(entry.getDate());
	            if (calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == month) {
	                entries.add(entry);
	             }
	        }
	        return entries;
	    }
	    
	    // To calculate total budget
	    public double calculateTotalBudget() {
	        double totalBudget = 0.0;
	        for (Expense entry : budgetEntries.values()) {
	            totalBudget += entry.getAmount();
	        }
	        return totalBudget;
	    }
	    
	    // To delete budget logs
	    public void deleteBudgetEntriesByMonth(int year, int month) {
	        Iterator<Map.Entry<Date, Expense>> iterator = budgetEntries.entrySet().iterator();
	        Calendar calendar = Calendar.getInstance();
	        while (iterator.hasNext()) {
	            Map.Entry<Date, Expense> entry = iterator.next();
	            calendar.setTime(entry.getKey());
	            if (calendar.get(Calendar.YEAR) == year && calendar.get(Calendar.MONTH) == month) {
	                iterator.remove();
	            }
	        }
	    }
	        public void changePassword(String newPassword) {
	            this.password = newPassword;
	            System.out.println("Password changed successfully.");
	        }
	    }

	