# 🎓 UNIWA-STUDENTS Management System

**👤 Author:** Reidon Floqi  
**📅 Last Updated:** May 2024  
**🏫 Course:** Introduction to Object-Oriented Programming (University of West Attics)

## 🌟 Project Overview
Console application for managing student records at the University of West Attics. Implements core OOP principles with a clean menu-driven interface.

## 🚀 Features
  | # | Functionality                | Emoji | Description                     |
  |---|------------------------------|-------|---------------------------------|
  | 1 | View All Students            | 👥    | Display all registered students |
  | 2 | Add New Student              | ➕    | Register new student            |
  | 3 | Search by Name               | 🔍    | Find student by name            |
  | 4 | Search by Phone              | 📱    | Find student by phone number    |
  | 5 | Edit Student by Name         | ✏️    | Modify student details          |
  | 6 | Delete Student by Name       | ❌    | Remove student record           |
  | 7 | Exit Application             | 🚪    | Close the program               |

## 🧠 Student Model
```java
public class Student {
    private String name;        // Όνομα
    private String studentId;   // Αριθμός Μητρώου
    private String email;       // Φοιτητικό e-mail
    private String department;  // Τμήμα
    private String phone;       // Τηλέφωνο (προαιρετικό)
}

⚙️ Technical Implementation
  OOP Principles:
  Encapsulation (private fields + getters/setters)
  Abstraction through class design
  Modular methods for each operation
  Data Storage: ArrayList<Student>
  Input Handling: Scanner class for user input
  Error Prevention: Duplicate AM check
  UI Enhancements: Screen clearing methods

🛠️ How to Run
  Compile all Java files:
  bash
  javac uniwa_rf/*.java
  Execute main class:

  bash
  java uniwa_rf.MainApp
  🖥️ Sample Interface
  -----------------UNIWA------------------
  --------------Κύριο Μενού---------------
  1. Προβολή όλων των διαθέσιμων φοιτητών
  2. Προσθήκη νέου φοιτητή
  ...
  ---------------------------------------
📁 Project Structure
src/
├── MainApp.java        - Main application logic
├── Student.java        - Student model class
✅ Key Requirements Met
🛡️ All attributes private
📦 Main program in separate package
📝 JavaDoc-style comments
💾 Data persistence via ArrayList
♻️ Input validation (e.g., duplicate ID check)
🌈 Additional Features
✨ Interactive confirmation prompts
🧹 Screen clearing for better UX
🔄 Case-insensitive search
📋 Full student details display

Developed with ❤️ by Reidon Floqi
