//---------------------------------------
// CLASS: Document
//
// Author: Zhiyi Chen,7863368
//
// REMARKS: This class is inherit from class listItem, since each document has its own
//title.
//
//-----------------------------------------
public class Document extends ListItem{
    private String doc;

    //constructor
    public Document(String docName){
        this.doc=docName;
    }
    public void print(){
        System.out.println(doc);
    }

    //compare the new document name with others
    public boolean equal(String docName){
        return this.doc.equals(docName);
    }

    public String setData(String doc){
        return this.doc=doc;
    }
    public String toString(){return doc.toString();}
}
