package foodstorage;


// ===================== TIME COMPLEXITY (circular queue, FIFO) =====================
// isEmpty()    O(1) - only checks front, one comparison
// isFull()     O(1) - one small calculation with %, no loop
// enqueue()    O(1) - rear moves one step with %, nothing else moves
// dequeue()    O(1) - front moves one step with %, nothing else moves
// peek()       O(1) - goes straight to trays[front]
// display()    O(n) - has to visit every food from front to rear
// searchById() O(n) - linear search: worst case checks all n foods (data is not sorted by ID)
// =====================================================================================
public class FoodQueue { //<-- the constructor name and the class name 
    
    private int front; // it changes to the front
    private int rear; // it goes back 
    private int capacity; // my capacity im gonna need to know the capacity of the queue
    private FoodItem[] trays; //my array of trays, each tray holds one FoodItem card
    
    //they are all private because of the same rule for FoodItem - encapsulation
    
    public FoodQueue (int size) {
        
        this.capacity = size; // here im defying the value of my capacity; i can also use it more than once if i declare here
        this.front = -1;
        this.rear = -1;
        this.trays = new FoodItem[size]; // creates the empty trays
       
    }
    
    // Time complexity: O(1)
    public boolean isEmpty(){ //im gonna use this method here to check if my queue is empty!
       return this.front == -1 && this.rear == -1; // return this front -1 when rear it is also -1
    }
    
    // Time complexity: O(1)
    public boolean isFull(){ 
      return (this.rear + 1) % this.capacity == this.front;
        // in a circular queue this is the formula that i use to check if the queue is full      
        // if the next position after rear (with % to wrap) is the front, there is no free tray
        // max limit of rear = capacity +(-1) + %(modolus) of my maximum value and then i compare w/ my front position
    }   
    
    // Time complexity: O(1) - circular queue: no shifting, rear just wraps around with %
    public void enqueue(FoodItem item) { // i use enqueue when i want to insert an item; rear +1
        if (isFull()) {                       // no free tray, so stop here
            System.out.println("Storage is full!"); //message saying the storage is full
            return;
        }
        if (isEmpty()) {
            this.front = 0;
            this.rear = 0;
        } else {
            this.rear = (this.rear + 1) % this.capacity;   // walk forward AND wrap to 0
        }
        this.trays[this.rear] = item;
    }
    
    // Time complexity: O(1) - circular queue: no shifting, front just wraps around with %
    public FoodItem dequeue(){ //dequeue is when i want to remove an item; front +1
        if (isEmpty()) { //first im gonna check if my queue is empty
            System.out.println("Queue is empty"); // a message saying it is empty
            return null;   
        }
        
        FoodItem removeItem = this.trays[this.front];
        //fifo -first in first out - the first element to leave my queue it is going to be in the front
        if(this.front == this.rear) { // this happens if the front and the rear are in the same direction 
            this.front = -1;
            this.rear = -1; 
         // before the last dequeue if front == rear there is only one item left 
         // if thats the case its gonna remove that item and now the queue is empty
         
        } else {
            this.front = (this.front +1) % this.capacity; // (front +1) % capacity
        }
        
        return removeItem;
    }
    
    // peek = just LOOK at the next food, without taking it out
    // Time complexity: O(1)
    public FoodItem peek() {
        if (isEmpty()) {
            return null; // dont show nothing 
        }
        return this.trays[this.front]; // fifo: the next one out is at the front
    }
    
    // display = walk around the round bar from the front to the rear, showing every food
    // Time complexity: O(n) - one print for each food in the queue
    public void display() { // basically displays the whole food storage 
        if (isEmpty()) {
            System.out.println("Storage is empty!"); //if it is empty it is gonna display this message
            return;
        }
        int i = this.front; // start at the first food; i - it is like a finger pointing at the tray
        while (i != this.rear) { // while my "finger" is not on the last food keep walking until we reach the last one; 
            System.out.println(this.trays[i].getDetails()); // this trays[i] - the foof item on the tray i; 
                                                            //get details describes itself in one line
            i = (i + 1) % this.capacity; // next tray (wraps from the last tray back to 0)
            
        }
        System.out.println(this.trays[this.rear].getDetails()); // the loop stops AT rear, so print the last one too
    }
    
    // search = the same walk, but comparing the ID of each card (linear search)
    // Time complexity: O(n) - worst case: the ID is the last one or does not exist
    public FoodItem searchById(int id) {
        if (isEmpty()) {
            return null;
        }
        int i = this.front;
        while (i != this.rear) {
            if (this.trays[i].getId() == id) { // is this the one?
                return this.trays[i]; // found it, stop here
            }
            i = (i + 1) % this.capacity;
        }
        if (this.trays[this.rear].getId() == id) { // check the last one too
            return this.trays[this.rear];
        }
        return null; // not found :(
    }
}
