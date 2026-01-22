# MotorPH Inventory Management - Pseudocode Documentation

## 1. ARRAY Implementation

```
ALGORITHM: InventoryArrayManagement
// Purpose: Manage inventory items using a fixed-size array data structure
// Input: CSV file with inventory data
// Output: Display inventory items and perform operations

BEGIN
    // VARIABLES
    DECLARE inventoryArray AS Array[100] of InventoryItem
    DECLARE itemCount AS Integer = 0
    DECLARE choice AS Integer
    DECLARE searchEngine AS String
    
    // INPUT: Read CSV file
    FUNCTION loadInventoryFromCSV(filename)
        OPEN file filename
        SKIP first 2 lines // header lines
        
        // CONTROL STRUCTURE: Loop to read all records
        WHILE NOT end of file AND itemCount < 100
            READ line from file
            PARSE line into: date, stockLabel, brand, engineNumber, status
            
            // Create new inventory item
            inventoryArray[itemCount] = NEW InventoryItem(date, stockLabel, brand, engineNumber, status)
            INCREMENT itemCount
        END WHILE
        
        CLOSE file
        RETURN itemCount
    END FUNCTION
    
    // FUNCTION: Display all items in array
    FUNCTION displayAllItems()
        // OUTPUT: Print header
        PRINT "=== Inventory Items (Array) ==="
        PRINT "Total Items: " + itemCount
        
        // CONTROL STRUCTURE: For loop to iterate through array
        FOR i FROM 0 TO itemCount - 1
            PRINT inventoryArray[i].toString()
        END FOR
    END FUNCTION
    
    // FUNCTION: Search for item by engine number
    FUNCTION searchByEngineNumber(engineNum)
        // CONTROL STRUCTURE: Linear search loop
        FOR i FROM 0 TO itemCount - 1
            IF inventoryArray[i].engineNumber EQUALS engineNum THEN
                RETURN inventoryArray[i]
            END IF
        END FOR
        RETURN NULL // not found
    END FUNCTION
    
    // FUNCTION: Count items by brand
    FUNCTION countByBrand(brandName)
        DECLARE count AS Integer = 0
        
        // CONTROL STRUCTURE: Loop through array
        FOR i FROM 0 TO itemCount - 1
            IF inventoryArray[i].brand EQUALS brandName THEN
                INCREMENT count
            END IF
        END FOR
        RETURN count
    END FUNCTION
    
    // MAIN PROGRAM
    CALL loadInventoryFromCSV("inventory.csv")
    
    // CONTROL STRUCTURE: Main menu loop
    DO
        // OUTPUT: Display menu
        PRINT "\n=== Array-Based Inventory Menu ==="
        PRINT "1. Display All Items"
        PRINT "2. Search by Engine Number"
        PRINT "3. Count by Brand"
        PRINT "4. Exit"
        
        // INPUT: Get user choice
        INPUT choice
        
        // CONTROL STRUCTURE: Switch/Case for menu selection
        SWITCH choice
            CASE 1:
                CALL displayAllItems()
            CASE 2:
                PRINT "Enter Engine Number: "
                INPUT searchEngine
                result = CALL searchByEngineNumber(searchEngine)
                IF result IS NOT NULL THEN
                    PRINT result.toString()
                ELSE
                    PRINT "Item not found"
                END IF
            CASE 3:
                PRINT "Enter Brand Name: "
                INPUT brandName
                count = CALL countByBrand(brandName)
                PRINT "Total " + brandName + " items: " + count
            CASE 4:
                PRINT "Exiting..."
        END SWITCH
    WHILE choice NOT EQUALS 4
END

ELEMENTS IDENTIFIED:
- Input: CSV file data, user menu choices, search criteria
- Output: Inventory listings, search results, counts, menu displays
- Control Structures: WHILE loops, FOR loops, IF-ELSE, SWITCH-CASE, DO-WHILE
- Variables: inventoryArray, itemCount, choice, searchEngine, brandName, count
- Comments: Lines starting with //
```

---

## 2. LINKED LIST Implementation

