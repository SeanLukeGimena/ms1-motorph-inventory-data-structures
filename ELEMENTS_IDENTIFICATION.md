# ELEMENTS IDENTIFICATION SUMMARY
## MotorPH Inventory Management System - All Data Structures

---

## 1. INPUT ELEMENTS

### Common Inputs Across All Implementations:
1. **CSV File Data**
   - Date Entered (String)
   - Stock Label (String: "Old" or "New")
   - Brand (String: Honda, Yamaha, Suzuki, Kawasaki, Kymco)
   - Engine Number (String: Unique identifier)
   - Status (String: "On-hand" or "Sold")

2. **User Menu Selections**
   - Integer values (1-11 depending on implementation)
   - Choice for data structure selection
   - Choice for specific operations

3. **Search Criteria**
   - Engine number (String)
   - Brand name (String)
   - Status type (String)

4. **New Item Data** (for add operations)
   - All five fields required for creating new inventory items

5. **Update Values**
   - New status (String)
   - Index/position numbers (Integer)

6. **Numerical Parameters**
   - Array index (Integer)
   - List position (Integer)
   - Number of orders to process (Integer)

---

## 2. OUTPUT ELEMENTS

### Common Outputs Across All Implementations:

1. **Menu Displays**
   - Main menu (data structure selection)
   - Sub-menus (operation selection)
   - Formatted text with options

2. **Inventory Listings**
   - Formatted table with headers
   - Column-aligned data display
   - Item numbering (1, 2, 3, ...)

3. **Search and Filter Results**
   - Found items display
   - Count of results
   - "Not found" messages

4. **Operation Confirmations**
   - "Item added successfully"
   - "Item deleted/removed"
   - "Status updated"
   - "Item pushed/popped/enqueued/dequeued"

5. **Statistics and Summaries**
   - Total item count
   - On-hand vs Sold counts
   - Brand distribution
   - Percentages (ArrayList implementation)

6. **Error Messages**
   - "Invalid choice"
   - "Index out of bounds"
   - "Queue/Stack is empty"
   - "Item not found"
   - "File reading error"

---

## 3. CONTROL STRUCTURES

### Organized by Type:

#### A. LOOPS

1. **WHILE Loops**
   - **File Reading**: `while ((line = br.readLine()) != null)`
   - **Stack Processing**: `while (!inventoryStack.isEmpty())`
   - **Queue Processing**: `while (!inventoryQueue.isEmpty())`
   - **Linked List Traversal**: `while (current != null)`
   
2. **FOR Loops**
   - **Array Iteration**: `for (int i = 0; i < itemCount; i++)`
   - **Index-based Operations**: `for (int i = 0; i < inventoryList.size(); i++)`
   - **Bubble Sort Outer Loop**: `for (int i = 0; i < n - 1; i++)`
   - **Bubble Sort Inner Loop**: `for (int j = 0; j < n - i - 1; j++)`

3. **FOR-EACH Loops**
   - **ArrayList Iteration**: `for (InventoryItem item : inventoryList)`
   - **Queue Display**: `for (InventoryItem item : inventoryQueue)`
   - **Brand Array Iteration**: `for (String brand : brands)`
   - **Map Iteration**: `for (Map.Entry<String, Integer> entry : brandCounts.entrySet())`

4. **DO-WHILE Loops**
   - **Main Menu Loop**: `do { ... } while (choice != exitValue)`
   - Ensures at least one execution of menu display

#### B. CONDITIONAL STATEMENTS

1. **IF-ELSE Statements**
   - **Validation**: `if (index < 0 || index >= size)`
   - **Empty Check**: `if (stack.isEmpty())`
   - **Search Match**: `if (item.getEngineNumber().equals(searchTerm))`
   - **Status Check**: `if (item.getStatus().equalsIgnoreCase("On-hand"))`

2. **SWITCH-CASE Statements**
   - **Main Menu Selection**: All implementations use switch for menu routing
   - **Data Structure Selection**: App.java main menu
   - Cases for each menu option with default for invalid input

