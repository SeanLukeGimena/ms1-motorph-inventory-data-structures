import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/**
 * QueueInventory - Manages inventory using a Queue (FIFO - First In First Out)
 * Demonstrates: Queue data structure, enqueue/dequeue operations, FIFO processing
 */
public class QueueInventory {
    // Variables - Queue for inventory and scanner for input
    private Queue<InventoryItem> inventoryQueue;
    private int processedCount;  // Variable: track total processed orders
    private Scanner scanner;
    
    // Constructor
    public QueueInventory() {
        this.inventoryQueue = new LinkedList<>();
        this.processedCount = 0;
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Load inventory from CSV file into queue
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
                    inventoryQueue.offer(item);  // Enqueue to queue
                }
            }
            
            // Output: Display load confirmation
            System.out.println("Loaded " + inventoryQueue.size() + " items into queue.");
            return inventoryQueue.size();
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Enqueue new item to queue
     * Input: InventoryItem to enqueue
     * Output: Confirmation message
     */
    public void enqueueItem(InventoryItem item) {
        inventoryQueue.offer(item);  // Add to queue
        // Output: Confirmation
        System.out.println("Item enqueued: " + item.getEngineNumber());
    }
    
    /**
     * Dequeue item from front of queue
     * Output: Dequeued item or null if empty
     * Control Structure: if-else condition
     */
    public InventoryItem dequeueItem() {
        // Control Structure: Check if queue is empty
        if (inventoryQueue.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        } else {
            InventoryItem item = inventoryQueue.poll();  // Remove from queue
            // Output: Display dequeued item
            System.out.println("\nDequeued item:");
            System.out.println(InventoryItem.getHeader());
            System.out.println(item.toString());
            return item;
        }
    }
    
    /**
     * Peek at front item without removing
     * Output: Front item or null if empty
     * Control Structure: if-else condition
     */
    public InventoryItem peekFront() {
        // Control Structure: Check if queue is empty
        if (inventoryQueue.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        } else {
            InventoryItem item = inventoryQueue.peek();  // Peek at front
            // Output: Display front item
            System.out.println("\nFront item:");
            System.out.println(InventoryItem.getHeader());
            System.out.println(item.toString());
            return item;
        }
    }
    
    /**
     * Display all items in queue (non-destructive)
     * Output: All items in queue
     * Control Structure: if-else, for-each loop
     */
    public void displayQueue() {
        // Output: Print header
        System.out.println("\n=== Inventory Queue (FIFO) ===");
        System.out.println("Queue Size: " + inventoryQueue.size());
        
        // Control Structure: Check if empty
        if (inventoryQueue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.println(InventoryItem.getHeader());
        System.out.println("=".repeat(80));
        
        int position = 1;
        
        // Control Structure: For-each loop to display items
        for (InventoryItem item : inventoryQueue) {
            System.out.println(position + ". " + item.toString());
            position++;
        }
    }
    
    /**
     * Process orders (dequeue on-hand items first)
     * Input: Number of orders to process
     * Output: Number of orders processed
     * Control Structure: while loops, if condition
     */
    public void processOrders(int numOrders) {
        int processed = 0;  // Variable: counter for processed orders
        Queue<InventoryItem> tempQueue = new LinkedList<>();
        
        System.out.println("\n=== Processing Orders ===");
        
        // Control Structure: Loop through queue
        while (!inventoryQueue.isEmpty() && processed < numOrders) {
            InventoryItem item = inventoryQueue.poll();
            
            // Control Structure: Check if on-hand
            if (item.getStatus().equalsIgnoreCase("On-hand")) {
                processed++;
                processedCount++;
                // Output: Processing confirmation
                System.out.println("Processing order " + processed + ": " + 
                                   item.getBrand() + " - " + item.getEngineNumber());
                item.setStatus("Sold");  // Update status
            }
            
            tempQueue.offer(item);  // Add to temp queue
        }
        
        // Control Structure: Transfer remaining items
        while (!inventoryQueue.isEmpty()) {
            tempQueue.offer(inventoryQueue.poll());
        }
        
        // Restore to original queue
        inventoryQueue = tempQueue;
        
        // Output: Summary
        System.out.println("\n--- Order Processing Summary ---");
        System.out.println("Total orders processed: " + processed);
        System.out.println("Total orders processed today: " + processedCount);
        System.out.println("Remaining queue size: " + inventoryQueue.size());
    }
    
    /**
     * Filter queue by brand (non-destructive display)
     * Input: Brand name
     * Output: Filtered items
     * Control Structure: for-each loop, if condition
     */
    public void filterByBrand(String brandName) {
        Queue<InventoryItem> filteredQueue = new LinkedList<>();
        int count = 0;
        
        // Control Structure: Process entire queue
        for (InventoryItem item : inventoryQueue) {
            // Control Structure: Check brand match
            if (item.getBrand().equalsIgnoreCase(brandName)) {
                filteredQueue.offer(item);
                count++;
            }
        }
        
        // Output: Display filtered results
        System.out.println("\n=== Filtered Results: " + brandName + " ===");
        System.out.println("Found " + count + " items");
        
        // Control Structure: Display filtered items
        if (!filteredQueue.isEmpty()) {
            System.out.println(InventoryItem.getHeader());
            System.out.println("=".repeat(80));
            
            int position = 1;
            for (InventoryItem item : filteredQueue) {
                System.out.println(position + ". " + item.toString());
                position++;
            }
        }
    }
    
    /**
     * Filter queue by status
     * Input: Status (On-hand or Sold)
     * Output: Filtered items
     * Control Structure: for-each loop, if condition
     */
    public void filterByStatus(String status) {
        Queue<InventoryItem> filteredQueue = new LinkedList<>();
        int count = 0;
        
        // Control Structure: Process entire queue
        for (InventoryItem item : inventoryQueue) {
            // Control Structure: Check status match
            if (item.getStatus().equalsIgnoreCase(status)) {
                filteredQueue.offer(item);
                count++;
            }
        }
        
        // Output: Display filtered results
        System.out.println("\n=== Filtered Results: " + status + " ===");
        System.out.println("Found " + count + " items");
        
        // Control Structure: Display filtered items
        if (!filteredQueue.isEmpty()) {
            System.out.println(InventoryItem.getHeader());
            System.out.println("=".repeat(80));
            
            int position = 1;
            for (InventoryItem item : filteredQueue) {
                System.out.println(position + ". " + item.toString());
                position++;
            }
        }
    }
    
    /**
     * Count items by brand
     * Input: Brand name
     * Output: Count of matching items
     * Control Structure: for-each loop, if condition
     */
    public int countByBrand(String brandName) {
        int count = 0;
        
        // Control Structure: Count through queue
        for (InventoryItem item : inventoryQueue) {
            // Control Structure: Check brand match
            if (item.getBrand().equalsIgnoreCase(brandName)) {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Display menu
     * Output: Menu options
     */
    private void displayMenu() {
        System.out.println("\n=== Queue-Based Inventory Menu (FIFO) ===");
        System.out.println("1. Enqueue Item (Add to rear)");
        System.out.println("2. Dequeue Item (Remove from front)");
        System.out.println("3. Peek Front Item");
        System.out.println("4. Display Queue");
        System.out.println("5. Process Orders");
        System.out.println("6. Filter by Brand");
        System.out.println("7. Filter by Status");
        System.out.println("8. Count by Brand");
        System.out.println("9. Exit");
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
                    // Enqueue new item
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
                    enqueueItem(newItem);
                    break;
                    
                case 2:
                    // Dequeue item
                    dequeueItem();
                    break;
                    
                case 3:
                    // Peek front
                    peekFront();
                    break;
                    
                case 4:
                    // Display queue
                    displayQueue();
                    break;
                    
                case 5:
                    // Process orders
                    System.out.print("Enter number of orders to process: ");
                    int numOrders = scanner.nextInt();
                    scanner.nextLine();
                    processOrders(numOrders);
                    break;
                    
                case 6:
                    // Filter by brand
                    System.out.print("Enter brand name: ");
                    String brandName = scanner.nextLine();
                    filterByBrand(brandName);
                    break;
                    
                case 7:
                    // Filter by status
                    System.out.print("Enter status (On-hand/Sold): ");
                    String filterStatus = scanner.nextLine();
                    filterByStatus(filterStatus);
                    break;
                    
                case 8:
                    // Count by brand
                    System.out.print("Enter brand name: ");
                    String countBrand = scanner.nextLine();
                    int count = countByBrand(countBrand);
                    System.out.println("Total " + countBrand + " items in queue: " + count);
                    break;
                    
                case 9:
                    // Exit
                    System.out.println("Exiting Queue Inventory System...");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 9);  // Control Structure: Continue until exit
    }
    
    /**
     * Main method - Entry point
     */
    public static void main(String[] args) {
        // Create instance of QueueInventory
        QueueInventory inventory = new QueueInventory();
        
        // Load data from CSV file
        String csvPath = "csv/MotorPH Inventory Data - March 2023 Inventory Data.csv";
        inventory.loadInventoryFromCSV(csvPath);
        
        // Run the menu system
        inventory.run();
    }
}
