public class FrontierStack<T> implements Frontier<T>{
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    MyStack <T> save;

    public FrontierStack(){
	save = new MyStack<T>();
    }

    public void add(T element){
	save.push(element);
    }

    public T next(){
	return save.pop();
    }

    public boolean hasNext(){
	return save.size() != 0;
	
    }
}
