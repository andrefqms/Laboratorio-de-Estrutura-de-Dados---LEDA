package sorting.simpleSorting;
import util.Util;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && leftIndex <= array.length && rightIndex >= 0 && rightIndex <= array.length
				&& leftIndex <= rightIndex) {
			for (int i = leftIndex+1; i <= rightIndex; i++) {
				int muro = i;
				while (muro > 0) {
					if (array[muro-1].compareTo(array[muro]) > 0) {
						Util.swap(array, muro-1, muro);
					}muro--;
				}
			}
		}
	}
}
/*
for (int i = leftIndex + 1; i < rightIndex + 1; i++) {
	int pos = i;
	while ((pos > 0) && array[pos].compareTo(array[pos - 1]) == -1) {
		Util.swap(array, pos, pos - 1);
		pos--;
	}
}*/