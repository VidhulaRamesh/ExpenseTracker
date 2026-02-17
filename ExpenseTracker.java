import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ExpenseTracker {

    private ArrayList<Transaction> transactions;
    private final String FILE_NAME = "transactions.txt";

    public ExpenseTracker() {
        transactions = new ArrayList<>();
        loadFromFile();
    }

    public void addIncome(double amount, String category, String date) {

        if (amount <= 0) {
           System.out.println("Amount must be greater than 0.");
           return;
        }
        if (category == null || category.trim().isEmpty()) {
            System.out.println("Category cannot be empty.");
            return;
        }

        if (date == null || date.trim().isEmpty()) {
            System.out.println("Date cannot be empty.");
            return;
        }
        Transaction t = new Transaction(amount, "INCOME", category, date);
        transactions.add(t);
        saveToFile(t);
        System.out.println("Income added.");
    }


    public void addExpense(double amount, String category, String date) {

        if (amount <= 0) {
           System.out.println("Amount must be greater than 0.");
           return;
        }

        if (category == null || category.trim().isEmpty()) {
            System.out.println("Category cannot be empty.");
            return;
        }

        if (date == null || date.trim().isEmpty()) {
           System.out.println("Date cannot be empty.");
           return;
        }

        Transaction t = new Transaction(amount, "EXPENSE", category, date);
        transactions.add(t);
        saveToFile(t);
        System.out.println("Expense added.");
    }


    private void saveToFile(Transaction t) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(t.getAmount() + "," + t.getType() + "," + t.getCategory() + "," + t.getDate());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }

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

                transactions.add(new Transaction(amount, type, category, date));
            }
        } catch (IOException e) {
            System.out.println("Error loading transactions.");
        }
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction t : transactions) {
            t.display();
        }
    }

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

    public String getCategoryReport() {

        HashMap<String, Double> categoryMap = new HashMap<>();

        for (Transaction t : transactions) {
           if (t.getType().equals("EXPENSE")) {
               String category = t.getCategory();
               double amount = t.getAmount();

               categoryMap.put(category,
                  categoryMap.getOrDefault(category, 0.0) + amount);
            }
        }

        if (categoryMap.isEmpty()) {
            return "No expense data available.";
        }

        StringBuilder report = new StringBuilder("--- Expense By Category ---\n");

        for (Map.Entry<String, Double> entry : categoryMap.entrySet()) {
            report.append(entry.getKey())
                .append(" : ₹")
                .append(entry.getValue())
                .append("\n");
        }

        return report.toString();
    }


    // Date wise transaction filter
    public String getTransactionsByDate(String searchDate) {

        StringBuilder result = new StringBuilder("--- Transactions on " + searchDate + " ---\n");

        boolean found = false;

        for (Transaction t : transactions) {
            if (t.getDate().equals(searchDate)) {
                result.append(t.getType())
                    .append(" | ")
                    .append(t.getCategory())
                    .append(" | ₹")
                    .append(t.getAmount())
                    .append(" | ")
                    .append(t.getDate())
                    .append("\n");
                found = true;
            }
        }

        if (!found) {
            return "No transactions found for this date.";
        }

        return result.toString();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
