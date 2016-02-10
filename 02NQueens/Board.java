public class Board{
    private int[][] board;
    public String name(){
	return "Yu,Yueyang";
    }

    public Board(int x){
	board = new int[x][x];
	for(int row = 0; row < board.length;row++){
	    for(int col = 0; col < board.length;col++){
		board[row][col] = 0;
	    }
	}
    }

    public Board(){
	this(5);
    }
    

    public void PrintBoard(){
	for(int row = 0; row < board.length;row++){
	    System.out.println("");
	    for(int col = 0; col < board.length; col++){
		System.out.print(board[row][col]+",");
	    }
	}
    }

    public void addQueen(int row, int col){
	
    }

    public void removeQueen(int row, int col){
	
    }

    public static void main(String [] args){
	Board x = new Board();
	x.PrintBoard();
    }

    
}
