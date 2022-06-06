//---------------------------------------
// CLASS: Wiki
//
// Author: Zhiyi Chen,7863368
//
// REMARKS: The Wiki class will read the text file that contains many commands for our program
// and there are 11 different commands in our program. There commands will operate our program.
// Besides, this class will
//
//-----------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Wiki {
    UserList ulist=new UserList();
    DocList dL=new DocList();
    ContentList cL=new ContentList();
    CommandList commandList=new CommandList();

    //--------------------------
    //readTextFile
    //
    //PURPOSE: read the text file and execute all the commands in the file.
    //
    //----------------------------------
    public void readTextFile() throws NumberFormatException, IOException {
        Scanner keyboard=new Scanner(System.in);
        String fileName=keyboard.nextLine(); //store the name of text file that users typed

        BufferedReader br=new BufferedReader(new FileReader(fileName));
        String line=br.readLine(); //a line from the text files
        String[] tokens; // this array is only for temporary use
        boolean notTerminate = true; //variable to test if the program should terminate

        while(line!=null&&notTerminate){
            //System.out.println(line);
            tokens=line.split(" ");
            line= br.readLine();

            //These codes following will do USER command
            if(tokens[0].equals("USER")){
                String userId=tokens[1]; //assign the unique userid to a temp variable
                Users user1=new Users(userId);

                if(ulist.isEmpty()){ //if the userlist is empty add to it
                    ulist.addNode(user1);
                    System.out.println("CONFIRMED, we create a first new user:" + userId);
                }else {
                    if (ulist.search(userId)) {
                        //duplicate
                        System.out.println("DUPLICATE, we found " + userId + " is DUPLICATE");
                    } else {
                        //there is no duplicate, we create a new user
                        ulist.addNode(user1);
                        System.out.println("CONFIRMED, we create a new user:" + userId);
                    }
                }
            }
            //CREATE command part
            if(tokens[0].equals("CREATE")){
                String docName=tokens[1]; //assign the name of document
                String specialUser=tokens[2];
                Document newDoc=new Document(docName);

                if(ulist.search(specialUser)){
                    //now the special users is in the system
                    if(dL.isEmpty()){ //the document list is empty at the beginning
                        dL.addNode(newDoc);
                        System.out.println("CONFIRMED, we create the first new document with "+docName+" which is" +
                                " created by "+specialUser);
                        commandList.addNode(new Content(tokens[0]));
                    }else{
                        if(dL.searchDoc(docName)){
                            //we found a duplicate document name
                            System.out.println("DUPLICATE "+docName+" is already been created");
                        }else{
                            //there is no duplicate document is the document list
                            dL.addNode(newDoc);
                            System.out.println("CONFIRMED, we create a new document with "+docName+" which is" +
                                    " created by "+specialUser);
                        }
                    }
                }else{
                    //there is no such user in the system now
                    System.out.println("NOT FOUND! "+"The user "+ specialUser+" is not exist in the system now");
                }
            }
            //APPEND command part
            if(tokens[0].equals("APPEND")){
                String appendDoc=tokens[1];
                String user=tokens[2];
                String appendContent=cL.addString(tokens,3);

                Content newContent=new Content(appendContent);

                if(NotFound(appendDoc,user)){
                    System.out.println("No further processing occurs in this case---");
                } else{
                    //now we can append new lines to the document
                        cL.addNode(newContent);
                        System.out.println("CONFIRMED we append the "+appendContent+"Successfully");
                }
            }
            //Replace command part
            if(tokens[0].equals("REPLACE")){
                String repDoc=tokens[1];
                String userId=tokens[2];
                String replaceLine=tokens[3];
                //String replaceResult="";
                String replaceContent=cL.addString(tokens,4);

                if(NotFound(repDoc,userId)){
                    System.out.println("No further processing occurs in this case---");
                } else{
                    //now it is time to replace the content in line L with new content
                    if(cL.replaceLine(cL,replaceLine,replaceContent)){
                        System.out.println("SUCCESS! We replace with the new content:"+replaceContent+" for document"+
                                repDoc);
                    }else {
                        System.out.println("FAIL! There is no line:"+replaceLine+" in "+repDoc);
                    }
                }
            }
            //delete command part
            if(tokens[0].equals("DELETE")){
                String delDoc=tokens[1];
                String userId=tokens[2];
                String delLine=tokens[3];

                if(NotFound(delDoc,userId)){
                    System.out.println("No further processing occurs in this case---");
                } else{
                    if(cL.deleteLine(cL,delLine)){
                       // lineNum--;
                        System.out.println("SUCCESS! We delete with the line:"+delLine+" for document "+
                                delDoc);
                    }else{
                        System.out.println("FAIL! There is no line:"+delLine+" in "+delDoc);
                    }
                }
            }
            //Print command part
            if(tokens[0].equals("PRINT")){
                String docName=tokens[1];
                boolean foundDoc=dL.searchDoc(docName);
                if(foundDoc){
                    System.out.println("\nPrint document:"+docName);
                    cL.printContent(cL.getSize(),cL);
                }else{
                    System.out.println("NOT FOUND! There is no document called "+docName);
                }
            }
            //RESTORE command part

            //USERREPORT command part
            if(tokens[0].equals("USERREPORT")){
                //code
            }

            //QUIT command part
            if(tokens[0].equals("QUIT")){
                System.out.println("BYE");
                notTerminate=false;
            }
            //Comment command check
            char firstOfToken=tokens[0].charAt(0);

            if(firstOfToken=='#'){
                String comment=cL.addString(tokens,0);
                System.out.println(comment);
            }

        }
        if(notTerminate){
            //if this boolean variable is still true in after the while loop
            //this means there is no QUIT COMMAND
            System.out.println("QUIT COMMAND is missing");
        }
    }

    //--------------------------
    //NotFound
    //
    //PURPOSE: this method will check if the document or the userId are existed in
    //the system. There are three situations for Not Found output for our command.
    //Parameters:document's title, user's name
    //Return: It will return true once the output is Not Found.
    //----------------------------------
    public boolean NotFound(String document,String userId){
        boolean foundDoc=dL.searchDoc(document); //bool is true when we find a existed document
        boolean foundUser=ulist.search(userId); //bool is true when we find a existed user
        boolean notFound=false;

        //there are three conditions for not found situation
        if(!foundDoc||!foundUser){
            //there are three conditions for not found situation
            if(!foundUser&&foundDoc){
                System.out.println("NOT FOUND,"+userId+" is not be created");
            }else if(foundUser){
                System.out.println("NOT FOUND,"+" we can't find "+document+" in our system");
            }else {
                System.out.println("NOT FOUND,both user:"+userId+" and document:"+document+" " +
                        "are not in the system");
            }
            notFound=true;
        }
        return notFound;
    }
}
