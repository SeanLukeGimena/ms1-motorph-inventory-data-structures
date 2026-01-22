import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

/**
 * StackInventory - Manages inventory using a Stack (LIFO - Last In First Out)
 * Demonstrates: Stack data structure, push/pop operations, LIFO processing
 */
public class StackInventory {
    // Variables - Stack for inventory and scanner for input
    private Stack<InventoryItem> inventoryStack;
    private Scanner scanner;
    
    // Constructor
    public StackInventory() {
        this.inventoryStack = new Stack<>();
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Load inventory from CSV file
     * Input: CSV file path
     * Output: Number of items loaded
     * Control Structure: while loop, for-each loop
     */
    public int loadInventoryFromCSV(String filename) {
        ArrayList<InventoryItem> tempStorage = new ArrayList<>();  // Temporary storage
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            // Skip first two header lines
            br.readLine();
            br.readLine();
            
            // Control Structure: While loop to read all records
            while ((line = br.readLine()) != null) {
                // Parse CSV line
                String[] data = line.split(",");
                
                // Control Structure: If condition to validate data
                if (data.length >= 5) {
                    // Create new inventory item
                    InventoryItem item = new InventoryItem(
                        data[0].trim(),  // dateEntered
                        data[1].trim(),  // stockLabel
                        data[2].trim(),  // brand
                        data[3].trim(),  // engineNumber
                        data[4].trim()   // status
                    );
                    tempStorage.add(item);
                }
            }
            
            // Control Structure: For-each loop to push items onto stack
            for (InventoryItem item : tempStorage) {
                inventoryStack.push(item);  // Push to stack
            }
            
            // Output: Display load confirmation
            System.out.println("Loaded " + inventoryStack.size() + " items into stack.");
            return inventoryStack.size();
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Push new item to stack
     * Input: InventoryItem to push
     * Output: Confirmation message
     */
    public void pushItem(InventoryItem item) {
        inventoryStack.push(item);  // Push to stack
        // Output: Confirmation
        System.out.println("Item pushed to stack: " + item.getEngineNumber());
    }
    
    /**
     * Pop item from stack
     * Output: Popped item or null if empty
     * Control Structure: if-else condition
     */
    public InventoryItem popItem() {
        // Control Structure: Check if stack is empty
        if (inventoryStack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            InventoryItem item = inventoryStack.pop();  // Pop from stack
            // Output: Display popped item
            System.out.println("\nPopped item:");
            System.out.println(InventoryItem.getHeader());
            System.out.println(item.toString());
            return item;
        }
    }
    
    /**
     * Peek at top item without removing
     * Output: Top item or null if empty
     * Control Structure: if-else condition
     */
    public InventoryItem peekTop() {
        // Control Structure: Check if stack is empty
        if (inventoryStack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            InventoryItem item = inventoryStack.peek();  // Peek at top
            // Output: Display top item
            System.out.println("\nTop item:");
            System.out.println(InventoryItem.getHeader());
            System.out.println(item.toString());
            return item;
        }
    }
    
    /**
     * Display all items in stack (non-destructive)
     * Output: All items in stack
     * Control Structure: if-else, while loops
     */
    public void displayStack() {
        // Output: Print header
        System.out.println("\n=== Inventory Stack (LIFO) ===");
        System.out.println("Stack Size: " + inventoryStack.size());
        
        // Control Structure: Check if empty
        if (inventoryStack.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        
        System.out.println(InventoryItem.getHeader());
        System.out.println("=".repeat(80));
        
        // Create temporary stack for non-destructive display
        Stack<InventoryItem> tempStack = new Stack<>();
        int position = 1;
        
        // Control Structure: While loop to pop all items for display
        while (!inventoryStack.isEmpty()) {
            InventoryItem item = inventoryStack.pop();
            System.out.println(position + ". " + item.toString());
            tempStack.push(item);  // Save to temp stack
            position++;
        }
        
        // Control Structure: While loop to restore original stack
        while (!tempStack.isEmpty()) {
            inventoryStack.push(tempStack.pop());
        }
    }
    
    /**
     * Process sold items (remove from stack)
     * Output: Number of sold items processed
     * Control Structure: while loops, if condition
     */
    public void processSoldItems() {
        int soldCount = 0;  // Variable: counter for sold items
        Stack<InventoryItem> tempStack = new Stack<>();
        
        // Control Structure: Process entire stack
        while (!inventoryStack.isEmpty()) {
            InventoryItem item = inventoryStack.pop();
            
            // Control Structure: Check if sold
            if (item.getStatus().equalsIgnoreCase("Sold")) {
                soldCount++;
                // Output: Processing confirmation
                System.out.println("Processed sold item: " + item.getEngineNumber());
            } else {
                // Keep on-hand items
                tempStack.push(item);
            }
        }
        
        // Control Structure: Restore on-hand items to stack
        while (!tempStack.isEmpty()) {
            inventoryStack.push(tempStack.pop());
        }
        
        // Output: Summary
        System.out.println("\nTotal sold items processed (removed): " + soldCount);
        System.out.println("Remaining items in stack: " + inventoryStack.size());
    }
    
    /**
     * Search for item by engine number (non-destructive)
     * Input: Engine number
     * Output: Found item or null
     * Control Structure: while loops, if condition
     */
    public InventoryItem searchByEngineNumber(String engineNum) {
        Stack<InventoryItem> tempStack = new Stack<>();
        InventoryItem foundItem = null;
        
        // Control Structure: Search through stack
        while (!inventoryStack.isEmpty()) {
            InventoryItem item = inventoryStack.pop();
            
            // Control Structure: Check if match found
            if (item.getEngineNumber().equalsIgnoreCase(engineNum)) {
                foundItem = item;  // Save found item
            }
            tempStack.push(item);
        }
        
        // Control Structure: Restore stack
        while (!tempStack.isEmpty()) {
            inventoryStack.push(tempStack.pop());
        }
        
        return foundItem;
    }
    
    /**
     * Count items by brand (non-destructive)
     * Input: Brand name
     * Output: Count of matching items
     * Control Structure: while loops, if condition
     */
    public int countByBrand(String brandName) {
        int count = 0;
        Stack<InventoryItem> tempStack = new Stack<>();
        
        // Control Structure: Count through stack
        while (!inventoryStack.isEmpty()) {
            InventoryItem item = inventoryStack.pop();
            
            // Control Structure: Check brand match
            if (item.getBrand().equalsIgnoreCase(brandName)) {
                count++;
            }
            tempStack.push(item);
        }
        
        // Control Structure: Restore stack
        while (!tempStack.isEmpty()) {
            inventoryStack.push(tempStack.pop());
        }
        
        return count;
    }
    
    /**
     * Display menu
     * Output: Menu options
     */
    private void displayMenu() {
        System.out.println("\n=== Stack-Based Inventory Menu (LIFO) ===");
        System.out.println("1. Push Item (Add to top)");
        System.out.println("2. Pop Item (Remove from top)");
        System.out.println("3. Peek Top Item");
        System.out.println("4. Display Stack");
        System.out.println("5. Process Sold Items");
        System.out.println("6. Search by Engine Number");
        System.out.println("7. Count by Brand");
        System.out.println("8. Exit");
        System.out.print("Enter choice: ");
    }
    
    /**
     * Main menu loop
     * Control Structure: do-while loop, switch-case
     */
    public void run() {
        int choice;  // Variable: user choice
        
        // Control Structure: Do-while loop for menu
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            // Control Structure: Switch-case for menu options
            switch (choice) {
                case 1:
                    // Push new item
                    System.out.println("Enter item details:");
                    System.out.print("Date Entered: ");
                    String date = scanner.nextLine();
                    System.out.print("Stock Label: ");
                    String label = scanner.nextLine();
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Engine Number: ");
                    String engine = scanner.nextLine();
                    System.out.print("Status: ");
                    String status = scanner.nextLine();
                    
                    InventoryItem newItem = new InventoryItem(date, label, brand, engine, status);
                    pushItem(newItem);
                    break;
                    
                case 2:
                    // Pop item
                    popItem();
                    break;
                    
                case 3:
                    // Peek top
                    peekTop();
                    break;
                    
                case 4:
                    // Display stack
                    displayStack();
                    break;
                    
                case 5:
                    // Process sold items
                    processSoldItems();
                    break;
                    
                case 6:
                    // Search by engine number
                    System.out.print("Enter Engine Number: ");
                    String searchEngine = scanner.nextLine();
                    InventoryItem result = searchByEngineNumber(searchEngine);
                    
                    // Control Structure: If-else for search result
                    if (result != null) {
                        System.out.println("\nItem Found:");
                        System.out.println(InventoryItem.getHeader());
                        System.out.println(result.toString());
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;
                    
                case 7:
                    // Count by brand
                    System.out.print("Enter Brand Name: ");
                    String brandName = scanner.nextLine();
                    int count = countByBrand(brandName);
                    System.out.println("Total " + brandName + " items in stack: " + count);
                    break;
                    
                case 8:
                    // Exit
                    System.out.println("Exiting Stack Inventory System...");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 8);  // Control Structure: Continue until exit
    }
    
    /**
     * Main method - Entry point
     */
    public static void main(String[] args) {
        // Create instance of StackInventory
        StackInventory inventory = new StackInventory();
        
        // Load data from CSV file
        String csvPath = "csv/MotorPH Inventory Data - March 2023 Inventory Data.csv";
        inventory.loadInventoryFromCSV(csvPath);
        
        // Run the menu system
        inventory.run();
    }
}
