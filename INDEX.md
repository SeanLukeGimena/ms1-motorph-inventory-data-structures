# 📑 PROJECT INDEX
## MotorPH Inventory Management System - Navigation Guide

---

## 📖 START HERE

### For First-Time Users:
1. **[QUICK_START.md](QUICK_START.md)** - Step-by-step guide to run the program
2. **[README.md](README.md)** - Complete project overview and features

### For Understanding the Project:
1. **[PROJECT_SUMMARY.md](PROJECT_SUMMARY.md)** - Comprehensive completion summary
2. **[PSEUDOCODE.md](PSEUDOCODE.md)** - Detailed algorithms and pseudocode
3. **[ELEMENTS_IDENTIFICATION.md](ELEMENTS_IDENTIFICATION.md)** - Element analysis

---

## 📁 DOCUMENTATION FILES

### 🚀 Quick Start Guide
**File**: [QUICK_START.md](QUICK_START.md)  
**Purpose**: Get up and running quickly  
**Contains**:
- Compilation instructions
- How to run the program
- Menu navigation guide
- Example workflows
- Troubleshooting tips

**When to use**: First time running the project

---

### 📘 Main Documentation
**File**: [README.md](README.md)  
**Purpose**: Complete project documentation  
**Contains**:
- Project overview
- Data structure descriptions
- Feature lists by implementation
- Algorithm documentation
- Usage instructions
- File structure
- Testing results

**When to use**: Understanding project features and capabilities

---

### 📋 Project Summary
**File**: [PROJECT_SUMMARY.md](PROJECT_SUMMARY.md)  
**Purpose**: Comprehensive completion report  
**Contains**:
- Requirements checklist ✅
- Implementation statistics
- Testing results
- Deliverables verification
- Code metrics
- Bonus features

**When to use**: Reviewing project completion status

---

### 🔤 Pseudocode Documentation
**File**: [PSEUDOCODE.md](PSEUDOCODE.md)  
**Purpose**: Detailed algorithm documentation  
**Contains**:
- Array pseudocode (with comments)
- Linked List pseudocode (with comments)
- Stack pseudocode (with comments)
- Queue pseudocode (with comments)
- ArrayList pseudocode (with comments)
- Element identification for each
- Summary of all elements

**When to use**: Understanding algorithms before implementation

---

### 🔍 Element Identification
**File**: [ELEMENTS_IDENTIFICATION.md](ELEMENTS_IDENTIFICATION.md)  
**Purpose**: Comprehensive element analysis  
**Contains**:
- Input elements (6 types)
- Output elements (6 types)
- Control structures (7 types)
- Variables (50+ documented)
- Comments (7 types)
- Summary tables
- Comparison across implementations

**When to use**: Analyzing program structure and elements

---

## 💻 SOURCE CODE FILES

### 🎯 Main Application
**File**: [src/App.java](src/App.java)  
**Purpose**: Main entry point  
**Features**:
- Data structure selector menu
- Navigation between implementations
- Clean user interface

**How to run**:
```bash
cd src
java App
```

---

### 📦 Model Class
**File**: [src/InventoryItem.java](src/InventoryItem.java)  
**Purpose**: Data model for inventory items  
**Contains**:
- Private fields (dateEntered, stockLabel, brand, engineNumber, status)
- Constructor
- Getters and Setters
- toString() method for display
- Static getHeader() method

**Used by**: All 5 data structure implementations

---

### 1️⃣ Array Implementation
**File**: [src/ArrayInventory.java](src/ArrayInventory.java)  
**Data Structure**: Fixed-size array  
**Key Features**:
- Capacity: 100 items
- Linear search O(n)
- Index-based access O(1)
- Count operations
- Statistics display

**Menu Options**:
1. Display All Items
2. Search by Engine Number
3. Count by Brand
4. Count by Status
5. Display Statistics
6. Exit

**How to run**:
```bash
cd src
java ArrayInventory
```

---

### 2️⃣ Linked List Implementation
**File**: [src/LinkedListInventory.java](src/LinkedListInventory.java)  
**Data Structure**: Singly linked list with nodes  
**Key Features**:
- Dynamic size
- Node-based structure
- Insert/Delete operations
- Position-based access
- Traversal methods

**Menu Options**:
1. Display All Items
2. Search by Engine Number
3. Delete by Engine Number
4. Get Item at Position
5. Count by Brand
6. Display List Size
7. Exit

**How to run**:
```bash
cd src
java LinkedListInventory
```

---

### 3️⃣ Stack Implementation
**File**: [src/StackInventory.java](src/StackInventory.java)  
**Data Structure**: Stack (LIFO - Last In First Out)  
**Key Features**:
- Push/Pop operations O(1)
- Peek without removing
- Non-destructive display
- Process sold items
- Search while preserving

**Menu Options**:
1. Push Item (Add to top)
2. Pop Item (Remove from top)
3. Peek Top Item
4. Display Stack
5. Process Sold Items
6. Search by Engine Number
7. Count by Brand
8. Exit

