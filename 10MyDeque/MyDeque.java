import java.util.*;

public class MyDeque<T>{
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
	return true;
    }

    /*public boolean addLast(T x){
    }

    public T peekFirst(){

    }

    public T peekLast(){

    }

    public T pollFirst(){

    }

    public T pollLast(){

    }

    private void resize(){
    
    }
    */
}
