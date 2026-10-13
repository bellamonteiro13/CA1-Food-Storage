
package ca1_food_storage;

import Data_Structure.Queue;

public class EntryPoint {

   
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //to work with a circular queue i need two directions: front and rear
         Queue myQueue = new Queue(5); //dont forget to put the () beside the method that u are calling!
    
         myQueue.enqueue("Burger");
         myQueue.enqueue("Pizza");
         myQueue.enqueue("Fries");
         myQueue.enqueue("Sandwich");
         myQueue.enqueue("Hot-Dog");
    
    }
    
}