```
ALGORITHM: InventoryLinkedListManagement
// Purpose: Manage inventory using a linked list (dynamic structure)
// Input: CSV file with inventory data
// Output: Display and manipulate inventory in linked list

BEGIN
    // VARIABLES
    DECLARE head AS Node = NULL // pointer to first node
    DECLARE tail AS Node = NULL // pointer to last node
    DECLARE size AS Integer = 0
    
    // NODE STRUCTURE
    CLASS Node
        DECLARE data AS InventoryItem
        DECLARE next AS Node
        
        CONSTRUCTOR Node(item)
            this.data = item
            this.next = NULL
        END CONSTRUCTOR
    END CLASS
    
    // FUNCTION: Add item to end of linked list
    FUNCTION addToEnd(item)
        DECLARE newNode AS Node = NEW Node(item)
        
        // CONTROL STRUCTURE: Check if list is empty
        IF head IS NULL THEN
            head = newNode
            tail = newNode
        ELSE
            tail.next = newNode
            tail = newNode
        END IF
        
        INCREMENT size
    END FUNCTION
    
    // FUNCTION: Load inventory from CSV
    FUNCTION loadInventoryFromCSV(filename)
        OPEN file filename
        SKIP first 2 lines // header lines
        
        // CONTROL STRUCTURE: Loop to read all records
        WHILE NOT end of file
            READ line from file
            PARSE line into: date, stockLabel, brand, engineNumber, status
            
            item = NEW InventoryItem(date, stockLabel, brand, engineNumber, status)
            CALL addToEnd(item)
        END WHILE
        
        CLOSE file
    END FUNCTION
    
    // FUNCTION: Display all items in linked list
    FUNCTION displayAll()
        // OUTPUT: Print header
        PRINT "=== Inventory Items (Linked List) ==="
        PRINT "Total Items: " + size
        
        DECLARE current AS Node = head
        DECLARE position AS Integer = 1
        
        // CONTROL STRUCTURE: Traverse linked list
        WHILE current IS NOT NULL
            PRINT position + ". " + current.data.toString()
            current = current.next
            INCREMENT position
        END WHILE
    END FUNCTION
    
    // FUNCTION: Delete item by engine number
    FUNCTION deleteByEngineNumber(engineNum)
        DECLARE current AS Node = head
        DECLARE previous AS Node = NULL
        
        // CONTROL STRUCTURE: Traverse to find item
        WHILE current IS NOT NULL
            IF current.data.engineNumber EQUALS engineNum THEN
                // CONTROL STRUCTURE: Check if deleting head
                IF previous IS NULL THEN
                    head = current.next
                ELSE
                    previous.next = current.next
                END IF
                
                DECREMENT size
                RETURN TRUE
            END IF
            
            previous = current
            current = current.next
        END WHILE
        
        RETURN FALSE // not found
    END FUNCTION
    
    // FUNCTION: Get item at specific position
    FUNCTION getAtPosition(position)
        // CONTROL STRUCTURE: Validate position
        IF position < 1 OR position > size THEN
            RETURN NULL
        END IF
        
        DECLARE current AS Node = head
        DECLARE index AS Integer = 1
        
        // CONTROL STRUCTURE: Traverse to position
        WHILE index < position
            current = current.next
            INCREMENT index
        END WHILE
        
        RETURN current.data
    END FUNCTION
    
    // MAIN PROGRAM
    CALL loadInventoryFromCSV("inventory.csv")
    
    // Menu loop similar to Array implementation
    // ... (menu code here)
END

ELEMENTS IDENTIFIED:
- Input: CSV file, user choices, search/delete criteria
- Output: Linked list traversal, deletion confirmations, item details
- Control Structures: WHILE loops, IF-ELSE, nested conditions
- Variables: head, tail, size, current, previous, position, newNode
- Comments: Lines starting with //
```

---

## 3. STACK Implementation

