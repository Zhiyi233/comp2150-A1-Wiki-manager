//---------------------------------------
// CLASS: A1Test
//
// Author: Zhiyi Chen,7863368
//
// REMARKS:The class is for testing our data structure
//
//-----------------------------------------
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class A1Test {

    @Test
    public void testCreate(){
        UserList uList=new UserList();
        DocList docList= new DocList();
        ContentList contentList=new ContentList();

        //once the list is initialized it should be empty
        assertEquals(0,uList.getSize());
        assertEquals(0,docList.getSize());
        assertEquals(0,contentList.getSize());
    }

    @Test
    public void addTesting(){
        UserList uList=new UserList();
        DocList docList= new DocList();
        ContentList contentList=new ContentList();

        uList.addNode(new Users("kevin"));
        assertEquals(1,uList.getSize());

        docList.addNode(new Document("object_programming"));
        docList.addNode(new Document("dataBase"));
        assertEquals(2,docList.getSize());

        contentList.addNode(new Content("abcde"));
        assertEquals(1,contentList.getSize());
    }
    @Test
    public void testSearch(){
        UserList uList=new UserList();
        DocList docList= new DocList();

        uList.addNode(new Users("kevin"));
        assertTrue(uList.search("kevin"));

        docList.addNode(new Document("object_programming"));
        assertTrue(docList.searchDoc("object_programming"));

    }
    @Test
    public void testReplaceLine(){
        ContentList contentList=new ContentList();
        boolean result;
        contentList.addNode(new Content("abcde"));
        contentList.addNode(new Content("OOiscool"));

        //we are going to replace the line 2 of the content
        //if we replace it successfully it will return true
        result=contentList.replaceLine(contentList,"2","replaceitsuccessfully");
        assertTrue(result);
        System.out.println("\nLine 2 of the content will be : replaceitsuccessfully");
        contentList.printContent(contentList.getSize(),contentList);

    }
    @Test
    public void testDeleteLine(){
        ContentList contentList=new ContentList();
        boolean result;
        contentList.addNode(new Content("abcde"));
        contentList.addNode(new Content("OOiscool"));

        result=contentList.deleteLine(contentList,"1");

        System.out.println("\nThere only content will be:1 OOiscool");
        contentList.printContent(contentList.getSize(),contentList);
        assertTrue(result);
    }
    @Test
    public void testPrint(){
        UserList uList=new UserList();
        DocList docList= new DocList();
        ContentList contentList=new ContentList();

        uList.addNode(new Users("kevin"));
        System.out.println("Print the userList:");
        uList.print();

        System.out.println("\nPrint the document List:");
        docList.addNode(new Document("object_programming"));
        docList.addNode(new Document("dataBase"));
        docList.print();

        System.out.println("\nPrint the content List:");
        contentList.addNode(new Content("abcde"));
        contentList.print();

    }
}


