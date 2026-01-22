# Quick Start Guide
## MotorPH Inventory Management System

### Prerequisites
- Java JDK 8 or higher installed
- Command prompt or terminal access
- The CSV file must be in the `csv/` folder

### Step 1: Compile the Project

Open a terminal and navigate to the `src` directory:

```bash
cd "c:\Users\Admin\Downloads\DSA - VS Code\WEEK 3 DSA\MS1 MotorPH Inventory Data  Structure and Algorithm Proposal\src"
```

Compile all Java files:

```bash
javac *.java
```

### Step 2: Run the Main Application

Execute the main application:

```bash
java App
```

### Step 3: Navigate the Main Menu

You'll see:
```
============================================================
    MOTORPHPH INVENTORY MANAGEMENT SYSTEM
    Data Structures Implementation Demo
============================================================

Select Data Structure Implementation:
1. Array (Fixed-size array - MAX 100 items, manual tracking)
2. Linked List (Dynamic linked nodes)
3. Stack (LIFO - Last In First Out)
4. Queue (FIFO - First In First Out)
5. ArrayList (Dynamic array - unlimited size, automatic management)
6. Exit

Enter your choice:
```

Enter a number (1-5) to select a data structure, or 6 to exit.

### Step 4: Use the Selected Data Structure

Each data structure has its own menu with specific operations:

#### Array Menu (Option 1)
```
1. Display All Items - Shows all 49 inventory items
2. Search by Engine Number - Find specific item
3. Count by Brand - Count items by manufacturer
4. Count by Status - Count On-hand or Sold items
5. Display Statistics - Comprehensive statistics
6. Exit - Return to main menu
```

#### Linked List Menu (Option 2)
```
1. Display All Items - Traverse and display all nodes
2. Search by Engine Number - Find item in list
3. Delete by Engine Number - Remove item from list
4. Get Item at Position - Access specific position
5. Count by Brand - Count items by brand
6. Display List Size - Show current size
7. Exit - Return to main menu
```

#### Stack Menu (Option 3)
```
1. Push Item (Add to top) - Add new item to stack
2. Pop Item (Remove from top) - Remove top item
3. Peek Top Item - View top without removing
4. Display Stack - Show all items (LIFO order)
5. Process Sold Items - Remove sold items from stack
6. Search by Engine Number - Find item in stack
7. Count by Brand - Count items by brand
8. Exit - Return to main menu
```

#### Queue Menu (Option 4)
```
1. Enqueue Item (Add to rear) - Add item to queue
2. Dequeue Item (Remove from front) - Remove front item
3. Peek Front Item - View front without removing
4. Display Queue - Show all items (FIFO order)
5. Process Orders - Process N on-hand items
6. Filter by Brand - Show items of specific brand
7. Filter by Status - Show On-hand or Sold items
8. Count by Brand - Count items by brand
9. Exit - Return to main menu
```

#### ArrayList Menu (Option 5)
```
1. Display All Items - Show all items in list
2. Add Item - Add new item to list
3. Remove Item - Remove by index
4. Search by Brand - Find all items of a brand
5. Search by Engine Number - Find specific item
6. Filter by Status - Filter On-hand or Sold
7. Sort by Brand - Sort alphabetically by brand
8. Sort by Date - Sort by entry date
9. Update Status - Change item status
10. Get Statistics - Detailed statistics with percentages
11. Exit - Return to main menu
```

### Example Workflows

#### Example 1: View All Inventory (Array)
1. Run: `java App`
2. Select: `1` (Array)
3. Select: `1` (Display All Items)
4. View the 49 inventory items
5. Select: `6` (Exit)
6. Press Enter to return to main menu

#### Example 2: Search for an Item
1. Run: `java App`
2. Select: `2` (Linked List)
3. Select: `2` (Search by Engine Number)
4. Enter: `142QVTSIUR` (sample engine number)
5. View the found item details
6. Select: `7` (Exit)

#### Example 3: Process Orders (Queue)
1. Run: `java App`
2. Select: `4` (Queue)
3. Select: `5` (Process Orders)
4. Enter: `5` (process 5 orders)
5. View which items were processed
6. Select: `9` (Exit)

#### Example 4: Sort and View Statistics (ArrayList)
1. Run: `java App`
2. Select: `5` (ArrayList)
3. Select: `7` (Sort by Brand)
4. View sorted list
5. Select: `10` (Get Statistics)
6. View comprehensive statistics
7. Select: `11` (Exit)

#### Example 5: Stack Operations
1. Run: `java App`
2. Select: `3` (Stack)
3. Select: `3` (Peek Top Item) - View top without removing
4. Select: `2` (Pop Item) - Remove top item
5. Select: `4` (Display Stack) - See remaining items
6. Select: `8` (Exit)

### Running Individual Implementations

You can also run each implementation directly:

```bash
# Array
java ArrayInventory

# Linked List
java LinkedListInventory

# Stack
java StackInventory

# Queue
java QueueInventory

# ArrayList
java ArrayListInventory
```

### Sample Data

The CSV file contains 49 inventory records with:
- **Brands**: Honda, Yamaha, Suzuki, Kawasaki, Kymco
- **Status**: On-hand or Sold
- **Stock Label**: Old (February) or New (March)
- **Engine Numbers**: Unique 10-character identifiers

### Tips

1. **Array**: Best for fixed-size, index-based access
2. **Linked List**: Best for frequent insertions/deletions
3. **Stack**: Best for LIFO operations (recent items first)
4. **Queue**: Best for FIFO operations (order processing)
5. **ArrayList**: Best for dynamic operations with sorting

### Troubleshooting

**Problem**: "Error: Could not find or load main class"
- **Solution**: Make sure you're in the `src` directory when running

**Problem**: "File not found" when loading CSV
- **Solution**: Ensure the CSV file is in `csv/` folder relative to `src/`

**Problem**: Compilation errors
- **Solution**: Make sure Java JDK is installed: `java -version`

**Problem**: Scanner input issues
- **Solution**: Make sure to enter valid data types (integers for menu choices)

### Testing Different Operations

#### Test Search Function:
Try searching for these engine numbers:
- `142QVTSIUR` (On-hand Honda)
- `PZCT1S00XE` (Sold Honda)
- `NO8VW05PU9` (On-hand Suzuki)

#### Test Brand Counting:
Try counting these brands:
- Honda
- Yamaha
- Suzuki
- Kawasaki
- Kymco

#### Test Status Filtering:
- On-hand (items available)
- Sold (items already sold)

### Documentation Files

- **README.md** - Complete project documentation
- **PSEUDOCODE.md** - Detailed pseudocode for all implementations
- **ELEMENTS_IDENTIFICATION.md** - Comprehensive element analysis
- **QUICK_START.md** - This guide

### Need Help?

Refer to the detailed documentation in:
1. README.md for overview and features
2. PSEUDOCODE.md for algorithm details
3. ELEMENTS_IDENTIFICATION.md for element analysis

---

**Enjoy exploring different data structures with MotorPH Inventory Management System!**