```
ALGORITHM: InventoryStackManagement
// Purpose: Manage inventory using LIFO (Last In First Out) stack structure
// Input: CSV file with inventory data
// Output: Stack operations (push, pop, peek)

BEGIN
    // VARIABLES
    DECLARE inventoryStack AS Stack of InventoryItem
    DECLARE tempStorage AS ArrayList // for loading from CSV
    
    // FUNCTION: Load inventory from CSV
    FUNCTION loadInventoryFromCSV(filename)
        OPEN file filename
        SKIP first 2 lines // header lines
        
        // CONTROL STRUCTURE: Loop to read all records
        WHILE NOT end of file
            READ line from file
            PARSE line into: date, stockLabel, brand, engineNumber, status
            
            item = NEW InventoryItem(date, stockLabel, brand, engineNumber, status)
            ADD item to tempStorage
        END WHILE
        
        CLOSE file
        
        // CONTROL STRUCTURE: Push items onto stack
        FOR EACH item IN tempStorage
            PUSH item onto inventoryStack
        END FOR
    END FUNCTION
    
    // FUNCTION: Push new item to stack
    FUNCTION pushItem(item)
        PUSH item onto inventoryStack
        // OUTPUT: Confirmation
        PRINT "Item pushed to stack: " + item.engineNumber
    END FUNCTION
    
    // FUNCTION: Pop item from stack
    FUNCTION popItem()
        // CONTROL STRUCTURE: Check if stack is empty
        IF inventoryStack IS EMPTY THEN
            PRINT "Stack is empty!"
            RETURN NULL
        ELSE
            item = POP from inventoryStack
            // OUTPUT: Display popped item
            PRINT "Popped item: " + item.toString()
            RETURN item
        END IF
    END FUNCTION
    
    // FUNCTION: Peek at top item without removing
    FUNCTION peekTop()
        // CONTROL STRUCTURE: Check if stack is empty
        IF inventoryStack IS EMPTY THEN
            PRINT "Stack is empty!"
            RETURN NULL
        ELSE
            item = PEEK at inventoryStack
            // OUTPUT: Display top item
            PRINT "Top item: " + item.toString()
            RETURN item
        END IF
    END FUNCTION
    
    // FUNCTION: Display all items in stack
    FUNCTION displayStack()
        // OUTPUT: Print header
        PRINT "=== Inventory Stack (LIFO) ==="
        PRINT "Stack Size: " + inventoryStack.size()
        
        // CONTROL STRUCTURE: Check if empty
        IF inventoryStack IS EMPTY THEN
            PRINT "Stack is empty!"
            RETURN
        END IF
        
        // Create temporary stack for display
        DECLARE tempStack AS Stack
        DECLARE position AS Integer = 1
        
        // CONTROL STRUCTURE: Pop all items for display
        WHILE inventoryStack IS NOT EMPTY
            item = POP from inventoryStack
            PRINT position + ". " + item.toString()
            PUSH item onto tempStack
            INCREMENT position
        END WHILE
        
        // CONTROL STRUCTURE: Restore original stack
        WHILE tempStack IS NOT EMPTY
            item = POP from tempStack
            PUSH item onto inventoryStack
        END WHILE
    END FUNCTION
    
    // FUNCTION: Process sold items (pop until found)
    FUNCTION processSoldItems()
        DECLARE soldCount AS Integer = 0
        DECLARE tempStack AS Stack
        
        // CONTROL STRUCTURE: Process entire stack
        WHILE inventoryStack IS NOT EMPTY
            item = POP from inventoryStack
            
            // CONTROL STRUCTURE: Check if sold
            IF item.status EQUALS "Sold" THEN
                INCREMENT soldCount
                PRINT "Processed sold item: " + item.engineNumber
            ELSE
                PUSH item onto tempStack
            END IF
        END WHILE
        
        // CONTROL STRUCTURE: Restore on-hand items
        WHILE tempStack IS NOT EMPTY
            item = POP from tempStack
            PUSH item onto inventoryStack
        END WHILE
        
        // OUTPUT: Summary
        PRINT "Total sold items processed: " + soldCount
    END FUNCTION
    
    // MAIN PROGRAM
    CALL loadInventoryFromCSV("inventory.csv")
    
    // CONTROL STRUCTURE: Menu loop
    DO
        PRINT "\n=== Stack-Based Inventory Menu ==="
        PRINT "1. Push Item"
        PRINT "2. Pop Item"
        PRINT "3. Peek Top Item"
        PRINT "4. Display Stack"
        PRINT "5. Process Sold Items"
        PRINT "6. Exit"
        
        INPUT choice
        
        SWITCH choice
            CASE 1:
                // Get item details from user
                PRINT "Enter item details..."
                // ... input code
                CALL pushItem(newItem)
            CASE 2:
                CALL popItem()
            CASE 3:
                CALL peekTop()
            CASE 4:
                CALL displayStack()
            CASE 5:
                CALL processSoldItems()
            CASE 6:
                PRINT "Exiting..."
        END SWITCH
    WHILE choice NOT EQUALS 6
END

ELEMENTS IDENTIFIED:
- Input: CSV file, user menu selections, new item data
- Output: Stack operations results, item displays, process confirmations
- Control Structures: WHILE loops, FOR EACH, IF-ELSE, SWITCH-CASE, DO-WHILE
- Variables: inventoryStack, tempStorage, tempStack, soldCount, position, choice
- Comments: Lines starting with //
```

