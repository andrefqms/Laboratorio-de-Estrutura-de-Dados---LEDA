package problems;
   
   import util.Util;
   
   public class FloorBinarySearchImpl implements Floor {
   
   	@Override
   	public Integer floor(Integer[] array, Integer x) {
   		if (array.length == 0) {
  			return null;
  		}
  
  		sort(array, 0, array.length - 1);
  		return buscaBinaria(array, 0, array.length - 1, x);
  	}
  
  	public Integer buscaBinaria(Integer[] array, int inicio, int fim, Integer x) {
  		int mid = (inicio + fim) / 2;
  		if (array[mid] == x) {
  			return array[mid];
  		}
  		if (inicio > fim) {
  			if (fim < 0) {
  				return null;
  			}
  			return array[fim];
  		}
  
  		if (x < array[mid]) {
  			return buscaBinaria(array, inicio, mid - 1, x);
  		} else {
  			return buscaBinaria(array, mid + 1, fim, x);
  		}
  
  	}
  
  	public void sort(Integer[] array, int inicio, int fim) {
  		if (inicio < fim) {
  			int posicaoPivo = partition(array, inicio, fim);
  			sort(array, inicio, posicaoPivo - 1);
  			sort(array, posicaoPivo + 1, fim);
  		}
  	}
  
  	public Integer partition(Integer[] array, int inicio, int fim) {
  
  		Integer pivo = array[inicio];
  		int i = inicio;
  
  		for (int j = inicio + 1; j <= fim; j++) {
  			if (array[j] < pivo) {
  				i++;
  				Util.swap(array, i, j);
  
  			}
  		}
  
  		Util.swap(array, inicio, i);
  
  		return i;
  	}
  }
