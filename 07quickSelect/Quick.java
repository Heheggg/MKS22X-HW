import java.util.*;

public class Quick{

    private static int partition(int[]ary, int left, int right){
	int middlenum =ary[(left+right)/2];
	//System.out.println("pivot="+middlenum);
        swap(ary,(left+right)/2,right);
	
	
	int i = left;
	int k = right-1;
	
	while(i < k){
	    while(ary[i]< middlenum){
		i++;
	    }
	    while((ary[k]> middlenum)&&(k!=0)){
		k--;
	    }

	    if(i <= k){
		int save = ary[i];
		ary[i] = ary[k];
		ary[k] =  save;
		i++;
		k--;
	    }
	}




	for(int ind = left; ind < right; ind++){
	    if(ary[ind] > middlenum){
		swap(ary,ind,right);
		/*for(int z = 0; z < ary.length;z++){
		    System.out.print(ary[z]+",");
		}
		System.out.println();*/
		return ind;
	    }
	}


	return right;	    
    }

    private static void swap(int [] ary, int a, int b){
	int temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
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

    public static void quickSort(int [] ary){
	quickSort(ary,0,ary.length-1);
    }

    public static void quickSort(int [] ary, int bot, int top){
	int pivot = partition(ary,bot,top);
	if(bot < top){
	    if(pivot > bot){
		quickSort(ary,bot,pivot-1);
	    }
	    if(pivot < top){
		quickSort(ary,pivot+1,top);
	    }
	}
    }

    public static String name(){
	return "6,Xu,Yueyang";
    }

    public static void main(String [] args){
	int [] test1 = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4,0,-3,-5};
        quickSort(test1);



	
	for(int i = 0; i < test1.length;i++){
	    System.out.print(test1[i]+",");
	}


    }
    
}
