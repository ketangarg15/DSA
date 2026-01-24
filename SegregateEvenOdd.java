import java.util.LinkedList;

public class SegregateEvenOdd {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
            }
        current.next = newNode;
    }
    public void segregateEvenOdd(){
        if(head==null){
            return;
        }
        Node evenHead=null,eventail=null,oddHead=null,oddtail=null;
        Node current=head;
        while(current!=null){
            int data=current.data;
            if(data%2==0){
                if(evenHead==null){
                    evenHead=eventail=current;
                }
                else{
                    eventail.next=current;
                    eventail=current;
                }
            }
            else{
                if(oddHead==null){
                    oddHead=oddtail=current;
                }
                else{
                    oddtail.next=current;
                    oddtail=current;
                }
            }
            current=current.next;
        }
        if(evenHead!=null){
            eventail.next=oddHead;
        }
        if(oddHead!=null){
            oddtail.next=null;
        }
        head=evenHead!=null?evenHead:oddHead;
    }
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SegregateEvenOdd list = new SegregateEvenOdd();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("Original list:");
        list.printList();

        list.segregateEvenOdd();

        System.out.println("Segregated list (even before odd):");
        list.printList();
    }
}