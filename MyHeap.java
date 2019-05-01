public class MyHeap{

	public static void main(String[] args){
		int[] test = {0,0,0,0,0,0,0,1,1,1,1,0,1,1,0,1,2};
		heapsort(test);
		for(int i = 0; i < test.length; i++){
			System.out.println(test[i]);
		}
	}
	//We discussed these 2 methods already:
private static void pushDown(int[]data,int size,int index){
    // - size  is the number of elements in the data array.  
    // - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
    // - precondition: index is between 0 and size-1 inclusive
    // - precondition: size is between 0 and data.length-1 inclusive.
        while(true){
        	int c1 = 2 * index + 1;//first child
        	int c2 = 2 * index + 2;//second child
        	if(c1 >= size) break;// if the first child is out of bounds (i.e. there are no children) then we stop because it's been pushed all the way down.
        	if (c2 < size){
            	if(data[c1] > data[c2]){
                	if (data[c1] > data[index]){
                		swap(data, c1, index);
                   		index = c1;
                	}
                	else{
                		break;
                	}
            	} 
            	else if (data[c2] > data[index]){
            		swap(data, c2, index);
                	index = c2;
            	}
            	else{
            		break;
            	}
        	} 
        	else if (data[c1] > data[index]){
        		swap(data, c1, index);
        		index = c1;
        	}
        	else{
        		break;
        	}
       	}
}

private static void pushUp(int[]data,int index){
   	//- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
    //- precondition: index is between 0 and data.length-1 inclusive.
    while(data[(index - 1) / 2] < data[index]){
    	//System.out.println(parent + ", " + index + ", " + data[parent] + ", " + data[index]);
    	//parent = (index - 1) / 2;
    	swap(data, (index - 1) / 2, index);
    	index = (index - 1) / 2;
    }
 }

private static void swap(int[] data, int i1, int i2){
	int temp = data[i1];
	data[i1] = data[i2];
	data[i2] = temp;
}
//We will discuss this today:
public static void heapify(int[] data){
    //- convert the array into a valid heap. [ should be O(n) ]
    for(int i = (data.length / 2) - 1; i >= 0; i--){
    	pushDown(data, data.length, i);
    }
}

public static void heapsort(int[] data){
    //- sort the array [ should be O(nlogn) ] :
    // converting it into a heap 
    // removing the largest value n-1 times (remove places at end of the sub-array). 
    heapify(data);
    for(int i = data.length-1; i > 0; i--){
    	swap(data, i, data.length-1);
    	pushDown(data, data.length-1, 0);
    }
}

}