public class node {
    String nama;
    int nomor;
    node prev, next;

    node(node prev, int no, String nama, node next){
        this.prev = prev;
        this.nama = nama;
        this.no = no;
        this.next = next;
    }
}