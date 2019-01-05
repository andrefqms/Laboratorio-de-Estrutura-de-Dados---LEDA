package sorting.simpleSorting;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public static void main(String[] args) {
		 Integer[] vetor = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
					31 };
		 SelectionSort<Integer> se = new SelectionSort<>();
		 se.sort(vetor, 0, vetor.length-1);
		 System.out.println(Arrays.toString(vetor));
	}
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && leftIndex <= array.length && rightIndex >= 0 && rightIndex <= array.length
				&& leftIndex <= rightIndex) {
			for (int i = 0; i < rightIndex; i++) {
				int minino = i;
				for (int j = i+1; j <= rightIndex; j++) {
					if (array[minino].compareTo(array[j]) > 0) {
						minino = j;
					}
				}Util.swap(array, i, minino);
			}
		}	
	}
}