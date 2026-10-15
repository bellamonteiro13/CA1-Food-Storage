package foodstorage;

import java.util.Scanner;
import java.time.LocalDate; //holds a date (the best before)
import java.time.format.DateTimeFormatter; // reads/shows a date with dd/MM/yyyy
import java.time.format.DateTimeParseException; //this is for errors - when the chef types and invalid date  

public class FoodStorage {



public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    String [] foods = {"Burger", "Pizza", "Fries", "Sandwich", "Hotdog"};
        
    // created BEFORE the loop, so the while at the end can see it
    // it starts empty, so the first answer is always checked
    String storageOption = "";
    
    do {
        System.out.println("--------------------------------");
        System.out.println("   Choose an option first:     ");
        System.out.println("--------------------------------");
        System.out.println(" 1:Stack ");
        System.out.println(" 2:Queue");
        System.out.println("--------------------------------");
        System.out.print("Select one: ");
        storageOption = keyboard.nextLine().trim(); // trim() removes extra spaces before/after the answer
        System.out.println("");
        
        // only "1" or "2" are accepted, anything else shows an error
        if (!storageOption.equals("1") && !storageOption.equals("2")) {
            System.out.println("Invalid option. Please type 1 or 2.");
            System.out.println("");
        }
        
    } while (!storageOption.equals("1") && !storageOption.equals("2")); // repeat while the answer is NOT 1 AND NOT 2
    
    // ----- how many trays? (between 1 and 10) -----
    // starts at 0 (an invalid size), so the loop always asks at least once
    int storageSize = 0;
    
    do {
        System.out.print("How many trays does the storage have? (1-10): ");
        String sizeAnswer = keyboard.nextLine().trim();
        System.out.println("");
        
        // parseInt turns the text into a number, e.g. "7" -> 7
        // if the chef types letters (e.g. "abc"), parseInt fails, so catch makes the size 0 (invalid) instead of crashing
        try {
            storageSize = Integer.parseInt(sizeAnswer);
        } catch (NumberFormatException e) {
            storageSize = 0;
        }
        
        // only 1 to 10 trays are accepted
        if (storageSize < 1 || storageSize > 10) {
            System.out.println("Invalid size. Please type a number between 1 and 10.");
            System.out.println("");
        }
        
    } while (storageSize < 1 || storageSize > 10); // repeat while the size is smaller than 1 OR bigger than 10
    
    System.out.println("Storage created with " + storageSize + " trays.");
    System.out.println("");
    
    // i need two options cause it is like two storage rooms ready, but the chef is going to pick up the one he wants
    // storagesize it is my constructor cause i dont know the size of the tray the chef it is gonna input
    FoodStack stack = new FoodStack(storageSize); // here im creating an option for the stack trays
    FoodQueue queue = new FoodQueue(storageSize); // here it is the queue option ; 
    
    int nextId = 1; //that is the ticket counter! 
    
