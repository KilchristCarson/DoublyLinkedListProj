This project implements a doubly linked list to manage a collection of vehicles, including both cars and planes.
The program reads commands from an input file (ContainersAfall24Double.txt), processes them, and outputs the results to UseVehicleList.txt.
The list supports insertion, deletion, and printing in both forward and reverse order.
The core functionality is handled in UseVehicleList.java, which parses the input file and processes commands.
Vehicles are represented by the Vehicle class, with Car and Plane extending it.
The Node class stores individual vehicles and links them within the doubly linked list.
The VehicleList class manages this list, providing insertion at the front or rear, deletion of all vehicles by a specific manufacturer, and functions to print the list in either direction.
It also maintains a list of deleted vehicles.Output includes inserted vehicles, the list's current state, and deleted entries.
This implementation demonstrates efficient list operations while preserving flexibility in handling different vehicle types and input formats.
This was a project from my Fall 2024 semester class, with some of the design choices being made due to certain restrictions I had to maintain.
