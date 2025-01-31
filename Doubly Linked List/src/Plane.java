/*Plane.java
Plane Class extends the Vehicle Class, a plane object
with manufacturer, price, stock, and engine type*/
public class Plane extends Vehicle {
    private final String engineType;

    public Plane(String manufacturer, double price, int stock, String engineType) {
        super(manufacturer, price, stock);
        this.engineType = engineType;
    }
    @Override
    public String getType() {
        return "Plane";
    }
    public String getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return "Plane -  Manufacturer: " + getManufacturer() + ", Price: " + getPrice() + ", Stock: " + getStock() + ", Engine Type: " + engineType;
    }
}