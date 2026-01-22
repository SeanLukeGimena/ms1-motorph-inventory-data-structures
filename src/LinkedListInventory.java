import java.io.*;
import java.util.Scanner;

/**
 * LinkedListInventory - Manages inventory using a Linked List
 * Demonstrates: Linked List data structure, dynamic memory, node traversal
 */
public class LinkedListInventory {
    
    /**
     * Node class - Represents a single node in the linked list
     * Variables: data (InventoryItem), next (reference to next node)
     */
    private class Node {
        InventoryItem data;  // Variable: item data
        Node next;           // Variable: reference to next node
        
        // Constructor
        Node(InventoryItem item) {
            this.data = item;
            this.next = null;
        }
    }
    
    // Variables - Head and tail pointers, size counter
    private Node head;
    private Node tail;
    private int size;
    private Scanner scanner;
    
    // Constructor
    public LinkedListInventory() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Add item to end of linked list
     * Input: InventoryItem to add
     * Control Structure: if-else condition
     */
    public void addToEnd(InventoryItem item) {
        Node newNode = new Node(item);  // Create new node
        
        // Control Structure: Check if list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;  // Link new node
            tail = newNode;        // Update tail
        }
        size++;  // Increment size
    }
    
    /**
     * Load inventory from CSV file
     * Input: CSV file path
     * Output: Number of items loaded
     * Control Structure: while loop
     */
    public int loadInventoryFromCSV(String filename) {
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
                    // Create new inventory item and add to list
                    InventoryItem item = new InventoryItem(
                        data[0].trim(),  // dateEntered
                        data[1].trim(),  // stockLabel
                        data[2].trim(),  // brand
                        data[3].trim(),  // engineNumber
                        data[4].trim()   // status
                    );
                    addToEnd(item);  // Add to linked list
                }
            }
            
            // Output: Display load confirmation
            System.out.println("Loaded " + size + " items into linked list.");
            return size;
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Display all items in linked list
     * Output: Formatted list of all items
     * Control Structure: while loop
     */
    public void displayAll() {
        // Output: Print header
        System.out.println("\n=== Inventory Items (Linked List Implementation) ===");
        System.out.println("Total Items: " + size);
        System.out.println(InventoryItem.getHeader());
        System.out.println("=".repeat(80));
        
        // Variables for traversal
        Node current = head;
        int position = 1;
        
        // Control Structure: While loop to traverse linked list
        while (current != null) {
            System.out.println(position + ". " + current.data.toString());
            current = current.next;  // Move to next node
            position++;
        }
    }
    
    /**
     * Search for item by engine number
     * Input: Engine number
     * Output: Found item or null
     * Control Structure: while loop, if condition
     */
    public InventoryItem searchByEngineNumber(String engineNum) {
        Node current = head;  // Variable: current node pointer
        
        // Control Structure: Traverse linked list
        while (current != null) {
            // Control Structure: Check if engine number matches
            if (current.data.getEngineNumber().equalsIgnoreCase(engineNum)) {
                return current.data;  // Return found item
            }
            current = current.next;  // Move to next node
        }
        return null;  // Not found
    }
    
    /**
     * Delete item by engine number
     * Input: Engine number
     * Output: true if deleted, false if not found
     * Control Structure: while loop, if-else conditions
     */
    public boolean deleteByEngineNumber(String engineNum) {
        Node current = head;
        Node previous = null;
        
        // Control Structure: Traverse to find item
        while (current != null) {
            // Control Structure: Check if engine number matches
            if (current.data.getEngineNumber().equalsIgnoreCase(engineNum)) {
                // Control Structure: Check if deleting head node
                if (previous == null) {
                    head = current.next;
                    // Control Structure: If list becomes empty
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    previous.next = current.next;
                    // Control Structure: If deleting tail
                    if (current.next == null) {
                        tail = previous;
                    }
                }
                size--;  // Decrement size
                return true;  // Deletion successful
            }
            previous = current;
            current = current.next;
        }
        return false;  // Not found
    }
    
    /**
     * Get item at specific position
     * Input: Position (1-based index)
     * Output: Item at position or null
     * Control Structure: if condition, while loop
     */
    public InventoryItem getAtPosition(int position) {
        // Control Structure: Validate position
        if (position < 1 || position > size) {
            return null;
        }
        
        Node current = head;
        int index = 1;
        
        // Control Structure: Traverse to position
        while (index < position) {
            current = current.next;
            index++;
        }
        
        return current.data;
    }
    
    /**
     * Count items by brand
     * Input: Brand name
     * Output: Count of matching items
     * Control Structure: while loop, if condition
     */
    public int countByBrand(String brandName) {
        int count = 0;
        Node current = head;
        
        // Control Structure: Traverse linked list
        while (current != null) {
            // Control Structure: Check brand match
            if (current.data.getBrand().equalsIgnoreCase(brandName)) {
                count++;
            }
            current = current.next;
        }
        return count;
    }
    
    /**
     * Display menu
     * Output: Menu options
     */
    private void displayMenu() {
        System.out.println("\n=== Linked List-Based Inventory Menu ===");
        System.out.println("1. Display All Items");
        System.out.println("2. Search by Engine Number");
        System.out.println("3. Delete by Engine Number");
        System.out.println("4. Get Item at Position");
        System.out.println("5. Count by Brand");
        System.out.println("6. Display List Size");
        System.out.println("7. Exit");
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
                    // Delete by engine number
                    System.out.print("Enter Engine Number to delete: ");
                    String deleteEngine = scanner.nextLine();
                    boolean deleted = deleteByEngineNumber(deleteEngine);
                    
                    // Control Structure: If-else for deletion result
                    if (deleted) {
                        System.out.println("Item deleted successfully!");
                        System.out.println("New size: " + size);
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;
                    
                case 4:
                    // Get item at position
                    System.out.print("Enter position (1 to " + size + "): ");
                    int position = scanner.nextInt();
                    scanner.nextLine();
                    InventoryItem item = getAtPosition(position);
                    
                    // Control Structure: If-else for result
                    if (item != null) {
                        System.out.println("\nItem at position " + position + ":");
                        System.out.println(InventoryItem.getHeader());
                        System.out.println(item.toString());
                    } else {
                        System.out.println("Invalid position!");
                    }
                    break;
                    
                case 5:
                    // Count by brand
                    System.out.print("Enter Brand Name: ");
                    String brandName = scanner.nextLine();
                    int count = countByBrand(brandName);
                    System.out.println("Total " + brandName + " items: " + count);
                    break;
                    
                case 6:
                    // Display size
                    System.out.println("Current list size: " + size);
                    break;
                    
                case 7:
                    // Exit
                    System.out.println("Exiting Linked List Inventory System...");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);  // Control Structure: Continue until exit
    }
    
    /**
     * Main method - Entry point
     */
    public static void main(String[] args) {
        // Create instance of LinkedListInventory
        LinkedListInventory inventory = new LinkedListInventory();
        
        // Load data from CSV file
        String csvPath = "csv/MotorPH Inventory Data - March 2023 Inventory Data.csv";
        inventory.loadInventoryFromCSV(csvPath);
        
        // Run the menu system
        inventory.run();
    }
}
