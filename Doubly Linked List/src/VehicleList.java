import java.io.FileWriter;
import java.io.IOException;

public class VehicleList {
    private Node head;
    private Node tail;


    private DeletedNode deletedHead;
    private DeletedNode deletedTail;

    public VehicleList() {
        head = null;
        tail = null;
        deletedHead = null;
        deletedTail = null;
    }

    public void insertRight(Vehicle vehicle) {
        Node newNode = new Node(vehicle);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }


    public void printLeftToRight(FileWriter writer) throws IOException {
        Node current = head;
        while (current != null) {
            writer.write(current.getVehicle().toString() + "\n");
            current = current.getNext();
        }
    }

    public void printRightToLeft(FileWriter writer) throws IOException {
        Node current = tail;
        while (current != null) {
            writer.write(current.getVehicle().toString() + "\n");
            current = current.getPrev();
        }
    }

    public void printNumberOfElements(FileWriter writer) throws IOException {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        writer.write("Total number of vehicles: " + count + "\n");
    }

    public void deleteByManufacturer(String manufacturer) {
        Node current = head;
        while (current != null) {
            if (current.getVehicle().getManufacturer().equalsIgnoreCase(manufacturer)) {
                Node toDelete = current;
                current = current.getNext();
                deleteNode(toDelete);
            } else {
                current = current.getNext();
            }
        }
    }


    private void deleteNode(Node node) {
        if (node == null) return;
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            head = node.getNext();
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            tail = node.getPrev();
        }


        addDeletedVehicle(node.getVehicle());

        node.setPrev(null);
        node.setNext(null);
    }

    private static class DeletedNode {

        public DeletedNode() {
        }

        public void setNext(DeletedNode next) {
        }

    }
    private void addDeletedVehicle(Vehicle vehicle) {
        DeletedNode newNode = new DeletedNode();
        if (deletedHead == null) {
            deletedHead = newNode;
            deletedTail = newNode;
        } else {
            deletedTail.setNext(newNode);
            deletedTail = newNode;
        }
    }

}
