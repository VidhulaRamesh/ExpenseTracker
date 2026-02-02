# Expense Tracker (Java)

A console-based Expense Tracker application built using **Core Java** and **Object-Oriented Programming (OOPS)** concepts.  
This project helps users track their income and expenses, view all transactions, and see a financial summary.

---

## 🚀 Features
- Add Income
- Add Expense
- View all transactions
- View total income, total expense, and balance
- Menu-driven console application

---

## 🛠 Technologies Used
- Java
- OOPS concepts
- ArrayList
- Scanner
- Git & GitHub

---

## 🧠 OOPS Concepts Used

### 1. Encapsulation
- All data members in the `Transaction` class are **private**
- Accessed only through public getter methods

### 2. Abstraction
- User interacts with simple methods like `addIncome()` and `addExpense()`
- Internal logic is hidden from the user

### 3. Classes & Objects
- `Transaction` class represents a single transaction
- Multiple `Transaction` objects are stored using `ArrayList`

### 4. Separation of Concerns
- `Transaction.java` → Data model
- `ExpenseTracker.java` → Business logic
- `Main.java` → User interaction

---

## 📁 Project Structure
  ExpenseTracker/
│
├── Main.java
├── Transaction.java
├── ExpenseTracker.java
