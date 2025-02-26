
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (true) {
            System.out.println("1. Add Expense"); 
            System.out.println("2. Generated Monthly Report"); 
            System.out.println("3. Exit"); 
            System.out.println("Choose an option: "); 
            choice = scanner.nextInt();
            scanner.next();

            if(choice == 1)
            {
                System.out.println("Enter amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter category: ");
                String category = scanner.nextLine();
                System.out.println("Enter date (YYYY-MM-DD): ");
                String dateInput = scanner.nextLine();
                LocalDate date = LocalDate.parse(dateInput);
                tracker.addExpense(amount, category, date);
                System.out.println("Expense added");
            }
            else if(choice == 2)
            {
                System.out.println("Enter Month (1-12): ");
                int month = scanner.nextInt();
                System.out.println("Enter year (e.g., 2023)");
                int year = scanner.nextInt();
                tracker.generateMonthlyReport(month, year);

            }
            else if(choice == 3)
            {
            System.out.println("Exiting Application");
            break;
            }
            else
            System.out.println("Invalid option. Try again");

            
        }
    }
}
