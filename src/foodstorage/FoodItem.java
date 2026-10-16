package foodstorage;

import java.time.LocalDate; // a date only - so we can have a control of best-before

import java.time.LocalDateTime; // the date/time when the chef add a new food

import java.time.format.DateTimeFormatter; // changes how the date is shown, e.g. 2026-10-22 -> 22/10/2026

//im creating this class so i can update every card of new food
//with fooditem my stack and the queue only need ONE array of cards!!!

public class FoodItem {
    
    private int id;
    private String foodType;
    private String name;
    private int weight;   // in grams
    private LocalDate bestBefore;
    private LocalDateTime timeAdded;
    
    //private = others classes could not access and/or change these directly, they can only read them with the getters
    //remember: this is called encapsulation (important core of OOP)
    
    public FoodItem (int id, String foodType, String name, int weight, LocalDate bestBefore){ //info that the chef it is gonna insert
        this.id = id;
        this.foodType = foodType;
        this.name = name;
        this.weight = weight; 
        this.bestBefore = bestBefore;
        this.timeAdded = LocalDateTime.now(); //this is a good one cause the clock itself it is gonna fill this part for us 
        //that means that the chef cannot fake the time!!!
    }
    
    public int getId() { // public method (getter) to read the private ID, the search uses it to compare the IDs
        return id;
    }
    
    // each FoodItem is like a label card; get details is the card reading itself out lod in a sentence
    // written ONCE here, so the queue and the stack can both reuse it
    public String getDetails() { // 
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "ID: " + id + " | " + foodType + " | " + name + " | " + weight + "g"
             + " | Best before: " + bestBefore.format(dateFormat)
             + " | Added: " + timeAdded.format(timeFormat);
    }
}
