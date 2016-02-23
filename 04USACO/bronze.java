import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class bronze{
    String read = "";

    public bronze(){
	File file = new File("makelake.in");

	try{
	    Scanner sc = new Scanner(file);
	    while(sc.hasNextLine()){
		read += sc.nextLine()+"\n";
	    }
	}catch( FileNotFoundException e){
	    e.printStackTrace();
	}
    }

    public void print(){
	System.out.println(read);
    }

    public static void main(String []args){
	bronze x = new bronze();
	x.print();
    }
}
