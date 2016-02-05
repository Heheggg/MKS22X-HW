public class Recursion implements hw01{
    public String name(){
	return "Xu,Yueyang";
    }

    public Boolean helpsqrt(double current, double y){
	return Math.abs((Math.pow(current,2)/y) - 1) < 0.00001; 
    }

    public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException("n < 0");
	}
	double counter = n/2;
	while(!helpsqrt(counter, n)){
	    counter = (n/counter + counter)/2;
	}
	return counter;
    }

    /*public static void main(String [] args){
	Recursion x = new Recursion();
	System.out.println(x.sqrt(20));
    }*/
}
