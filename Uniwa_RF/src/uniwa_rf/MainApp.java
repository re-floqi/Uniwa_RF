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
         AllStudents.add(new Student("Reidon Floqi","00001","refloqi@uniwa.com","ICT","6975625353"));
         AllStudents.add(new Student("Elli Papa","00002","ellipapa@uniwa.com","Economics","6975625350"));
         AllStudents.add(new Student("Vaso Ksinou","00003","vksinou@uniwa.com","Law","6975625351"));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    
    
    
    
    
    public static void main(String[] args) {
        MainApp MP = new MainApp();
        
    }
    
}
