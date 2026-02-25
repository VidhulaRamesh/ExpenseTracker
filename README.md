# 💰 FinSight – Smart Expense Analytics & Financial Planning System

FinSight is a Java-based desktop financial analytics application that helps users track income and expenses, visualize spending patterns, and generate AI-powered financial management plans.

---

## 🚀 Features

### 📊 Expense Tracking
- Add income and expenses
- Categorize transactions
- Date-based filtering
- Persistent storage using file handling

### 📈 Analytics & Visualization
- Category-wise expense distribution (Pie Chart using JFreeChart)
- Summary view (Total Income, Total Expense, Balance)
- Scrollable transaction reports

### 🧠 AI Financial Advisor
- Accepts monthly salary input
- Calculates total expenses and savings
- Computes savings percentage
- Provides intelligent management suggestions
- Identifies high-spending categories

---

## 🏗 Tech Stack

- **Java**
- **Java Swing (GUI)**
- **JFreeChart (Data Visualization)**
- **File Handling (BufferedReader / BufferedWriter)**
- **OOP Principles**

---

## 🧩 Project Architecture

```
UI Layer (ExpenseTrackerUI.java)
        ↓
Business Logic (ExpenseTracker.java)
        ↓
AI Advisor Module (FinancialAdvisor.java)
        ↓
Data Model (Transaction.java)
        ↓
File Storage (transactions.txt)
```

---

## 📊 Sample Functionalities

✔ Add income & expenses  
✔ View summary report  
✔ Filter transactions by date  
✔ View category distribution pie chart  
✔ Generate AI-based financial management plan  

---

## 🎯 AI Advisor Logic

The AI module analyzes:

- Total expenses
- Savings amount
- Savings percentage
- Category spending ratio

Based on these, it provides:
- Low savings warnings
- Spending optimization suggestions
- Investment recommendations

---

## 🛠 How to Run

### 1️⃣ Compile (Windows)

```bash
javac -cp ".;jfreechart-1.0.19.jar;jcommon-1.0.23.jar" *.java
```

### 2️⃣ Run

```bash
java -cp ".;jfreechart-1.0.19.jar;jcommon-1.0.23.jar" ExpenseTrackerUI
```

---

## 📌 Future Enhancements

- Monthly spending trend line chart
- PDF report export
- Database integration (MySQL)
- Web-based version (Full Stack)
- ML-based expense prediction

---

## 👩‍💻 Author

**Vidhula Ramesh**

---

## ⭐ Project Highlights

This project demonstrates:

- Object-Oriented Programming
- Event-Driven GUI Development
- Data Aggregation & Visualization
- Rule-Based AI System
- Clean Layered Architecture

---

> Built as a portfolio-level desktop financial analytics system.
