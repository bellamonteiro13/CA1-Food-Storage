package foodstorage;

// stack = LIFO (last in, first out)
// like a pile of trays: you put on the TOP and you take from the TOP
// it does not need % because it never goes around, it only goes up and down

// ===================== TIME COMPLEXITY (stack, LIFO) =====================
// isEmpty()    O(1) - only checks top, one comparison
// isFull()     O(1) - only compares top with capacity - 1
// push()       O(1) - top goes up one tray, nothing else moves
// pop()        O(1) - top goes down one tray, nothing else moves
// peek()       O(1) - goes straight to trays[top]
// display()    O(n) - has to visit every food from top to bottom
// searchById() O(n) - linear search: worst case checks all n foods (data is not sorted by ID)
// =========================================================================
public class FoodStack {
    
    private int top;          // position of the food on the top of the pile
    private int capacity;     // how many trays (the chef's answer)
    private FoodItem[] trays; // the trays, each one holds one FoodItem card
    
    public FoodStack(int size) {
        this.capacity = size;
        this.top = -1;                     // -1 = the pile is empty
        this.trays = new FoodItem[size];   // creates the empty trays
    }
    
    // Time complexity: O(1)
    public boolean isEmpty() {
        return this.top == -1;
    }
    
    // Time complexity: O(1)
    public boolean isFull() {
        return this.top == this.capacity - 1; // the last tray is capacity - 1 (it starts at 0)
    }
    
    // push = put a new food on the top
    // Time complexity: O(1) - always works at the top, no loop
    public void push(FoodItem item) {
        if (isFull()) {
            System.out.println("Storage is full!");
            return;
        }
        this.top++;                    // go up one tray
        this.trays[this.top] = item;   // put the food there
    }
    
    // pop = take out the food from the top (the LAST one that came in)
    // Time complexity: O(1) - always works at the top, no loop
    public FoodItem pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        FoodItem removeItem = this.trays[this.top]; // save the top food before removing it
        this.trays[this.top] = null;                // clean the tray
        this.top--;                                 // go down one tray
        return removeItem;
    }
    
    // peek = just LOOK at the top food, without taking it out
    // Time complexity: O(1)
    public FoodItem peek() {
        if (isEmpty()) {
            return null;
        }
        return this.trays[this.top];
    }
    
    // display = show the pile from the top to the bottom
    // Time complexity: O(n) - one print for each food in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return;
        }
        for (int i = this.top; i >= 0; i--) { // start at the top and go down to tray 0
            System.out.println(this.trays[i].getDetails()); // 
        }
    }
    
    // search = check every card from the top to the bottom (linear search)
    // Time complexity: O(n) - worst case: the ID is at the bottom or does not exist
    public FoodItem searchById(int id) {
        for (int i = this.top; i >= 0; i--) { // if the stack is empty, top is -1 so the loop doesnt even start
            if (this.trays[i].getId() == id) {
                return this.trays[i];
            }
        }
        return null; // not found
    }
}
