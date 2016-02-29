import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class Silver{
    private int ans;
    private int[][] board;
    private String read = "";

    private int startx;
    private int starty;
    private int endx;
    private int endy;
    private int steps;

    public Silver(){
	File file = new File("ctravel.in");

	try{
	    Scanner sc = new Scanner(file);
	    board = new int[sc.nextInt()][sc.nextInt()];
	    steps = sc.nextInt();

	    for(int row = 0; row < board.length; row++){
		for(int col = 0; col < board[row].length; col++){
		    board[row][col] = sc.nextInt();
		}
	    }

	    startx = sc.nextInt() - 1;
	    starty = sc.nextInt() - 1;
	    endx = sc.nextInt() - 1 ;
	    endy = sc.nextInt() - 1;
	}catch(FileNotFoundException e){
	    e.printStackTrace();
	}  
    }

    
public void print(){
	System.out.println(ans+",6,Xu,Yueyang(Sam)");
    }
}
