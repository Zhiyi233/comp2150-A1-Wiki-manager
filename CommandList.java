//---------------------------------------
// CLASS: CommandList
//
// Author: Zhiyi Chen,7863368
//
// REMARKS: this class is to create a list to store all the command for users
//
//-----------------------------------------
public class CommandList extends List{
    private Node head;

    public CommandList(){
        head=null;
    }

    public void addNode(ListItem data){
        head = new Node(data, head);
    }

}
