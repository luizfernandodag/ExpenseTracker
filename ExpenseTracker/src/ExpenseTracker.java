
import java.lang.classfile.Signature;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Expense;

public class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        this.expenses = new ArrayList<Expense>();

    }
    public void addExpense(double amount, String category, LocalDate date)
    {
        expenses.add(new Expense(amount, category, date));

    }

    public List<Expense> getExpenses()
    {
        return this.expenses;
    }
    
    public double getTotalExpensesForMonth(int month, int year)
    {
        return this.expenses.stream()
        .filter(expense -> expense.getDate().getMonthValue() == month && expense.getDate().getYear() == year)
        .mapToDouble(Expense::getAmount)
        .sum();


    }

    public void generateMonthlyReport(int month, int year)
    {
        System.out.println("Monthly Report for " + month + "/" + year);
        for(Expense expense : expenses)
        {
            if(expense.getDate().getMonthValue() ==  month && expense.getDate().getYear() == year)
            {
                System.out.println(expense);
            }


        }
        System.out.println("Total Expense: " + getTotalExpensesForMonth(month, year));

    }
    

}
