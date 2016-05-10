import java.util.*;

public class Driver{

    public static void main(String[]args){
	MyHeap<Integer> test = new MyHeap<Integer>();
	System.out.println(test);
	test.add(1);
	System.out.println(test);
	test.add(2);
	System.out.println(test);
	test.add(1);
	System.out.println(test);
	test.add(0);
	System.out.println(test);
	test.add(-1);
	System.out.println(test);
	test.add(2);
	System.out.println(test);
	Random r = new Random();
	for(int i = 0; i < 10; i++){
	    test.add(r.nextInt(10)-5);
	}
	System.out.println(test);
    }
}
