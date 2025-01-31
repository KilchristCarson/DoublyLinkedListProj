/*Car.java
Car class extends the Vehicle Class, a car object with
manufacturer, price and stock*/
public class Car extends Vehicle {
    public Car(String manufacturer, double price, int stock) {
        super(manufacturer, price, stock);
    }

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public String toString() {
        return "Car - Manufacturer: " + getManufacturer() + ", Price: " + getPrice() + ", Stock: " + getStock();
    }
}