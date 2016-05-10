import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isMax;

    
    public MyHeap(T[] array){
	isMax = false;
        heapify(array);
    }

    
    public MyHeap(boolean isMax){
        this.isMax = isMax;
	data = (T [])(new Comparable[11]);
    }

    
    public MyHeap(T[] array, boolean isMax){
	this(array);
	this.isMax = isMax;
    }

    
    public MyHeap(){
        isMax = true;
	data = (T [])(new Comparable[11]);        
    }


    public T peek() {
	if(size == 0){
	    throw new NoSuchElementException("Empty List");
	}
	return data[1];
    }

    private void heapify(T [] ary){
	data = (T[])(new Comparable[ary.length+1]);
	size = ary.length;
	System.arraycopy(ary,0,data,1,ary.length);
	for(int i = size / 2; i > 0; i--){
	    pushDown(i);
	}
    }

    private void pushDown(int index){
	if(index * 2 <= size && index > 0){
	    if(index * 2 + 1 > size){
		if(compares(data[index * 2], data[index])){
		    swap(index, index * 2);
		    pushDown(index * 2);
		}
	    }else{
		T left = data[index * 2];
		T right = data[index * 2 + 1];
		T temp = data[index];
		if(compares(left,temp) && compares(right,temp)){
		    if(compares(left,right)){
			swap(index, index * 2);
			pushDown(index * 2);
		    }else{
			swap(index, index * 2 + 1);
			pushDown(index * 2 + 1);
		    }
		}
	    }
	}
    }

    private void pushUp(int index){
	if(index > 1){
	    T root = data[index / 2];
	    T temp = data[index];
	    if(compares(temp,root)){
		swap(index,index/2);
		pushUp(index/2);
	    }
	}
    }

    private boolean compares(T a,T b){
	if(isMax){
	    return a.compareTo(b) >= 0;	    
	}else{
	    return a.compareTo(b) < 0;
	}
    }

    public void swap(int a, int b){
	T temp = data[a];
        data[a] = data[b];
	data[b] = temp;
    }
    
    public T delete(){
	if(size == 0){
	    throw new NoSuchElementException("No array dude");
	}
	T temp = data[1];
	data[1] = data[size];
	size--;
	pushDown(1);
	return temp;
    }
	
    
    public void add(T x){
	if(size == data.length - 1){
	    doubleSize();
	}
	size++;
	data[size] = x;
	pushUp(size);	       
    }

    private void doubleSize(){
	T[] temp = (T[])(new Comparable[data.length * 2]);
	System.arraycopy(data,0,temp,0,data.length);
	data = temp;
    }

    public String toString(){
	String save = "[";
	for(int i =1;i<=size;i++){
	    save+= data[i]+", ";
	}
	if(save.length() > 1){
	    save = save.substring(0,save.length()-2);
	}
	return save + "]";
    }


}
