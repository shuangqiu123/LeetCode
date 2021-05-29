public static class QuickSort {

        public static void quickSort(int[] a) {
            quickSort(a,0,a.length-1);
        }

        public  static void quickSort(int[] a, int i, int j) {
            if (i>=j) return;

            int pivot = findPivot(i,j);

            pivot = partition(a,i,j,pivot);

            quickSort(a,i,pivot-1);
            quickSort(a,pivot+1,j);
        }

        public static int findPivot(int i, int j) {
            Random random = new Random();
            return random.nextInt(j-i) + i;
        }

        public static int partition(int[] a, int i, int j, int pivot) {
            int fe=i,fg=j;
            int pivotValue = a[pivot];
            
            for (int k=i;k<=j;++k) {
                while (k < fg && a[k] > pivotValue) swap(a,k,fg--);
                while (k > fe && a[k] < pivotValue) swap(a,k,fe++);
            }

            return fe;
        }

        public static void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

    }