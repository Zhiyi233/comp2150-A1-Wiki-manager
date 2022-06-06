//---------------------------------------
// CLASS: UserList
//
// Author: Zhiyi Chen,7863368
//
// REMARKS: UserList class stores a list of registered users. This class extends from List to get
//some basic information of our list.
//
//-----------------------------------------
public class UserList extends List {
    private Node head;
    private int size;
    public UserList(){
        head=null;
        size=0;
    }

    public boolean isEmpty(){
       return head==null;
    }
    public int getSize(){
        return this.size;
    }

    //----------------------------
    //search
    //PURPOSE: Define the Wiki object for this class, and call readTextFile method
    //to print all the output for our program
    //Parameter:the name of the user that we want to check if it is duplicate.
    //Return: return true if there is duplicate
    //------------------------------
    public boolean search(String name){
        boolean found=false;
        Node temp=head;
        ListItem currtItem;

        while (temp!=null&&!found){
            currtItem=temp.getData();
            if(currtItem.equal(name)){
                found=true; //we found the duplicate users in the user list
            }
            temp=temp.getNext();
        }
        return found;
    }

    public void addNode(ListItem data){
        head=new Node(data,head);
        size++;
    }
    public void print(){
        if(head!=null){
            head.print();
        }
    }
}
