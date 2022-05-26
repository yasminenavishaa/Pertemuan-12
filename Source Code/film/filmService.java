public class filmService {
    Node head, tail;
    int size;

    public filmService() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(film item) {
        if (isEmpty()) {
            head = new Node(null, item, null);
            tail = head;
        } else {
            Node newNode = new Node(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(film item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
           Node temp = new Node(tail, item, null);
           tail.next = temp;
           tail = temp;
           size++;

        }
    }

    public void add(film item, int index){
        if (index == 0) {
            addFirst(item);
        }else if (index == size+1) {
            addLast(item);
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node newNode = new Node(current.prev, item, current);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            while (tmp != null) {
                System.out.println("ID " + tmp.data.id);
                System.out.println(" Judul film " + tmp.data.nama );
                System.out.println(" Rating film " + tmp.data.rating );
                System.out.println("");
                tmp = tmp.next;
            }
        } else {
            System.out.println("Linked Lists Kosong");
        }
    }

    public film removeFirst() {
        if (!isEmpty()) {
            film item = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            }else{
                head.prev = null;
            }
            size--;
            return item;
        } else {
            return null;
        }
    }

    public film removeLast(){
        if (!isEmpty()) {
            film item = tail.data;
            tail = tail.prev;
            if(tail == null){
                head = null;
            }else{
                tail.next = null;
            }
            size--;
            return item;
        } else {
            return null;
        }
    }

    public film remove(int index) {
        if (index == 1) {
            return removeFirst();
        } else if (index == size){
            return removeLast();
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            film item = current.data;
            current.prev.next = current.next;
            current.next.prev = current. prev;
            size--;
            return item;
        }
    }

    public film get(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("linked List Kosong");
        }
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int cari(int id) {
        Node tmp = head;
        int index = 0;
        while(tmp.next != null && tmp.data.id != id){
            tmp = tmp.next;
            index++;
        }
        if(tmp.data.id != id){
            return -1;
        }else{
            return index;
        }
    }

    public void printDesc() {
        if (!isEmpty()) {
            film[] FilmsOrderByRateDesc = new film[size];
            Node current = head;
            int counter = 0;
            // Store data from list to array
            while (true) {
                if (counter == size) break;
                FilmsOrderByRateDesc[counter] = current.data;
                counter++;
                current = current.next;
            }
            // Sort array
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (FilmsOrderByRateDesc[i].rating < FilmsOrderByRateDesc[j].rating) {
                        film temp = FilmsOrderByRateDesc[i];
                        FilmsOrderByRateDesc[i] = FilmsOrderByRateDesc[j];
                        FilmsOrderByRateDesc[j] = temp;
                    }
                }
            }
            // Print array
            System.out.println("Cetak Data film Berdasarkan Rating Desc");
            for (int i = 0; i < size; i++) {
                System.out.println(FilmsOrderByRateDesc[i]);
                System.out.println("");
            }
        } else {
            System.out.println("List masih kosong");
        }

    }
}