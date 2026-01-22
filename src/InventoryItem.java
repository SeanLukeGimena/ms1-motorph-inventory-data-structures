/**
 * InventoryItem - Model class representing a single inventory item
 */
public class InventoryItem {
    // Instance variables
    private String dateEntered;
    private String stockLabel;
    private String brand;
    private String engineNumber;
    private String status;
    
    // Constructor
    public InventoryItem(String dateEntered, String stockLabel, String brand, 
                         String engineNumber, String status) {
        this.dateEntered = dateEntered;
        this.stockLabel = stockLabel;
        this.brand = brand;
        this.engineNumber = engineNumber;
        this.status = status;
    }
    
    // Getters
    public String getDateEntered() { return dateEntered; }
    public String getStockLabel() { return stockLabel; }
    public String getBrand() { return brand; }
    public String getEngineNumber() { return engineNumber; }
    public String getStatus() { return status; }
    
    // Setters
    public void setDateEntered(String dateEntered) { this.dateEntered = dateEntered; }
    public void setStockLabel(String stockLabel) { this.stockLabel = stockLabel; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setEngineNumber(String engineNumber) { this.engineNumber = engineNumber; }
    public void setStatus(String status) { this.status = status; }
    
    // toString method for display
    @Override
    public String toString() {
        return String.format("%-12s | %-10s | %-10s | %-14s | %-8s", 
                             dateEntered, stockLabel, brand, engineNumber, status);
    }
    
    // Display header for toString format
    public static String getHeader() {
        return String.format("%-12s | %-10s | %-10s | %-14s | %-8s", 
                             "Date", "Stock Label", "Brand", "Engine Number", "Status");
    }
}
