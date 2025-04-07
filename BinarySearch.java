class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {16, 19, 20, 23, 45, 56, 78, 90, 96, 100};
        boolean res = binarySearch(arr, 56, 0, arr.length-1);
        System.out.print(res);
    }

    public static boolean binarySearch(int[] arr, int n, int left, int right) {                
        if(left <= right) {
            int mid = (left + right) / 2;
        
            if(n == arr[mid]) {
                return true;
            } 
            else if(n < arr[mid]) {
                return binarySearch(arr, n, left, mid-1);
            }
            else if(n >= arr[mid]){
                return binarySearch(arr, n, mid+1, right);
            }
        }

        return false;
    }
}