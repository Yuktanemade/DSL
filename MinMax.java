import java.util.Scanner;

public class MinMax {

    // Pair class to return min and max together
    static class Pair {
        int min;
        int max;
    }

    static Pair findMinMax(int[] arr, int low, int high) {
        Pair result = new Pair();

        // If there's only one element
        if (low == high) {
            result.min = result.max = arr[low];
            return result;
        }

        // If there are two elements
        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                result.min = arr[low];
                result.max = arr[high];
            } else {
                result.min = arr[high];
                result.max = arr[low];
            }
            return result;
        }

        // If more than two elements
        int mid = (low + high) / 2;
        Pair left = findMinMax(arr, low, mid);
        Pair right = findMinMax(arr, mid + 1, high);

        result.min = Math.min(left.min, right.min);
        result.max = Math.max(left.max, right.max);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Pair result = findMinMax(arr, 0, n - 1);

        System.out.println("Minimum element: " + result.min);
        System.out.println("Maximum element: " + result.max);

        sc.close();
    }
}
