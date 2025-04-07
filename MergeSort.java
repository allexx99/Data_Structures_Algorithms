class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given array is");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);


    }

    // responsible for combining two sorted subarrays into a single sorted array
    public static void merge(int[] arr, int l, int m, int   r) {
        // Find sizes of two subarrays to be merged
        // Because l and m are both inclusive, 
        // we need +1 to account for the extra element.
        int n1 = m - l + 1;
        int n2 = r - m;

        // We create two temporary arrays to store the values from arr[]
        // We need these because we'll be modifying arr[] while merging.
        int L[] = new int[n1];
        int R[] = new int[n2];

        // We copy values from arr[] into L[] and R[]
        // L[i] = arr[l + i] → Copies elements from l to m
        // R[j] = arr[m + 1 + j] → Copies elements from m+1 to r
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the Two Sorted Arrays
        // We use three pointers:
        // i → Tracks position in L[]
        // j → Tracks position in R[]
        // k → Tracks position in arr[]
        int i = 0, j = 0;
        int k = l;

        // Compare L[i] and R[j] and place the smaller element in arr[k].
        // Move the respective pointer (i or j) to the next element.
        // Move k forward to keep placing elements.
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //After the while loop, one of the subarrays may still have elements left. 
        // We copy them directly into arr[]
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // repeatedly split into two halves using recursion 
    // until each subarray contains only one element
    public static void sort(int[] arr, int l, int r) {
        // Recursion continues until l < r is no longer true, 
        // meaning the array is fully split.
        if(l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}