3. **Nested Conditions**
   - **Deletion Logic**: Checking head/tail nodes in linked list
   - **Search and Filter**: Multiple condition checks
   - **Sorting Comparisons**: Nested in bubble sort loops

---

## 4. VARIABLES

### By Data Structure:

#### A. Array Implementation (ArrayInventory.java)
```
Variables:
- inventoryArray[] : InventoryItem[] - FIXED-SIZE array (MAX_SIZE = 100)
- itemCount : int - MANUAL size tracking (must increment ourselves)
- MAX_SIZE : final int - HARD LIMIT: Maximum capacity (100)
- scanner : Scanner - User input
- choice : int - Menu selection
- engineNum : String - Search parameter
- brandName : String - Brand filter
- status : String - Status filter
- count : int - Counter variable
- result : InventoryItem - Search result

KEY CHARACTERISTICS:
✗ NO automatic resizing - fixed at 100 items
✗ MUST manually track size with itemCount
✗ MUST check capacity before adding: if (itemCount < MAX_SIZE)
```

#### E. ArrayList Implementation (ArrayListInventory.java)
```
Variables:
- inventoryList : ArrayList<InventoryItem> - DYNAMIC list (unlimited size)
- results : ArrayList<InventoryItem> - Search results
- filtered : ArrayList<InventoryItem> - Filter results
- brandCounts : Map<String, Integer> - Brand statistics
- scanner : Scanner - User input
- choice : int - Menu selection
- index : int - List index
- count : int - Counter variable
- onHandCount : int - On-hand items

KEY CHARACTERISTICS:
✓ AUTOMATIC resizing - no size limit
✓ Built-in .size() method - no manual tracking needed
✓ NO capacity check needed - grows automatically
✓ Rich methods: .add(), .remove(), .contains(), .sort()
```

### 📊 Array vs ArrayList Variable Comparison

| Aspect | Array | ArrayList |
|--------|-------|-----------|
| **Data Storage** | `InventoryItem[]` | `ArrayList<InventoryItem>` |
| **Size Variable** | `int itemCount` (manual) | `.size()` (automatic) |
| **Capacity Limit** | `MAX_SIZE = 100` | No limit |
| **Size Check** | `if (itemCount < MAX_SIZE)` | Not needed |
| **Adding Item** | `arr[itemCount++] = item` | `list.add(item)` |
| **Getting Size** | `itemCount` | `list.size()` |

#### B. Linked List Implementation (LinkedListInventory.java)
```
Variables:
- head : Node - First node reference
- tail : Node - Last node reference
- size : int - Number of nodes
- current : Node - Traversal pointer
- previous : Node - Previous node reference
- newNode : Node - Newly created node
- scanner : Scanner - User input
- choice : int - Menu selection
- position : int - Node position
- item : InventoryItem - Data payload
```

#### C. Stack Implementation (StackInventory.java)
```
Variables:
- inventoryStack : Stack<InventoryItem> - Main stack
- tempStack : Stack<InventoryItem> - Temporary storage
- tempStorage : ArrayList<InventoryItem> - Loading buffer
- soldCount : int - Sold items counter
- position : int - Display position
- scanner : Scanner - User input
- choice : int - Menu selection
- item : InventoryItem - Stack element
```

