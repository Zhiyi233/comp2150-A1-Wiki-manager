//---------------------------------------
// CLASS: ContentList
//
// Author: Zhiyi Chen,7863368
//
// REMARKS: A list of content for every document. Each document has its own contents
//so this class is for storing content data.
//
//-----------------------------------------
public class ContentList extends List {
    private Node head;
    private int contentSize;
    private  List list;

    public ContentList(){
        head=null;
        this.list=new List();
        this.contentSize=0;
    }
    public int getSize(){
        return this.contentSize;
    }

    public void addNode(ListItem item){
        head=new Node(item,head);
        this.contentSize++;
    }

    public String addString(String[] token, int index){
        return this.list.addString(token,index);
    }
    //----------------------------------
    //replaceLine
    //PURPOSE: this method is trying to find the replace line of content
    //and replace the current contents with the new contents
    //---------------------------------
    public boolean replaceLine(ContentList cL, String targetLine,String content){
        boolean foundLine;
        Node temp; //temporary use
        temp=head;
        ListItem curr;

        String totalLine=String.valueOf(cL.getSize()); //convert the line number into string
        int lineNum=cL.getSize();//this is the total line number of content for each document

        while(!totalLine.equals(targetLine)&&lineNum>0){
            lineNum--;
            totalLine=String.valueOf(lineNum);
            temp=temp.getNext();
        }
        if(totalLine.equals(targetLine)){
            curr= temp.getData(); //get the data from current Node
            curr.setData(content); //replace the data with new content
            foundLine=true;
        }else{
            foundLine=false;
          //  System.out.println("there is no line："+targetLine);
        }
        return foundLine;
    }
    //-------------------------------------------------------
    //deleteLine
    //this method is similar to replaceLine
    //the only difference is that it will delete the current Node rather
    //replace a new content
    //-----------------------------------------------------
    public boolean deleteLine(ContentList contentList,String targetLine){
        boolean done=false;
        Node curr=head;
        Node prev=head;
        int lineNum=contentList.getSize();
        String totalLine=String.valueOf(lineNum);

        while(!totalLine.equals(targetLine)&&lineNum>0){
            lineNum--;
            totalLine=String.valueOf(lineNum);
            prev=curr; //assign to the previous node
            curr=curr.getNext(); //get the next node
        }
        if(totalLine.equals(targetLine)&&lineNum>0){
            //in this case temp is the node that we want to delete
            curr=curr.getNext(); //the next node for delete node
            prev=prev.setNext(curr);
            done=true;
            //System.out.println("delete successfully");
            contentSize--;
        }else{
            done=false;
        }
        return done;
    }
    //----------------------------
    //printContent
    //PURPOSE: print all the line number of each line and the content of that line
    //Parameters: The total number of the content, the contentList
    //------------------------------
    public void printContent(int lineNum,ContentList list){
        Node temp=head;
        ListItem curr;
        String str;

        while(lineNum!=0){
            curr=temp.getData();
            str=curr.toString();
            System.out.println(lineNum+" "+str);
            temp=temp.getNext();
            lineNum--;
        }
    }

    public void print(){
        if(head!=null){
            head.print();
        }
    }
}
