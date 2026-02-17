import javax.swing.*;
import java.awt.*;

public class ExpenseTrackerUI {

    private ExpenseTracker tracker;
    private JTextArea outputArea;

    public ExpenseTrackerUI() {

        tracker = new ExpenseTracker();

        JFrame frame = new JFrame("Expense Tracker");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ===== Input Panel =====
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JTextField amountField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField dateField = new JTextField();

        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Date:"));
        inputPanel.add(dateField);

        // ===== Button Panel =====
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JButton incomeButton = new JButton("Add Income");
        JButton expenseButton = new JButton("Add Expense");
        JButton viewAllButton = new JButton("View All");
        JButton summaryButton = new JButton("Summary");
        JButton categoryButton = new JButton("Category Report");
        JButton dateFilterButton = new JButton("Filter By Date");

        buttonPanel.add(incomeButton);
        buttonPanel.add(expenseButton);
        buttonPanel.add(viewAllButton);
        buttonPanel.add(summaryButton);
        buttonPanel.add(categoryButton);
        buttonPanel.add(dateFilterButton);

        // ===== Output Area =====
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // ===== Add Panels To Frame =====
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // ===== Button Actions =====

        incomeButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                tracker.addIncome(amount, categoryField.getText(), dateField.getText());
                outputArea.setText("Income Added Successfully!\n");
            } catch (Exception ex) {
                outputArea.setText("Invalid Input!\n");
            }
        });

        expenseButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                tracker.addExpense(amount, categoryField.getText(), dateField.getText());
                outputArea.setText("Expense Added Successfully!\n");
            } catch (Exception ex) {
                outputArea.setText("Invalid Input!\n");
            }
        });

        viewAllButton.addActionListener(e -> {
            outputArea.setText("");
            for (Transaction t : tracker.getTransactions()) {
                outputArea.append(t.getType() + " | "
                        + t.getCategory() + " | ₹"
                        + t.getAmount() + " | "
                        + t.getDate() + "\n");
            }
        });

        summaryButton.addActionListener(e -> {
            outputArea.setText("");
            double income = 0, expense = 0;

            for (Transaction t : tracker.getTransactions()) {
                if (t.getType().equals("INCOME"))
                    income += t.getAmount();
                else
                    expense += t.getAmount();
            }

            outputArea.append("Total Income  : ₹" + income + "\n");
            outputArea.append("Total Expense : ₹" + expense + "\n");
            outputArea.append("Balance       : ₹" + (income - expense) + "\n");
        });

        categoryButton.addActionListener(e -> {
            outputArea.setText(tracker.getCategoryReport());
        });


        dateFilterButton.addActionListener(e -> {
            outputArea.setText(tracker.getTransactionsByDate(dateField.getText()));
        });


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ExpenseTrackerUI();
    }
}
