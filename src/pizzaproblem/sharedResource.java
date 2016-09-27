package pizzaproblem;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
/**
 *
 * @author pubudurw
 */
public class sharedResource {
    int pizza_slice = 0;            //keep amount of pizza slices
    Semaphore mutex = new Semaphore(1); // allow access to critical section
    Semaphore ordering =  new Semaphore(1); //signal when pizza delivered
    Semaphore pizzaAvailable =  new Semaphore(0); //signal to pizza is available  
    
    /*Function to pizza delivery*/
    public void deliver_pizz(int numberOfPizzaSlices) throws InterruptedException{
        while(true){
            ordering.acquire();  //Kamal is waiting until a call from one of student  
            mutex.acquire();    //Acuire mutex, once called, start delivering the pizza. 
                    
           
            System.out.println("\nDeliver pizza and wake up the students");// deliver pizza
            pizza_slice = numberOfPizzaSlices;  //increase number of pizza slices by piza slices in one pizza
            for(int i = 0; i <= pizza_slice; i++)
                //signal pizza has been delivered and incrementing the pizaslise semaphore values.
                pizzaAvailable.release(); 
            
            mutex.release();    //release mutex as signaling for student to take pizza.                   
        }
    }
    
    /*Function to represent student behavior*/
    public void student_behavior(int id) throws InterruptedException{
        while(true){
            pizzaAvailable.acquire(); //waiting for pizza if there is no pizza
            mutex.acquire();  //aquire mutex, ensure that one piza slice for one student.
            
            if(pizza_slice > 0){ //check whether pizza is available or not
                pizza_slice--;      //consuming the pizza one by one 
                System.out.println("Student "+id+" takes a pizza. Go to study with the pizza");
                mutex.release();  //release mutex, ensure that one piza slice for one student.      
                sleep(5000);     //put a sleep to delay the next arrival (studing) 
            }
            
            else{
                System.out.println(id+" student calls to Kamal for a pizza");
                ordering.release(); //signaling that pizza has been ordered
                System.out.println("Students go to sleep"); //student sleep
                mutex.release();    //release mutex,                                
            }           
            
        }
    }
}
