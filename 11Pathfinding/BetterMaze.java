import java.util.*;
import java.io.File;

public class BetterMaze{

    private class Node{
	int [] coordinate;
	Node previous;
	int size;

	public Node(int row, int col ,Node last,int length){
	    coordinate = new int[2];
	    coordinate[0] = row;
	    coordinate[1] = col;
	    previous = last;
	    size = length;
	}

	public Node getLast(){
	    return previous;
	}

	public int[] getCoord(){
	    return coordinate;
	}

	public int getSize(){
	    return size;
	}
    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false
    private boolean solved,solvable;


    /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     **/
    public int[] solutionCoordinates(){
        /** IMPLEMENT THIS **/      
	if(!solved){
	    solveDFS();
	}
	if(solvable){
	    int [] temp = new int[solution.length];
	    System.arraycopy(solution,0,temp,0,solution.length);
	    return temp;
	}else{
	    System.out.println("No solution");
	    return null;
	}
    }    


    /**initialize the frontier as a queue and call solve
     **/
    public boolean solveBFS(){  
        /** IMPLEMENT THIS **/      
	placesToGo = new FrontierQueue<Node>();
	return solve();
    }   


    /**initialize the frontier as a stack and call solve
     */ 
    public boolean solveDFS(){  
        /** IMPLEMENT THIS **/  
	placesToGo = new FrontierStack<Node>();
	return solve();
    }    

    /**Search for the end of the maze using the frontier. 
       Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){  
        /** IMPLEMENT THIS **/
	Node start = new Node(startRow,startCol,null,1);
	maze[startRow][startCol] = '.';
	placesToGo.add(start);
	//System.out.println(placesToGo.hasNext());
	while(placesToGo.hasNext()){
	    if(animate){
	       System.out.println(this);
	       wait(50);
	    }
	    if(process(placesToGo.next())){
		solved = true;
		return true;
	    }
	}
	solvable = false;
	return false;
    }

    private boolean process(Node c){
	int row = c.getCoord()[0];
	int col = c.getCoord()[1];
	if(maze[row+1][col]== ' ' || maze[row+1][col]== 'E'){
	    Node newN = new Node(row+1,col,c,c.getSize()+1);
	    if(maze[row+1][col]== 'E'){
		setSolution(newN);
		return true;
	    }
	    maze[row+1][col] = '.';
	    placesToGo.add(newN);
	}
	if(maze[row-1][col]== ' ' || maze[row-1][col]== 'E'){
	    Node newN = new Node(row-1,col,c,c.getSize()+1);
	    if(maze[row-1][col]== 'E'){
		setSolution(newN);
		return true;
	    }
	    maze[row-1][col] = '.';
	    placesToGo.add(newN);	    
	}
	if(maze[row][col+1]== ' ' || maze[row][col+1]== 'E'){
	    Node newN = new Node(row,col+1,c,c.getSize()+1);
	    if(maze[row][col+1]== 'E'){
		setSolution(newN);
		return true;
	    }
	    maze[row][col+1] = '.';
	    placesToGo.add(newN);	    
	}
	if(maze[row][col-1]== ' ' || maze[row][col-1]== 'E'){
	    Node newN = new Node(row,col-1,c,c.getSize()+1);
	    if(maze[row][col-1]== 'E'){
		setSolution(newN);
		return true;
	    }
	    maze[row][col-1] = '.';
	    placesToGo.add(newN);
	}
	return false;
    }

    private void setSolution(Node n){
	solution = new int [n.getSize()*2];
	int counter = solution.length -1;
	while(n != null){
	    solution[counter]=n.getCoord()[1];
	    counter--;
	    solution[counter]=n.getCoord()[0];
	    counter--;
	    maze[n.getCoord()[0]][n.getCoord()[1]]='@';
	    n = n.getLast();
	}
    }
     
    /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  /** IMPLEMENT THIS **/
	animate = b;
    }    


    public BetterMaze(String filename){
	animate = false;
	solved = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    
}

