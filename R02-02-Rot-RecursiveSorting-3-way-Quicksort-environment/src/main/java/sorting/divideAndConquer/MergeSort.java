package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length
				&& array.length != 0) {
			int meio = (leftIndex + rightIndex) / 2;
			
			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			
			merge(array, leftIndex, meio, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int meio, int rightIndex) {
		T[] aux = Arrays.copyOf(array, array.length);
		int i = leftIndex;
		int k = leftIndex;
		int j = meio+1;
		while(i <= meio && j <= rightIndex ) {
			if (aux[i].compareTo(aux[j]) < 0) {
				array[k] = aux[i];
				i++;
			}else {
				array[k] = aux[j];
				j++;
			}k++;
		}
		while(i<= meio) {
			array[k] = aux[i];
			i++;
			k++;
		}
		while(j<= rightIndex) {
			array[k] = aux[j];
			j++;
			k++;
		}
		
	}
}
