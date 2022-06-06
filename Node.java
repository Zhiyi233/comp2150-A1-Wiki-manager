//---------------------------------------
// CLASS: Node
//
// Author: Zhiyi Chen,7863368
//
// REMARKS: Node for any linkedList data structure for the wiki. It holds any ListItem as data.
//And there are some basic operation functions for linked list.
//
//-----------------------------------------
public class Node {
    private ListItem data;
    private Node next;

    public Node(ListItem data, Node next){
        this.next=next;
        this.data=data;
    }

    public void print(){
        data.print();
        if(next!=null){
            next.print();
        }
    }
    public Node getNext(){
        return next;
    }
    public ListItem getData(){
        return data;
    }
    public String toString(){
        return data.toString();
    }
    public Node setNext(Node n){
        return this.next=n;
    }
}
