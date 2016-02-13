public class KnightBoard{
    
    private int[][] board;
    private boolean solved;
    private static final int [][] helpmove = {
	{2,1}, {2,-1,},{1,2},{1,-2},{-2,1},{-2,-1},{-1,2},{-2,1}
    };
    
    public KnightBoard(int x){
	solved = false;
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
		System.out.print(board[row][col]+"\t");
	    }
	}
    }

    public Boolean validXY(int x, int y){
	return ((x >= 0 && x < board.length) && (y >= 0 && y < board.length)) &&(board[x][y] == 0);
    }

    public Boolean solve(){
	solveH(0,0,1);
	return solved;
    }


    public void solveH(int row, int col,int x){
        if(x == (Math.pow(board.length,2)+1)){
	    solved = true;	    
	}
	for(int i = 0; (i < helpmove.length) && (!solved);i++){
	    if(validXY(row+helpmove[i][0],col+helpmove[i][1])){
		board[row+helpmove[i][0]][col+helpmove[i][1]] = x;
		solveH(row+helpmove[i][0],col+helpmove[i][1],x+1);
	    }
	    printSolution();
	}
	if(!solved){
	    board[row][col] = 0;
	}
    }

    public static void main(String args[]){
	KnightBoard x = new KnightBoard(4);
	System.out.println(x.solve());
	x.printSolution();
    }
    
}
