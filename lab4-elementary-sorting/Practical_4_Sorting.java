import java.lang.ref.PhantomReference;
import java.lang.reflect.Array;

import static java.lang.reflect.Array.getLength;

public class Practical_4_Sorting {

    //*** PRACTICAL 4 **//
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void SelectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min])
                    min = j;

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println("Selection Sorting: ");
        printArray(arr);
    }

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

        System.out.println("Insertion Sorting: ");
        printArray(arr);
    }

    public static void SillyBogoSorting(int arr[]) {
        while (isSorted(arr) == false)
            shuffle(arr);
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

    static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }

        System.out.println("Silly Sorting: ");
        printArray(arr);
        return true;
    }

    public static void main(String args[]) {

        for (int i = 3; i <= 12; i++) {
            System.out.println("size: " + i);
            int[] arr = new int[i];
            for (int j = 0; j < i; j++) {
                arr[j] = j;
            }

            shuffle(arr);

            final long startTime = System.currentTimeMillis();
            SelectionSort(arr.clone());
            final long finishedTime = System.currentTimeMillis();
            final long elapsedTime = finishedTime - startTime;
            System.out.println("the time taken, Selection Sort: " + elapsedTime);

            final long startTime2 = System.currentTimeMillis();
            InsertionSort(arr.clone());
            final long finishedTime2 = System.currentTimeMillis();
            final long elapsedTime2 = finishedTime2 - startTime2;
            System.out.println("the time taken, Insertion Sort: " + elapsedTime2);

            final long startTime3 = System.currentTimeMillis();
            SillyBogoSorting(arr.clone());
            final long finishedTime3 = System.currentTimeMillis();
            final long elapsedTime3 = finishedTime3 - startTime3;
            System.out.println("the time taken, Silly Bogo Sort: " + elapsedTime3 + "\n");


        }
    }
}

