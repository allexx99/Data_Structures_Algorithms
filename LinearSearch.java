import java.util.Scanner;

class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {10, 23, 15, 8, 4, 3, 25, 30, 34, 2, 19};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item");
        int number = sc.nextInt();

        int index = 0;

        for(int i=0; i<arr.length; i++) {
            if(number == arr[i]) {
                index = i+1;
                break;
            } else {
                index = 0;
            }
        }

        if(index != 0) {
            System.out.println("The number was found at index " + index);
        } else {
            System.out.println("The number was not found");
        }
    }
}