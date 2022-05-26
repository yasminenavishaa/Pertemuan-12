public class Node {
    Node prev, next;
    Film data;
    
    Node(Node prev, Film data, Node next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
