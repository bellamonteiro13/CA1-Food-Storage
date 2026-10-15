package foodstorage;

import java.time.LocalDate; // a date only - so we can have a control of best-before

import java.time.LocalDateTime; // the date/time when the chef add a new food

import java.time.format.DateTimeFormatter; // changes how the date is shown, e.g. 2026-10-22 -> 22/10/2026

//im creating this class so i can update every card of new food
//with fooditem my stack and the queue only need ONE array of cards!!!

public class FoodItem {
    
    private int id;
    private String name;
    private int weight;   // in grams
    private LocalDate bestBefore;
    private LocalDateTime timeAdded;
    
    //private = others classes could not change these directly, they can only read them with the getters
    //remember: this is called encapsulation (important core of OOP)
    
    public FoodItem (int id, String name, int weight, LocalDate bestBefore){ //info that the chef it is gonna insert
        this.id = id;
        this.name = name;
        this.weight = weight; 
        this.bestBefore = bestBefore;
        this.timeAdded = LocalDateTime.now(); //this is a good one cause the clock itself it is gonna fill this part for us 
        //that means that the chef cannot fake the time!!!
    }
    
    //this is a getter - like windows to read the card; a getter it is like give me the value of this field
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public LocalDateTime getTimeAdded() {
        return timeAdded;
    }
    
    // the card describes itself in one line
    // written ONCE here, so the queue and the stack can both reuse it
    public String getDetails() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "ID: " + id + " | " + name + " | " + weight + "g"
             + " | Best before: " + bestBefore.format(dateFormat)
             + " | Added: " + timeAdded.format(timeFormat);
    }
}
