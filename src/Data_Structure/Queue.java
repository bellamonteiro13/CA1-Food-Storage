package Data_Structure;

public class Queue {
    
    private int front; // it changes to the front
    private int rear; // it goes back 
    private int capacity; // my capacity im gonna need to know the capacity of the queue
    private String[] arr; //my string array
    
    public Queue(int size) {
        
        this.capacity = size; // here im defying the value of my capacity; i can also use it more than once if i declare here
        this.front = -1;
        this.rear = -1;
        this.arr = new String[size]; // 
       
    }
    
    public boolean isEmpty(){ //im gonna use this method here to check if my queue is empty!
       return this.front == -1 && this.rear == -1;
    }
    
    public boolean isFull(){ 
      return (this.rear + 1) % this.capacity == this.front;
        // in a circular queue this is the formula that i use to check if the queue is full      
        // if my rear +1 = my full capacity i cannot insert one more value!
        // max limit of rear = capacity +(-1) + %(modolus) of my maximum value and then i compare w/ my front position
    }
    
    public void enqueue(String item){
        if (isEmpty()){
            this.front = 0;
            this.rear = 0;
        } else {
            this.rear++; // here im saying like if there is still space in my queue add one
        }
        
        this.arr[this.rear]= item; // 
    }

    
}

// (rear +1) % capacity

// 
