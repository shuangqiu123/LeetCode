import java.util.*;

class Program {
  public static int quickselect(int[] array, int k) {		
    return quickselect(array, 0, array.length, k - 1);
  }
	
	public static int quickselect(int[] array, int start, int end, int k) {
		int pivot = start + new Random().nextInt(end - start);
		int[] pArray = partition(array, start, end, pivot);
		int fe = pArray[0];
		int fg = pArray[1];
		
		if (k < fe) {
			return quickselect(array, start, fe, k);
		}
		else if (k >= fe && k < fg) {
			return array[fe];
		}
		return quickselect(array, fg, end, k);
	}
	
	public static int[] partition(int[] array, int start, int end, int pivot) {
		int pivotValue = array[pivot];
		int fe = start;
		int fg = end;
		int next = fe;
		
		while (next < fg) {
			if (array[next] < pivotValue) {
				swap(array, next++, fe++);
			}
			else if (array[next] > pivotValue) {
				swap(array, next, --fg);
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
