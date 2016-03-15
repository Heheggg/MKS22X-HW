public class MyLinkedList{

    public static void main(String []args){
	MyLinkedList x = new MyLinkedList();
        x.add(-5);
	x.add(5);
	x.add(0);
	x.add(42,0);
	System.out.println(x.get(2));
	System.out.println(x.toString());
    }

    public MyLinkedList(){
	size = 0;
    }
    
    private LNode start;
    private int size;

    public Boolean add(int value, int index){
	LNode temp = start;
	LNode newV = new LNode(value);
	if(temp == null){
	    start = newV;
	    return true;
	}
	if(index == 0){
	    newV.setNext(start);
	    start = newV;
	    return true;
	}
	while(index!=1){
	    temp = temp.getNext();
	    index--;
	}
	if(temp.hasNext()){
	    newV.setNext(temp.getNext());
	}
	temp.setNext(newV);
	return true;
    }
    
    public Boolean add(int value){
	LNode x = start;
	LNode newV = new LNode(value);
	if(x == null){
	    start = newV;
	    return true;
	}
	while(x.hasNext()){
	    x = x.getNext();
	}
	x.setNext(newV);
	size++;
	return true;
    }

    public int get(int index){
	LNode temp = start;
        while(index!=0){
	    temp = temp.getNext();
	    index--;
	}
	return temp.getInt();
    }

    public int set(int index, int newValue){
	LNode temp = start;
	while(index!=0){
	    temp = temp.getNext();
	    index--;
	}
	int save = temp.getInt();
        temp.setInt(newValue);
	return save;
    }

    public int size(){
	return size;
    }

    public int remove(int index){
	LNode x = start;
	if(index == 0){
	    int save = start.getInt();
	    start = start.getNext();
	    return save;
	}else if(index == (size-1)){
	    while(index!=1){
		x = x.getNext();
		index--;
	    }
	    int save = x.getNext().getInt();
	    x.setNext(null);
	    return save;
	}
	while(index!= 1){
	    x = x.getNext();
	    index--;
	}
	int save = x.getNext().getInt();
	x.setNext(x.getNext().getNext());
	return save;
    }

    public int indexOf(int value){
	LNode temp = start;
	int Index = 0;
	while(temp!=null){
	    if(temp.getInt()==value){
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
	    save+= temp.getInt()+",";
	    temp = temp.getNext();
	}
	save+= "]";
	return save;	    
    }

    private class LNode{
	private int x;
	private LNode next;

	public LNode(int x ){
	    this.x = x;
	}

	public int getInt(){
	    return x;
	}

	public void setInt(int x){
	    this.x = x;
	}
	
	public LNode getNext(){
	    return next;
	}
	public Boolean hasNext(){
	    return !(next==null);
	}

	public void setNext(LNode node){
	    next = node;
	}
    }
}
