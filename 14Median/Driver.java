public class Driver{
    public static void main(String [] args){
	RunningMedian x = new RunningMedian();
	x.add(5);
	System.out.println(x.getMedian());
	x.add(0);
	System.out.println(x.getMedian());
	x.add(2);
	System.out.println(x.getMedian());
	x.add(-2);
	System.out.println(x.getMedian());	
    }
}
