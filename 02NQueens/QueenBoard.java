public class QueenBoard{
    private int[][] board;
    public String name(){
	return "Yu,Yueyang";
    }

    public  QueenBoard(int x){
	board = new int[x][x];
	for(int row = 0; row < board.length;row++){
	    for(int col = 0; col < board.length;col++){
		board[row][col] = 0;
	    }
	}
    }

    public QueenBoard(){
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

    public void PrintSolve(){
	for(int row = 0; row < board.length;row++){
	    System.out.println("");
	    for(int col = 0; col < board.length; col++){
		if(board[row][col]== 1){
		    System.out.print("Q,");
			}else{
		    System.out.print(" ,");
		}
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
	    if(row - offset >= 0){
		board[row-offset][i] -= 1;
	    }
	    if(row + offset < board.length){
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
	    if(row - offset >= 0){
		board[row-offset][i] += 1;
	    }
	    if(row + offset < board.length){
		board[row+offset][i] += 1;
	    }
	    offset++;
	}
	return true;
    }

    
    public Boolean Solve(){
	return solveH(0);
    }
    

    public Boolean solveH(int col){
	if(col == board.length-1){
	    for(int i = 0; i < board.length;i++){
		if(board[i][col] == 0){
		    addQueen(i,col);
		    return true;
		}
	    }
	    return false;
	}
	
	for(int i = 0; i < board.length; i++){
	    if(addQueen(i,col)){
		if(solveH(col+1)){
		    return true;
		}else{
		    removeQueen(i,col);
		}
	    }
	}
	return false;
    }
    
    public static void main(String [] args){
	QueenBoard x = new QueenBoard();
	System.out.println(x.Solve());
	x.PrintBoard();
	x.PrintSolve();
    }

    
}
