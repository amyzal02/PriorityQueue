import java.lang.Math.*; 

public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 
	private int ogPlace; 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
		numElements = 1;
	}

	/**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	TODO: Please complete this method.
	*/
	public void insert(Interval k) {
		if (numElements == size) { // Expand the buffer allocated for the heap to another buffer that is twice as big.
			Interval[] newHeap = new Interval[2 * size + 1];
			for(int i = 0; i < heap.length; i++){
				newHeap[i] = heap[i];
			}
			size = 2 * size;
			heap = newHeap;
			
		}
		if(numElements == 1){
			heap[1] = k;
			numElements++;
		}
		else{

		int i = numElements; 
		heap[numElements] = k; 
		numElements++;

		siftUp(i); //sifts up 




		}
	}

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length. See the compareTo function of Interval for more details on the comparison.
	TODO: Please complete this method.
	*/
	public Interval remove_max() {
		Interval max = null;
		

		if(numElements == 1) 
			return null;
		if (numElements == 2){ 
			max = heap[1];
			heap[1] = null;
			numElements--; 
			return max;
		
		} 
		// Remove_max code here.
		
		max = heap[1];
		swap(numElements - 1, 1);
		heap[numElements -1] = null; 
		numElements--;
		
		siftDown(1);

		siftUp(left(2));
		siftUp(right(2));

		siftUp(left(3));
		siftUp(right(3));

		
		return max; // Replace this statement with returning the max element (root) in the heap.
	}

	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i)
			System.out.println("\t["+ i +"] " + heap[i]);
	}

	public void siftUp(int i){ 
		
		boolean noNull = true; 
		boolean done = false; 
		int parent = parent(i);

		if(heap[i] == null)
				noNull = false;
			if(parent == 0)
				noNull = false; 

		while(noNull && !done){

			if(heap[i].compareTo(heap[parent]) > 0){ // condition 
				swap(i, parent);
				i = parent; 
			}
			else{
				done = true; 
			}
			
			parent = parent(i); 
			
			if(heap[i] == null)
				noNull = false;
			if(parent == 0)
				noNull = false; 
	

		} 


 	}

	public void siftDown(int i){ 

		boolean satisfied = false;
		boolean iNull =  false; 
		boolean leftNull = false; 
		boolean rightNull = false; 
		int left = left(i);
		int right = right(i);

		if(heap[i] == null)
			iNull = true;
		if(left == 0 || heap[left] == null)
			leftNull = true;
		if(right == 0 || heap[right] == null)
			rightNull = true;
		
		
		while(!satisfied && !iNull && (!leftNull || !rightNull)){

			int rightCompare = 0; 
			int leftCompare = 0; 

			if(!rightNull){
				rightCompare = heap[i].compareTo(heap[right]);
			}
			if(!leftNull){
				leftCompare = heap[i].compareTo(heap[left]);
			}

			if (!rightNull && !leftNull && heap[left].compareTo(heap[right]) > 0 )
				rightNull = true; 
			else
				leftNull = false;

		
			if(heap[i] == null){
				return; //don't do anything 
			}

			if(!rightNull && rightCompare < 0){
					swap(i, right);				
					i = right;
			}
			else if(!leftNull && leftCompare < 0){
					swap(i, left);				
					i = left;
			}
			else{
				satisfied = true; 
			}
			
			left = left(i);
			right = right(i);
			
			if(heap[i] == null)
				iNull = true;
			if(left == 0 || heap[left] == null)
				leftNull = true;
			if(right == 0 || heap[right] == null)
				rightNull = true;
		}
 	}


	public void swap(int i, int k){
		Interval swap = heap[i]; 
		heap[i] = heap[k];
		heap[k] = swap;  
	}

	public int parent(double i){
		int parent = (int) Math.floor(i/2);
		if(parent < 1 || parent > numElements)
			return 0; 
		return parent; 
	}

	public int left(int i){
		int left =  2 * i;
		if(left < 1 || left > numElements)
			return 0; 
		return left; 
	}

	public int right(int i){
		int right =  2 * i + 1;
		if(right < 1 || right > numElements)
			return 0; 
		return right; 
	}
}