    String menuOption = ""; // im creating my string menuoption for the food
    
    
    //here im gonna display my storage food menu
    do { //keep showing me menu 
        System.out.println("---------------------------------");
        System.out.println("       STORAGE FOOD MENU      ");
        System.out.println("---------------------------------");
        System.out.println("1. Add food");                  
        System.out.println("2. Display all food items");               
        System.out.println("3. View next Food");  
        System.out.println("4. Search food item by ID");          
        System.out.println("5. Remove next food item");              
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
        
        menuOption = keyboard.nextLine().trim(); //here im colleting the input of the user
        System.out.println("");
        
        // the switch is INSIDE the loop, so it runs every time the chef chooses an option
        switch (menuOption) { // what the chef typed
            case "1": {                                  // if the chef typed "1" he is gonna add 
                 
                boolean storageFull;
                
                if (storageOption.equals("1")) { //if the chef choose stack 
                     storageFull = stack.isFull();    // question to make sure if the stack is full
               
                } else {                         // if it is not stack it is gonna be queue
                    storageFull = queue.isFull();    // question to know if the queue is full
                    
                    }
                
                if (storageFull){
                    System.out.println("Storage is full! Remove a food item first.");
                    break;
                }
                
                int foodChoice = 0;
                
                do { 
                    System.out.println("Choose the food:");
                    
                for (int i = 0; i < foods.length; i++) { // im gonna insert the for here; if the chef gets it wrong, the loop goes back to the start
                    System.out.println((i + 1) + ". " + foods[i]); // inside the do, right after "Choose the food:" 
                } 
                
                    System.out.print("Select one (1-5): "); 
                    String foodAnswer = keyboard.nextLine().trim(); 
                    try { 
                        foodChoice = Integer.parseInt(foodAnswer);
                    } catch (NumberFormatException e) { 
                        foodChoice = 0; 
                    } 
                    if (foodChoice < 1 || foodChoice > 5) { // if the chef tries to input a number small than 01 and bigger than 5
                        System.out.println("Invalid food. Please type a number between 1 and 5."); 
                    } 
                
                } while (foodChoice < 1 || foodChoice > 5);
                
                String foodName = foods[foodChoice - 1];
                
                int weight = 0;
                
                 do {
                    
                        System.out.print("Select the weight in grams: "); //the weight it is gonna be measured in grams
                        String weightAnswer = keyboard.nextLine().trim(); 
                    try { 
                        weight = Integer.parseInt(weightAnswer);
                    } catch (NumberFormatException e) { //my exception
                        weight = 0; 
                    } 
                    if (weight < 1) { // if the chef tries to input a number small than 01 
                        System.out.println("Invalid weight. Please type a number bigger than 0."); 
                    } 
                
                } while (weight < 1);
                 
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //the expired date:day/month/year
                LocalDate today = LocalDate.now();            // the today's date (it is gonna use the date on the computer's clock)
                LocalDate maxDate = today.plusDays(14);       // today + 14 days = that is the limit (2 weeks)
                LocalDate bestBefore = null;                  // null = it means no valid date yet
                
                do {
                    System.out.print("Best-before date (dd/MM/yyyy):");
                    String dateAnswer = keyboard.nextLine().trim();
                    try{
                        bestBefore = LocalDate.parse(dateAnswer, dateFormat); // turns the text input into a real date! that is magical 
                        if(bestBefore.isBefore(today) || bestBefore.isAfter(maxDate)) {
                        System.out.println("Invalid date. It must be between today and " +maxDate.format(dateFormat) + ".");
                        // this is gonna make sure that the chefs could only insert today date 
                        bestBefore = null; //  back to "no date" it is not acceptable
                    }
                    } catch (DateTimeParseException e) { //in case chef typed something that isn't dd//MM/yyyy
                        System.out.println("Invalid Format! Please use dd/MM/yyyy.");
                        bestBefore = null;
                        
                    }
                }
                 while (bestBefore == null);
                
                FoodItem newFood = new FoodItem(nextId, foodName, weight, bestBefore);  // prints the card!

                if (storageOption.equals("1")) { // 
                    stack.push(newFood);          // stack: on the top of the file
                } else {
                    queue.enqueue(newFood);       // queue: at the rear of the line
                }

                    nextId++;  // ticket count + 1 ; the next food gets the next number
                    System.out.println("Food added: " + newFood.getDetails()); // confirms to the chef using the card describing itself

                break;                                  // stop 
            }
            case "2":                                   // show every food in the storage
                System.out.println("Display all food items: coming soon!");
                break;
            
            case "3":                                   // show the next food (top of the stack / front of the queue)
                System.out.println("View next food: coming soon!");
                break;
            
            case "4":                                   // look for one food using its ID
                System.out.println("Search food item by ID: coming soon!");
                break;
            
            case "5":                                   // take out the next food
                System.out.println("Remove next food item: coming soon!");
                break;
            
            case "0":
                System.out.println("Okay, goodbye!");
                break;
            
            default:                                    // ANY other answer
                System.out.println("Invalid option. Please type 0 to 5.");
                break;
        }
        System.out.println("");
    
    } while (!menuOption.equals("0")); //while the answer is not 0!
    
    // montar o menu de opcoes para food!
    // adicionar os arquivos de estrutura(queue, stack)
    // criar o objeto food item (: (oop) mt dificil esse crlh
    // vincular o adicionar do menu com as estruturas 
    // testar vinculo criado (pedir a bestie pra fazer)
    //    "1", "Add food item"
    //"2", "Display all food items"
   //"3", "View next food item"
   //"4", "Search food item by ID"
   //"5", "Remove next food item"
    
}

}    