---

## 4. QUEUE Implementation

```
ALGORITHM: InventoryQueueManagement
// Purpose: Manage inventory using FIFO (First In First Out) queue structure
// Input: CSV file with inventory data
// Output: Queue operations (enqueue, dequeue, processing orders)

BEGIN
    // VARIABLES
    DECLARE inventoryQueue AS Queue of InventoryItem
    DECLARE processedCount AS Integer = 0
    
    // FUNCTION: Load inventory from CSV into queue
    FUNCTION loadInventoryFromCSV(filename)
        OPEN file filename
        SKIP first 2 lines // header lines
        
        // CONTROL STRUCTURE: Loop to read all records
        WHILE NOT end of file
            READ line from file
            PARSE line into: date, stockLabel, brand, engineNumber, status
            
            item = NEW InventoryItem(date, stockLabel, brand, engineNumber, status)
            ENQUEUE item to inventoryQueue
        END WHILE
        
        CLOSE file
        // OUTPUT: Confirmation
        PRINT "Loaded " + inventoryQueue.size() + " items into queue"
    END FUNCTION
    
    // FUNCTION: Enqueue new item
    FUNCTION enqueueItem(item)
        ENQUEUE item to inventoryQueue
        // OUTPUT: Confirmation
        PRINT "Item enqueued: " + item.engineNumber
    END FUNCTION
    
    // FUNCTION: Dequeue item from front
    FUNCTION dequeueItem()
        // CONTROL STRUCTURE: Check if queue is empty
        IF inventoryQueue IS EMPTY THEN
            PRINT "Queue is empty!"
            RETURN NULL
        ELSE
            item = DEQUEUE from inventoryQueue
            // OUTPUT: Display dequeued item
            PRINT "Dequeued item: " + item.toString()
            RETURN item
        END IF
    END FUNCTION
    
    // FUNCTION: Peek at front item without removing
    FUNCTION peekFront()
        // CONTROL STRUCTURE: Check if queue is empty
        IF inventoryQueue IS EMPTY THEN
            PRINT "Queue is empty!"
            RETURN NULL
        ELSE
            item = PEEK at inventoryQueue
            // OUTPUT: Display front item
            PRINT "Front item: " + item.toString()
            RETURN item
        END IF
    END FUNCTION
    
    // FUNCTION: Display all items in queue
    FUNCTION displayQueue()
        // OUTPUT: Print header
        PRINT "=== Inventory Queue (FIFO) ==="
        PRINT "Queue Size: " + inventoryQueue.size()
        
        // CONTROL STRUCTURE: Check if empty
        IF inventoryQueue IS EMPTY THEN
            PRINT "Queue is empty!"
            RETURN
        END IF
        
        // Create temporary queue for display
        DECLARE tempQueue AS Queue
        DECLARE position AS Integer = 1
        
        // CONTROL STRUCTURE: Dequeue all items for display
        WHILE inventoryQueue IS NOT EMPTY
            item = DEQUEUE from inventoryQueue
            PRINT position + ". " + item.toString()
            ENQUEUE item to tempQueue
            INCREMENT position
        END WHILE
        
        // CONTROL STRUCTURE: Restore original queue
        WHILE tempQueue IS NOT EMPTY
            item = DEQUEUE from tempQueue
            ENQUEUE item to inventoryQueue
        END WHILE
    END FUNCTION
    
    // FUNCTION: Process orders (dequeue on-hand items first)
    FUNCTION processOrders(numOrders)
        DECLARE processed AS Integer = 0
        DECLARE tempQueue AS Queue
        
        // CONTROL STRUCTURE: Loop through queue
        WHILE inventoryQueue IS NOT EMPTY AND processed < numOrders
            item = DEQUEUE from inventoryQueue
            
            // CONTROL STRUCTURE: Check if on-hand
            IF item.status EQUALS "On-hand" THEN
                INCREMENT processed
                INCREMENT processedCount
                // OUTPUT: Processing confirmation
                PRINT "Processing order " + processed + ": " + item.engineNumber
                item.status = "Sold"
            END IF
            
            ENQUEUE item to tempQueue
        END WHILE
        
        // CONTROL STRUCTURE: Restore queue with remaining items
        WHILE inventoryQueue IS NOT EMPTY
            item = DEQUEUE from inventoryQueue
            ENQUEUE item to tempQueue
        END WHILE
        
        // Transfer back to original queue
        inventoryQueue = tempQueue
        
        // OUTPUT: Summary
        PRINT "Total orders processed: " + processed
    END FUNCTION
    
    // FUNCTION: Filter queue by brand
    FUNCTION filterByBrand(brandName)
        DECLARE filteredQueue AS Queue
        DECLARE tempQueue AS Queue
        DECLARE count AS Integer = 0
        
        // CONTROL STRUCTURE: Process entire queue
        WHILE inventoryQueue IS NOT EMPTY
            item = DEQUEUE from inventoryQueue
            
            // CONTROL STRUCTURE: Check brand match
            IF item.brand EQUALS brandName THEN
                ENQUEUE item to filteredQueue
                INCREMENT count
            END IF
            
            ENQUEUE item to tempQueue
        END WHILE
        
        // CONTROL STRUCTURE: Restore original queue
        WHILE tempQueue IS NOT EMPTY
            item = DEQUEUE from tempQueue
            ENQUEUE item to inventoryQueue
        END WHILE
        
        // OUTPUT: Display filtered results
        PRINT "Found " + count + " items of brand: " + brandName
        
        // CONTROL STRUCTURE: Display filtered items
        WHILE filteredQueue IS NOT EMPTY
            item = DEQUEUE from filteredQueue
            PRINT item.toString()
        END WHILE
    END FUNCTION
    
    // MAIN PROGRAM
    CALL loadInventoryFromCSV("inventory.csv")
    
    // CONTROL STRUCTURE: Menu loop
    DO
        PRINT "\n=== Queue-Based Inventory Menu ==="
        PRINT "1. Enqueue Item"
        PRINT "2. Dequeue Item"
        PRINT "3. Peek Front Item"
        PRINT "4. Display Queue"
        PRINT "5. Process Orders"
        PRINT "6. Filter by Brand"
        PRINT "7. Exit"
        
        INPUT choice
        
        SWITCH choice
            CASE 1:
                // Get item details from user
                PRINT "Enter item details..."
                // ... input code
                CALL enqueueItem(newItem)
            CASE 2:
                CALL dequeueItem()
            CASE 3:
                CALL peekFront()
            CASE 4:
                CALL displayQueue()
            CASE 5:
                PRINT "Enter number of orders to process: "
                INPUT numOrders
                CALL processOrders(numOrders)
            CASE 6:
                PRINT "Enter brand name: "
                INPUT brandName
                CALL filterByBrand(brandName)
            CASE 7:
                PRINT "Exiting..."
        END SWITCH
    WHILE choice NOT EQUALS 7
END

ELEMENTS IDENTIFIED:
- Input: CSV file, menu choices, number of orders, brand filter
- Output: Queue displays, order processing results, filter results
- Control Structures: WHILE loops, IF-ELSE, SWITCH-CASE, DO-WHILE, nested loops
- Variables: inventoryQueue, tempQueue, processedCount, position, choice, numOrders
- Comments: Lines starting with //
```

