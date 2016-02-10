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

    public Boolean addQueen(int row, int col){
	if(board[row][col] == 0){
	    board[row][col] = 1;
	}else{
	    return false;
	}
	int offset = 1;
	for(int i = col+1; i < board.length; i++){
	    if(board[row][i] <= 0){
		board[row][i] -= 1;
	    }
	    if(col - offset >= 0){
		board[row-offset][i] -= 1;
	    }
	    if(col + offset < board.length){
		board[row+offset][i] -= 1;
	    }
	    offset++;
	}
	return true;
    }

    public Boolean removeQueen(int row, int col){
	if(board[row][col] == 1){
	    board[row][col] = 0;
	}else{
	    return false;
	}
	int offset = 1;
	for(int i = col+1; i < board.length; i++){
	    if(board[row][i] <= 0){
		board[row][i] += 1;
	    }
	    if(col - offset >= 0){
		board[row-offset][i] += 1;
	    }
	    if(col + offset < board.length){
		board[row+offset][i] += 1;
	    }
	    offset++;
	}
	return true;
    }

    
    public void Solve(){
	
    }

    public static void main(String [] args){
	Board x = new Board();
	x.addQueen(2,2);
	x.removeQueen(2,2);
	x.PrintBoard();
    }

    
}
