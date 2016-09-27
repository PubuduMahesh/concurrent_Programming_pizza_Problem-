/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaproblem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pubururw
 * Student class to represent students behavior
 */
public class Student extends Thread{
    sharedResource resource;
    int id;
    
    public Student(sharedResource r, int id){
        this.resource = r;
        this.id = id;
    }
    
    @Override
    public void run(){
        try {
            resource.student_behavior(id); //Call to student behavior function
        } catch (InterruptedException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
