import java.util.*;

public class MyDeque<T>{

    public static void main(String [] args){
 
	MyDeque<Integer> d = new MyDeque<Integer>();
	ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
 
	// Limit the number of times addFirst and addLast is done
 
	int limit = 1000000;
 
	d.resize();
	d.resize();
	d.resize();
	d.resize();
	d.resize();
	d.resize();
	d.resize();
	d.resize();
	d.resize();
	d.resize();
	d.resize();
	
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
 
        // Add to the head and to the tail
 
        for (int i = 0; i < limit/2; i++) {
            Integer r1 = (int) (Math.random() * 1000000);
 
            // Add first
            d.addFirst(r1);
            ad.addFirst(r1);
        }
       
        for (int i = 0; i < limit/2; i++) {
            Integer r2 = (int) (Math.random() * 1000000);
            // Add last
            d.addLast(r2);
            ad.addLast(r2);
        }
 
        // Test if adding worked by removing elements
 
        for (int i = 0; i < limit; i++) {
            if (!d.peekFirst().equals(ad.peekFirst())) {
                System.out.println("Test #0 (addFirst) failed at: " + i + "!");
                System.exit(0);
            }
 
            if (!d.peekLast().equals(ad.peekLast())) {
                System.out.println("Test #1 (addLast) failed at: " + i + "!");
                System.exit(0);
            }
 
            if (!d.pollFirst().equals(ad.pollFirst())) {
                System.out.println("Test #2 (removeFirst) failed at: " + i + "!");
                System.exit(0);
            }
 
            if (!d.pollLast().equals(ad.pollLast())) {
                System.out.println("Test #3 (removeLast) failed at: " + i + "!");
                System.exit(0);
            }
        }
 
        // Sizes should be equal
 
        if (d.size() != ad.size()) {
            System.out.println("Not equal sizes. Error!");
            System.exit(0);
        }
 
        System.out.println("Success!");
    }
 

 
private int start;
private int end;
private int size;
private T [] array;

public MyDeque(){
    array = (T[]) new Object[32];
    start = 0;
    end = 0;
    size = 0;
}

public boolean addFirst(T x){
    if(size >= array.length){
	throw new IllegalStateException();
	}
	if(size == 0){
	    array[start] = x;
	    size = 1;
	    return true;
	}
	if(start == 0){
	    start = array.length-1;	    
	}else{
	    start = start-1;
	}
	array[start] = x;
	size++;
	return true;
    }

    public boolean addLast(T x){
	if(size >= array.length){
	    throw new IllegalStateException();
	}
	if(size == 0){
	    array[end] = x;
	    size = 1;
	    return true;
	}
	if(end == array.length-1){
	    end = 0;	    
	}else{
	    end = end+1;
	}
	array[end] = x;
	size++;
	return true;
    }

    public T peekFirst(){
	return array[start];
    }

    public T peekLast(){
	return array[end];
    }

    public T pollFirst(){
	if(size == 0){
	    throw new IllegalStateException();
	}
	T save = array[start];
	array[start] = null;
	if(start == array.length-1){
	    start = 0;
	}else{
	    start++;
	}
	return save;
    }

    public T pollLast(){
	if(size == 0){
	    throw new IllegalStateException();
	}
	T save = array[end];
	array[end] = null;
	if(end == 0){
	    end = array.length-1;
	}else{
	    end --;
	}
	return save;
    }

    private void resize(){
	T [] newary = (T[]) new Object[array.length*2];
	int counter = 0;
	do{
	    newary[counter] = array[start];
	    if(start == array.length-1){
		start = 0;
	    }else{
		if(start!=end){
		    start++;
		}
	    }
	    counter++;
	}while(start!=end);
	
	array = newary;
	start = 0;
	end = Math.max(0,size-1);  
    }

    public String toString(){
	String save = "[";
	while(peekFirst()!=null){
	    save+=pollFirst();
	    if(peekFirst()!=null){
		save+=",";
	    }
	}
	save += "]";
	return save;
    }

    public int size(){
	return size;
    }
}
