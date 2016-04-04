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
	if(size == 0){
	    throw new IllegalStateException();
	}
	T [] newary = (T[]) new Object[array.length*2];
	int counter = 0;
	do{
	    newary[counter] = array[start];
	    if(start == array.length-1){
		start = 0;
	    }else{
		start++;
	    }
	}while(start!=end);
	
	start = 0;
	end = size-1;  
    }
}
