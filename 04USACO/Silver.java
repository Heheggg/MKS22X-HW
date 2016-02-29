import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class Silver{
    private int ans;
    private int[][][] board;
    private String read = "";
    private final int [][] helper = {
	{0,1},{0,-1},{1,0},{-1,0}
    };

    private int startx;
    private int starty;
    private int endx;
    private int endy;
    private int steps;

    public Silver(){
	File file = new File("ctravel.in");

	try{
	    Scanner sc = new Scanner(file);
	    board = new int[sc.nextInt()][sc.nextInt()][2];
	    steps = sc.nextInt();
	    sc.nextLine();

	    for(int row = 0; row < board.length; row++){
	        String save = sc.nextLine();
		for(int col = 0; col < board[row].length; col++){
		    if(save.charAt(col) == '.'){
			board[row][col][0] = 0;
		    }else{
			board[row][col][0] = -1;
		    }
		}
	    }

	    startx = sc.nextInt() - 1;
	    starty = sc.nextInt() - 1;
	    endx = sc.nextInt() - 1 ;
	    endy = sc.nextInt() - 1;
	}catch(FileNotFoundException e){
	    e.printStackTrace();
	}

	update();
	for(int help = 0; help < helper.length;help++){
	    if(verify(startx,starty,help)){
		board[startx+helper[help][0]][starty+helper[help][1]][0] =  1;
	    }
	}

	  
	for(int i = 1; i < steps; i++){
	    update();
	    for(int row = 0; row < board.length; row++){
		for(int col = 0; col < board[row].length; col++){
		    if(board[row][col][0]!= -1){
			int sum = 0;
			for(int help = 0; help < helper.length; help++){
			    if(verify(row,col,help)){
				sum += board[row+helper[help][0]][col+helper[help][1]][1];
			    }
			}
			board[row][col][0] = sum;
		    }
		}
	    }
	}

	ans = board[endx][endy][0];
    }

    public void update(){
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		board[row][col][1] = board[row][col][0];
	    }
	}
    }

    public boolean verify(int x, int y, int i){
	return (((x+helper[i][0] >= 0) && (x+helper[i][0] < board.length)) && ((y+helper[i][1] >= 0) && (y+helper[i][1] < board[0].length))) && ((board[x+helper[i][0]][y+helper[i][1]][1] != -1));
    }
    
    public void print(){
	System.out.println(ans+",6,Xu,Yueyang(Sam)");
    }

    public void printboard(){
	System.out.println("");
	for(int row = 0; row < board.length; row++){
	    System.out.println ("");
	    for(int col = 0; col < board[row].length; col ++){
		System.out.print(board[row][col][0]+",");
	    }
	}
    }
    
    public static void main(String [] args){
	Silver x = new Silver();
	x.print();
    }
}
