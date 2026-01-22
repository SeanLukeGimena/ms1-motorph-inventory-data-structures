# MotorPH Inventory Management System
## Data Structures and Algorithm Implementation

### Project Overview
This project demonstrates the implementation of five different data structures (Array, Linked List, Stack, Queue, and ArrayList) for managing MotorPH's motorcycle inventory data. Each implementation provides a complete working system with menu-driven interfaces for various operations.

### Data Structures Implemented

1. **Array (ArrayInventory.java)**
   - Fixed-size array implementation
   - Linear search algorithm
   - Operations: Display, Search, Count by brand/status, Statistics

2. **Linked List (LinkedListInventory.java)**
   - Dynamic singly linked list with nodes
   - Operations: Add, Display, Search, Delete, Get at position, Count

3. **Stack (StackInventory.java)**
   - LIFO (Last In First Out) structure
   - Operations: Push, Pop, Peek, Display, Process sold items, Search

4. **Queue (QueueInventory.java)**
   - FIFO (First In First Out) structure
   - Operations: Enqueue, Dequeue, Peek, Display, Process orders, Filter

5. **ArrayList (ArrayListInventory.java)**
   - Dynamic array implementation
   - Operations: Add, Remove, Search, Filter, Sort (Bubble sort), Update, Statistics

### File Structure
```
├── README.md
├── PSEUDOCODE.md                    # Detailed pseudocode for all implementations
├── csv/
│   └── MotorPH Inventory Data - March 2023 Inventory Data.csv
└── src/
    ├── App.java                     # Main application entry point
    ├── InventoryItem.java           # Model class for inventory items
    ├── ArrayInventory.java          # Array implementation
    ├── LinkedListInventory.java     # Linked List implementation
    ├── StackInventory.java          # Stack implementation
    ├── QueueInventory.java          # Queue implementation
    └── ArrayListInventory.java      # ArrayList implementation
```

### CSV Data Format
The inventory data contains the following fields:
- **Date Entered**: Date when stock was entered
- **Stock Label**: Old or New stock
- **Brand**: Honda, Yamaha, Suzuki, Kawasaki, or Kymco
- **Engine Number**: Unique identifier
- **Status**: On-hand or Sold

### Elements Identified in Each Implementation

#### 1. Input Elements
- CSV file data (inventory records)
- User menu selections (integer choices)
- Search criteria (engine number, brand, status)
- New item data (date, label, brand, engine number, status)
- Update values (new status)
- Numerical parameters (index, position, order count)

#### 2. Output Elements
- Menu displays (formatted text)
- Inventory listings (formatted tables)
- Search and filter results
- Operation confirmations
- Statistics and summaries
- Error messages

#### 3. Control Structures
- **WHILE loops**: File reading, queue/stack processing, linked list traversal
- **FOR loops**: Array iteration, sorting algorithms
- **FOR-EACH loops**: ArrayList/collection iteration
- **IF-ELSE**: Conditional logic, validation
- **SWITCH-CASE**: Menu selection handling
- **DO-WHILE**: Main menu loops
- **Nested loops**: Sorting algorithms (bubble sort)

#### 4. Variables
- **Array**: `inventoryArray[]`, `itemCount`, `MAX_SIZE`
- **Linked List**: `head`, `tail`, `current`, `previous`, `size`
- **Stack**: `inventoryStack`, `tempStack`, `soldCount`
- **Queue**: `inventoryQueue`, `tempQueue`, `processedCount`
- **ArrayList**: `inventoryList`, `results`, `brandCounts`, `filtered`
- **Common**: `scanner`, `choice`, `engineNum`, `brandName`, `status`

#### 5. Comments
- Class-level documentation
- Method-level JavaDoc comments
- Inline explanatory comments
- Section headers
- Element identification comments

### How to Run

#### Compile All Files
```bash
cd src
javac *.java
```

#### Run the Main Application
```bash
java App
```

#### Run Individual Implementations
```bash
# Array implementation
java ArrayInventory

# Linked List implementation
java LinkedListInventory

# Stack implementation
java StackInventory

# Queue implementation
java QueueInventory

# ArrayList implementation
java ArrayListInventory
```

### Features by Data Structure

#### Array Features
- Fixed capacity (100 items)
- Fast index-based access
- Linear search for items
- Brand and status counting
- Comprehensive statistics

#### Linked List Features
- Dynamic size (grows as needed)
- Efficient insertion/deletion
- Position-based access
- Node-based traversal
- Delete by engine number

#### Stack Features
- LIFO operations
- Non-destructive display
- Process sold items (remove from stack)
- Search while preserving stack
- Brand counting

#### Queue Features
- FIFO operations
- Order processing system
- Filter by brand or status
- Non-destructive display
- Track processed count

#### ArrayList Features
- Dynamic resizing
- Bubble sort (by brand or date)
- Update item status
- Comprehensive statistics with percentages
- Filter and search operations
- Add/remove items

### Algorithms Implemented

1. **Linear Search**
   - Used in Array and Linked List implementations
   - Time complexity: O(n)

2. **Bubble Sort**
   - Used in ArrayList implementation
   - Sorts by brand or date
   - Time complexity: O(n²)

3. **Linked List Traversal**
   - Sequential node-by-node access
   - Time complexity: O(n)

4. **Stack Operations**
   - Push/Pop operations
   - Time complexity: O(1)

5. **Queue Operations**
   - Enqueue/Dequeue operations
   - Time complexity: O(1)

### Sample Usage

#### Example: Running Array Implementation
1. Start the application: `java App`
2. Select option 1 (Array)
3. Choose from menu:
   - Display all items
   - Search by engine number
   - Count by brand
   - View statistics

#### Example: Processing Orders with Queue
1. Select option 4 (Queue)
2. Choose option 5 (Process Orders)
3. Enter number of orders to process
4. System processes on-hand items in FIFO order

### Key Learning Outcomes

1. **Data Structure Selection**: Understanding when to use each data structure
2. **Algorithm Implementation**: Practical application of search and sort algorithms
3. **File I/O**: Reading and parsing CSV data
4. **Menu-Driven Interface**: User interaction design
5. **Code Documentation**: Proper commenting and documentation practices

### Pseudocode Documentation

Detailed pseudocode for all implementations can be found in [PSEUDOCODE.md](PSEUDOCODE.md), including:
- Step-by-step algorithm descriptions
- Element identification for each implementation
- Control structure analysis
- Variable documentation

### Testing

Each implementation has been tested with the provided CSV data containing 49 inventory records. All operations work correctly:
- File loading ✓
- Display operations ✓
- Search operations ✓
- Add/Remove operations ✓
- Sorting operations ✓
- Statistical analysis ✓

### Author
Created for MotorPH Inventory Data Structure and Algorithm Proposal

### Date
January 2026

