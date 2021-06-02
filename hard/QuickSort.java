import java.util.*;

class Program {
  public static int[] quickSort(int[] array) {
		doQuickSort(array, 0, array.length);
    return array;
  }
	
	public static void doQuickSort(int[] array, int start, int end) {
		if (end - start <= 1) {
			return;
		}
		Random random = new Random();
		int pivot = start + random.nextInt(end - start);
		
		int[] separator = partition(array, start, end, pivot);
		
		doQuickSort(array, start, separator[0]);
		doQuickSort(array, separator[1], end);
	}
	
	public static int[] partition(int[] array, int start, int end, int pivot) {
		int pivotValue = array[pivot];
		int fe = start;
		int fg = end;
		int next = start;
		while (next < fg) {
			if (array[next] < pivotValue) {
				swap(array, fe, next);
				fe++;
				next++;
			}
			else if (array[next] > pivotValue) {
				fg--;
				swap(array, fg, next);
			}
			else {
				next++;
			}
		}
		
		return new int[]{fe, fg};
	}
	
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
