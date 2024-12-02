package Snorlax054;

public class Node<Interger> {
	int data;   
    Node<Interger> next;
    
    public Node(int data) 
    {
        this.data = data;
        this.next = null; // Default value
    }
    public void setNext(Node<Interger> next)
    {
    	this.next = next;
    }
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        Node<Interger> current = this;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}