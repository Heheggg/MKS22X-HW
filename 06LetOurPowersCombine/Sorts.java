import java.util.*;

public class Sorts{

    public static void main(String []args){
	int [] test1 = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
	int [] test2 = {-3,876,56};
	Sorts.mergeSort(test2);
	Sorts.printArray(test2);

	
	//Selection Sort 5.212s 
	//int [] t1 = new int [10];
	/*for(int i = 0; i < t1.length ; i++){
	    t1[i] = (int)(Math.random()*100);
	}*/
	//selectionSort(t1);
	//System.out.println(Arrays.toString(t1));	

	//Insertion Sort3.879
	/*int [] t1 = new int [10];
	for(int i = 0; i < t1.length ; i++){
	    t1[i] = (int)(Math.random()*100);
	    //System.out.println(Arrays.toString(t1));
	}
	//System.out.println(Arrays.toString(t1));
	insertionSort(t1);*/
	//System.out.println(Arrays.toString(t1));
	
    }
    public static void printArray(int[]data){
	//print the array like:  [ 1, 2, 3, 4]
	String save = "[ ";
	for (int i = 0; i < data.length; i++){
	    save += data[i] + ", ";
	}
	save = save.substring(0,save.length()-2);
	save += "]";
	System.out.println(save);
    }
    
    public static void insertionSort(int[]data){
	//your code here to make data re-order its elements
	//from least to greatest just like we did in class
	//same algorithm as the way you created your OrderedSuperArray
	for(int i = 1; i <  data.length;i++){
	    int x = i;
	    int save = data[i];
	    while(data[x-1] > data[x]){
		data[x] = data[x-1];
		data[x-1] = save;
		if (x > 1){
		    x -= 1;
		}
	    }
	    //System.out.println(Arrays.toString(data));
	}
    }

    public static void selectionSort(int [] x){
	int save = x.length - 1;
	for(int i = 0; i < x.length - 1 ; i++){
	    for(int i2 = x.length - 1; i2 > i; i2 --){
		if(x[i2] < x[save]){
		    save = i2;
		}
	    }
	    if(x[i] > x[save]){
		int s2 = x[i];
		x[i] = x[save];
		x[save] = s2; 
	    }
	    save = x.length -1;
	    // System.out.println(Arrays.toString(x));
	}
    }

    public static void bubbleSort(int [] ary){
	for(int i = ary.length - 1 ; i < ary.length -1 ; i++){
	    
	}
    }

    public static void mergeSort(int [] ary){
	int [] ary1 = Arrays.copyOf(ary,ary.length);
	int [] ary2 = Arrays.copyOf(ary,ary.length);
	Boolean x = true;
	for(int index = 1; index < ary.length; index = index*2){
	    int counter = 0;
	    while((counter+index)<=ary.length){	        
		if(x){
		    mergehelp(ary1,ary2,counter,counter+(index-1),counter+index,Math.min(ary.length-1,counter+(2*index-1)));
		}else{
		    mergehelp(ary2,ary1,counter,counter+(index-1),counter+index,Math.min(ary.length-1,counter+(2*index-1)));
		}
		counter+= 2*index;
	    }
	    x = !x;

	}
	if(x){
	    for(int i = 0; i < ary.length;i++){
		ary[i] = ary1[i];
	    }
	}else{
	    for(int i = 0; i < ary.length;i++){
		ary[i] = ary2[i];
	    }
	}
	
    }

    public  static void mergehelp(int [] ary1, int [] ary2, int start1, int end1,int start2, int end2){
	int counter = Math.min(start1,start2);
	while((start1 <=  end1) && (start2 <= end2)){
	    if(ary1[start1] >= ary1[start2]){
		ary2[counter] = ary1[start2];
		start2++;
		counter++;
	    }else{
		ary2[counter] = ary1[start1];
		start1++;
		counter++;
	    }	    
	}
	while(start1 <= end1){	    
	    ary2[counter] = ary1[start1];
	    start1++;
	    counter++;		
	}
	while(start2 <= end2){
	    ary2[counter] = ary1[start2];
	    start2++;
	    counter++;		
	}
    }

    /* public static int sort(int [] ary, int num){
	int top = ary.length -2;
	int bot = 0;

	int temp = ary[k];
	int ary[k] = ary[ary.length-1];
	int ary[ary.length-1] = temp;
	    

	Random randgen = new Random();
	if(low >= high){
	    throw new IllegalArgumentException("wut");
	}
	int middle = Random.nextInt(ary.length-3)+1;
	int middlenum = ary[middle];


	int i = top;
	int k = bot;
	while(i <= k){
	    while(ary[i]< middlenum){
		i++;
	    }
	    while(ary[k]> middlenum){
		k++
	    }

	    if(i <= bot){
		int save = ary[i];
		ary[i] = ary[j];
		ary[j] =  save;
		i++;
		j++;
	    }
	}	
	    
	}*/



    
}
