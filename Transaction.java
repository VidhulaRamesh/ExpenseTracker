public class Transaction {

    private double amount;
    private String type;      // INCOME or EXPENSE
    private String category;  // Food, Travel, Rent, Salary, etc.
    private String date;      // dd-mm-yyyy

    // Constructor
    public Transaction(double amount, String type, String category, String date) {
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.date = date;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    // Display transaction details
    public void display() {
        System.out.println(type + " | " + category + " | ₹" + amount + " | " + date);
    }
}
