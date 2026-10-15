package foodstorage;

import java.util.Scanner;


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
            case "1":                                   // if the chef typed "1" he is gonna add 
                System.out.println("Add food: coming soon!");   
                break;                                  // stop 
            
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



