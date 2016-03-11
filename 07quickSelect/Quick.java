import java.util.*;

public class Quick{

    private Random randgen = new Random();
    
    private static int [] partition(int[]ary, int left, int right){
	int [] save = new int [2];
	int middlenum =ary[(left+right)/2];
	//System.out.println("pivot="+middlenum);
	int [] copy = Arrays.copyOfRange(ary,left,right+1);
	int counter = 0;
	for(int i = 0; i < copy.length-counter; i++){
	    if(copy[i] == middlenum){
		swap(copy,i,(copy.length-1-counter));		
		counter++;
		i--;
	    }
	}

	
       	/*for(int i = 0; i < copy.length;i++){
	    System.out.print(copy[i]+",");
	    }
	System.out.println();*/
	int bot = left;
	int top = right;

	for(int i = 0; i < copy.length-counter; i++){
	    if(copy[i] < middlenum){
		ary[bot] = copy[i];
		bot++;
	    }else if(copy[i] > middlenum){
		ary[top] = copy[i];
		top--;
	    }
	}
	save[0] = bot;
	save[1] = top;
	//System.out.println("bot:"+save[0]+" top:"+save[1]);
	while(bot<=top){
	    ary[bot] = middlenum;
	    bot++;
	}
	return save;
    }

    private static void swap(int [] ary, int a, int b){
	int temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }

    
    public static int quickSelect(int [] ary, int num){
	num--;
	int top = ary.length-1;
	int bot = 0;
	int leftpiv;
	int rightpiv;
	do{
	    int [] save = partition(ary,bot,top);
	    leftpiv = save[0];
	    rightpiv = save[1];

	    if(num > rightpiv){
		bot = rightpiv + 1;
	    }else if(num < leftpiv){
		top = leftpiv - 1;
	    }
	    
	}while((num>rightpiv) || (num<leftpiv));
	return ary[leftpiv];	    
    }

    public static void quickSort(int [] ary){
	quickSort(ary,0,ary.length-1);
    }

    public static void quickSort(int [] ary, int bot, int top){
	int [] pivot = partition(ary,bot,top);
	int left = pivot[0];
	int right = pivot[1];
	if(bot < top){
	    if(left > bot){
		quickSort(ary,bot,left-1);
	    }
	    if(right < top){
		quickSort(ary,right+1,top);
	    }
	}
    }

    public static String name(){
	return "6,Xu,Yueyang";
    }

    public static void main(String [] args){
	int [] test = new int [4000000];
	for(int i = 0; i < test.length; i++){
	    // test[i] = (int)(Math.random()*3);
	    test[i] = (int)(Integer.MAX_VALUE*(Math.random()*2-1));
	}
	int [] testA = Arrays.copyOf(test,test.length);
	int [] testB = Arrays.copyOf(test,test.length);	    

	//Quick.quickSort(test);
	//Quick.quickSortOld(test);
	//Arrays.sort(test);


	//System.out.println(Quick.quickselect(test,33));
	/*for(int i = 0; i < test.length;i++){
	  System.out.print(test[i]+",");
	  }*/

	
	
	//int [] test1 = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4,93,648,29,2,2,2,2 };
	//System.out.println(Quick.quickselect(test1,3));
    }

     private static int partitionOld(int[]ary, int left, int right){
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
    
    public static int quickselectOld(int [] ary, int num){
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

    public static void quickSortOld(int [] ary){
	quickSortOld(ary,0,ary.length-1);
    }

    public static void quickSortOld(int [] ary, int bot, int top){
	int pivot = partitionOld(ary,bot,top);
	if(bot < top){
	    if(pivot > bot){
		quickSortOld(ary,bot,pivot-1);
	    }
	    if(pivot < top){
		quickSortOld(ary,pivot+1,top);
	    }
	}
    }


    
}
