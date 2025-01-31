/*Node.java
Node holds a reference to Vehicle with pointers to next
and previous nodes*/
class Node {
    private final Vehicle vehicle;
    private Node next;
    private Node prev;

    public Node(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}