public class KnightBoard{
    
    private int[][] board;
    private boolean solved;
    private static final int [][] helpmove = {
	{2,1}, {2,-1,},{1,2},{1,-2},{-2,1},{-2,-1},{-1,2},{-1,-2}
    };
    
    public KnightBoard(int x,int y){
	solved = false;
	board = new int[x][y];
	for(int row = 0; row < board.length;row++){
	    for(int col = 0; col < board[0].length; col++){
		board[row][col] = 0;
	    }
	}
	board[0][0] = 1;
    }

    public KnightBoard(int x){
        this(x,x);
    }
    

    public KnightBoard(){
	this(5);
    }

    public void printSolution(){
	for(int row = 0; row < board.length;row++){
	    System.out.println("");
	    for(int col = 0; col < board[0].length; col++){
		System.out.print(board[row][col]+"\t");
	    }
	}
    }

    public Boolean validXY(int x, int y){
	return ((x >= 0 && x < board.length) && (y >= 0 && y < board[0].length)) &&(board[x][y] == 0);
    }

    public Boolean solve(){
	return solveH(0,0,2);
    }


    public Boolean solveH(int row, int col,int x){
        if(x == ((board.length*board[0].length)+1)){
	    return true;	    
	}
	for(int i = 0; i < helpmove.length;i++){
	    if(validXY(row+helpmove[i][0],col+helpmove[i][1])){
		board[row+helpmove[i][0]][col+helpmove[i][1]] = x;
		if(solveH(row+helpmove[i][0],col+helpmove[i][1],x+1)){
		    return true;
		}
	    }
	}
	board[row][col] = 0;
        return false;
    }

    /*public static void main(String args[]){
	KnightBoard x = new KnightBoard(7);
	System.out.println(x.solve());
	x.printSolution();
    }*/
    
}
