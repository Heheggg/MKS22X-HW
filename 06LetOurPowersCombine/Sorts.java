import java.util.*;

public class Sorts{

    public static void main(String []args){
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

    public static void mergSort(int [] ary){
	for(int index = 2; index*2 < ary.length; index = index*2){
	   
	}
    }

    private static void mergehelp(int [] ary1, int [] ary2; int start1, int end1,int start2, int end2){
	int counter = Math.min(start1,start2);
	while((start1 <=  end1) && (start2 <= end2)){
	    if(ary1[start1] <= ary1[start2]){
		ary2[couter] = ary1[start2];
		start2++;
		counter++;
	    }else{
		ary2[counter] = ary1[start1];
		start1++;
		counter++;
	    }	    
	}

	if(start1 <= end1){
	    ary2[counter] = ary1[start1];
	    start1++;
	    counter++;		
	}
	if(start2 <= end2){
	    ary2[counter] = ary1[start2];
	    start2++;
	    counter++;		
	}
    }
}
