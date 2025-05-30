/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniwa_rf;

/**
 *
 * @author macuser
 */
public class Student {
    // Ιδιωτικά Πεδία (Private fields)
    private String name;        // Όνομα Φοιτητή
    private String studentId;   // Αριθμός Μητρώου
    private String email;       // Φοιτητικό e-mail
    private String department;  // Τμήμα
    private String phone;       // Τηλέφωνο (προαιρετικό πεδίο)

    // Κατασκευαστής (Constructor)
    public Student(String name, String studentId, String email, String department, String phone) {
        this.name = name;
        this.studentId = studentId;
        this.email = email;
        this.department = department;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    
    public void fullPrint(){
        System.out.println("Όνομα:..........." + name);
        System.out.println("AM:.............." + studentId);
        System.out.println("Email:..........." + email);
        System.out.println("Τμήμα:..........." + department);
        System.out.println("Τηλέφωνο:........" + phone);
    }
    
}