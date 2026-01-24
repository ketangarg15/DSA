public class BitonicList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            data=d;
            next=null;
            prev=null;
        }
    }
    Node head;
    static Node reverse(Node head_ref){
        Node temp=null;
        Node curr=head_ref;
        while(curr!=null){
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;
        }
        if(temp!=null){
            head_ref=temp.prev;
        }
        return head_ref;
    }
    static Node merge(Node l1,Node l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.data<l2.data){
            l1.next=merge(l1.next, l2);
            l1.next.prev=l1;
            l1.prev=null;
            return l1;
        }
        else{
            l2.next=merge(l1, l2.next);
            l2.next.prev=l2;
            l2.prev=null;
            return l2;
        }
    }
    static Node sort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node current=head.next;
        while(current!=null){
            if(current.data<current.prev.data){
                break;
            }
            current=current.next;
        }
        if(current==null){
            return head;
        }
        current.prev.next=null;
        current.prev=null;
        current=reverse(current);
        return merge(head,current);
    }
    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node(0);
        new_node.data = new_data;
        new_node.prev = null;
        new_node.next = (head_ref);
        if ((head_ref) != null)
            (head_ref).prev = new_node;
        (head_ref) = new_node;
        return head_ref;
  }
    static void printList(Node head) {
        if (head == null)
            System.out.println("Doubly Linked list empty");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        Node head = null;
    
        head = push(head, 1);
        head = push(head, 4);
        head = push(head, 6);
        head = push(head, 10);
        head = push(head, 12);
        head = push(head, 7);
        head = push(head, 5);
        head = push(head, 2);
        System.out.println("Original List:");
        printList(head);
        head = sort(head);
        System.out.println("\nSorted List:");
        printList(head);
    }
}
