import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class Bronze{
    public static final int[][] help = {
	{1,1},{1,0},{1,-1},{0,1},{0,0},{0,-1},{-1,1},{-1,0},{-1,-1}
    };
	
    String read = "";
    private int [][] board;

    private int elevation;
    private int instnum;
    private int volume;

    public Bronze(){
	File file = new File("makelake.in");
	
	try{	    
	    Scanner sc = new Scanner(file);
	    board = new int[sc.nextInt()][sc.nextInt()];
	    elevation = sc.nextInt();
	    instnum = sc.nextInt();
	    
	    for(int row = 0; row < board.length; row++){
		for(int col = 0; col < board[row].length; col++){
		    board[row][col] = sc.nextInt();
		}
	    }

	    for(int i = 0; i < instnum; i++){
		int row = sc.nextInt();
		int col = sc.nextInt();
		int stomp = sc.nextInt();
		int maxmod = getMax(row,col) - stomp;
		for(int i2 = 0; i2<help.length; i2++){
		    try{
			if(board[row+help[i2][0]][col+help[i2][1]] > maxmod){
			    board[row+help[i2][0]][col+help[i2][1]] = maxmod;
			}
		    }catch(IndexOutOfBoundsException e){}
		}
	    }

	    
	    int save = 0;
	    for(int row = 0; row < board.length; row++){
		//System.out.println("\n");
		for(int col = 0; col < board[row].length; col++){
		    //System.out.print(board[row][col] + "\t");
		    if(board[row][col] < elevation){
			save += (elevation - board[row][col]);
		    }
		}
	    }
	    volume = save * 6 * 6 * 12 * 12;
	    
	}catch(FileNotFoundException e){
	    e.printStackTrace();
	}
    }

    public int getMax(int row, int col){
	int max = 0;
	for(int i = 0;i < help.length; i++){
	    try{
		if(board[row+help[i][0]][col+help[i][1]] > max){
		    max = board[row+help[i][0]][col+help[i][1]];
		}
	    }catch(IndexOutOfBoundsException e){}
	}
	return max;
    }

    public void print(){
	System.out.println(volume+",6,Xu,Yueyang(Sam)");
    }


    public static void main(String []args){
	Bronze x = new Bronze();
	x.print();
    }
}
