package homework3;

class Node<T>{
    public Node(){
        this.next = null;
    }
    public T date;
    public Node next;

    @Override
    public String toString() {
        return "Node{" +
                "date=" + date +
                ", next=" + next +
                '}';
    }
}
public class LinkList {
    public static void main(String[] args) {
        System.out.println("headInsert：");
        Node<Integer> head = new Node<Integer>();
        head.date=0;
        System.out.println("head->next = " + head.next);

        Node<Integer> node1 = new Node<Integer>();
        node1.date = 1;
        headInsert(head,node1);
        System.out.println("head->next = " + head.next);

        Node<Integer> node2 = new Node<Integer>();
        node2.date = 2;
        headInsert(head,node2);
        System.out.println("head->next = " + head.next);

        System.out.println("tailInsert：");
        Node<Integer> tail = new Node<Integer>();
        tail = head.next.next;
        System.out.println("head->next = " + head.next);


        Node<Integer> node3 = new Node<Integer>();
        node3.date = 3;
        tailInsert(tail,node3);
        tail = tail.next;
        System.out.println("head->next = " + head.next);

        Node<Integer> node4 = new Node<Integer>();
        node4.date = 4;
        tailInsert(tail,node4);
        tail=tail.next;
        System.out.println("head->next = " + head.next);

        System.out.println(head);
    }

    public static void headInsert(Node head,Node newNode){
        newNode.next = head.next;
        head.next = newNode;
    }
    public static void tailInsert(Node tail,Node newNode){
        tail.next = newNode;
    }
}
