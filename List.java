//---------------------------------------
// CLASS: List
//
// Author: Zhiyi Chen,7863368
//
// REMARKS: List class
//title.
//
//-----------------------------------------
public class List extends ListItem{
    private Node head;
    private int size;
    public List(){
        head=null;
        this.size=0;
    }

    public void print(){
        //code
        if(head!=null){
            head.print();
        }
    }
    public int getSize(){
        return this.size;
    }

    public void addNode(ListItem data){
        head= new Node(data,head);
        this.size++;
    }

    public boolean equal(String userId){
        return head.toString().equals(userId);
    }

    public String setData(String set){return set;}

    public String addString(String[] inTokens,int index){
        String result="";
        for(int i=index;i<inTokens.length;i++){
            char spaceString=' '; //a space character between each string
            result+=inTokens[i]+spaceString;
        }
        return result;
    }
    public String toString(){
        return head.toString();
    }
}
