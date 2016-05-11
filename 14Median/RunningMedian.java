@SuppressWarnings("unchecked")
public class RunningMedian{
    private MyHeap smaller;
    private MyHeap bigger;

    public RunningMedian(){
	smaller = new MyHeap<Double>(true);
	bigger = new MyHeap<Double>(false);
    }

    public double getMedian(){
	int sizeS = smaller.getSize();
	int sizeB = bigger.getSize();
	if(sizeS == sizeB){
	    return ((Double)smaller.peek() + (Double)bigger.peek())/2;
	}else if(sizeS > sizeB){
	    return (Double)smaller.peek();
	}else{
	    return (Double)bigger.peek();
	}
	    
    }

    public void add(double x){
	if(smaller.getSize() == 0 && bigger.getSize() == 0){
	    bigger.add(x);
	}else{
	    if(x > getMedian()){
		bigger.add(x);
		if(bigger.getSize()-smaller.getSize() > 1){
		    smaller.add(bigger.delete());
		}
	    }else{
		smaller.add(x);
		if(smaller.getSize()-bigger.getSize() > 1){
		    bigger.add(smaller.delete());
		}
	    }
	}
    }

    
}
