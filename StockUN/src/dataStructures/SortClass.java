package dataStructures;

import principal.Producto;

public class SortClass {

	public SortClass() {
	}

	private static void swapElements(Producto[] array, int i, int j) {
		Producto temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static void moveDown(Producto[] array, int parent, int size) {
		boolean flag = false;
		Producto largest = null;
		int child = 2*parent+1;
		Producto temp = array[parent];
		while(child < size && !flag) {
                    largest = array[child];
                    if(child+1 < size && array[child+1].compareTo(array[child])>0)
                        largest = array[++child];
                    if(largest!=null && temp!=null && largest.compareTo(temp)>0) {
                        array[parent] = largest;
                        parent = child;
                    }
                    else flag = true;

                    child = 2*parent+1;
		}

		array[parent] = temp;
	}

	private static void makeHeap(Producto[] array, int n) {
		for (int i=n/2-1; i>=0; i--)
                    moveDown(array,i,n);
	}

	public static void heapSort(Producto[] array, int n) {
            long timeSort = System.nanoTime();
            makeHeap(array,n);
            for(int i=n-1; i>0; i--) {
                    swapElements(array,0,i);
                    moveDown(array,0,i);
            }
            System.out.println("Sort Heap: "+(System.nanoTime()-timeSort));
	}
}

