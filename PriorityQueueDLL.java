public class PriorityQueueDLL{
    static class Node{
        int data;
        int priority;
        Node prev,next;
        Node(int data,int priority){
            this.data=data;
            this.priority=priority;
            this.prev=this.next=null;
        }
    }
        private Node head;
        public void insert(int data,int priority){
            Node newNode=new Node(data,priority);
            if(head==null || priority<head.priority){
                newNode.next=head;
                if(head!=null){
                    head.prev=null;
                }
                head=newNode;
                return;
            }
            Node temp=head;
            while(temp.next!=null && temp.next.priority<=priority){
                temp=temp.next;
            }
            newNode.next=temp.next;
            if(temp.next!=null){
                temp.next.prev=newNode;
            }
            temp.next=newNode;
            newNode.prev=temp;
    }
     public int delete() {
        if (head == null) {
            throw new RuntimeException("Priority Queue is empty");
        }

        int val = head.data;
        head = head.next;

        if (head != null)
            head.prev = null;

        return val;
    }

    // Peek highest priority element
    public int peek() {
        if (head == null) {
            throw new RuntimeException("Priority Queue is empty");
        }
        return head.data;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print("(" + temp.data + ", p=" + temp.priority + ") <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        PriorityQueueDLL pq = new PriorityQueueDLL();

        pq.insert(10, 3);
        pq.insert(20, 1);
        pq.insert(30, 2);
        pq.insert(40, 1);

        System.out.println("Priority Queue:");
        pq.display();

        System.out.println("Peek: " + pq.peek());
        System.out.println("Deleted: " + pq.delete());

        System.out.println("After deletion:");
        pq.display();
    }
}