---

## 5. ARRAYLIST Implementation

```
ALGORITHM: InventoryArrayListManagement
// Purpose: Manage inventory using dynamic ArrayList structure
// Input: CSV file with inventory data
// Output: Dynamic list operations with sorting and filtering

BEGIN
    // VARIABLES
    DECLARE inventoryList AS ArrayList of InventoryItem
    DECLARE choice AS Integer
    
    // FUNCTION: Load inventory from CSV
    FUNCTION loadInventoryFromCSV(filename)
        OPEN file filename
        SKIP first 2 lines // header lines
        
        // CONTROL STRUCTURE: Loop to read all records
        WHILE NOT end of file
            READ line from file
            PARSE line into: date, stockLabel, brand, engineNumber, status
            
            item = NEW InventoryItem(date, stockLabel, brand, engineNumber, status)
            ADD item to inventoryList
        END WHILE
        
        CLOSE file
        // OUTPUT: Confirmation
        PRINT "Loaded " + inventoryList.size() + " items"
    END FUNCTION
    
    // FUNCTION: Display all items
    FUNCTION displayAll()
        // OUTPUT: Print header
        PRINT "=== Inventory ArrayList ==="
        PRINT "Total Items: " + inventoryList.size()
        
        // CONTROL STRUCTURE: For-each loop
        DECLARE index AS Integer = 1
        FOR EACH item IN inventoryList
            PRINT index + ". " + item.toString()
            INCREMENT index
        END FOR
    END FUNCTION
    
    // FUNCTION: Add new item
    FUNCTION addItem(item)
        ADD item to inventoryList
        // OUTPUT: Confirmation
        PRINT "Item added successfully: " + item.engineNumber
    END FUNCTION
    
    // FUNCTION: Remove item by index
    FUNCTION removeItem(index)
        // CONTROL STRUCTURE: Validate index
        IF index < 0 OR index >= inventoryList.size() THEN
            PRINT "Invalid index!"
            RETURN FALSE
        END IF
        
        removedItem = REMOVE item at index from inventoryList
        // OUTPUT: Confirmation
        PRINT "Removed: " + removedItem.toString()
        RETURN TRUE
    END FUNCTION
    
    // FUNCTION: Search items by brand
    FUNCTION searchByBrand(brandName)
        DECLARE results AS ArrayList
        
        // CONTROL STRUCTURE: For-each loop to search
        FOR EACH item IN inventoryList
            IF item.brand EQUALS brandName THEN
                ADD item to results
            END IF
        END FOR
        
        // OUTPUT: Display results
        PRINT "Found " + results.size() + " items"
        
        // CONTROL STRUCTURE: Display results
        FOR EACH item IN results
            PRINT item.toString()
        END FOR
        
        RETURN results
    END FUNCTION
    
    // FUNCTION: Filter by status
    FUNCTION filterByStatus(statusType)
        DECLARE filtered AS ArrayList
        
        // CONTROL STRUCTURE: For-each loop
        FOR EACH item IN inventoryList
            IF item.status EQUALS statusType THEN
                ADD item to filtered
            END IF
        END FOR
        
        RETURN filtered
    END FUNCTION
    
    // FUNCTION: Sort by brand (ascending)
    FUNCTION sortByBrand()
        // CONTROL STRUCTURE: Bubble sort algorithm
        FOR i FROM 0 TO inventoryList.size() - 2
            FOR j FROM 0 TO inventoryList.size() - i - 2
                // CONTROL STRUCTURE: Compare adjacent items
                IF inventoryList[j].brand > inventoryList[j + 1].brand THEN
                    // Swap items
                    temp = inventoryList[j]
                    inventoryList[j] = inventoryList[j + 1]
                    inventoryList[j + 1] = temp
                END IF
            END FOR
        END FOR
        
        // OUTPUT: Confirmation
        PRINT "List sorted by brand"
    END FUNCTION
    
    // FUNCTION: Update item status
    FUNCTION updateStatus(engineNumber, newStatus)
        DECLARE found AS Boolean = FALSE
        
        // CONTROL STRUCTURE: Search and update
        FOR i FROM 0 TO inventoryList.size() - 1
            IF inventoryList[i].engineNumber EQUALS engineNumber THEN
                oldStatus = inventoryList[i].status
                inventoryList[i].status = newStatus
                found = TRUE
                // OUTPUT: Confirmation
                PRINT "Updated " + engineNumber + " from " + oldStatus + " to " + newStatus
                BREAK
            END IF
        END FOR
        
        // CONTROL STRUCTURE: Check if found
        IF NOT found THEN
            PRINT "Item not found"
        END IF
        
        RETURN found
    END FUNCTION
    
    // FUNCTION: Get statistics
    FUNCTION getStatistics()
        DECLARE totalItems AS Integer = inventoryList.size()
        DECLARE onHandCount AS Integer = 0
        DECLARE soldCount AS Integer = 0
        DECLARE brandCounts AS Map
        
        // CONTROL STRUCTURE: Calculate statistics
        FOR EACH item IN inventoryList
            // Count by status
            IF item.status EQUALS "On-hand" THEN
                INCREMENT onHandCount
            ELSE IF item.status EQUALS "Sold" THEN
                INCREMENT soldCount
            END IF
            
            // Count by brand
            IF brandCounts CONTAINS item.brand THEN
                INCREMENT brandCounts[item.brand]
            ELSE
                brandCounts[item.brand] = 1
            END IF
        END FOR
        
        // OUTPUT: Display statistics
        PRINT "=== Inventory Statistics ==="
        PRINT "Total Items: " + totalItems
        PRINT "On-hand: " + onHandCount
        PRINT "Sold: " + soldCount
        PRINT "\nBrand Distribution:"
        
        // CONTROL STRUCTURE: Display brand counts
        FOR EACH brand IN brandCounts
            PRINT brand + ": " + brandCounts[brand]
        END FOR
    END FUNCTION
    
    // MAIN PROGRAM
    CALL loadInventoryFromCSV("inventory.csv")
    
    // CONTROL STRUCTURE: Menu loop
    DO
        PRINT "\n=== ArrayList-Based Inventory Menu ==="
        PRINT "1. Display All Items"
        PRINT "2. Add Item"
        PRINT "3. Remove Item"
        PRINT "4. Search by Brand"
        PRINT "5. Filter by Status"
        PRINT "6. Sort by Brand"
        PRINT "7. Update Status"
        PRINT "8. Get Statistics"
        PRINT "9. Exit"
        
        INPUT choice
        
        SWITCH choice
            CASE 1:
                CALL displayAll()
            CASE 2:
                // Get item details
                PRINT "Enter item details..."
                // ... input code
                CALL addItem(newItem)
            CASE 3:
                PRINT "Enter index to remove: "
                INPUT index
                CALL removeItem(index)
            CASE 4:
                PRINT "Enter brand name: "
                INPUT brandName
                CALL searchByBrand(brandName)
            CASE 5:
                PRINT "Enter status (On-hand/Sold): "
                INPUT statusType
                results = CALL filterByStatus(statusType)
                PRINT "Found " + results.size() + " items"
                FOR EACH item IN results
                    PRINT item.toString()
                END FOR
            CASE 6:
                CALL sortByBrand()
                CALL displayAll()
            CASE 7:
                PRINT "Enter engine number: "
                INPUT engineNum
                PRINT "Enter new status: "
                INPUT newStatus
                CALL updateStatus(engineNum, newStatus)
            CASE 8:
                CALL getStatistics()
            CASE 9:
                PRINT "Exiting..."
        END SWITCH
    WHILE choice NOT EQUALS 9
END

ELEMENTS IDENTIFIED:
- Input: CSV file, menu selections, item details, search criteria, update values
- Output: Lists, statistics, search results, confirmations, sorted data
- Control Structures: WHILE loops, FOR loops, FOR-EACH, IF-ELSE, SWITCH-CASE, nested loops
- Variables: inventoryList, choice, index, results, brandCounts, onHandCount, soldCount
- Comments: Lines starting with //
```

