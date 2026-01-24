

public class CycleDetection{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    Node head;
    void push(int newData){
        Node newNode=new Node(newData);
        newNode.next=head;
        head=newNode;
    }
    void detectLoopAndPrint(){
        Node slow=head,fast=head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.print("Loop Found");
                return;
            }
        }
        System.out.println("Loop not found");
    }
    void removeloop(){
        Node slow=head,fast=head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                slow.next=null;
                System.out.println(slow.data);
                return;
            }
        }
    }
    public static void main(String[] args) {
        CycleDetection list=new CycleDetection();
        list.push(20);
        list.push(1000);
        list.push(23000);
        list.push(98);
        list.head.next.next.next.next=list.head;
        list.detectLoopAndPrint();
        list.removeloop();
    }
}