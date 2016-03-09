import java.util.*;

public class Quick{

    private static int partition(int[]ary, int left, int right){
	int middlenum =ary[(left+right)/2];
	ary[(left+right)/2] = ary[right];
	ary[right] = middlenum;
	
	
	int i = left;
	int k = right-1;
	
	while(i <= k-1){
	    while(ary[i]< middlenum){
		i++;
	    }
	    while(ary[k]> middlenum){
		k--;
	    }

	    if(i <= (right-1)){
		int save = ary[i];
		ary[i] = ary[k];
		ary[k] =  save;
		i++;
		k--;
	    }
	}

	for(int ind = left; ind < right; ind++){
	    if(ary[ind] > middlenum){
		return ind;
	    }
	}
	return right;	    
    }

    
    public static int quickselect(int [] ary, int num){
	int top = ary.length-1;
	int bot = 0;

	Random randgen = new Random();
	
	if(bot >= top){
	    throw new IllegalArgumentException("wut");
	}

	while(bot < top){
	
	    int middle = randgen.nextInt(ary.length-3)+1;
	    int i = bot;
	    int k = top;

	    int middlenum = ary[(top+bot)/2];	    
	    while(i < k){

		if(ary[i] >= middlenum){
		    int temp = ary[k];
		    ary[k] = ary[i];
		    ary[i] = temp;
		    k--;
		}else{
		    i++;
		}
	    }

	    if(ary[i] > middlenum){
		i--;
	    }

	    if(num <= i){
		top = i;
	    }else{
		bot = i + 1;
	    }
	}

	
	return ary[num];
	    
    }

    public static void main(String [] args){
	int [] test1 = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
	System.out.println(Quick.partition(test1,0,4));

    }
    
}
