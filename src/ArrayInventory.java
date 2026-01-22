import java.io.*;
import java.util.Scanner;

/**
 * ArrayInventory - Manages inventory using a fixed-size Array
 * Demonstrates: Array data structure, linear search, and basic operations
 */
public class ArrayInventory {
    // Variables - Fixed size array and item counter
    private static final int MAX_SIZE = 100;
    private InventoryItem[] inventoryArray;
    private int itemCount;
    private Scanner scanner;
    
    // Constructor
    public ArrayInventory() {
        this.inventoryArray = new InventoryItem[MAX_SIZE];
        this.itemCount = 0;
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Load inventory from CSV file
     * Input: CSV file path
     * Output: Number of items loaded
     * Control Structures: while loop, if condition
     */
    public int loadInventoryFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            // Skip first two header lines
            br.readLine();
            br.readLine();
            
            // Control Structure: While loop to read all records
            while ((line = br.readLine()) != null && itemCount < MAX_SIZE) {
                // Parse CSV line
                String[] data = line.split(",");
                
                // Control Structure: If condition to validate data
                if (data.length >= 5) {
                    // Create new inventory item and add to array
                    inventoryArray[itemCount] = new InventoryItem(
                        data[0].trim(),  // dateEntered
                        data[1].trim(),  // stockLabel
                        data[2].trim(),  // brand
                        data[3].trim(),  // engineNumber
                        data[4].trim()   // status
                    );
                    itemCount++;  // Increment counter
                }
            }
            
            // Output: Display load confirmation
            System.out.println("Loaded " + itemCount + " items from CSV file.");
            return itemCount;
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Display all items in the array
     * Output: Formatted list of all inventory items
     * Control Structure: for loop
     */
    public void displayAllItems() {
        // Output: Print header
        System.out.println("\n=== Inventory Items (Array Implementation) ===");
        System.out.println("Total Items: " + itemCount);
        System.out.println(InventoryItem.getHeader());
        System.out.println("=".repeat(80));
        
        // Control Structure: For loop to iterate through array
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + inventoryArray[i].toString());
        }
    }
    
    /**
     * Search for item by engine number using linear search
     * Input: Engine number to search
     * Output: Found item or null
     * Control Structure: for loop, if condition
     */
    public InventoryItem searchByEngineNumber(String engineNum) {
        // Control Structure: Linear search through array
        for (int i = 0; i < itemCount; i++) {
            // Control Structure: If condition to check match
            if (inventoryArray[i].getEngineNumber().equalsIgnoreCase(engineNum)) {
                return inventoryArray[i];  // Return found item
            }
        }
        return null;  // Not found
    }
    
    /**
     * Count items by brand name
     * Input: Brand name
     * Output: Count of matching items
     * Control Structure: for loop, if condition
     */
    public int countByBrand(String brandName) {
        int count = 0;  // Variable: counter
        
        // Control Structure: Loop through array
        for (int i = 0; i < itemCount; i++) {
            // Control Structure: If condition to check brand
            if (inventoryArray[i].getBrand().equalsIgnoreCase(brandName)) {
                count++;  // Increment counter
            }
        }
        return count;
    }
    
    /**
     * Count items by status
     * Input: Status (On-hand or Sold)
     * Output: Count of matching items
     * Control Structure: for loop, if condition
     */
    public int countByStatus(String status) {
        int count = 0;
        
        // Control Structure: Iterate through array
        for (int i = 0; i < itemCount; i++) {
            if (inventoryArray[i].getStatus().equalsIgnoreCase(status)) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Display menu and get user choice
     * Input: User menu selection
     * Output: Menu display
     */
    private void displayMenu() {
        System.out.println("\n=== Array-Based Inventory Menu ===");
        System.out.println("1. Display All Items");
        System.out.println("2. Search by Engine Number");
        System.out.println("3. Count by Brand");
        System.out.println("4. Count by Status");
        System.out.println("5. Display Statistics");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }
    
    /**
     * Display inventory statistics
     * Output: Statistics about inventory
     * Control Structure: for loop
     */
    public void displayStatistics() {
        System.out.println("\n=== Inventory Statistics ===");
        System.out.println("Total Items: " + itemCount);
        System.out.println("On-hand Items: " + countByStatus("On-hand"));
        System.out.println("Sold Items: " + countByStatus("Sold"));
        
        // Count unique brands
        System.out.println("\nBrand Distribution:");
        String[] brands = {"Honda", "Yamaha", "Suzuki", "Kawasaki", "Kymco"};
        
        // Control Structure: For loop through brands
        for (String brand : brands) {
            int count = countByBrand(brand);
            // Control Structure: If condition to display only if count > 0
            if (count > 0) {
                System.out.println("  " + brand + ": " + count);
            }
        }
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
                    // Display all items
                    displayAllItems();
                    break;
                    
                case 2:
                    // Search by engine number
                    System.out.print("Enter Engine Number: ");
                    String engineNum = scanner.nextLine();
                    InventoryItem result = searchByEngineNumber(engineNum);
                    
                    // Control Structure: If-else for search result
                    if (result != null) {
                        System.out.println("\nItem Found:");
                        System.out.println(InventoryItem.getHeader());
                        System.out.println(result.toString());
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;
                    
                case 3:
                    // Count by brand
                    System.out.print("Enter Brand Name: ");
                    String brandName = scanner.nextLine();
                    int brandCount = countByBrand(brandName);
                    System.out.println("Total " + brandName + " items: " + brandCount);
                    break;
                    
                case 4:
                    // Count by status
                    System.out.print("Enter Status (On-hand/Sold): ");
                    String status = scanner.nextLine();
                    int statusCount = countByStatus(status);
                    System.out.println("Total " + status + " items: " + statusCount);
                    break;
                    
                case 5:
                    // Display statistics
                    displayStatistics();
                    break;
                    
                case 6:
                    // Exit
                    System.out.println("Exiting Array Inventory System...");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);  // Control Structure: Continue until exit
    }
    
    /**
     * Main method - Entry point
     */
    public static void main(String[] args) {
        // Create instance of ArrayInventory
        ArrayInventory inventory = new ArrayInventory();
        
        // Load data from CSV file
        String csvPath = "csv/MotorPH Inventory Data - March 2023 Inventory Data.csv";
        inventory.loadInventoryFromCSV(csvPath);
        
        // Run the menu system
        inventory.run();
    }
}
