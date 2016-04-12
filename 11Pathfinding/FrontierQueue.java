public class FrontierQueue<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    MyQueue <T> save;
    
    public FrontierQueue(){
	save = new MyQueue<T>();
    }

    public void add(T element){
	save.enqueue(element);
    }

    public T next(){
	return save.dequeue();
    }

    public boolean hasNext(){
	return save.size() != 0;
    }
}