---

## Summary of Elements Across All Implementations

### Common Input Elements:
1. CSV file data (Date, Stock Label, Brand, Engine Number, Status)
2. User menu choices
3. Search criteria (engine number, brand, status)
4. New item data
5. Update values

### Common Output Elements:
1. Menu displays
2. Item listings
3. Search/filter results
4. Operation confirmations
5. Statistics and counts
6. Error messages

### Control Structures Used:
1. **WHILE loops** - File reading, queue/stack processing, traversals
2. **FOR loops** - Array iterations, sorting algorithms
3. **FOR-EACH loops** - ArrayList iterations
4. **IF-ELSE** - Conditional logic, validation
5. **SWITCH-CASE** - Menu selection handling
6. **DO-WHILE** - Main menu loops
7. **Nested loops** - Sorting, filtering, searching

### Variables by Data Structure:
1. **Array**: inventoryArray[], itemCount, choice, index
2. **Linked List**: head, tail, current, previous, size
3. **Stack**: inventoryStack, tempStack, soldCount
4. **Queue**: inventoryQueue, tempQueue, processedCount
5. **ArrayList**: inventoryList, results, brandCounts, statistics

### Comments:
- All pseudocode includes explanatory comments marked with //
- Comments describe purpose, logic, and operations
- Header comments for each function/algorithm
