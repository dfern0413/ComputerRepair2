package linkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList<T> {
    Node<T> head;
    private int length = 0;
    private static final Logger LOGGER = LogManager.getLogger("LinkedList Logger");
    LinkedList() {
        this.head = null;
    }

    void add(T data) {
        Node<T> node = new Node<>(data);
        node.next = null;
        if (this.head == null) {
            head = node;
        }
        else {
            Node<T> node2 = head;
            while (node2.next != null) {
                node2 = node2.next;
            }
            node2.next = node;
        }
        length++;
    }
    public void show(){
        Node node = this.head;
        if(length == 0){
            LOGGER.info("Empty");
            return;
        }
        do {
            LOGGER.info(node.data);
            node = node.next;
        }while (node.next != null);
        LOGGER.info(node.data);
    }
    void addAt(int position, T data) {
        Node<T> node = new Node<>(data);
        node.next = null;

        if (position == 0) {
            Node<T> node1 = new Node<>(data);
            node.next = head;
            head = node;
        }
        else {
            Node<T> temp = head;
            for(int i = 0; i < position-1; i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }
    void removeAt(int position) {
        Node<T> prev = new Node<>(null);
        prev.next = head;
        Node<T> next = head.next;
        if (position == 0) {
            head = head.next;
        }
        else {
            Node node = head;
            Node temp = null;
            for(int i = 0; i < position-1; i++){
                node = node.next;
            }
            temp = node.next;
            node.next = temp.next;
        }
    }
    void clear() {
        head = null;
        length = 0;
    }
    int size() { return this.length; }
    public String toString() {
        StringBuilder S = new StringBuilder("[");
        Node<T> X = head;
        if (X == null)
            return S + "]";
        while (X.next != null) {
            S.append(String.valueOf(X.data)).append(",");
            X = X.next;
        }
        S.append(String.valueOf(X.data));
        return S + "]";
    }
}