**How to run**:
```bash
cd src
java StackInventory
```

---

### 4️⃣ Queue Implementation
**File**: [src/QueueInventory.java](src/QueueInventory.java)  
**Data Structure**: Queue (FIFO - First In First Out)  
**Key Features**:
- Enqueue/Dequeue operations O(1)
- Peek at front
- Order processing system
- Filter by brand/status
- Track processed count

**Menu Options**:
1. Enqueue Item (Add to rear)
2. Dequeue Item (Remove from front)
3. Peek Front Item
4. Display Queue
5. Process Orders
6. Filter by Brand
7. Filter by Status
8. Count by Brand
9. Exit

**How to run**:
```bash
cd src
java QueueInventory
```

---

### 5️⃣ ArrayList Implementation
**File**: [src/ArrayListInventory.java](src/ArrayListInventory.java)  
**Data Structure**: ArrayList (Dynamic array)  
**Key Features**:
- Dynamic resizing
- Bubble sort algorithm
- Update operations
- Advanced statistics
- Multiple filters

**Menu Options**:
1. Display All Items
2. Add Item
3. Remove Item
4. Search by Brand
5. Search by Engine Number
6. Filter by Status
7. Sort by Brand
8. Sort by Date
9. Update Status
10. Get Statistics
11. Exit

**How to run**:
```bash
cd src
java ArrayListInventory
```

---

## 📊 DATA FILES

### CSV Inventory Data
**File**: [csv/MotorPH Inventory Data - March 2023 Inventory Data.csv](csv/MotorPH Inventory Data - March 2023 Inventory Data.csv)  
**Format**:
```
Date Entered, Stock Label, Brand, Engine Number, Status
```

**Records**: 49 inventory items  
**Brands**: Honda, Yamaha, Suzuki, Kawasaki, Kymco  
**Status Types**: On-hand, Sold  
**Stock Labels**: Old (February), New (March)

---

## 🎓 LEARNING PATH

### Beginner Path:
1. Read [QUICK_START.md](QUICK_START.md)
2. Run the program: `java App`
3. Try each data structure (options 1-5)
4. Read [README.md](README.md) for features

### Intermediate Path:
1. Read [PSEUDOCODE.md](PSEUDOCODE.md)
2. Review [ELEMENTS_IDENTIFICATION.md](ELEMENTS_IDENTIFICATION.md)
3. Examine source code in `src/` folder
4. Compare different implementations

### Advanced Path:
1. Study all pseudocode algorithms
2. Analyze time/space complexity
3. Review element identification
4. Modify and extend the code
5. Create custom operations

---

## 🔗 QUICK LINKS

### Documentation
- [Quick Start Guide](QUICK_START.md) - Get started
- [README](README.md) - Full documentation
- [Project Summary](PROJECT_SUMMARY.md) - Completion status
- [Pseudocode](PSEUDOCODE.md) - Algorithm details
- [Elements](ELEMENTS_IDENTIFICATION.md) - Element analysis

### Source Code
- [App.java](src/App.java) - Main application
- [InventoryItem.java](src/InventoryItem.java) - Model class
- [ArrayInventory.java](src/ArrayInventory.java) - Array implementation
- [LinkedListInventory.java](src/LinkedListInventory.java) - Linked List
- [StackInventory.java](src/StackInventory.java) - Stack
- [QueueInventory.java](src/QueueInventory.java) - Queue
- [ArrayListInventory.java](src/ArrayListInventory.java) - ArrayList

### Data
- [CSV File](csv/MotorPH Inventory Data - March 2023 Inventory Data.csv) - Inventory data

---

## 📌 CHEAT SHEET

### Compilation
```bash
cd src
javac *.java
```

### Run Main App
```bash
java App
```

### Run Individual Implementations
```bash
java ArrayInventory      # Array
java LinkedListInventory # Linked List
java StackInventory      # Stack
java QueueInventory      # Queue
java ArrayListInventory  # ArrayList
```

### Sample Engine Numbers for Testing
- `142QVTSIUR` - Honda, On-hand
- `PZCT1S00XE` - Honda, Sold
- `NO8VW05PU9` - Suzuki, On-hand
- `NWIP2MQEIN` - Yamaha, Sold

### Sample Brands for Testing
- Honda
- Yamaha
- Suzuki
- Kawasaki
- Kymco

---

## 📞 PROJECT INFO

**Name**: MotorPH Inventory Management System  
**Type**: Data Structures and Algorithm Implementation  
**Status**: ✅ Complete  
**Files**: 12 source/documentation files  
**Lines of Code**: ~1,660 lines  
**Data Structures**: 5 implementations  

---

## ✅ COMPLETION CHECKLIST

- ✅ 5 Data structures implemented
- ✅ Pseudocode with comments
- ✅ Elements identified
- ✅ Java code converted
- ✅ CSV integration
- ✅ Documentation complete
- ✅ Code compiles
- ✅ All features tested

---

**Navigate this project easily using the links above!**

*For questions or issues, refer to the appropriate documentation file.*
