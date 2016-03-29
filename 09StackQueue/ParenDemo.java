import java.util.*;

public class ParenDemo{
    private static List<Character> opening = Arrays.asList('(','[','{','<');
    private static List<Character> closing = Arrays.asList(')',']','}','>');
    
    public static void main(String [] args){
	String input = "[([hello]){}";
	if(args.length < 0){
	    input = args[0];
	}

	System.out.println(isMatching(input));
    }

    public static Boolean isMatching(String s){
	MyStack <Character> save = new MyStack<Character>();
	int size = s.length();
	for(int i = 0; i < size; i++){
	    if(opening.contains(s.charAt(i))){
		save.push(s.charAt(i));
	    }else if(closing.contains(s.charAt(i))){
		if(opening.indexOf(save.peek())!=closing.indexOf(s.charAt(i))){
		    System.out.println("no matching pairs for " + s.charAt(i));
		    return false;
		}else{
		    save.pop();
		}
	    }
	}
	if(save.size()!=0){
	    System.out.println("no matching pairs for " + save.peek());
	}
	return true;
    }
}
