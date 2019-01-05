package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two selection sorts simultaneously. In a same
 * iteration, a selection sort pushes the greatest elements to the right and
 * another selection sort pushes the smallest elements to the left. At the end
 * of the first iteration, the smallest element is in the first position (index
 * 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. And so on. The execution
 * continues until the array is completely ordered.
 */
public class SimultaneousSelectionsort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex > rightIndex)
			return;
		if (array == null)
			return;
		if (leftIndex < 0 || rightIndex < 0)
			return;
		if (array.length < leftIndex)
			return;
		if (array.length == 0) {
			return;
		}

		for (int i = leftIndex; i <= rightIndex; i++) {
			int minimo = i;
			int maximo = rightIndex;
			for (int j = i + 1; j <= rightIndex; j++) {
				if (array[minimo].compareTo(array[j]) > 0) {
					minimo = j;
				}
			}
			Util.swap(array, minimo, leftIndex);
			leftIndex++;
			for (int k = rightIndex-1; k >= leftIndex; k--) {
				if (array[maximo].compareTo(array[k]) < 0) {
					maximo = k;
				}
			}
			Util.swap(array, maximo, rightIndex);
			rightIndex--;
		
		}
	}
}
