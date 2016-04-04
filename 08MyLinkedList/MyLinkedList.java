import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

    public static void main(String []args){
	MyLinkedList <Integer> x = new MyLinkedList<Integer>();
        x.add(-5);
	x.add(5);
	x.add(0);
	x.add(0,42);
	System.out.println(x.get(2));
	System.out.println(x.toString());
    }

    public Iterator <T> iterator(){
	return new cake();
    }

    private class cake implements Iterator <T>{
	private LNode index;

	public cake(){
	    index = start;
	}
	
	public boolean hasNext(){
	    return  !(index == null);
	}
	
	public T next(){
	    if(index == null){
		//index = start;
		throw new NoSuchElementException();
	    }
	    T save = index.getInt();
	    index = index.getNext();
	    return save;
	}

	public void remove(){
	    throw new UnsupportedOperationException ("heh");
	}
    }

    public MyLinkedList(){
	size = 0;
    }
    
    private LNode start;
    private LNode end;
    private int size;

    public Boolean add(int index, T value){
	if((index < 0) || (index > size)){
	    throw new IndexOutOfBoundsException ("seriously man?");
	}
	LNode temp = start;
	LNode newV = new LNode(value);
	if(temp == null){
	    add(value);
	    return true;
	}
	if(index == 0){
	    newV.setNext(start);
	    start.setPrevious(newV);
	    start = newV;
	    size++;
	    return true;
	}
	if(index == size){
	    add(value);
	    return true;
	}
	while(index!=1){
	    temp = temp.getNext();
	    index--;
	}
	if(temp.hasNext()){
	    newV.setNext(temp.getNext());
	}
	newV.setPrevious(temp);
	temp.setNext(newV);
	size++;
	return true;
    }
    
    public Boolean add(T value){
        LNode x = new LNode(value);
	if(start == null){
	    start = x;
	    end = x;
	    size++;
	    return true;
	}
	x.setPrevious(end);
	end.setNext(x);
	end = x;
	size++;
	return true;
    }

    public T get(int index){
	if((index < 0) || (index > size-1)){
	    throw new IndexOutOfBoundsException ("seriously man?");
	}
	LNode temp = start;
        while(index!=0){
	    temp = temp.getNext();
	    index--;
	}
	return temp.getInt();
    }

    public T set(int index, T newValue){
	if((index < 0) || (index > size-1)){
	    throw new IndexOutOfBoundsException ("seriously man?");
	}
	LNode temp = start;
	while(index!=0){
	    temp = temp.getNext();
	    index--;
	}
	T save = temp.getInt();
        temp.setInt(newValue);
	return save;
    }

    public int size(){
	return size;
    }

    public T remove(int index){
	if((index < 0) || (index > size-1)){
	    throw new IndexOutOfBoundsException ("seriously man?");
	}
	LNode x = start;
	if(index == 0){
	    T save = start.getInt();
	    start = start.getNext();
	    if(size!=1){
		start.setPrevious(null);
	    }
	    size--;
	    return save;
	}else if(index == (size-1)){
	    while(index!=1){
		x = x.getNext();
		index--;
	    }
	    T save = x.getNext().getInt();
	    x.setNext(null);
	    end = x;
	    size--;
	    return save;
	}
	while(index!= 1){
	    x = x.getNext();
	    index--;
	}
	T save = x.getNext().getInt();
	x.setNext(x.getNext().getNext());
	x.getNext().setPrevious(x);
	size--;
	return save;
    }

    public int indexOf(int value){
	LNode temp = start;
	int Index = 0;
	while(temp!=null){
	    if(temp.getInt().equals(value)){//System
		return Index;
	    }
	    Index++;
	    temp = temp.getNext();
	}
	return -1;
    }

    public String toString(){
	String save = "[";
	LNode temp = start;
	while(temp != null){
	    save+= temp.getInt().toString();
	    if(temp.hasNext()){
		save += ", ";
	    }
	    temp = temp.getNext();
	}
	save+= "]";
	return save;	    
    }
    
    public String toString(Boolean x){
	String save = "";
	save += "HEAD:"+start.getInt();
	save += " TAIL:"+this.end.getInt();
	save += " SIZE:"+size();
	save += "\n" + toString();
	return save;
    }
    
    private class LNode{
	private T x;
	private LNode next;
	private LNode previous; 

	public LNode(T x ){
	    this.x = x;
	}

	public T getInt(){
	    return x;
	}

	public void setInt(T x){
	    this.x = x;
	}
	
	public LNode getNext(){
	    return next;
	}
	public LNode getPrevious(){
	    return previous;
	}
	public Boolean hasNext(){
	    return !(next==null);
	}

	public void setNext(LNode node){
	    next = node;
	}
	public void setPrevious(LNode node){
	    previous = node;
	}
    }
}
