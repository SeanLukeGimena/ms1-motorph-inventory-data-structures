import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ArrayListInventory - Manages inventory using ArrayList (dynamic array)
 * Demonstrates: ArrayList data structure, dynamic resizing, sorting, filtering
 * 
 * KEY ADVANTAGES OF ARRAYLIST:
 * - DYNAMIC SIZE: Automatically grows as needed - no size limit
 * - AUTOMATIC MANAGEMENT: Built-in .size() method, no manual counting
 * - RICH OPERATIONS: .add(), .remove(), .contains(), .sort() methods
 * - FLEXIBLE: Can insert/delete items at any position easily
 * - CONVENIENT: Many built-in methods for common operations
 */
public class ArrayListInventory {
    // Variables - ArrayList for inventory and scanner for input
    private ArrayList<InventoryItem> inventoryList;  // DYNAMIC: Grows automatically, no size limit
    private Scanner scanner;
    // NO itemCount variable needed - ArrayList has built-in .size() method
    // NO MAX_SIZE constant needed - unlimited capacity
    
    // Constructor
    public ArrayListInventory() {
        this.inventoryList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Load inventory from CSV file
     * Input: CSV file path
     * Output: Number of items loaded
     * Control Structure: while loop, if condition
     */
    public int loadInventoryFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            // Skip first two header lines
            br.readLine();
            br.readLine();
            
            // Control Structure: While loop - NO SIZE LIMIT CHECK NEEDED
            // ARRAYLIST ADVANTAGE: No need to check capacity, grows automatically
            while ((line = br.readLine()) != null) {  // Notice: No size check like in Array!
                // Parse CSV line
                String[] data = line.split(",");
                
                // Control Structure: If condition to validate data
                if (data.length >= 5) {
                    // Create new inventory item
                    // ARRAYLIST OPERATION: Simple .add() method handles everything
                    InventoryItem item = new InventoryItem(
                        parts[0].trim(),  // dateEntered
                        parts[1].trim(),  // stockLabel
                        parts[2].trim(),  // brand
                        parts[3].trim(),  // engineNumber
                        parts[4].trim()   // status
                    );
                    inventoryList.add(item);  // Automatic resizing - no index, no manual counting
                    // NO manual increment needed - .size() is updated automatically
                }
            }
            
            // Output: Display load confirmation
            System.out.println("Loaded " + inventoryList.size() + " items into ArrayList.");
            return inventoryList.size();
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Display all items in ArrayList
     * Output: Formatted list of all items
     * Control Structure: for-each loop
     */
    public void displayAll() {
        // Output: Print header
        System.out.println("\n=== Inventory ArrayList ===");
        System.out.println("Total Items: " + inventoryList.size());
        System.out.println(InventoryItem.getHeader());
        System.out.println("=".repeat(80));
        
        int index = 1;  // Variable: position counter
        
        // Control Structure: For-each loop to iterate through list
        for (InventoryItem item : inventoryList) {
            System.out.println(index + ". " + item.toString());
            index++;
        }
    }
    
    /**
     * Add new item to ArrayList
     * Input: InventoryItem to add
     * Output: Confirmation message
     */
    public void addItem(InventoryItem item) {
        inventoryList.add(item);  // Add to list
        // Output: Confirmation
        System.out.println("Item added successfully: " + item.getEngineNumber());
        System.out.println("New size: " + inventoryList.size());
    }
    
    /**
     * Remove item by index
     * Input: Index to remove (0-based)
     * Output: true if removed, false if invalid index
     * Control Structure: if-else condition
     */
    public boolean removeItem(int index) {
        // Control Structure: Validate index
        if (index < 0 || index >= inventoryList.size()) {
            System.out.println("Invalid index!");
            return false;
        }
        
        InventoryItem removedItem = inventoryList.remove(index);  // Remove from list
        // Output: Confirmation
        System.out.println("\nRemoved item:");
        System.out.println(InventoryItem.getHeader());
        System.out.println(removedItem.toString());
        System.out.println("New size: " + inventoryList.size());
        return true;
    }
    
    /**
     * Search items by brand
     * Input: Brand name
     * Output: List of matching items
     * Control Structure: for-each loop, if condition
     */
    public ArrayList<InventoryItem> searchByBrand(String brandName) {
        ArrayList<InventoryItem> results = new ArrayList<>();  // Variable: results list
        
        // Control Structure: For-each loop to search
        for (InventoryItem item : inventoryList) {
            // Control Structure: Check if brand matches
            if (item.getBrand().equalsIgnoreCase(brandName)) {
                results.add(item);
            }
        }
        
        // Output: Display results
        System.out.println("\n=== Search Results: " + brandName + " ===");
        System.out.println("Found " + results.size() + " items");
        
        // Control Structure: Display results if any found
        if (!results.isEmpty()) {
            System.out.println(InventoryItem.getHeader());
            System.out.println("=".repeat(80));
            
            int index = 1;
            for (InventoryItem item : results) {
                System.out.println(index + ". " + item.toString());
                index++;
            }
        }
        
        return results;
    }
    
    /**
     * Filter by status
     * Input: Status type (On-hand or Sold)
     * Output: List of matching items
     * Control Structure: for-each loop, if condition
     */
    public ArrayList<InventoryItem> filterByStatus(String statusType) {
        ArrayList<InventoryItem> filtered = new ArrayList<>();
        
        // Control Structure: For-each loop to filter
        for (InventoryItem item : inventoryList) {
            // Control Structure: Check if status matches
            if (item.getStatus().equalsIgnoreCase(statusType)) {
                filtered.add(item);
            }
        }
        
        return filtered;
    }
    
    /**
     * Sort by brand using bubble sort
     * Output: Confirmation message
     * Control Structure: nested for loops, if condition
     */
    public void sortByBrand() {
        int n = inventoryList.size();
        
        // Control Structure: Bubble sort outer loop
        for (int i = 0; i < n - 1; i++) {
            // Control Structure: Bubble sort inner loop
            for (int j = 0; j < n - i - 1; j++) {
                // Control Structure: Compare adjacent items
                if (inventoryList.get(j).getBrand().compareToIgnoreCase(
                        inventoryList.get(j + 1).getBrand()) > 0) {
                    // Swap items
                    InventoryItem temp = inventoryList.get(j);
                    inventoryList.set(j, inventoryList.get(j + 1));
                    inventoryList.set(j + 1, temp);
                }
            }
        }
        
        // Output: Confirmation
        System.out.println("List sorted by brand (ascending order)");
    }
    
    /**
     * Sort by date using bubble sort
     * Output: Confirmation message
     * Control Structure: nested for loops, if condition
     */
    public void sortByDate() {
        int n = inventoryList.size();
        
        // Control Structure: Bubble sort algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Control Structure: Compare dates
                if (inventoryList.get(j).getDateEntered().compareToIgnoreCase(
                        inventoryList.get(j + 1).getDateEntered()) > 0) {
                    // Swap items
                    InventoryItem temp = inventoryList.get(j);
                    inventoryList.set(j, inventoryList.get(j + 1));
                    inventoryList.set(j + 1, temp);
                }
            }
        }
        
