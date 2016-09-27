/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaproblem;
import java.util.Scanner;
/**
 *
 * @author Pubudurw
 */
public class PizzaProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        sharedResource resource = new sharedResource();
        int pizzaCount;
        int numberOfStudent;
        
        System.out.print("Pizza slices per pizza : ");
        pizzaCount = sc.nextInt(); // get number of pizza slices
        
        System.out.print("Number of students takepart : ");
        numberOfStudent = sc.nextInt();  // get number of students
        
        new Kamal(resource, pizzaCount).start();//start vaitor thread
        
        for(int i = 0; i < numberOfStudent; i++){
            new Student(resource, i).start();//start student threads per each student.
        }                          
    }    
}
