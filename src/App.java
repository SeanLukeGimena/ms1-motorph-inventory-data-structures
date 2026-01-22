import java.util.Scanner;

/**
 * App - Main entry point for MotorPH Inventory Management System
 * Allows user to select which data structure implementation to use
 * 
 * Elements Identified:
 * - Input: User's choice of data structure
 * - Output: Menu display and navigation
 * - Control Structures: do-while loop, switch-case, if-else
 * - Variables: scanner, choice
 * - Comments: Documentation throughout the code
 */
public class App {
    
    /**
     * Display main menu
     * Output: Menu options for data structure selection
     */
    private static void displayMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("    MOTORPHPH INVENTORY MANAGEMENT SYSTEM");
        System.out.println("    Data Structures Implementation Demo");
        System.out.println("=".repeat(60));
        System.out.println("\nSelect Data Structure Implementation:");
        System.out.println("1. Array (Fixed-size array)");
        System.out.println("2. Linked List (Dynamic linked nodes)");
        System.out.println("3. Stack (LIFO - Last In First Out)");
        System.out.println("4. Queue (FIFO - First In First Out)");
        System.out.println("5. ArrayList (Dynamic array)");
        System.out.println("6. Exit");
        System.out.print("\nEnter your choice: ");
    }
    
    /**
     * Main method - Entry point of the application
     * Control Structures: do-while loop, switch-case
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Variable: scanner for input
        int choice;  // Variable: user's menu choice
        
        // Control Structure: Do-while loop for main menu
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            System.out.println();
            
            // Control Structure: Switch-case for data structure selection
            switch (choice) {
                case 1:
                    // Array Implementation
                    System.out.println(">>> Starting Array-Based Inventory System <<<\n");
                    ArrayInventory arrayInv = new ArrayInventory();
                    arrayInv.loadInventoryFromCSV("csv/MotorPH Inventory Data - March 2023 Inventory Data.csv");
                    arrayInv.run();
                    break;
                    
                case 2:
                    // Linked List Implementation
                    System.out.println(">>> Starting Linked List-Based Inventory System <<<\n");
                    LinkedListInventory linkedListInv = new LinkedListInventory();
                    linkedListInv.loadInventoryFromCSV("csv/MotorPH Inventory Data - March 2023 Inventory Data.csv");
                    linkedListInv.run();
                    break;
                    
                case 3:
                    // Stack Implementation
                    System.out.println(">>> Starting Stack-Based Inventory System (LIFO) <<<\n");
                    StackInventory stackInv = new StackInventory();
                    stackInv.loadInventoryFromCSV("csv/MotorPH Inventory Data - March 2023 Inventory Data.csv");
                    stackInv.run();
                    break;
                    
                case 4:
                    // Queue Implementation
                    System.out.println(">>> Starting Queue-Based Inventory System (FIFO) <<<\n");
                    QueueInventory queueInv = new QueueInventory();
                    queueInv.loadInventoryFromCSV("csv/MotorPH Inventory Data - March 2023 Inventory Data.csv");
                    queueInv.run();
                    break;
                    
                case 5:
                    // ArrayList Implementation
                    System.out.println(">>> Starting ArrayList-Based Inventory System <<<\n");
                    ArrayListInventory arrayListInv = new ArrayListInventory();
                    arrayListInv.loadInventoryFromCSV("csv/MotorPH Inventory Data - March 2023 Inventory Data.csv");
                    arrayListInv.run();
                    break;
                    
                case 6:
                    // Exit application
                    System.out.println("Thank you for using MotorPH Inventory Management System!");
                    System.out.println("Goodbye!");
                    break;
                    
                default:
                    // Invalid choice
                    System.out.println("Invalid choice! Please select 1-6.");
            }
            
            // Control Structure: If condition to pause before showing menu again
            if (choice != 6) {
                System.out.println("\nPress Enter to return to main menu...");
                scanner.nextLine();
            }
            
        } while (choice != 6);  // Control Structure: Continue until user exits
        
        scanner.close();  // Close scanner resource
    }
}

/*
 * ELEMENTS IDENTIFIED ACROSS ALL IMPLEMENTATIONS:
 * 
 * 1. INPUT ELEMENTS:
 *    - CSV file data (Date, Stock Label, Brand, Engine Number, Status)
 *    - User menu selections (integers)
 *    - Search criteria (strings: engine number, brand name, status)
 *    - New item data (strings for all fields)
 *    - Update values (strings)
 *    - Numerical inputs (index, position, number of orders)
 * 
 * 2. OUTPUT ELEMENTS:
 *    - Menu displays (formatted text)
 *    - Inventory item listings (tables)
 *    - Search and filter results (formatted data)
 *    - Operation confirmations (success/error messages)
 *    - Statistics and counts (numerical summaries)
 *    - Error messages (validation feedback)
 * 
 * 3. CONTROL STRUCTURES:
 *    - WHILE loops: File reading, queue/stack processing, linked list traversal
 *    - FOR loops: Array iteration, sorting algorithms, index-based operations
 *    - FOR-EACH loops: ArrayList iteration, collection processing
 *    - IF-ELSE: Conditional logic, validation, result checking
 *    - SWITCH-CASE: Menu selection handling
 *    - DO-WHILE: Main menu loops ensuring at least one execution
 *    - Nested loops: Sorting algorithms (bubble sort), filtering operations
 * 
 * 4. VARIABLES (by Data Structure):
 *    Array: inventoryArray[], itemCount, MAX_SIZE, choice, index
 *    Linked List: head, tail, current, previous, size, Node objects
 *    Stack: inventoryStack, tempStack, soldCount, position
 *    Queue: inventoryQueue, tempQueue, processedCount
 *    ArrayList: inventoryList, results, brandCounts, filtered
 *    Common: scanner, choice, engineNum, brandName, status, item
 * 
 * 5. COMMENTS:
 *    - Class-level documentation (purpose, functionality)
 *    - Method-level documentation (parameters, return values, purpose)
 *    - Inline comments explaining logic and algorithms
 *    - Section headers for code organization
 *    - Element identification comments
 */
