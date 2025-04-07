class QuickSort {
    
    static int partition(int[] arr, int low, int high) {
        // Choose the pivot
        int pivot = arr[high];

        // Index of smaller element 
        // It indicates the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low..high-1] and move all smaller
        // elements to the left side.
        for(int j=low; j<=high-1; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i+1, high);
        return i+1;
    }

    static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            // pi is the partition return index of pivot
            int pivotIndex = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater elements
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n-1);

        for(int val : arr) {
            System.out.println(val + " ");
        }
    }
}