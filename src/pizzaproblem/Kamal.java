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
 * @author pubudurw
 * Kamal Class to represents kamale's delivery behavior
 */
public class Kamal extends Thread{
    
    sharedResource resource;
    private int pizzaCount;
    public Kamal(sharedResource r, int pizzaCount){
        this.resource = r;
        this.pizzaCount = pizzaCount;
    }
    
    @Override
    public void run(){
        try {
            resource.deliver_pizz(pizzaCount);//call the method of delivering method of kamal
        } catch (InterruptedException ex) {
            Logger.getLogger(Kamal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
