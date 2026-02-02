import java.util.ArrayList;

public class ExpenseTracker {

    private ArrayList<Transaction> transactions;

    // Constructor
    public ExpenseTracker() {
        transactions = new ArrayList<>();
    }

    // Add income
    public void addIncome(double amount, String category, String date) {
        Transaction t = new Transaction(amount, "INCOME", category, date);
        transactions.add(t);
        System.out.println("Income added successfully.");
    }

    // Add expense
    public void addExpense(double amount, String category, String date) {
        Transaction t = new Transaction(amount, "EXPENSE", category, date);
        transactions.add(t);
        System.out.println("Expense added successfully.");
    }

    // Show all transactions
    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\nType | Category | Amount | Date");
        System.out.println("--------------------------------");
        for (Transaction t : transactions) {
            t.display();
        }
    }

    // Show summary
    public void showSummary() {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {
            if (t.getType().equals("INCOME")) {
                totalIncome += t.getAmount();
            } else {
                totalExpense += t.getAmount();
            }
        }

        System.out.println("\n--- Summary ---");
        System.out.println("Total Income  : ₹" + totalIncome);
        System.out.println("Total Expense : ₹" + totalExpense);
        System.out.println("Balance       : ₹" + (totalIncome - totalExpense));
    }
}
