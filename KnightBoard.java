public class KnightBoard{
    
    private int[][] board;
    
    public KnightBoard(int x){
	board = new int[x][x];
	for(int row = 0; row < board.length;row++){
	    for(int col = 0; col < board.length; col++){
		board[row][col] = 0;
	    }
	}
    }

    public KnightBoard(){
	this(5);
    }

    public void printSolution(){
	for(int row = 0; row < board.length;row++){
	    System.out.println("");
	    for(int col = 0; col < board.length; col++){
		System.out.print(board[row][col]+"/t");
	    }
	}
    }

    public Boolean validXY(int x, int y){
	return ((x > 0 && x < board.length) && (y > 0 && y < board.length));
    }

    public Boolean solve(){
	
    }

    public int[] canMove(){
	
    }

    public Boolean solveH(int[]pos){
	
    }
    
}
