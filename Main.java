import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();

        int choice;

        do {
            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View All Transactions");
            System.out.println("4. View Summary");
            System.out.println("5. View Category Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter income amount: ");
                    double incomeAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String incomeCategory = sc.nextLine();

                    System.out.print("Enter date: ");
                    String incomeDate = sc.nextLine();

                    tracker.addIncome(incomeAmount, incomeCategory, incomeDate);
                    break;

                case 2:
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String expenseCategory = sc.nextLine();

                    System.out.print("Enter date: ");
                    String expenseDate = sc.nextLine();

                    tracker.addExpense(expenseAmount, expenseCategory, expenseDate);
                    break;

                case 3:
                    tracker.showTransactions();
                    break;

                case 4:
                    tracker.showSummary();
                    break;

                case 5:
                    tracker.showCategoryReport();
                    break;

                case 6:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
