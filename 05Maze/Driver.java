public class Driver{
    public static void main(String[]args){
        Maze f;
        f = new Maze("data2.dat",true);//true animates the maze.
        System.out.println(f.toString());
	f.clearTerminal();
	f.solve();

        f.clearTerminal();
        System.out.println(f);
    }
}
