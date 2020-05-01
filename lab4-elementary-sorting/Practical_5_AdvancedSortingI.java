public class Practical_5_AdvancedSortingI {

    public static void InsertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int index = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > index) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = index;
        }
    }

    public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    public static void mergeSort(int[] arr, int[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, aux, lo, mid);
        mergeSort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    public static void MergeSort(int[] arr){
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);
    }

    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if(i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[i] < aux[j])
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    public static void EnhancedMergeSort(int[] arr){
        int[] aux = new int[arr.length];
        enhancedMergeSort(arr, aux, 0, arr.length - 1);
    }

    public static void enhancedMergeSort(int[] arr, int[] aux, int lo, int hi) {
        final int cutoff = 10;
        if (hi <= lo + cutoff-1) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, aux, lo, mid);
        mergeSort(arr, aux, mid + 1, hi);
        if(arr[mid] < arr[mid+1])
            return;
        merge(arr, aux, lo, mid, hi);
    }

    public static void main(String args[]) {

        for(int i = 1000; i<=10000; i = i+1000) {

            int[] arr = new int[i];
            for (int j = 0; j < i; j++) {
                arr[j] = j;
            }

            shuffle(arr);

            final long startTime = System.currentTimeMillis();
            MergeSort(arr.clone());
            final long finishedTime = System.currentTimeMillis();
            final long elapsedTime = finishedTime - startTime;

            final long startTime2 = System.currentTimeMillis();
            InsertionSort(arr.clone());
            final long finishedTime2 = System.currentTimeMillis();
            final long elapsedTime2 = finishedTime2 - startTime2;

            int temp[] = arr.clone();
            final long startTime3 = System.currentTimeMillis();
            EnhancedMergeSort(temp);
            final long finishedTime3 = System.currentTimeMillis();
            final long elapsedTime3 = finishedTime3 - startTime3;

            System.out.println(i + ", " + elapsedTime + ", " + elapsedTime2 + ", " + elapsedTime3);
        }
    }
}
