public class Driver{
    public static void main(String [] args){
	BetterMaze x = new BetterMaze("data2.dat");
	x.setAnimate(true);
	x.clearTerminal();
	x.solveBFS();

	x.clearTerminal();
	System.out.println(x.toString());
    }
}
