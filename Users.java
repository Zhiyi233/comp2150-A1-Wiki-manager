//---------------------------------------
// CLASS: User
//
// Author: Zhiyi Chen,7863368
//
// REMARKS: User class extends from ListItem. This is the actual object for the information
//of users' id.
//
//-----------------------------------------
public class Users extends ListItem{
    private String name;

    //constructor for Users
    public Users(String userId){
        this.name=userId;
    }

    public boolean equal(String userId){
       return this.name.equals(userId);
    }

    public void print(){
        System.out.println(name);
    }
    public String setData(String userId){ return this.name=userId; }
    public String toString(){return name.toString();}
}
