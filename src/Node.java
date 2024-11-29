package Snorlax054;

public class Node {
    int data;       // Example field to store data
    Node next;      // Reference to the next node (for a linked list)
    
    public Node(int data) 
    {
        this.data = data;
        this.next = null; // Default value
    }
    public void isNext(Node next)
    {
    	this.next = next;
    }
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        Node current = this;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}