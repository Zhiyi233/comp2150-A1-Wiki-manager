//---------------------------------------
// CLASS: DocList
//
// Author: Zhiyi Chen,7863368
//
// REMARKS: DocList class extends from List class, DocList is a list that stores a list of document's
//title. When we trying to check if there is a duplicate document in our system,
//we can call function searchDoc to do this job.
//
//-----------------------------------------
public class DocList extends List {
    private Node head;
    private int docSize;
    public DocList() {
        head = null;
        docSize=0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addNode(ListItem data) {
        head = new Node(data, head);
        this.docSize++;
    }
    public int getSize(){
        return this.docSize;
    }

    //----------------------------
    //searchDoc
    //PURPOSE: Define the Wiki object for this class, and call readTextFile method
    //to print all the output for our program
    //Parameter:the name of the document that we want to check if it is duplicate.
    //Return: return true if there is duplicate
    //------------------------------
    public boolean searchDoc(String docName) {
        boolean found = false;
        Node temp = head;
        ListItem currtItem;

        while (temp != null && !found) {
            currtItem = temp.getData();
            if (currtItem.equal(docName)) {
                found = true; //we found the duplicate doc in the docList
            }
            temp = temp.getNext();
        }
        return found;
    }
    public void print(){
        if(head!=null){
            head.print();
        }
    }
}
