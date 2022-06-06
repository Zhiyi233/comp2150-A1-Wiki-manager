//---------------------------------------
// CLASS: Content
//
// Author: Zhiyi Chen,7863368
//
// REMARKS: This class is inherit class listItem, every document will have a list of content
//so this is the exact items for contentList.
//
//-----------------------------------------
public class Content extends ListItem{
    private String content;

    public Content(String content){
        this.content=content;
    }

    public void print(){
        System.out.println(content+" ");
    }

    public boolean equal(String content){
        return this.content.equals(content);
    }

    public String setData(String content){
        return this.content=content;
    }
    public String setContent(String content){
        return this.content=content;
    }
    public String toString(){return content.toString();}

}
