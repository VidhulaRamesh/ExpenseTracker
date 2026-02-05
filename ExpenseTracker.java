import java.util.ArrayList;
import java.io.*;

public class ExpenseTracker {

    private ArrayList<Transaction> transactions;
    private final String FILE_NAME = "transactions.txt";

    public ExpenseTracker() {
        transactions = new ArrayList<>();
        loadFromFile();   // load data when app starts
    }

    // Add income
    public void addIncome(double amount, String category, String date) {
        Transaction t = new Transaction(amount, "INCOME", category, date);
        transactions.add(t);
        saveToFile(t);
        System.out.println("Income added.");
    }

    // Add expense
    public void addExpense(double amount, String category, String date) {
        Transaction t = new Transaction(amount, "EXPENSE", category, date);
        transactions.add(t);
        saveToFile(t);
        System.out.println("Expense added.");
    }

    // Save single transaction to file
    private void saveToFile(Transaction t) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(
                t.getAmount() + "," +
                t.getType() + "," +
                t.getCategory() + "," +
                t.getDate()
            );
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }

    // Load transactions from file
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                double amount = Double.parseDouble(data[0]);
                String type = data[1];
                String category = data[2];
                String date = data[3];

                transactions.add(
                    new Transaction(amount, type, category, date)
                );
            }
        } catch (IOException e) {
            System.out.println("Error loading transactions.");
        }
    }

    // Show all transactions
    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        for (Transaction t : transactions) {
            t.display();
        }
    }

    // Show summary
    public void showSummary() {
        double income = 0, expense = 0;

        for (Transaction t : transactions) {
            if (t.getType().equals("INCOME"))
                income += t.getAmount();
            else
                expense += t.getAmount();
        }

        System.out.println("Total Income  : ₹" + income);
        System.out.println("Total Expense : ₹" + expense);
        System.out.println("Balance       : ₹" + (income - expense));
    }
}
