package codility;

public class Solution {
	public int solution(int[] A) {
		quickSort(A,0,A.length-1);
		int i=0;
		while((A[i]<0)||(A[i+1]-A[i]>1)) {
			i++;
		}
        return A[i];
    }
	
	public void quickSort(int[] A, int low, int high)
	{
	    if (low < high)
	    {
	        /* pi is partitioning index, arr[pi] is now
	           at right place */
	        int pi = partition(A, low, high);

	        quickSort(A, low, pi - 1);  // Before pi
	        quickSort(A, pi + 1, high); // After pi
	    }
	}
	
	public int partition (int[] A, int low, int high)
	{
	    // pivot (Element to be placed at right position)
	    int pivot = A[high];  
	 
	    int i = (low - 1);  // Index of smaller element

	    for (int j = low; j <= high- 1; j++)
	    {
	        // If current element is smaller than the pivot
	        if (A[j] < pivot)
	        {
	            i++;    // increment index of smaller element
	            swap (A[i],A[j]);
	        }
	    }
	    swap (A[i + 1] ,A[high]);
	    return (i + 1);
	}
	
	public void swap(int a, int b) {
		int x=a;
		a=b;
		b=x;
	}
}