        // Output: Confirmation
        System.out.println("List sorted by date (ascending order)");
    }
    
    /**
     * Update item status by engine number
     * Input: Engine number and new status
     * Output: true if updated, false if not found
     * Control Structure: for loop, if condition
     */
    public boolean updateStatus(String engineNumber, String newStatus) {
        boolean found = false;
        
        // Control Structure: Search and update
        for (int i = 0; i < inventoryList.size(); i++) {
            // Control Structure: Check if engine number matches
            if (inventoryList.get(i).getEngineNumber().equalsIgnoreCase(engineNumber)) {
                String oldStatus = inventoryList.get(i).getStatus();
                inventoryList.get(i).setStatus(newStatus);  // Update status
                found = true;
                // Output: Confirmation
                System.out.println("\nStatus updated successfully!");
                System.out.println("Engine Number: " + engineNumber);
                System.out.println("Old Status: " + oldStatus);
                System.out.println("New Status: " + newStatus);
                break;  // Exit loop after finding
            }
        }
        
        // Control Structure: Check if found
        if (!found) {
            System.out.println("Item not found with engine number: " + engineNumber);
        }
        
        return found;
    }
    
    /**
     * Get comprehensive statistics
     * Output: Statistics about inventory
     * Control Structure: for-each loop, if-else conditions
     */
    public void getStatistics() {
        int totalItems = inventoryList.size();
        int onHandCount = 0;
        int soldCount = 0;
        int oldStockCount = 0;
        int newStockCount = 0;
        Map<String, Integer> brandCounts = new HashMap<>();
        
        // Control Structure: Calculate statistics
        for (InventoryItem item : inventoryList) {
            // Count by status
            // Control Structure: If-else for status
            if (item.getStatus().equalsIgnoreCase("On-hand")) {
                onHandCount++;
            } else if (item.getStatus().equalsIgnoreCase("Sold")) {
                soldCount++;
            }
            
            // Count by stock label
            // Control Structure: If-else for stock label
            if (item.getStockLabel().equalsIgnoreCase("Old")) {
                oldStockCount++;
            } else if (item.getStockLabel().equalsIgnoreCase("New")) {
                newStockCount++;
            }
            
            // Count by brand
            String brand = item.getBrand();
            // Control Structure: If-else for brand counting
            if (brandCounts.containsKey(brand)) {
                brandCounts.put(brand, brandCounts.get(brand) + 1);
            } else {
                brandCounts.put(brand, 1);
            }
        }
        
        // Output: Display statistics
        System.out.println("\n=== Comprehensive Inventory Statistics ===");
        System.out.println("\nGeneral Statistics:");
        System.out.println("  Total Items: " + totalItems);
        System.out.println("  On-hand Items: " + onHandCount + " (" + 
                           String.format("%.1f%%", (onHandCount * 100.0 / totalItems)) + ")");
        System.out.println("  Sold Items: " + soldCount + " (" + 
                           String.format("%.1f%%", (soldCount * 100.0 / totalItems)) + ")");
        
        System.out.println("\nStock Label Distribution:");
        System.out.println("  Old Stock: " + oldStockCount);
        System.out.println("  New Stock: " + newStockCount);
        
        System.out.println("\nBrand Distribution:");
        // Control Structure: For-each loop to display brand counts
        for (Map.Entry<String, Integer> entry : brandCounts.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue() + " (" +
                               String.format("%.1f%%", (entry.getValue() * 100.0 / totalItems)) + ")");
        }
    }
    
    /**
     * Search by engine number
     * Input: Engine number
     * Output: Found item or null
     * Control Structure: for-each loop, if condition
     */
    public InventoryItem searchByEngineNumber(String engineNumber) {
        // Control Structure: Search through list
        for (InventoryItem item : inventoryList) {
            // Control Structure: Check if match
            if (item.getEngineNumber().equalsIgnoreCase(engineNumber)) {
                return item;
            }
        }
        return null;  // Not found
    }
    
    /**
     * Display menu
     * Output: Menu options
     */
    private void displayMenu() {
        System.out.println("\n=== ArrayList-Based Inventory Menu ===");
        System.out.println("1. Display All Items");
        System.out.println("2. Add Item");
        System.out.println("3. Remove Item");
        System.out.println("4. Search by Brand");
        System.out.println("5. Search by Engine Number");
        System.out.println("6. Filter by Status");
        System.out.println("7. Sort by Brand");
        System.out.println("8. Sort by Date");
        System.out.println("9. Update Status");
        System.out.println("10. Get Statistics");
        System.out.println("11. Exit");
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
                    // Display all items
                    displayAll();
                    break;
                    
                case 2:
                    // Add new item
                    System.out.println("\nEnter item details:");
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
                    addItem(newItem);
                    break;
                    
                case 3:
                    // Remove item by index
                    System.out.print("Enter index to remove (0 to " + (inventoryList.size() - 1) + "): ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    removeItem(index);
                    break;
                    
                case 4:
                    // Search by brand
                    System.out.print("Enter brand name: ");
                    String brandName = scanner.nextLine();
                    searchByBrand(brandName);
                    break;
                    
                case 5:
                    // Search by engine number
                    System.out.print("Enter engine number: ");
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
                    
                case 6:
                    // Filter by status
                    System.out.print("Enter status (On-hand/Sold): ");
                    String statusType = scanner.nextLine();
                    ArrayList<InventoryItem> filteredResults = filterByStatus(statusType);
                    
                    System.out.println("\n=== Filtered Results: " + statusType + " ===");
                    System.out.println("Found " + filteredResults.size() + " items");
                    
                    // Control Structure: If-else to display results
                    if (!filteredResults.isEmpty()) {
                        System.out.println(InventoryItem.getHeader());
                        System.out.println("=".repeat(80));
                        
                        int idx = 1;
                        for (InventoryItem item : filteredResults) {
                            System.out.println(idx + ". " + item.toString());
                            idx++;
                        }
                    }
                    break;
                    
                case 7:
                    // Sort by brand
                    sortByBrand();
                    System.out.println("Displaying sorted list:");
                    displayAll();
                    break;
                    
                case 8:
                    // Sort by date
                    sortByDate();
                    System.out.println("Displaying sorted list:");
                    displayAll();
                    break;
                    
                case 9:
                    // Update status
                    System.out.print("Enter engine number: ");
                    String updateEngine = scanner.nextLine();
                    System.out.print("Enter new status: ");
                    String newStatus = scanner.nextLine();
                    updateStatus(updateEngine, newStatus);
                    break;
                    
                case 10:
                    // Get statistics
                    getStatistics();
                    break;
                    
                case 11:
                    // Exit
                    System.out.println("Exiting ArrayList Inventory System...");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 11);  // Control Structure: Continue until exit
    }
    
    /**
     * Main method - Entry point
     */
    public static void main(String[] args) {
        // Create instance of ArrayListInventory
        ArrayListInventory inventory = new ArrayListInventory();
        
        // Load data from CSV file
        String csvPath = "csv/MotorPH Inventory Data - March 2023 Inventory Data.csv";
        inventory.loadInventoryFromCSV(csvPath);
        
        // Run the menu system
        inventory.run();
    }
}
