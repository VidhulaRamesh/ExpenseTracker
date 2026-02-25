import java.util.HashMap;

public class FinancialAdvisor {

    public static String generatePlan(ExpenseTracker tracker, double salary) {

        double totalExpense = 0;
        HashMap<String, Double> categoryMap = new HashMap<>();

        for (Transaction t : tracker.getTransactions()) {
            if (t.getType().equals("EXPENSE")) {
                totalExpense += t.getAmount();

                categoryMap.put(
                        t.getCategory(),
                        categoryMap.getOrDefault(t.getCategory(), 0.0) + t.getAmount()
                );
            }
        }

        double savings = salary - totalExpense;
        double savingsPercent = (savings / salary) * 100;

        StringBuilder plan = new StringBuilder();
        plan.append("===== Financial Management Plan =====\n");
        plan.append("Salary: ₹").append(salary).append("\n");
        plan.append("Total Expense: ₹").append(totalExpense).append("\n");
        plan.append("Savings: ₹").append(savings).append("\n");
        plan.append("Savings %: ").append(String.format("%.2f", savingsPercent)).append("%\n\n");

        // Advice Logic
        if (savingsPercent < 20) {
            plan.append("⚠ Low savings. Try reducing unnecessary expenses.\n");
        } else if (savingsPercent >= 20 && savingsPercent < 40) {
            plan.append("✔ Moderate savings. You are managing fairly well.\n");
        } else {
            plan.append("🎉 Excellent savings rate! Consider investing.\n");
        }

        // Category based suggestions
        for (String category : categoryMap.keySet()) {
            double percent = (categoryMap.get(category) / salary) * 100;

            if (percent > 30) {
                plan.append("⚠ High spending on ").append(category)
                    .append(". Try optimizing this category.\n");
            }
        }

        return plan.toString();
    }
}