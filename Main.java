//---------------------------------------
// CLASS: Main
//
// Author: Zhiyi Chen,7863368
//
//-----------------------------------------
import java.io.IOException;

public class Main {
    //----------------------------
    //main
    //PURPOSE: Define the Wiki object for this class, and call readTextFile method
    //to print all the output for our program
    //------------------------------
    public static void main(String[] args) throws IOException {
        Wiki wk=new Wiki();
        wk.readTextFile();
        System.out.println("\nEnd of processing.");
    }
}
