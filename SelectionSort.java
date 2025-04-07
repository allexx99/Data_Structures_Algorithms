import java.util.*;

class SelectionSort {
    public static void main(String[] args) {
        Integer[] a = {12, 10, 9, 7, 101, 23, 44, 12, 78, 34, 23};  

        // smallest id
        int smallest = getSmallest(a, 0);

        int temp = a[0];
        a[0] = a[smallest];
        a[smallest] = temp;

        for(int i=1; i<a.length; i++) {
            int smallestI = getSmallest(a, i);

            if(smallestI != i) {
                int tempI = a[i];
                a[i] = a[smallestI];
                a[smallestI] = tempI;
            }
        }

        for(int nb : a) {
            System.out.print(nb + " ");
        }

    }

    public static int getSmallest(Integer[] arr, int j) {
        int len = arr.length;
        int smallest = arr[j];

        int index=j;
        for(int i=j+1; i<len; i++) {
            if(arr[i] < smallest) {
                smallest = arr[i];
                index = i;
            }
        }

        return index;
    }
}