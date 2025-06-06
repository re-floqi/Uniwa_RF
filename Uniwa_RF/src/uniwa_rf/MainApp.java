/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uniwa_rf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author refloqi
 */

public class MainApp {
    ArrayList <Student> AllStudents;
    Scanner KeyB;
    
     public MainApp (){
         AllStudents = new ArrayList <Student> ();
         KeyB = new Scanner (System.in);
         AllStudents.add(new Student("Reidon Floqi","00001","rf@uniwa.com","ICT","00000"));
         AllStudents.add(new Student("E P","00002","ep@uniwa.com","Economics","11111"));
         AllStudents.add(new Student("V K","00003","vk@uniwa.com","Tech","22222"));
    }

    public void Menu() {
        int choice;
        do {
        Cls();
        ClsWin();
        System.out.println("-----------------UNIWA------------------");
        System.out.println("--------------Κύριο Μενού---------------");
        System.out.println("1. Προβολή όλων των διαθέσιμων φοιτητών");
        System.out.println("2. Προσθήκη νέου φοιτητή");
        System.out.println("3. Αναζήτηση φοιτητή βάσει ονόματος");
        System.out.println("4. Αναζήτηση φοιτητή βάσει τηλεφώνου");
        System.out.println("5. Επεξεργασία φοιτητή βάσει ονόματος");
        System.out.println("6. Διαγραφή φοιτητή βάσει ονόματος");
        System.out.println("7. Έξοδος από την εφαρμογή");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.print("Επιλέξτε μια επιλογή (1-7): ");
        choice = KeyB.nextInt();
        KeyB.nextLine(); // Καθαρισμός του buffer

        switch (choice) {
            case 1:
                showAllStudents();
                break;
            case 2: addStudent();
                break;
            case 3:
                searchStudentName();
                break;
            case 4:
                searchStudentPhone();
                break;
            case 5: 
            editStudentName();
            break;
            case 6:
                deleteStudentName();
                break;
            default:
                break;
        }
    }   while (choice != 7);
        Cls();
        ClsWin();
        banner();
        System.out.println("Ευχαριστώ που χρησιμοποιήσατε την εφαρμογή μου!");
        System.exit(0); // Τερματισμός της εφαρμογής
    }

    public void pause() { // Μέθοδος για παύση της εκτέλεσης και αναμονή για είσοδο από τον χρήστη
        System.out.print("Πατήστε Enter για να συνεχίσετε...");
        KeyB.nextLine();
    }
    
    public void banner() { // Μέθοδος για γραφικα
    System.out.print("""
           __  __ _   __ ____ _       __ ___ 
          / / / // | / //  _/| |     / //   |
         / / / //  |/ / / /  | | /| / // /| |
        / /_/ // /|  /_/ /   | |/ |/ // ___ |
        \\____//_/ |_//___/   |__/|__//_/  |_|
                                             
        """);
    
    }
    
 
    

    public void showAllStudents() { // Μέθοδος για εμφάνιση όλων των φοιτητών
        Cls();
        ClsWin();
        System.out.println("-----------------UNIWA------------------");
        System.out.println("Εκτυπωση ολους τους φοιτητες:");
        for (Student tmp : AllStudents) {
            
            System.out.println("----------------------------------------");
            tmp.fullPrint();
        }
        pause();
    }

    public void addStudent() { // Μέθοδος για προσθήκη νέου φοιτητή
        Cls();
        ClsWin();
        String name, studentId, email, department, phone;
        System.out.println("-----------------UNIWA------------------");
        System.out.println("------------Εισαγωγή Ατόμου-------------");
        System.out.print("Όνομα: ");
        name = KeyB.nextLine();
        System.out.print("AM: "); 
        studentId = KeyB.nextLine();
        while (searchStudentID(studentId)) // Ελέγχουμε αν το ΑΜ υπάρχει ήδη
            { 
            System.out.print("Το ΑΜ υπάρχει ήδη. \nΠαρακαλώ εισάγετε ένα νέο ΑΜ: ");
            studentId = KeyB.nextLine();
            }
        System.out.print("Email: ");
        email = KeyB.nextLine();
        System.out.print("Τμήμα: ");
        department = KeyB.nextLine();
        System.out.print("Τηλέφωνο: ");
        phone = KeyB.nextLine();
        AllStudents.add(new Student(name, studentId, email, department, phone));
        System.out.println("Ο φοιτητής προστέθηκε επιτυχώς.");
        pause();
    }
    public boolean searchStudentID(String ID){ // Μέθοδος για αναζήτηση φοιτητή βάσει ΑΜ και ελέγχουμε αν υπάρχει φοιτητής με το συγκεκριμένο ΑΜ
        for (Student tmp : AllStudents) {
            if (tmp.getStudentId().equals(ID)) {
                return true;
            }
        }
        return false;
    }
    public void searchStudentName() { // Μέθοδος αναζήτησης φοιτητή βάσει αρχικών χαρακτήρων ονόματος
        Cls();
        ClsWin();
        System.out.println("-----------------UNIWA------------------");
        System.out.println("----Αναζήτηση φοιτητή βάσει ονόματος----\n");
        while (true) {
            System.out.print("Εισάγετε το όνομα του φοιτητή:");
            String name = KeyB.nextLine();
            int i = SearchByName(name);
            if (i == -1) {
                System.out.println("Δεν υπάρχει άτομο με αυτό το όνομα. Προσπαθήστε ξανά.\n");
            } else {
                Student tmp = AllStudents.get(i);
                tmp.fullPrint();
                System.out.println("\n");
                pause();
                break;
            }
        }
    }

