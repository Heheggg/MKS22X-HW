import java.util.*;

public class Main{
    public static void main(String [] args){
	Stack<Integer> x1 = new Stack<Integer>();
	MyStack<Integer> x2 = new MyStack<Integer>();
	Queue<Integer> y1 = new Queue<Integer>();
	MyQueue<Integer> y2 = new MyQueue<Integer>();

	Random randgen = new Random();
	for(int i = 0; i < 100000; i++){
	    int temp = randgen.nextInt(Integer.MAX_VALUE);
	    x1.push(temp);
	    x2.push(temp);
	    y1.enqueue(temp);
	    y2.enqueue(temp);
	}

	int counter = randgen.nextInt(50000);
	for(int i = 0; i < counter; i++){
	    
	}
    }
}
