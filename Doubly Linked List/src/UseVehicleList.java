import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class UseVehicleList {
    public static void main(String[] args) {
        VehicleList vehicleList = new VehicleList();
        String inputFilePath = "ContainersAfall24Double.txt";
        String outputFilePath = "UseVehicleList.txt";

        try (Scanner scanner = new Scanner(new File(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {
            /*Allowing for multi-line and single-line readability helps the customer by being more flexible
            to the command format they choose*/
            StringBuilder multiLineData = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                if (line.equals("IR") || line.equals("IF") || !multiLineData.isEmpty()) {
                    multiLineData.append(line).append(" ");
                    String[] parts = multiLineData.toString().trim().split("\\s+");

                    if (parts.length == 4) {
                        String command = parts[0];
                        String manufacturer = parts[1];
                        double price = Double.parseDouble(parts[2]);
                        int stock = Integer.parseInt(parts[3]);

                        if (command.equals("IR") || command.equals("IF")) {
                            insertVehicle(new String[]{command, manufacturer, String.valueOf(price), String.valueOf(stock)}, vehicleList, writer, true);
                        }

                        multiLineData.setLength(0);
                        continue;
                    } else {
                        continue;
                    }
                }

                String[] parts = line.split("\\s+");
                String command = parts[0];
                switch (command) {
                    case "IR":
                        insertVehicle(parts, vehicleList, writer, true);
                        break;

                    case "IF":
                        insertVehicle(parts, vehicleList, writer, false);
                        break;

                    case "D":
                        if (parts.length == 2) {
                            String manufacturer = parts[1];
                            writer.write("Deleting all vehicles by: " + manufacturer + "\n\n");
                            vehicleList.deleteByManufacturer(manufacturer);
                        }
                        break;

                    case "PN":
                        writer.write("\n");
                        vehicleList.printNumberOfElements(writer);

                        break;

                    case "PF":
                        writer.write("\n");
                        writer.write("Current Vehicles in the list (Right to Left):\n");
                        vehicleList.printRightToLeft(writer);
                        writer.write("\n");

                        break;

                    case "PL":
                        writer.write("Current Vehicles in the list (Left to Right):\n");
                        vehicleList.printLeftToRight(writer);
                        writer.write("\n");

                        break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertVehicle(String[] parts, VehicleList vehicleList, FileWriter writer, boolean insertRight) throws IOException {
        if (parts.length < 4) {
            System.out.println("Invalid command format for: " + String.join(" ", parts));
            return;
        }
        String manufacturer = parts[1];
        double price = Double.parseDouble(parts[2]);
        int stock = Integer.parseInt(parts[3]);

        Vehicle vehicle;
        if (manufacturer.equalsIgnoreCase("Boeing") || manufacturer.equalsIgnoreCase("Piper")) {
            vehicle = new Plane(manufacturer, price, stock, "Jet");
        } else if (manufacturer.equalsIgnoreCase("Cessna")) {
            vehicle = new Plane(manufacturer, price, stock, "Propeller");
        } else {
            vehicle = new Car(manufacturer, price, stock);
        }

        writer.write(String.format("Inserted vehicle: %s Price: %.2f Stock: %d\n", manufacturer, price, stock));
        vehicleList.insertRight(vehicle);

    }
}