#### D. Queue Implementation (QueueInventory.java)
```
Variables:
- inventoryQueue : Queue<InventoryItem> - Main queue
- tempQueue : Queue<InventoryItem> - Temporary storage
- filteredQueue : Queue<InventoryItem> - Filter results
- processedCount : int - Total processed
- processed : int - Current batch processed
- count : int - Counter variable
- scanner : Scanner - User input
- choice : int - Menu selection
- numOrders : int - Orders to process
```
- soldCount : int - Sold items
- oldStockCount : int - Old stock count
- newStockCount : int - New stock count
- totalItems : int - Total count
- n : int - List size (for sorting)
- temp : InventoryItem - Swap variable
```

### Common Variables Across All Implementations:
```
- scanner : Scanner - User input (all classes)
- choice : int - Menu choice (all classes)
- engineNum : String - Engine number search
- brandName : String - Brand search/filter
- status : String - Status filter
- item : InventoryItem - Inventory item object
- count : int - Generic counter
- date : String - Date input
- label : String - Stock label input
- brand : String - Brand input
- engine : String - Engine number input
```

---

## 5. COMMENTS

### Types of Comments Used:

#### A. Class-Level Comments (JavaDoc)
```java
/**
 * ArrayInventory - Manages inventory using a fixed-size Array
 * Demonstrates: Array data structure, linear search, and basic operations
 */
```

#### B. Method-Level Comments (JavaDoc)
```java
/**
 * Load inventory from CSV file
 * Input: CSV file path
 * Output: Number of items loaded
 * Control Structures: while loop, if condition
 */
```

#### C. Inline Comments
```java
// Skip first two header lines
// Control Structure: While loop to read all records
// Increment counter
// Add to ArrayList
```

#### D. Variable Declaration Comments
```java
int count = 0;  // Variable: counter for sold items
Scanner scanner = new Scanner(System.in);  // Variable: scanner for input
```

#### E. Section Header Comments
```java
// Control Structure: Do-while loop for menu
// Output: Display results
// Validation: Check if empty
```

#### F. Element Identification Comments
```java
/*
 * ELEMENTS IDENTIFIED:
 * - Input: CSV file data, user choices
 * - Output: Displays, confirmations
 * - Control Structures: loops, conditions
 * - Variables: list of all variables
 * - Comments: documentation
 */
```

#### G. Operation Description Comments
```java
// Create new inventory item and add to array
// Control Structure: Check if deleting head node
// Swap items for bubble sort
// Restore original stack after display
```

---

## SUMMARY TABLE

| Element Type | Array | Linked List | Stack | Queue | ArrayList |
|--------------|-------|-------------|-------|-------|-----------|
| **Input Sources** | 6 | 6 | 6 | 6 | 6 |
| **Output Types** | 6 | 6 | 6 | 6 | 6 |
| **Loop Types** | 3 | 3 | 4 | 3 | 4 |
| **Conditional Types** | 3 | 3 | 3 | 3 | 3 |
| **Total Variables** | 12+ | 14+ | 13+ | 14+ | 20+ |
| **Comment Types** | 7 | 7 | 7 | 7 | 7 |

---

## KEY OBSERVATIONS

### Input Consistency
All implementations accept the same CSV format and provide similar user interaction patterns, ensuring consistency across different data structures.

### Output Uniformity
Consistent formatting and display patterns make it easy to compare the behavior of different data structures.

### Control Structure Usage
- **Array**: Heavy use of FOR loops for index-based access
- **Linked List**: Extensive WHILE loops for node traversal
- **Stack**: WHILE loops for non-destructive operations
- **Queue**: FOR-EACH for display, WHILE for processing
- **ArrayList**: Mix of FOR, FOR-EACH, and nested loops for sorting

### Variable Patterns
- Simple types use basic data structures (Array, Linked List)
- Complex types add supporting structures (temp stacks/queues)
- ArrayList uses the most diverse set of variables (maps, multiple lists)

### Comment Coverage
All implementations maintain comprehensive documentation with:
- 100% class documentation
- 100% method documentation
- Extensive inline comments
- Clear element identification
- Operation descriptions

---

## CONCLUSION

This project successfully demonstrates:
1. ✅ Comprehensive pseudocode for all 5 data structures
2. ✅ Complete identification of Input, Output, Control Structures, Variables, and Comments
3. ✅ Full conversion from pseudocode to working Java code
4. ✅ Use of CSV file for inventory data
5. ✅ Proper documentation and commenting throughout

Each implementation is fully functional, well-documented, and demonstrates the unique characteristics and use cases of its respective data structure.