    public int SearchByName (String A) // Βοηθητική Μέθοδος αναζήτησης φοιτητή βάσει αρχικών χαρακτήρων ονόματος
    {
        int i;
        Student tmp;
        for (i = 0; i < AllStudents.size (); i++)
        {
            tmp = AllStudents.get (i);
            if (tmp.getName ().toUpperCase ().startsWith (A.toUpperCase ()))
                return i;
        }
        return -1;     
    }

    public void searchStudentPhone() { // Μέθοδος για αναζήτηση φοιτητή βάσει τηλεφώνου
        Cls();
        ClsWin();
        System.out.println("-----------------UNIWA------------------");
        System.out.println("----Αναζήτηση φοιτητή βάσει τηλεφώνου---\n");
        System.out.print("Εισάγετε το τηλεφωνο του φοιτητή:");
        String phone = KeyB.nextLine();
        Student tmp;
        int i;
        for(i=0;i < AllStudents.size(); i++)
        {
            tmp = AllStudents.get (i);
            if (tmp.getPhone().equals(phone))
                break;
        }
        if (i == AllStudents.size()) {
        System.out.println("Δεν βρέθηκε φοιτητής με αυτό το τηλέφωνο.");
        } else {
        tmp = AllStudents.get(i);
        tmp.fullPrint();
    }
        pause();
    
    }
    

    public void editStudentName() { // Μέθοδος για επεξεργασία φοιτητή βάσει ονόματος
        Cls();
        ClsWin();
        System.out.println("-----------------UNIWA------------------");
        System.out.println("---Επεξεργασία φοιτητή βάσει ονόματος---\n");
        String choice;
        String name;
        Student tmp = null;
        int i = -1;
        do {
            System.out.print("Εισάγετε το όνομα του φοιτητή:");
            name = KeyB.nextLine();

            if (( i= SearchByName(name)) == -1) {
                System.out.println ("Δεν υπάρχει άτομο με αυτό το όνομα....");
                pause();
                return;
            }
            tmp = AllStudents.get(i);
            tmp.fullPrint();
            System.out.print("Το κατάλληλο άτομο για επεξεργασία; (Ν/Ο): ");
            choice = KeyB.nextLine().toUpperCase();
        }while (!choice.equalsIgnoreCase("N") && !choice.equals("Ν"));
        String email, department, phone; // ΠΑΡΑΔΟΧΗ - Δεν μπορεί να τροποποιηθεί το ΑΜ.
        System.out.print("Εισάγετε το νέο όνομα: ");
        name = KeyB.nextLine();
        tmp.setName(name);
        System.out.print("Εισάγετε το νέo Email: ");
        email = KeyB.nextLine();
        tmp.setEmail(email);
        System.out.print("Τμήμα: ");
        department = KeyB.nextLine();
        tmp.setDepartment(department);
        System.out.print("Τηλέφωνο: ");
        phone = KeyB.nextLine();
        tmp.setPhone(phone);
        System.out.println("Ο φοιτητής ενημερώθηκε επιτυχώς.");
        pause();
    }
    
    public void deleteStudentName() { // Μέθοδος για διαγραφή φοιτητή βάσει ονόματος
        Cls();
        ClsWin();
        System.out.println("-----------------UNIWA------------------");
        System.out.println("-----Διαγραφή φοιτητή βάσει ονόματος----\n");
        String choice;
        String name;
        Student tmp = null;
        int i = -1;
        do {
            System.out.print("Εισάγετε το όνομα του φοιτητή:");
            name = KeyB.nextLine();

            if (( i= SearchByName(name)) == -1) {
                System.out.println ("Δεν υπάρχει άτομο με αυτό το όνομα....");
                pause();
                return;
            }
            tmp = AllStudents.get(i);
            tmp.fullPrint(); // Εμφάνιση των στοιχείων του φοιτητή για επιβεβαίωση
            System.out.print("Το κατάλληλο άτομο για διαγραφή; (Ν/Ο): ");
            choice = KeyB.nextLine().toUpperCase(); // Εισαγωγή επιλογής από τον χρήστη και μετατροπή σε κεφαλαία γράμματα
        }while (!choice.equalsIgnoreCase("N") && !choice.equals("Ν"));
        System.out.print("Είστε σίγουροι ότι θέλετε να διαγράψετε τον φοιτητή " + tmp.getName() + "? (Ν/Ο): ");
        choice = KeyB.nextLine().toUpperCase(); // Εισαγωγή επιλογής από τον χρήστη και μετατροπή σε κεφαλαία γράμματα
            if (!choice.equalsIgnoreCase("N") && !choice.equals("Ν")) {
                System.out.println("Η διαγραφή ακυρώθηκε.");
                pause();
            }
            else {
                AllStudents.remove(i); // Διαγραφή του φοιτητή από τη λίστα

            }
        System.out.println("Ο φοιτητής διαγράφηκε επιτυχώς.");
        pause();
    }
        
     /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        MainApp MP = new MainApp();
        MP.Menu();
    }
    public void Cls () {
        try
        {
            new ProcessBuilder ("/usr/bin/clear").inheritIO ().
                start(). waitFor ();
        }
        catch (IOException ex)
        {
            
        }
        catch (InterruptedException ex)
        {
            
        }
    }
    
    
    public void ClsWin (){

        try
        {
            new ProcessBuilder ("cmd", "/c", "cls").inheritIO ().
                start(). waitFor ();
        }
        catch (IOException ex)
        {
            
        }
        catch (InterruptedException ex)
        {
            
        }
    }    
    }