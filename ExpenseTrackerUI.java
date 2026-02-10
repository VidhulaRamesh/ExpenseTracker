import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExpenseTrackerUI {

    private ExpenseTracker tracker;

    public ExpenseTrackerUI() {

        tracker = new ExpenseTracker();

        JFrame frame = new JFrame("Expense Tracker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField();

        JButton incomeButton = new JButton("Add Income");
        JButton expenseButton = new JButton("Add Expense");

        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(categoryLabel);
        frame.add(categoryField);
        frame.add(dateLabel);
        frame.add(dateField);
        frame.add(incomeButton);
        frame.add(expenseButton);

        incomeButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                tracker.addIncome(amount, categoryField.getText(), dateField.getText());
                JOptionPane.showMessageDialog(frame, "Income Added!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input!");
            }
        });

        expenseButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                tracker.addExpense(amount, categoryField.getText(), dateField.getText());
                JOptionPane.showMessageDialog(frame, "Expense Added!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input!");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ExpenseTrackerUI();
    }
}
