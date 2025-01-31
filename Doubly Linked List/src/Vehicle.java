/*Vehicle.java
abstract base class for Vehicles, with their shared attributes
manufacturer, price, and stock*/
public abstract class Vehicle {
    private final String manufacturer;
    private final double price;
    private final int stock;
    public Vehicle(String manufacturer, double price, int stock) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Vehicle - Manufacturer: " + manufacturer + ", Price: " + price + ", Stock: " + stock;
    }
}